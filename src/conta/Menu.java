package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) {
    	
        Scanner leia = new Scanner(System.in);
        int opcao;        
        
     // Teste da Classe Conta Corrente
        ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
        cc1.visualizar();
        cc1.sacar(12000.0f);
        cc1.visualizar();
        cc1.depositar(5000.0f);
        cc1.visualizar();

     // Teste da Classe Conta Poupança
        ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
        cp1.visualizar();
        cp1.sacar(1000.0f);
        cp1.visualizar();
        cp1.depositar(5000.0f);
        cp1.visualizar();
        
        while (true) {
            System.out.println(Cores.TEXT_PURPLE_BOLD + Cores.ANSI_BLACK_BACKGROUND);
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            BANCO DO BRAZIL COM Z                    ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Conta                          ");
            System.out.println("            2 - Listar todas as Contas               ");
            System.out.println("            3 - Buscar Conta por Número              ");
            System.out.println("            4 - Atualizar Dados da Conta             ");
            System.out.println("            5 - Apagar Conta                         ");
            System.out.println("            6 - Sacar                                ");
            System.out.println("            7 - Depositar                            ");
            System.out.println("            8 - Transferir valores entre Contas      ");
            System.out.println("            9 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.print("Entre com a opção desejada:                          ");
            System.out.println(Cores.TEXT_RESET);

            opcao = leia.nextInt();

            if (opcao == 9) {
                System.out.println("\nBanco do Brazil com Z - Até mais!");
                leia.close();
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Conta\n");
                    break;
                case 2:
                    System.out.println("Listar todas as Contas\n");
                    break;
                case 3:
                    System.out.println("Buscar Conta por Número\n");
                    break;
                case 4:
                    System.out.println("Atualizar Dados da Conta\n");
                    break;
                case 5:
                    System.out.println("Apagar Conta\n");
                    break;
                case 6:
                    System.out.println("Sacar\n");
                    break;
                case 7:
                    System.out.println("Depositar\n");
                    break;
                case 8:
                    System.out.println("Transferir valores entre Contas\n");
                    break;
                default:
                    System.out.println("Opção Inválida!\n");
                    break;
            }
        }
    }
}