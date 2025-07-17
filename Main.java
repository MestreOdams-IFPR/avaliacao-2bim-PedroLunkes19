
public class Main {
    public static void main(String[] args) {
        criarSentencaDancante("             This         is      a      dancing      sentence");
    }

    public static void criarSentencaDancante(String frase) {
        char[] fraseVet = frase.toCharArray();

        if (fraseVet.length > 1) {
            for (int i = 1; i < frase.length(); i++) {
                if (fraseVet[i] != ' ' && !Character.isUpperCase(fraseVet[i - 1])) {
                    fraseVet[i] = Character.toUpperCase(frase.charAt(i));

                }
            }
        } else {
            fraseVet[0] = Character.toUpperCase(fraseVet[0]);
        }

        frase = new String(fraseVet);
        System.out.println(frase);
    }

    public static int calcularPeel(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return (2 * calcularPeel(n - 1)) + calcularPeel(n - 2);
    }

    public static int calcularTribonacci(int n) {
        if (n <= 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        return calcularTribonacci(n - 1) + calcularTribonacci(n - 2) + calcularTribonacci(n - 3);

    }

    public static void metodoRec02( // Inverte um vetor
            int v[], int e, int d) {
        int t;
        if (e >= d)
            return;
        else {
            t = v[e];
            v[e] = v[d];
            v[d] = t;
            metodoRec02(v, e + 1, d - 1);
        }
    }
}