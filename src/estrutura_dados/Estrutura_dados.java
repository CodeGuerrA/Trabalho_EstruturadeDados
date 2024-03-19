/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estrutura_dados;

/**
 *
 * @author carlo
 */
public class Estrutura_dados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomeArquivo = "C:\\Romanian (Modern).txt";
        ManipuladorArquivo manipulador = new ManipuladorArquivo(nomeArquivo);

        manipulador.mostrarQuantidadeCaracteresPalavras();
    }

}
