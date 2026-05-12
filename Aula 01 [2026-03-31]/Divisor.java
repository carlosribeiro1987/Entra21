import java.util.Scanner;
public class Divisor {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
       

        System.out.print("Digite o primeiro numero: ");
        int num1 = entrada.nextInt();
        System.out.print("Digite o segundo numero: ");
        int num2 = entrada.nextInt();
        if(num2 == 0){
            System.err.println("Imposivel dividir por zero!");
        }
        else{
            System.out.println("Resultado: " + (num1 / num2));
        }
    }
}
