import java.util.Scanner;

public class SomaWhile {
    public static void main(String[] args) {
        int count = 1;
        int soma1 = 0;
        Scanner entrada = new Scanner(System.in);
        int valor = 0;
        int soma2 = 0;
        // dSoma 1 a 100
        while(count <= 100){ 
            soma1 += count;
            count++;
        }
        System.out.println("\n\nSoma dos números de 1 até 100 = " + soma1 );


        // Soma enquanto usuário não digitar 0
        do{
            soma2 += valor;
            System.out.println("\nSoma atual = " + soma2);
            System.out.println("\nDigite um valor para somar ou 0 para sair: ");
            valor = entrada.nextInt();
            System.out.println("\n");
        }while(valor != 0);

        entrada.close();
    }
}
