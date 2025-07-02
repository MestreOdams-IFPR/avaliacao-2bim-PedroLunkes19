import java.util.Scanner;

public class ordemJedi {
    
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // int qtdAceitos;
        // int[] vet;
        // int n;

        int x;
        int y;
        int[] pos;
        int cont = 0;
        
        // while(sc.hasNext()){
        //     n = sc.nextInt();
        //     qtdAceitos = sc.nextInt();
        //     vet = new int[n];

        //     for (int i = 0; i < n; i++) {
        //         vet[i] = sc.nextInt();
        //     }

        //     System.out.println(calcularForcaMin(vet, qtdAceitos));
        // }

        
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();

            if (x == 0 && y == 0) {
                break;
            }

            int[] cristais = new int[x];
            int[] buscas = new int[y];
            pos = new int[y];

            lerVet(cristais);
            lerVet(buscas);
            pos = encontrarCristais(cristais, buscas, pos);

            cont++;
            imprimirCasos(pos, buscas, cont);
        }
        

    }

    public static void imprimirCasos(int[] pos, int[] perguntas, int cont){

        System.out.println("CASE# " + (cont) + ':');
        for (int i = 0; i < pos.length; i++) {
            if(pos[i] == 0){
                System.out.println(perguntas[i] + " not found");
            }else{
                System.out.println(perguntas[i] + " found at " + pos[i]);
            }
           
        }
    }

    public static int[] encontrarCristais(int[] cristais, int[] buscas, int[] pos){
        mergeSort(cristais, 0, cristais.length);

        for (int i = 0; i < buscas.length; i++) {
            for (int j = 0; j < cristais.length; j++) {
                if(cristais[j] == buscas[i]){
                    pos[i] = j+1;
                    break;
                }
            }
        }

        return pos;

    }

    
    
    public static void lerVet(int[] vet){
        for (int i = 0; i < vet.length; i++) {
            vet[i] = sc.nextInt();
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

    

    public static void mergeSort(int vet[], int inicio, int fim) {
        int meio = 0;
        if (inicio < fim - 1) {
            meio = (inicio + fim) / 2;
            mergeSort(vet, inicio, meio);
            mergeSort(vet, meio, fim);
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

