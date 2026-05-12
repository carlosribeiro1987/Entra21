public class ExemploArray {
    public static void main(String[] args) {

        int[] numeros = new int[5];
        //{10, 20, 30, 40, 50}
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;

        // Acessando elementos
        System.out.println("Primeiro número: " + numeros[0]);
        System.out.println("Terceiro número: " + numeros[2]);

        // Percorrendo o array
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posição " + i + ": " + numeros[i]);
        }
    }
}