import java.util.Scanner;

public class teste {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num;
        do {
            System.out.print("Digite um numero: ");
            num = entrada.nextInt();
            if(num % 2 == 0){
                System.out.println("Numero " + num + " = PAR\n");
            }
            else{
                System.out.println("Numero" + num + " = IMPAR\n");
            }
        } while(num >= 0);
    }
    
}
