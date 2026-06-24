package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

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
				System.out.println("Digite um número inteiro entre 0 e 8");
				leia.nextLine();
			}
			

			if (opcao == 0) {
				System.out.println(Cores.TEXT_GREEN + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
                leia.close();
				System.exit(0);
		}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nCriar Conta\n\n");
                cadastrarConta();
                keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nListar todas as Contas\n\n");
				
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nConsultar dados da Conta - por número\n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nAtualizar dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nApagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nSaque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nDepósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nTransferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
		}
	}
}
		public static void keyPress() {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			leia.nextLine();
		}

            public static void sobre() {
	            System.out.println("\n*********************************************************");
	            System.out.println(Cores.TEXT_YELLOW + "Projeto Desenvolvido por Raquel ");
	            System.out.println("Generation Brasil - raqueln@genstudents.org");
	            System.out.println("Github: https://github.com/quelbarch");
	            System.out.println("                                                                            " + Cores.TEXT_RESET);
	            System.out.println(Cores.TEXT_GREEN + "*********************************************************");
         }
            
         public static void criarContasTestes() {
        	 contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
     		 contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
        	 
         }
            
         public static void listarContas() {
        	 contaController.listarTodas();
         }
            
         public static void cadastrarConta() {
        	 
        	 System.out.println("Digite o número da agência: ");
        	 int agencia = leia.nextInt();
        	 
        	 System.out.println("Digite o nome do titular da conta: ");
        	 leia.skip("\\R");
        	 String titular = leia.nextLine();
        	 
        	 System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
        	 int tipo = leia.nextInt();
        	 
        	 System.out.println("Digite o saldo da conta: ");
        	 float saldo = leia.nextFloat();
        	 
        	 switch(tipo) {
        	 case 1 ->{
        		 System.out.println("Digite o limite da conta: ");
        		 float limite = leia.nextFloat();
        		 
        		 contaController.cadastrar(
        				 new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
        	 }
        	 case 2 -> {
        		 System.out.println("Digite o dia do aniversário da conta: ");
        		 int aniversario = leia.nextInt();
        		 
     				contaController.cadastrar(
     						new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
     			}
     			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválida!" + Cores.TEXT_RESET);
     		}
      
        	 }
        	 
         }

         
         
     

