/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho_estrutura;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Trabalho_Estrutura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dicionarioBr = "C:\\brasileiro.txt";
        String dicionarioEs = "C:\\spanish.txt";

        // Carregar palavras dos dicionários
        String[] palavrasBr = FileHandler.readFileAndCleanData(dicionarioBr);
        String[] palavrasEs = FileHandler.readFileAndCleanData(dicionarioEs);

        // Criar uma instância de ManipuladorArquivo
        ManipuladorArquivo manipulador = new ManipuladorArquivo(dicionarioBr, dicionarioEs);



        int escolhaPrincipal;
        do {
            System.out.println("Escolha um dicionario:");
            System.out.println("0-Para sair");
            System.out.println("1-Dicionario Brasileiro");
            System.out.println("2-Dicionario Espanhol");

            escolhaPrincipal = sc.nextInt();

            switch (escolhaPrincipal) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    manipulador.processarDicionario("Dicionario Brasileiro", palavrasBr);
                    break;
                case 2:
                    manipulador.processarDicionario("Dicionario Espanhol", palavrasEs);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolhaPrincipal != 0);

        sc.close();
    }

}
