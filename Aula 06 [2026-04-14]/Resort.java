import java.util.Scanner;

public class Resort {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int idade = 0;
        int qtdDiarias = 0;
        double valorDiaria = 0.0;
        double valorTotal = 0.0;
        String classificação = "Desconhecido";
        String situacao = "";
        int categoria = 0; // Desconhecido
        do {
            System.out.println("\n\n");
            System.out.println("Digite a idade da pessoa: ");
            idade = entrada.nextInt();
            if (idade < 0 || idade > 130) {
                System.out.println("\n\nIDADE INVÁLIDA!!!\n");               
                
            }
        } while (idade < 0 || idade > 130);

        do {
            System.out.println("Digite a quantidade de diárias:");
            qtdDiarias = entrada.nextInt();
            if (qtdDiarias < 1) {
                System.out.println("\n\nQUANTIDADE INVÁLIDA!!!\n");
            }
        } while (qtdDiarias < 1);

        if (idade >= 0 && idade < 10) {
            categoria = 1; // Crianças
        } else if (idade < 60) {
            categoria = 2; // Adultos
        } else {
            categoria = 3; // Idosos
        }

        switch (categoria) {
            case 1:
                classificação = "Criança";
                valorDiaria = 500.12;
                break;
            case 2:
                classificação = "Adulto";
                valorDiaria = 1000.14;
                break;
            case 3:
                classificação = "Idoso";
                valorDiaria = 700.25;
                break;
            default:
                classificação = "Desconhecido";
                valorDiaria = 0.0;
                break;
        }

        valorTotal = valorDiaria * qtdDiarias;
        situacao = valorTotal <= 3000.0 ? "Evoluir na fidelidade" : "Cliente fiel";

        System.out.println("\n\nIdade: " + idade + " | Categoria: " + categoria + " | Classificação: " + classificação + " | Valor diárias: " + valorTotal);
        System.out.println("Situação: "+ situacao);
        System.out.println("\n\n");
        entrada.close();
    }
}
