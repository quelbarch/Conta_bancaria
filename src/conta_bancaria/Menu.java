package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
	public static void main(String[] args) {
		
		Scanner leia = new Scanner (System.in);
		
		int opcao;
		
		/* Instanciar Objetos da Classe Conta */
		
		Conta c1 = new Conta (1, 123, 1, "Isabella", 200000.00f);
		c1.visualizar();
		
		Conta c2 = new Conta (1, 123, 2, "Thiago", 100000.00f);
		c2.visualizar();
		
		
		//Alterar saldo e nome do titular//
		
		c1.setSaldo(300000.00f);
		c1.setTitular ("Isabella Bruno");
		c1.visualizar();
		
		
		System.out.println("Sacar R$ 1.000,00 da conta C2: " + (c2.sacar(1000.00f) ?
				"Saque efetuado com sucesso!" : "Saldo Insuficiente"));
		
		System.out.println("Sacar R$ 300.000,00 da conta C2: " + (c2.sacar(300000.00f) ?
				"Saque efetuado com sucesso!" : "Saldo Insuficiente"));
		
		c2.visualizar();
		
		
		/* Depósito na Conta c2*/
		
		c2.depositar(50000.00f);
		c2.visualizar();
		
		
		
		while (true) {
			
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND 
					+ "*************************************************************");
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
			
			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_GREEN + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
                leia.close();
				System.exit(0);
		}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nCriar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nListar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nConsultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nAtualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nApagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nSaque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nDepósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nTransferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nOpção Inválida!\n");
				break;
		}
	}
}

            public static void sobre() {
	            System.out.println("\n*********************************************************");
	            System.out.println(Cores.TEXT_YELLOW + "Projeto Desenvolvido por Raquel ");
	            System.out.println("Generation Brasil - raqueln@genstudents.org");
	            System.out.println("Github: https://github.com/quelbarch");
	            System.out.println("                                                                            " + Cores.TEXT_RESET);
	            System.out.println(Cores.TEXT_GREEN + "*********************************************************");
         }
     }