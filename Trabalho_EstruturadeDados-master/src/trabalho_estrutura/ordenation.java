/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho_estrutura;

/**
 *
 * @author carlo
 */
public class ordenation {

    public static void insertionSortByLength(String[] palavras) {
        for (int i = 1; i < palavras.length; i++) {
            String chave = palavras[i];
            int j = i;

            while (j > 0 && palavras[j - 1].length() > chave.length()) {
                palavras[j] = palavras[j - 1];
                j = j - 1;
            }
            palavras[j] = chave;
        }
    }

    public static void selectionSortBylenght(String[] palavras) {
        for (int i = 0; i < palavras.length - 1; i++) {
            int imenor = i;

            for (int j = i + 1; j < palavras.length; j++) {
                // Comparação de strings usando compareToIgnoreCase para ignorar diferenças de maiúsculas/minúsculas
                if (palavras[j].length() < palavras[imenor].length()) {
                    imenor = j;
                }
            }

            // Troca as palavras de posição
            String smallNumber = palavras[imenor];
            palavras[imenor] = palavras[i];
            palavras[i] = smallNumber;
        }
    }

    public static void mergeSortMain(String palavras[], int ini, int fim) {
        if (ini < fim) {
            int m = (ini + fim) / 2;
            mergeSortMain(palavras, ini, m);
            mergeSortMain(palavras, m + 1, fim);
            mergeSortIntercala(palavras, ini, m, fim);
        }
    }

    public static void mergeSortIntercala(String palavras[], int ini, int m, int fim) {
        String palavrasAux[] = new String[palavras.length];

        for (int i = ini; i <= m; i++) {
            palavrasAux[i] = palavras[i];
        }

        for (int i = m + 1; i <= fim; i++) {
            palavrasAux[fim + m + 1 - i] = palavras[i];
        }

        int i = ini;
        int j = fim;

        for (int k = ini; k <= fim; k++) {
            if (palavrasAux[i].length() <= palavrasAux[j].length()) {
                palavras[k] = palavrasAux[i];
                i++;
            } else {
                palavras[k] = palavrasAux[j];
                j--;
            }
        }
    }

    public static void quickSortMain(String palavras[], int ini, int fim) {
        // Verifica se ainda há elementos a serem ordenados
        if (ini < fim) {
            // Particiona o array e retorna o índice do pivô
            int q = quickSortParti(palavras, ini, fim);
            // Chama recursivamente o Quicksort para as partições à esquerda e à direita do pivô
            quickSortMain(palavras, ini, q);
            quickSortMain(palavras, q + 1, fim);
        }
    }

    // Método de particionamento do Quicksort
    public static int quickSortParti(String palavras[], int ini, int fim) {
        // Seleciona o pivô como o primeiro elemento do array
        String pivot = palavras[ini];
        // Define índices inicial e final para a iteração
        int i = ini - 1;
        int j = fim + 1;
        // Loop principal do particionamento
        while (true) {
            // Encontra um elemento à esquerda do pivô que seja maior ou igual ao pivô
            do {
                i++;
            } while (palavras[i].length() < pivot.length());
            // Encontra um elemento à direita do pivô que seja menor ou igual ao pivô
            do {
                j--;
            } while (palavras[j].length() > pivot.length());
            // Se os índices se cruzarem ou se encontrar o pivô, retorna o índice de partição
            if (i >= j) {
                return j;
            }
            // Troca os elementos encontrados acima
            String temp = palavras[i];
            palavras[i] = palavras[j];
            palavras[j] = temp;
        }
    }
}
