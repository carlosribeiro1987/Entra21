/*
* Programa que registra votos de uma assembleia
* Criado pelo DeepSeek.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class AssembleiaVotacao {

    static class Voto {
        String nome;
        String opcao;

        public Voto(String nome, String opcao) {
            this.nome = nome;
            this.opcao = opcao;
        }

        @Override
        public String toString() {
            return nome + " - " + opcao;
        }
    }

    // Scanner como atributo estático para ser usado em todos os métodos
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Voto> votos = new ArrayList<>();
        boolean executando = true;

        System.out.println("=== SISTEMA DE VOTACAO DA ASSEMBLEIA ===");
        System.out.println("(Para melhor visualizacao, execute em terminal com suporte a UTF-8)\n");

        do {
            exibirMenuPrincipal();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    menuRegistrarVotos(votos);
                    break;
                case 2:
                    menuListarVotos(votos);
                    break;
                case 3:
                    menuExibirResultado(votos);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (executando);

        scanner.close();
        System.out.println("Sistema finalizado.");
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1 - Registrar voto");
        System.out.println("2 - Listar todos os votos");
        System.out.println("3 - Exibir resultado");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Digite um numero.");
            scanner.next();
            System.out.print("Escolha: ");
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa buffer
        return valor;
    }

    // Submenu para registrar votos (repete até o usuário voltar ou sair)
    private static void menuRegistrarVotos(ArrayList<Voto> votos) {
        boolean subAtivo = true;
        do {
            registrarVoto(votos);
            subAtivo = exibirSubmenu("1 - Registrar outro voto");
        } while (subAtivo);
    }

    // Submenu para listar votos (repete até o usuário voltar ou sair)
    private static void menuListarVotos(ArrayList<Voto> votos) {
        boolean subAtivo = true;
        do {
            listarVotos(votos);
            subAtivo = exibirSubmenu("1 - Listar novamente");
        } while (subAtivo);
    }

    // Submenu para exibir resultado (repete até o usuário voltar ou sair)
    private static void menuExibirResultado(ArrayList<Voto> votos) {
        boolean subAtivo = true;
        do {
            exibirResultado(votos);
            subAtivo = exibirSubmenu("1 - Exibir resultado novamente");
        } while (subAtivo);
    }

    // Exibe um submenu genérico e retorna true se deve repetir a operação
    private static boolean exibirSubmenu(String opcaoRepetir) {
        System.out.println("\n--- Submenu ---");
        System.out.println(opcaoRepetir);
        System.out.println("2 - Voltar ao menu principal");
        System.out.println("0 - Sair do programa");
        System.out.print("Escolha: ");

        int escolha = lerOpcao();
        switch (escolha) {
            case 1:
                return true;   // continua no submenu (repete a operação)
            case 2:
                return false;  // volta ao menu principal
            case 0:
                System.out.println("Encerrando o sistema...");
                System.exit(0); // encerra o programa imediatamente
            default:
                System.out.println("Opcao invalida. Voltando ao menu principal.");
                return false;
        }

    }

    private static void registrarVoto(ArrayList<Voto> votos) {
        System.out.println("\n--- REGISTRO DE VOTO ---");
        System.out.print("Nome do votante: ");
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Nome nao pode ser vazio. Voto nao registrado.");
            return;
        }

        System.out.println("Escolha a opcao de voto:");
        System.out.println("1 - Sim");
        System.out.println("2 - Nao");
        System.out.println("3 - Abstencao");
        System.out.print("Digite o numero: ");

        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Voto nao registrado.");
            return;
        }

        String votoOpcao;
        switch (escolha) {
            case 1: votoOpcao = "Sim"; break;
            case 2: votoOpcao = "Nao"; break;
            case 3: votoOpcao = "Abstencao"; break;
            default:
                System.out.println("Opcao inexistente. Voto nao registrado.");
                return;
        }

        votos.add(new Voto(nome, votoOpcao));
        System.out.println("Voto registrado com sucesso!");
    }

    private static void listarVotos(ArrayList<Voto> votos) {
        System.out.println("\n--- LISTA DE VOTOS ---");
        if (votos.isEmpty()) {
            System.out.println("Nenhum voto registrado ate o momento.");
        } else {
            for (int i = 0; i < votos.size(); i++) {
                System.out.println((i + 1) + ". " + votos.get(i));
            }
        }
    }

    private static void exibirResultado(ArrayList<Voto> votos) {
        System.out.println("\n--- RESULTADO DA VOTACAO ---");
        if (votos.isEmpty()) {
            System.out.println("Nenhum voto registrado. Nao ha resultado.");
            return;
        }

        int sim = 0, nao = 0, abstencao = 0;
        for (Voto v : votos) {
            switch (v.opcao) {
                case "Sim": sim++; break;
                case "Nao": nao++; break;
                case "Abstencao": abstencao++; break;
            }
        }

        int total = votos.size();
        System.out.println("Total de votos: " + total);
        System.out.println("Sim:        " + sim + " votos (" + percentual(sim, total) + "%)");
        System.out.println("Nao:        " + nao + " votos (" + percentual(nao, total) + "%)");
        System.out.println("Abstencao:  " + abstencao + " votos (" + percentual(abstencao, total) + "%)");

        if (sim > nao) {
            System.out.println("Resultado: PROPOSTA APROVADA.");
        } else if (nao > sim) {
            System.out.println("Resultado: PROPOSTA REJEITADA.");
        } else {
            System.out.println("Resultado: EMPATE.");
        }
    }

    private static int percentual(int parte, int total) {
        return (int) Math.round((parte * 100.0) / total);
    }
}