public class metodosOrdenacao {
    static int contador = 0;

    public static int[] bubblesort(int v[]) {
        int contador = 0;
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] > v[j]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
                contador++;
            }
        }
        System.out.println("Complexidade: " + contador);
        return v;
    }

    public static int[] insertionsort(int v[]) {
        int pivo, j, contador = 0;
        for (int i = 1; i < v.length; i++) {
            contador++;
            pivo = v[i];
            j = i - 1;
            while (j >= 0 && pivo < v[j]) {
                contador++;
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = pivo;
        }
        System.out.println("Complexidade: " + contador);
        return v;
    }

    public static void quicksort(int v[]) {
        contador = 0;
        quicksort2(v, 0, v.length - 1);

        System.out.println("Complexidade: " + contador);
    }

    public static void quicksort2(int v[], int inicio, int fim) {

        if (inicio < fim) {
            int meio = partition(v, inicio, fim);

            quicksort2(v, inicio, meio - 1);
            quicksort2(v, meio + 1, fim);
            contador++;
        }

    }

    public static void swap(int v[], int i, int j) {
        int aux = v[j];
        v[j] = v[i];
        v[i] = aux;
    }

    public static int partition(int v[], int inicio, int fim) {
        int pivo = v[fim];
        int i = (inicio - 1);

        for (int j = inicio; j <= fim - 1; j++) {
            if (v[j] < pivo) {
                i++;

                swap(v, i, j);
            }
        }

        swap(v, i + 1, fim);

        return i + 1;
    }

    public static int[] piorCaso(int tamanho) {
        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = tamanho - i;
        }

        return v;
    }

    public static int[] medioCaso(int tamanho) {
        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = (int) (Math.random() * tamanho);
        }

        return v;
    }

    public static int[] melhorCaso(int tamanho) {
        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = i;
        }

        return v;
    }

    public static void main(String[] args) {
        int tamanho_total = 1000;

        int[] melhor = melhorCaso(tamanho_total);
        int[] medio = medioCaso(tamanho_total);
        int[] pior = piorCaso(tamanho_total);




        System.out.println("------------------------------------------------");
        System.out.println("-------------------BUBBLESORT-------------------");
        System.out.println("\n\n\n");

        System.out.println("\nBUBBLESORT MELHOR CASO\n");
        for (int i = 1; i <= tamanho_total; i++) {
            bubblesort(melhorCaso(i));
        }
        
        System.out.println("\nBUBBLESORT CASOS MÉDIOS\n");
        for (int i = 0; i <= 10; i++) {
            System.out.println("\nCaso médio N°: " + i + "\n");

            for (int j = 1; j <= tamanho_total; j++) {
                bubblesort(medioCaso(j));
            }
            medio = medioCaso(tamanho_total);
        }

        System.out.println("\nBUBBLESORT PIOR CASO\n");
        for (int i = 1; i <= tamanho_total; i++) {
            bubblesort(piorCaso(i));
        }




        System.out.println("------------------------------------------------");
        System.out.println("-------------------INSERTIONSORT-------------------");
        System.out.println("\n\n\n");

        System.out.println("\nINSERTION MELHOR CASO\n");
        for (int i = 1; i <= tamanho_total; i++) {
            insertionsort(melhorCaso(i));
        }

        System.out.println("\nINSERTIONSORT CASOS MÉDIOS\n");
        for (int i = 0; i <= 10; i++) {
            System.out.println("\nCaso médio N°: " + i + "\n");

            for (int j = 1; j <= tamanho_total; j++) {
                insertionsort(medioCaso(j));
            }
            medio = medioCaso(tamanho_total);
        }

        System.out.println("\nINSERTIONSORT PIOR CASO\n");
        for (int i = 1; i <= tamanho_total; i++) {
            insertionsort(piorCaso(i));
        }


        

        System.out.println("------------------------------------------------");
        System.out.println("-------------------QUICKSORT-------------------");
        System.out.println("\n\n\n");

        System.out.println("\nQUICKSORT MELHOR CASO\n");
        for (int i = 1; i <= tamanho_total; i++) {
            quicksort(melhorCaso(i));
        }

        System.out.println("\nQUICKSORT CASOS MÉDIOS\n");
        for (int i = 0; i <= 10; i++) {
            System.out.println("\nCaso médio N°: " + i + "\n");

            for (int j = 1; j <= tamanho_total; j++) {
                quicksort(medioCaso(j));
            }
            medio = medioCaso(tamanho_total);
        }

        System.out.println("\nQUICKSORT PIOR CASO\n");
        for (int i = 1; i <= tamanho_total; i++) {
            quicksort(piorCaso(i));
        }
    }
}