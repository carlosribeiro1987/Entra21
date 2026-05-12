import java.util.Scanner;

public class ExercicioArray {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int[] pares = new int[10];
        int[] impares = new int[10];
        int somaPares = 0;
        int somaImpares = 0;
        try(Scanner entrada = new Scanner(System.in);) {
            int iP = 0;
            int iI = 0;
            for(int i = 0; i < 10; i++){
                System.out.println("Digite um número: ");
                numeros[i] = entrada.nextInt();
                if(numeros[i] % 2 == 0){
                    pares[iP] = numeros[i];
                    iP++;
                }
                else{
                    impares[iI] = numeros[i];
                    iI++;
                }
            }            
        }

        System.out.print("\n\n Pares:");
        
        for(int par: pares){
            if(par != 0){
                System.out.print(" | " + par);
            }            
            somaPares += par;            
        }
        System.out.print(" |\n");
        System.out.println(" Soma PARES: " + somaPares);
        System.out.print("\n\n Ímpares:");
        for(int impar: impares){
            if(impar != 0){
                System.out.print(" | " + impar);
            }
            
            somaImpares += impar;
        }
        System.out.print(" |\n");
        System.out.println(" Soma ÍMPARES: " + somaImpares);
        System.out.println("\n\n");
    }
}
