import java.util.ArrayList;
import java.util.Scanner;

public class NomesArraylist {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();

        //Criar um programa Java que armazene apenas nomes em um ArrayList e permita adicionar e remover nomes de forma dinâmica..
        try(Scanner entrada = new Scanner(System.in)) {
            int opção;

            do{
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Adicionar nome");
                System.out.println("2 - Listar nomes");
                System.out.println("3 - Remover nome");
                System.out.println("4 - Sair");

                opção = entrada.nextInt();
                entrada.nextLine(); // Limpar buffer

                switch (opção) {
                    case 1:
                        System.out.print("\n\nDigite o nome a ser adicionado: ");
                        String nome = entrada.nextLine();
                        nomes.add(nome);
                        System.out.println("Nome adicionado com sucesso!");
                        break;
                    case 2:
                        System.out.println("\n--- Lista de Nomes ---");
                        for (String n : nomes) {
                            System.out.println(n);
                        }
                        System.out.println("-------------------\n\n");
                        break;
                    case 3:
                        System.out.print("Digite o nome a ser removido: ");
                        String nomeRemover = entrada.nextLine();
                        if (nomes.remove(nomeRemover)) {
                            System.out.println("Nome removido com sucesso!");
                        } else {
                            System.out.println("Nome não encontrado.");
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while(opção != 4);
        }
        

    }
}
