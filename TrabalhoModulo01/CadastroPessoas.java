

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPessoas {
    public static class Pessoa{
        int codigo;
        String nome;
        public double salario;
        String categoriaSalarial;
        
        public void calcularCategoriaSalarial() {
            if (this.salario >= 5000) {
                this.categoriaSalarial = "Alto";
            } else {
                this.categoriaSalarial = "Baixo";
            }
        }
    }

    public static final Scanner entrada = new Scanner(System.in);
    public static double[] salarios = new double[100];
    public static int indiceSalarios = 0;

    public static void main(String[] args) {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        int opcao = 0;
        do {
            LimparTela();
            Titulo();
            opcao = Menu();
            switch (opcao) {
                case 1:
                    CadastrarPessoa(listaPessoas);
                    break;
                case 2:
                    ListarPessoas(listaPessoas);
                    break;
                case 3:
                    BuscarPessoa(listaPessoas);
                    break;
                case 4:
                    System.out.println("\n\nSaindo...\n\n");
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
            if (opcao != 4) {
                System.out.println("\nPressione Enter para continuar...");
                entrada.nextLine();
            }
        } while (opcao != 4);
        entrada.close();
    }
   
    public static int Menu(){
        int opcao = 0;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Buscar pessoa por nome");
            System.out.println("4 - Sair");
            if (!entrada.hasNextInt()) {
                System.out.println("\nOpção inválida!\n");
                entrada.nextLine();
                continue;
            }
            opcao = entrada.nextInt();
            entrada.nextLine(); // Limpar buffer
            switch (opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return opcao;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
        } while (true);
    }
    public static void CadastrarPessoa(ArrayList<Pessoa> listaPessoas){
        String opcao = "";
        do { 
            Pessoa p = new Pessoa();
            System.out.print("Digite o código da pessoa: ");
            while (!entrada.hasNextInt()) {
                System.out.println("\n\nEntrada inválida!!!\n Digite um número inteiro para o código:");
                entrada.nextLine();
            }
            p.codigo = entrada.nextInt();
            entrada.nextLine(); // Limpar buffer
            System.out.print("Digite o nome da pessoa: ");
            p.nome = entrada.nextLine();
            System.out.print("Digite o salário da pessoa: ");
            while (!entrada.hasNextDouble()) {
                System.out.println("\n\nEntrada inválida!!!\n Digite um número válido para o salário:");
                entrada.nextLine();
            }
            p.salario = entrada.nextDouble();
            entrada.nextLine(); // Limpar buffer
            p.calcularCategoriaSalarial();
            listaPessoas.add(p);
            salarios[indiceSalarios++] = p.salario;
            System.out.println("\n\nPessoa cadastrada com sucesso!\n");
            do { 
                System.out.print("\nDeseja cadastrar outra pessoa? (S/N): ");
                opcao = entrada.nextLine();
                    if (!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")) {
                        System.out.println("Opção inválida. Digite 'S' para sim ou 'N' para não.");
                    }
            } while (!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"));
            

        } while (opcao.equalsIgnoreCase("S") );

        
       
    }
    public static void ListarPessoas(ArrayList<Pessoa> listaPessoas){
//─│┌┐└┘├┤┬┴┼
        System.out.println("\n\n┌──────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│                              Pessoas cadastrados                             │");
            System.out.println("├─────┬────────────┬────────────────────────────────┬──────────────┬───────────┤");
        System.out.printf("│ %-3s │ %-10s │ %-30s │ %12s │ %9s │%n", "#", "Código", "Nome", "Salário", "Categoria");
        System.out.println("├─────┼────────────┼────────────────────────────────┼──────────────┼───────────┤");
        for (int i = 0; i < listaPessoas.size(); i++) {
            System.out.printf("│ %-3d │ %-10s │ %-30s │ %12.2f │ %9s │%n",
                    i + 1,
                    listaPessoas.get(i).codigo,
                    listaPessoas.get(i).nome,
                    listaPessoas.get(i).salario,
                    listaPessoas.get(i).categoriaSalarial);
        }
        System.out.println("└─────┴────────────┴────────────────────────────────┴──────────────┴───────────┘");

    }

    public static void BuscarPessoa(ArrayList<Pessoa> listaPessoas){
        System.out.print("Digite o nome para buscar: ");
        String busca = entrada.nextLine();
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa p = listaPessoas.get(i);
            if (p.nome.equalsIgnoreCase(busca)) {
                System.out.println("\n\n┌──────────────────────────────────────────────────────────────────────────────┐");
                    System.out.println("│                              Pessoa Encontrada                               │");
                    System.out.println("├─────┬────────────┬────────────────────────────────┬──────────────┬───────────┤");
                System.out.printf("│ %-3s │ %-10s │ %-30s │ %12s │ %9s │%n", "#", "Código", "Nome", "Salário", "Categoria");
                    System.out.println("├─────┼────────────┼────────────────────────────────┼──────────────┼───────────┤");


                System.out.printf("│ %-3d │ %-10s │ %-30s │ %12.2f │ %9s │%n",
                    i + 1,
                    p.codigo,
                    p.nome,
                    p.salario,
                    p.categoriaSalarial);
                System.out.println("└─────┴────────────┴────────────────────────────────┴──────────────┴───────────┘");
                return;
            }
        }
        System.out.println("\n\n┌──────────────────────────────────────────────────────────────────┐");
            System.out.println("│                        Pessoa não encontrada                     │");
            System.out.println("└──────────────────────────────────────────────────────────────────┘");
    }



    public static void LimparTela() {
        try {
            // Cria um processo que executa "cmd /c cls"
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()          // Redireciona a saída para o console atual
                .start()
                .waitFor();           // Aguarda o término do comando
        } catch (Exception e) {
            System.err.println("Erro ao limpar a tela: " + e.getMessage());
        }
    }


    //─│┌┐└┘├┤┬┴┼═║╒╓╔╕╖╗╘╙╚╛╜╝╞╟╠╡╢╣╤╥╦╧╨╩╪╫╬▀▄█▌▐░▒▓■□▪▫▬

    public static void Titulo(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                       CADASTRO DE PESSOAS                                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("\n\n\n");
    }


}


