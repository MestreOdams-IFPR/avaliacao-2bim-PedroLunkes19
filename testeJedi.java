import java.util.Scanner;

public class testeJedi {
    
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        int qtdAceitos;
        int[] vet;
        
        while(sc.hasNext()){
            n = sc.nextInt();
            qtdAceitos = sc.nextInt();
            vet = new int[n];

            for (int i = 0; i < n; i++) {
                vet[i] = sc.nextInt();
            }

            System.out.println(calcularForcaMin(vet, qtdAceitos));
        }

    }

    public static int calcularForcaMin(int[] vet , int qtdAceitos){
        mergeSort(vet, 0, vet.length);
        int minForca = 0;

        for (int i = 0; i < qtdAceitos; i++) {
            minForca += vet[vet.length-1-i];
        }

        return minForca;
    }

    public static void mergeSort(int[] vet, int inicio, int fim) {
        int meio = 0;

        if (inicio < fim-1) {
            meio = (inicio + fim) / 2;
            mergeSort(vet, inicio, meio);
            mergeSort(vet, meio + 1, fim);
            intercalar(vet, inicio, meio, fim);
        }

    }

    public static void intercalar(int vet[], int inicio, int meio, int fim) {
        int i = inicio, j = meio, k = 0;
        int[] vetAux = new int[fim - inicio];

        while (i < meio && j < fim) {
            if (vet[i] <= vet[j]) {
                vetAux[k++] = vet[i++];
            } else {
                vetAux[k++] = vet[j++];
            }

        }

        while (i < meio) {
            vetAux[k++] = vet[i++];
        }

        while (j < fim) {
            vetAux[k++] = vet[j++];
        }

        for (i = inicio; i < fim; i++) {
            vet[i] = vetAux[i - inicio];
           }
    }

}

