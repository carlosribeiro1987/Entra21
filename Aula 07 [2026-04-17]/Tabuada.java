import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int valor = 0;        
        System.out.print("Digite o valor da tabuada: ");
        valor = entrada.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(valor + " x " + i + " = " + (valor * i));
            // System.out.printf("%d x %d = %d\n", valor, i, valor * i);
        }
        entrada.close();
    }
}
