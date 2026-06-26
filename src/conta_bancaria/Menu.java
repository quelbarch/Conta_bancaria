package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria_controller.ContaController;

public class Menu {

		private static final Scanner leia = new Scanner (System.in);
		private static final ContaController contaController = new ContaController();
		
		public static void main(String[] args) {
			
		int opcao;
		
		// Criar dados de teste
		criarContasTestes();
		
		
		while (true) {
			
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND 
					+ "\n*************************************************************");
			System.out.println("                                                             ");
			System.out.println("                    BANCO DO BRAZIL COM Z                    ");
			System.out.println("                                                             ");
			System.out.println("*************************************************************" + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_YELLOW+ Cores.ANSI_BLACK_BACKGROUND 
					+ "                                                             ");
			System.out.println("                 1- Criar Conta                              ");
			System.out.println("                 2- Listar todas as Contas                   ");
			System.out.println("                 3- Buscar Conta por Numero                  ");
			System.out.println("                 4- Atualizar Dados da Conta                 ");
			System.out.println("                 5- Apagar Conta                             ");
			System.out.println("                 6- Sacar                                    ");
			System.out.println("                 7- Depositar                                ");
			System.out.println("                 8- Transferir valores entre Contas          ");
			System.out.println("                 9- Consultar por nome do titular            ");
			System.out.println("                 0- Sair                                     ");
			System.out.println("                                                             ");
			System.out.println(Cores.TEXT_GREEN + "*************************************************************");
			System.out.println("Entre com a opção desejada:                                  ");
			System.out.println("                                                             " + Cores.TEXT_RESET);
			
			try {
			    opcao = leia.nextInt();
			    leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 9");
				leia.nextLine();
			}
			

			if (opcao == 0) {
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND +  "\nBanco do Brazil com Z - O seu Futuro começa aqui!            ");
				System.out.println("                                                             " + Cores.TEXT_RESET);
				sobre();
                leia.close();
				System.exit(0);
		}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW + "\nCriar Conta\n\n");
                cadastrarConta();
                keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW + "\nListar todas as Contas\n\n");
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW + "\nConsultar dados da Conta - por número\n\n");
				procurarContaPorNumero();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW + "\nAtualizar dados da Conta\n\n");
				atualizarConta();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW + "\nApagar a Conta\n\n");
				deletarConta();
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_YELLOW + "\nSaque\n\n");
                sacar();
				break;
			case 7:
				System.out.println(Cores.TEXT_YELLOW + "\nDepósito\n\n");
				depositar();
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW + "\nTransferência entre Contas\n\n");
				transferir();
				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_YELLOW + "Consulta por nome do titular\n\n");
				listarPorTitular();
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED + "\nOpção Inválida!\n");
				keyPress();
				break;
		}
	}
}


            public static void sobre() {
	            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "*************************************************************");
	            System.out.println(Cores.TEXT_YELLOW + "Projeto Desenvolvido por Raquel                              ");
	            System.out.println("Generation Brasil - raqueln@genstudents.org                  ");
	            System.out.println("Github: https://github.com/quelbarch                         ");
	            System.out.println("                                                             ");
	            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + 
	            		"*************************************************************" + Cores.TEXT_RESET);
         }
            
    		public static void keyPress() {
    			System.out.println(Cores.TEXT_YELLOW + "\n\nPressione Enter para continuar...");
    			leia.nextLine();
    	}
    		
         public static void criarContasTestes() {
        	 contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
     		 contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
        	 
         }
            
         public static void listarContas() {
        	 contaController.listarTodas();
         }
            
         public static void cadastrarConta() {
        	 
        	 System.out.println(Cores.TEXT_YELLOW + "Digite o número da agência: "  + Cores.TEXT_WHITE);
        	 int agencia = leia.nextInt();
        	 
        	 System.out.println(Cores.TEXT_YELLOW + "Digite o nome do titular da conta: " + Cores.TEXT_WHITE);
        	 leia.skip("\\R");
        	 String titular = leia.nextLine();
        	 
        	 System.out.println(Cores.TEXT_YELLOW + "Digite o tipo da conta (1 - CC | 2 - CP): " + Cores.TEXT_WHITE);
        	 int tipo = leia.nextInt();
        	 
        	 System.out.println(Cores.TEXT_YELLOW + "Digite o saldo da conta: " + Cores.TEXT_WHITE);
        	 float saldo = leia.nextFloat();
        	 
        	 switch(tipo) {
        	 case 1 ->{
        		 System.out.println(Cores.TEXT_YELLOW + "Digite o limite da conta: " + Cores.TEXT_WHITE );
        		 
        		 float limite = leia.nextFloat();
        		 leia.nextLine();
        		 
        		 contaController.cadastrar(
        				 new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
        	 }
        	 case 2 -> {
        		 System.out.println(Cores.TEXT_YELLOW + "Digite o dia do aniversário da conta: " + Cores.TEXT_WHITE);
        		 int aniversario = leia.nextInt();
        		 leia.nextLine();
        		 
     				contaController.cadastrar(
     						new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
     			}
     			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválida!" + Cores.TEXT_RESET);
     		}
      
       }
        	 
       public static void procurarContaPorNumero() {
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o número da conta: " + Cores.TEXT_WHITE);
    	   int numero = leia.nextInt();
    	   leia.nextLine();
    	   
    	   contaController.procurarPorNumero(numero);
       }
       
       public static void deletarConta() {
   		
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o número da conta: " + Cores.TEXT_WHITE);
    	   int numero = leia.nextInt();
    	   leia.nextLine();
    	   
    	   Optional<Conta> conta = contaController.buscarNaCollection(numero);
    	   
    	   if(conta.isPresent()) {
    		   
    		   //Confirmação da exclusãop
    		   
    		   System.out.printf(Cores.TEXT_YELLOW + "Tem certaza que você deseja excluir a conta número %d (S/N)?"+ Cores.TEXT_WHITE , numero);
    		   String confirmacao = leia.nextLine();
    		   
    		   if(confirmacao.equalsIgnoreCase("S")) 
    			   contaController.deletar(numero);
    		   else
    			   System.out.println(Cores.TEXT_RED + "\nOperação cancelada!");
    		   
    		   }else {
    			   System.out.printf(Cores.TEXT_RED + "\nA conta número %d não foi encontrada" + Cores.TEXT_WHITE , numero);
    		   }
    	   }
       
       public static void atualizarConta() {
    	   
    	   System.out.println("Digite o número da conta: " + Cores.TEXT_WHITE);
    	   int numero = leia.nextInt();
    	   leia.nextLine();
    	   
    	   Optional<Conta> conta = contaController.buscarNaCollection(numero);
    	   
    	   if(conta.isPresent()) {
    		   
    		   //Obtém os dados atuais da conta
    		   int agencia = conta.get().getAgencia();
    		   String titular = conta.get().getTitular();
    		   int tipo = conta.get().getTipo();
    		   float saldo = conta.get().getSaldo();
    		   
    		   //Atualiza a agência ou mantém o valor atual
    		   System.out.printf(Cores.TEXT_YELLOW + "Agência atual: " + Cores.TEXT_WHITE + "%d" + Cores.TEXT_YELLOW + 
    				    "%nDigite o número da nova agência " + Cores.TEXT_GREEN + "(Pressione ENTER para manter o valor atual) " + Cores.TEXT_WHITE, agencia);
    		   String entrada = leia.nextLine();
    		   
    		   agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
    		   
    		   //Atualiza o titular ou mantém o valor atual
    		   System.out.printf(Cores.TEXT_YELLOW + "Titular atual: " + Cores.TEXT_WHITE + "%s" + Cores.TEXT_YELLOW 
    				   + "%nDigite o nome do novo titular " + Cores.TEXT_GREEN + "(Pressione ENTER para manter o valor atual) " + Cores.TEXT_WHITE, titular);
    		   entrada = leia.nextLine();
    		   
    		   titular = entrada.isEmpty() ? titular : entrada;
    		   
    		 //Atualiza o saldo ou mantém o valor atual
    		   System.out.printf(Cores.TEXT_YELLOW + "Saldo atual: " + Cores.TEXT_WHITE + "%s" + Cores.TEXT_YELLOW + "%nDigite o novo saldo " + Cores.TEXT_GREEN + "(Pressione ENTER para manter o valor atual) " + Cores.TEXT_WHITE, saldo);
    		   entrada = leia.nextLine();
    		   
    		   saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",","."));
    		   
    		   switch(tipo) {
    		   case 1 ->{
    			   ContaCorrente contaCorrente = (ContaCorrente) conta.get();
    			   float limite = contaCorrente.getLimite();
    			   
    			   //Atualiza o limite ou mantém o valor atual
    			   System.out.printf(Cores.TEXT_YELLOW + "Limite atual: " + Cores.TEXT_WHITE + "%.2f" + Cores.TEXT_YELLOW 
    					   + "%nDigite o novo limite " + Cores.TEXT_GREEN + "(Pressione ENTER para manter o valor atual" + Cores.TEXT_WHITE, limite);
    			   entrada = leia.nextLine();
    			   
    			   limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",","."));
    			   
    			   contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
    		   }
    		   case 2 ->{
    			   ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
    			   int aniversario = contaPoupanca.getAniversario();
    			   
    			   //Atualiza o aniversario ou mantém o valor atual
    			   System.out.printf(Cores.TEXT_YELLOW + "Dia do aniversario atual: " + Cores.TEXT_WHITE + "%d" + Cores.TEXT_YELLOW 
    					   + "%nDigite o novo dia do aniversário da conta " + Cores.TEXT_GREEN + "(Pressione ENTER para manter o valor atual)" + Cores.TEXT_WHITE, aniversario);
    			   entrada = leia.nextLine();
    			   
    			   aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
    			   
    			   contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
    		   }
    		   default -> System.out.println(Cores.TEXT_RED + "Tipo da conta é inválido!" + Cores.TEXT_RESET);
    		   }
    		   
    	   }else {
    		   System.out.printf(Cores.TEXT_RED + "\nA conta número %d não foi encontrada!", numero);
    	   }
    	   
       }
       
       public static void sacar() {
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o número da conta: " + Cores.TEXT_WHITE);
    	   int numero = leia.nextInt();
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o valor do saque: " + Cores.TEXT_WHITE);
    	   float valor = leia.nextFloat();
    	   
    	   contaController.sacar(numero, valor);
       }
       
       public static void depositar() {
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o número da conta: " + Cores.TEXT_WHITE);
    	   int numero = leia.nextInt();
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o valor do depósito: " + Cores.TEXT_WHITE);
    	   float valor = leia.nextFloat();
    	   leia.nextLine();
    	   
    	   contaController.depositar(numero, valor);
       }
       
       public static void transferir() {
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o número da conta de origem: " + Cores.TEXT_WHITE);
    	   int numeroOrigem = leia.nextInt();
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o número da conta de destino: " + Cores.TEXT_WHITE);
    	   int numeroDestino = leia.nextInt();
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o valor da transferência: " + Cores.TEXT_WHITE);
    	   float valor = leia.nextFloat();
    	   leia.nextLine();
    	   
    	   contaController.transferir(numeroOrigem, numeroDestino, valor);
    	   
       }
    	  
       public static void listarPorTitular() {
    	   
    	   System.out.println(Cores.TEXT_YELLOW + "Digite o nome do titular da conta: " + Cores.TEXT_WHITE);
    	   String titular = leia.nextLine();
    	   
    	   contaController.listarPorTitular(titular);
       }
  }
         

         
         
     

