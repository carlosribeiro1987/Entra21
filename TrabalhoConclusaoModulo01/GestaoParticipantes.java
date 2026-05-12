import java.util.ArrayList;
import java.util.Scanner;

public class GestaoParticipantes {

    public static class Participante{
        String nome;
        int idade;
        String email;
    }
    public static ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        do {
            LimparTela();
            Titulo();
            opcao = Menu();
            switch (opcao) {
                case 1:                    
                    CadastrarParticipante();
                    break;
                case 2:
                    ListarParticipantes();
                    break;
                case 3:
                    BuscarParticipantePorNome();
                    break;
                case 4:
                    RemoverParticipante();
                    break;
                case 5:
                    ExibirEstatisticas();
                    break;
                case 6:
                    System.out.println("\n\nSaindo...\n\n");
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
            if (opcao != 6) {
                System.out.println("\nPressione Enter para continuar...");
                entrada.nextLine();
            }
        } while (opcao != 6);
        entrada.close();
    }

    public static void CadastrarParticipante(){
        String opcao = "";
        do{
            LimparTela();
            Titulo();
            Scanner entrada = new Scanner(System.in);
            Participante p = new Participante();
            // LimparTela();
            do {
                System.out.println("\tDigite o nome do participante:");
                System.out.print("\t");
                p.nome = entrada.nextLine();

                if (!ValidarNome(p.nome)) {
                    System.out.println("\n\tNome inválido! Digite apenas letras e nao deixe o campo vazio.");
                    System.out.println("\n\tPressione Enter para tentar novamente...");
                    entrada.nextLine();
                    LimparTela();
                    Titulo();
                }
            } while (!ValidarNome(p.nome));

            String idade = "";
            do {
                System.out.println("\tDigite a idade do participante:");
                System.out.print("\t");
                idade = entrada.nextLine();

                if (!ValidarIdade(idade)) {
                    System.out.println("\n\tIdade inválida! Digite um número entre 0 e 160.");
                    System.out.println("\n\tPressione Enter para tentar novamente...");
                    entrada.nextLine();
                    LimparTela();
                    Titulo();
                }
            } while (!ValidarIdade(idade));
            p.idade = Integer.parseInt(idade);
            do{
                System.out.println("\tDigite o email do participante:");
                System.out.print("\t");
                p.email = entrada.nextLine();
                if (!ValidarEmail(p.email)) {
                    System.out.println("\n\tEmail inválido! Digite um email válido (ex: usuario@dominio.com).");
                    System.out.println("\n\tPressione Enter para tentar novamente...");
                    entrada.nextLine();
                    LimparTela();
                    Titulo();
                }
            } while (!ValidarEmail(p.email));
            listaParticipantes.add(p);
            LimparTela();
            Titulo();
            System.out.println("\n\n┌──────────────────────────────────────────────────────────────────┐");
                System.out.println("│                Participante cadastrado com sucesso!              │");
                System.out.println("└──────────────────────────────────────────────────────────────────┘");
                System.out.println("\n\n\tPressione Enter para continuar...");
                entrada.nextLine();
            
            do { 
                LimparTela();
                Titulo();
                System.out.print("\n\tDeseja cadastrar outro participante? (S/N): ");
                System.out.print("\n\t");
                opcao = entrada.nextLine();
                    if (!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")) {
                        System.out.println("\n\tOpção inválida!!! \n\tDigite 'S' para sim ou 'N' para não.");
                        System.out.println("\n\n\tPressione Enter para continuar...");
                        entrada.nextLine();
                    }
            } while (!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"));

        } while(opcao.equalsIgnoreCase("S"));        

    }

    public static void ListarParticipantes(){
        //─│┌┐└┘├┤┬┴┼ 
        LimparTela();
        Titulo();
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│                                      Participantes Cadastrados                                   │");
            System.out.println("├─────┬─────────────────────────────────────────┬───────┬──────────────────────────────────────────┤");
        System.out.printf("│ %-3s │ %-39s │ %-5s │ %-40s │%n", "#", "Nome", "Idade", "Email");
            System.out.println("├─────┼─────────────────────────────────────────┼───────┼──────────────────────────────────────────┤");
        for (int i = 0; i < listaParticipantes.size(); i++) {
            System.out.printf("│ %-3d │ %-39s │ %-5s │ %-40s │%n",
                    i + 1,
                    listaParticipantes.get(i).nome,
                    listaParticipantes.get(i).idade,
                    listaParticipantes.get(i).email
                );
        }
        System.out.println("└─────┴─────────────────────────────────────────┴───────┴──────────────────────────────────────────┘");
    }

    public static void BuscarParticipantePorNome(){
        LimparTela();
        Titulo();
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("\tDigite o nome do participante para buscar: ");
        String busca = entrada.nextLine();
        for (int i = 0; i < listaParticipantes.size(); i++) {
            Participante p = listaParticipantes.get(i);
            if (p.nome.equalsIgnoreCase(busca)) {
                LimparTela();
                Titulo();
                System.out.println("\n\n┌────────────────────────────────────────────────────────────────┐");
                    System.out.println("│                    Participante Encontrado                     │");
                    System.out.println("├─────┬────────────┬────────────┬────────────────────────────────┤");
                System.out.printf("│ %-3s │ %-10s │ %-10s │ %30s │%n", "#", "Nome", "Idade", "Email");
                    System.out.println("├─────┼────────────┼────────────┼────────────────────────────────┤");


                    System.out.printf("│ %-3d │ %-10s │ %-10s │ %30s │%n",
                    i + 1,
                    p.nome,
                    p.idade,
                    p.email
                );
                System.out.println("└─────┴────────────┴────────────┴────────────────────────────────┘");
                return;
            }
        }
        LimparTela();
        Titulo();
        System.out.println("\n\n┌──────────────────────────────────────────────────────────────────┐");
            System.out.println("│                    Participante não encontrado                   │");
            System.out.println("└──────────────────────────────────────────────────────────────────┘");
    }

    public static void RemoverParticipante(){
        LimparTela();
        Titulo();
        Scanner entrada = new Scanner(System.in);
        System.out.print("\tDigite o nome do participante a remover: ");
        String busca = entrada.nextLine();
        for (int i = 0; i < listaParticipantes.size(); i++) {
            Participante p = listaParticipantes.get(i);
            if (p.nome.equalsIgnoreCase(busca)) {
                listaParticipantes.remove(p);            
            }
            
            if(!listaParticipantes.contains(p)){
                LimparTela();
                Titulo();
                System.out.println("\n\n┌──────────────────────────────────────────────────────────────────┐");
                    System.out.println("│                Participante removido com sucesso!                │");
                    System.out.println("└──────────────────────────────────────────────────────────────────┘");
            }
        }
    }

    public static void ExibirEstatisticas() {
        int totalParticipantes = 0;
        double mediaIdade = 0;
        int qtdJovens = 0;
        int qtdAdultos = 0;
        int qtdIdosos = 0;
        int somaIdades = 0;

        for(Participante p : listaParticipantes){
            totalParticipantes++;
            somaIdades += p.idade;
            if(p.idade >= 0 && p.idade < 18){
                qtdJovens++;
            }
            else if(p.idade >= 18 && p.idade < 60){
                qtdAdultos++;
            }
            else {
                qtdIdosos++;
            }            
        }

        if(totalParticipantes > 0){
            mediaIdade = (double)somaIdades / (double)totalParticipantes;
        }
        



        //─│┌┐└┘├┤┬┴┼
        LimparTela();
        Titulo();
          System.out.println("\n┌────────────────────────────────────────────┐");
            System.out.println("│                 Estatísticas               │");
            System.out.println("├───────────────────────────┬────────────────┤");
        System.out.printf("│ %-25s │ %14s │%n", "Total de Participantes", totalParticipantes);
            System.out.println("├───────────────────────────┼────────────────┤");
            System.out.printf("│ %-25s │ %14.2f │%n", "Média de Idade", mediaIdade);
            System.out.println("├───────────────────────────┼────────────────┤");      
            System.out.printf("│ %-25s │ %14s │%n", "Quantidade Jovens", qtdJovens);
            System.out.println("├───────────────────────────┼────────────────┤");
            System.out.printf("│ %-25s │ %14s │%n", "Quantidade Adultos", qtdAdultos);
            System.out.println("├───────────────────────────┼────────────────┤");
            System.out.printf("│ %-25s │ %14s │%n", "Quantidade Idosos", qtdIdosos);
            System.out.println("└───────────────────────────┴────────────────┘");
    }

    

    public static int Menu(){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        do {
            LimparTela();
            Titulo();
            System.out.println("\tEscolha uma opção: \n");
            System.out.println("\t1 - Cadastrar Participante");
            System.out.println("\t2 - Listar Participantes");
            System.out.println("\t3 - Buscar Participante por nome");
            System.out.println("\t4 - Remover Participante por nome");
            System.out.println("\t5 - Exibir Estatísticas");
            System.out.println("\t6 - Sair");
            if (!entrada.hasNextInt()) {
                System.out.println("\n\tOpção inválida!\n");
                entrada.nextLine();
                continue;
            }
            System.out.print("\t");
            opcao = entrada.nextInt();
            entrada.nextLine(); // Limpar buffer
            switch (opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    // entrada.close();
                    return opcao;
                default:
                    System.out.println("\n\tOpção inválida!\n");
                    entrada.nextLine();
                    break;
            }
        } while (true);
        
    }

    public static void Titulo(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                GESTÃO DE PARTICIPANTES EM EVENTO                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("\n");
    }

    public static void LimparTela() {
        try {
            // Cria um processo que executa "cmd /c cls"
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()          // Redireciona a saída para o console atual
                .start()
                .waitFor();           // Aguarda o término do comando
        } catch (Exception e) {
            System.err.println("\n\tErro ao limpar a tela: " + e.getMessage());
        }
    }

    public static Boolean ValidarNome(String nome){
        if (nome == null || nome.isEmpty()) {
            return false;
        }

        for (int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);

            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static Boolean ValidarEmail(String email){
        if (email == null || email.isEmpty()) {
            return false;
        }

        int arroba = email.indexOf('@');

        // Deve ter apenas um @ e não pode ser no início/fim
        if (arroba <= 0 || arroba != email.lastIndexOf('@') || arroba == email.length() - 1) {
            return false;
        }

        int ponto = email.indexOf('.', arroba);

        // Deve existir ponto depois do @
        if (ponto == -1 || ponto == arroba + 1 || ponto == email.length() - 1) {
            return false;
        }

        // Verifica caracteres inválidos
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);

            boolean valido =
                    Character.isLetterOrDigit(c) ||
                    c == '@' ||
                    c == '.' ||
                    c == '_' ||
                    c == '-';

            if (!valido) {
                return false;
            }
        }

        return true;
    }

    public static Boolean ValidarIdade(String idade){
        if (idade == null || idade.isEmpty()) {
            return false;
        }

        for (int i = 0; i < idade.length(); i++) {
            if (!Character.isDigit(idade.charAt(i))) {
                return false;
            }
        }

        int valorIdade = Integer.parseInt(idade);
        if(valorIdade < 0 || valorIdade > 160){
            return false;
        }

        return true;
    }

}
