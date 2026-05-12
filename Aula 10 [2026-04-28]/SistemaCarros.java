
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCarros {
    private static final List<Carro> carros = new ArrayList<>();

    public class Carro{
        String nome;
        String montadora;
        double valor;
        

        public Carro(String nome, String montadora, double valor) {
            this.nome = nome;
            this.montadora = montadora;
            this.valor = valor;
        }

        String obterInfo(){
            return String.format("| %-3s | %-20s | %-30s | %12.2f |", "", nome, montadora, valor);
        }
    }

    public static void main(String[] args) {
        try(Scanner entrada = new Scanner(System.in)) {            
        int opção;

            do{
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Incluir carro");
                System.out.println("2 - Listar carros");
                System.out.println("3 - Remover Carro");
                System.out.println("4 - Sair");

                opção = entrada.nextInt();

                switch (opção) {
                    case 1:
                        new SistemaCarros().IncluirCarro();
                        break;
                    case 2:
                        new SistemaCarros().ListarCarros();
                        break;
                    case 3:
                        new SistemaCarros().RemoverCarro();
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

    public void IncluirCarro(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do carro:");
        String nome = entrada.nextLine();
        System.out.println("Digite a montadora do carro:");
        String montadora = entrada.nextLine();
        System.out.println("Digite o valor do carro:");
        double valor = entrada.nextDouble();

        Carro carro = new Carro(nome, montadora, valor);
        carros.add(carro);
        System.out.println("Carro incluído com sucesso!");

    }   

    public void ListarCarros(){
        if (carros.isEmpty()) {
            System.out.println("\nNenhum carro cadastrado.");
            return;
        }
        System.out.println("\n\n+----------------------------------------------------------------------------+");
        System.out.println("|                               Carros cadastrados                           |");
        System.out.println("+-----+----------------------+--------------------------------+--------------+");
        System.out.printf("| %-3s | %-20s | %-30s | %12s |%n", "#", "Nome", "Montadora", "Valor");
        System.out.println("+-----+----------------------+--------------------------------+--------------+");
        for (int i = 0; i < carros.size(); i++) {
            System.out.printf("| %-3d | %-20s | %-30s | %12.2f |%n",
                    i + 1,
                    carros.get(i).nome,
                    carros.get(i).montadora,
                    carros.get(i).valor);
        }
        System.out.println("+-----+----------------------+--------------------------------+--------------+");
    }

    public void RemoverCarro(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número do carro a ser removido:");
        int numero = entrada.nextInt();

        if (numero < 1 || numero > carros.size()) {
            System.out.println("Número inválido. Nenhum carro removido.");
            return;
        }

        Carro removido = carros.remove(numero - 1);
        System.out.println("Carro '" + removido.nome + "' removido com sucesso!");
    }
}
