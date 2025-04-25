package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;

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