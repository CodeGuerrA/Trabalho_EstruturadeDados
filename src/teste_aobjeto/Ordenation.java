/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste_aobjeto;

/**
 *
 * @author carlo
 */
public class Ordenation {

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
}
