import java.util.Scanner;

public class DiaDaSemana {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite um numero de 1 a 7");
        int dia = entrada.nextInt();

        switch (dia) {
            case 1:
                System.out.println("\nDomingo.");
                break;
            case 2:
                System.out.println("\nSegunda-feira.");
                break;
            case 3:
                System.out.println("\nTerça-feira.");
                break;
            case 4:
                System.out.println("\nQuarta-feira.");
                break;
            case 5:
                System.out.println("\nQuinta-feira.");
                break;
            case 6:
                System.out.println("\nSexta-feira.");
                break;
            case 7:
                System.out.println("\nSábado.");
                break;

            default:
                break;
        }
        entrada.close();;
    }

}
