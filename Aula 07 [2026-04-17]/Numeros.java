public class Numeros {
    public static void main(String[] args) {
        String pares = "| ";
        String impares = "| ";
        int soma = 0;
        for(int i = 1; i <= 10; i++){
            if(i % 2 == 0){
                pares += (String.valueOf(i) + " | ");
            }
            else{
                
                impares += (String.valueOf(i) + " | ");
            }
            soma += i;
        }
        System.out.println("PARES: \t\t"+ pares);
        System.out.println("IMPARES: \t"+ impares);
        System.out.println("SOMA: \t\t| "+ soma + " |");        
    }


}