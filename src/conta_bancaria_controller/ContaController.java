package conta_bancaria_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import conta_bancaria.util.Cores;
import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.printf(Cores.TEXT_CYAN + "\n\nA conta número %d foi criada com sucesso!%n" + Cores.TEXT_RESET, conta.getNumero());
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf(Cores.TEXT_RED + "\nA conta número %d não foi encontrada!"+ Cores.TEXT_RESET, numero);
		
	}

	@Override
	public void atualizar(Conta conta) {
		
			Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
			
			if(buscaConta.isPresent()) {
				listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
					System.out.printf(Cores.TEXT_BLUE + "\nA conta número %d foi atualizada com sucesso!", conta.getNumero());
			}else
				System.out.printf(Cores.TEXT_RED + "\nA conta número %d não foi encontrada!", conta.getNumero());
			
	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if (listaContas.remove(conta.get()))
				System.out.printf(Cores.TEXT_BLUE + "\nA conta número %d foi excluída com sucesso!", numero);
		}else
			System.out.printf(Cores.TEXT_RED + "\nA conta número %d não foi encontrada!" + Cores.TEXT_RESET, numero);
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
        Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if (conta.get().sacar(valor))
				System.out.printf(Cores.TEXT_BLUE + "\nO saque no valor de %.2f, na conta número %d foi efetuado com sucesso!\n\n" + Cores.TEXT_RESET
						, valor, numero);
				else
					System.out.printf(Cores.TEXT_RED + "\nO saque no valor de %.2f, na conta número %d não foi efetuado devido ao saldo ser insuficiente!\n\n"
				+ Cores.TEXT_RESET, valor, numero);
			
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		
	}

	@Override
	public void depositar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
		   conta.get().depositar(valor);
				System.out.printf(Cores.TEXT_BLUE + "\nO depósito no valor de %.2f, na conta número %d foi efetuado com sucesso!"
		   + Cores.TEXT_RESET	, valor, numero);
		}else
			System.out.printf(Cores.TEXT_RED + "\nA conta número %d não foi encontrada!" + Cores.TEXT_RESET, numero);
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
 
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor)) {
				contaDestino.get().depositar(valor);
				System.out.printf(Cores.TEXT_BLUE + "\nA transferência no valor de %.2f, da conta número %d "
						+ " para a conta %d foi efetuado com sucesso!" 
						+ Cores.TEXT_RESET, valor, numeroOrigem, numeroDestino);
			}else
				System.out.printf(Cores.TEXT_RED + "\nO transferência no valor de %.2f, na conta número %d "
						+ " para a conta %d não foi efetuado devido ao saldo ser insuficiente!" 
						+ Cores.TEXT_RESET, valor, numeroOrigem, numeroDestino);
		}else
			System.out.printf(Cores.TEXT_RED + "\nA conta número %d e/ou a conta número %d não foram encontradas!" 
		+ Cores.TEXT_RESET, numeroOrigem, numeroDestino);
		
	}
	
	@Override
	public void listarPorTitular(String titular) {
		
		List<Conta> listaTitulares = listaContas.stream()
				.filter(conta -> conta.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		
		if (listaTitulares.isEmpty())
			System.out.printf(Cores.TEXT_RED + "\nNenhum titular com o nome %s foi encontrado." + Cores.TEXT_RESET, titular);
		else
			listaTitulares.forEach(conta -> conta.visualizar());
				
	}
	
	
	// Método Auxiliar
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Optional<Conta> buscarNaCollection(int numero){
		for(var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}
		
		return Optional.empty();
	}
}
