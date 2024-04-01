/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho_estrutura;

/**
 *
 * @author carlo
 */
public class busca {

    public static boolean buscaSequencial(String[] A, String palavras) {

        for (int i = 0; i < A.length; i++) {
            if (A[i].equals(palavras)) {
                return true;
            }
        }

        return false;
    }

    public int busca(String[] A, String palavras) {//descobre parte do vetor A que tem o tamanha desejado

        int inicidoTamanho;
        int fimTamanho;
        if (palavras.length() != 1) {
            inicidoTamanho = buscaBinaria(A, palavras.length(), 0, A.length);
        } else {
            inicidoTamanho = 0;
        }
        fimTamanho = buscaBinaria(A, palavras.length() + 1, 0, A.length);
        int next = palavras.length() + 2;
        int biggest = A[A.length - 1].length();
        while (fimTamanho < 0 && next <= biggest) {

        }
        fimTamanho = fimTamanho >= 0 ? fimTamanho : A.length - 1;
        if (inicidoTamanho == -1) {
            return -1;
        }
        for (int i = inicidoTamanho; i <= fimTamanho; i++) {
            if (A[i].equals(palavras)) {
                return i;
            }
        }
        return -1;
    }

    public static int search(String[] A, int palavras) {
        if (palavras == 1) {
            return A[0].length() == 1 ? 0 : -1;
        }
        return buscaBinaria(A, palavras, 0, A.length);
    }

    //teremos erro sempre ao procurar por uma palavra de tamanho 1. a função "search" evita um if a mais na função recursiva
    public static int buscaBinaria(String[] A, int palavras, int inicio, int fim) {
        if (inicio > fim) {
            return -1;
        }
        int meio = (fim + inicio) / 2;
        int tamanhoMeio = A[meio].length();
        if (tamanhoMeio == palavras) {
            if (A[meio - 1].length() != palavras) {
                return meio;
            } else {
                return buscaBinaria(A, palavras, inicio, meio - 1);
            }
        }
        if (tamanhoMeio > palavras) {
            return buscaBinaria(A, palavras, inicio, meio - 1);
        } else {
            return buscaBinaria(A, palavras, meio + 1, fim);
        }
    }
}
