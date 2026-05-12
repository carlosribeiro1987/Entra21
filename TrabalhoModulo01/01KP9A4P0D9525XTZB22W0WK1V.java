// Sistema de Cadastro de Pessoas
// Funcionalidades:
// Menu interativo (switch)
// Cadastrar pessoa
// Listar pessoas
// Buscar pessoa por nome
// Sair

// Cadastro de pessoa
// Usar variáveis de diferentes tipos (int para codigo, String para nome, double para salario).
// Estruturas de controle (if/else)
// Validar se salario é maior ou igual a 5000 → alto, senão → baixo.
// Estruturas de repetição (for/while)
// while para manter o menu rodando até o usuário escolher sair.
// Utilizar o comando for para percorrer a lista de pessoas.
// Manipulação de arrays e coleções
// Array simples para salarios.
// ArrayList para armazenar as pessoas cadastradas.

// O que esse trabalho verificará:
// Variáveis e tipos de dados: String, int, double.
// Operadores: comparação (>=, ==).
// Estruturas de controle: if/else, switch.
// Estruturas de repetição: for, while.
// Arrays e coleções: ArrayList para pessoas, array poderia ser usado para salarios se quiser expandir.

// Exemplo com notas de alunos em JAVA:

import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    int idade;
    double nota;

    Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    void mostrarInfo() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Nota: " + nota);
        if (nota >= 7) {
            System.out.println("Situação: Aprovado");
        } else {
            System.out.println("Situação: Reprovado");
        }
    }
}

public class SistemaAlunos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno por nome");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();
                    listaAlunos.add(new Aluno(nome, idade, nota));
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Alunos ---");
                    for (Aluno a : listaAlunos) {
                        a.mostrarInfo();
                        System.out.println("-------------------");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome para buscar: ");
                    String busca = sc.nextLine();
                    boolean encontrado = false;
                    for (Aluno a : listaAlunos) {
                        if (a.nome.equalsIgnoreCase(busca)) {
                            a.mostrarInfo();
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        sc.close();
    }
}
