/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estrutura_dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class Estrutura_dados {

    public static void main(String[] args) {
        String nomeArquivo = "C:\\Portuguese (Brazilian).dic";
        Estrutura_dados manipulador = new Estrutura_dados(nomeArquivo);

        manipulador.mostrarQuantidadeCaracteresPalavras();
    }
    
    // Variável para armazenar o nome do arquivo
    private String nomeArquivo;

    // Construtor que recebe o nome do arquivo como parâmetro
    public Estrutura_dados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    // Método para contar o número de linhas em um arquivo
    private int contarLinhas(File arquivo) throws IOException {
        int contador = 0;
        // Cria um BufferedReader para ler o arquivo
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            // Enquanto houver uma linha no arquivo, incrementa o contador
            while (leitor.readLine() != null) {
                contador++;
            }
        }
        // Retorna o número total de linhas no arquivo
        return contador;
    }
    
    // Método para preencher um vetor com as linhas de um arquivo
    private void preencherVetor(File arquivo, String[] vetor) throws IOException {
        // Cria um BufferedReader para ler o arquivo
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            int indice = 0;
            String linha;
            // Enquanto houver uma linha no arquivo, armazena-a no vetor
            while ((linha = leitor.readLine()) != null) {
                vetor[indice++] = linha; // Preenche o vetor com a linha atual
            }
        }
    }
    
    // Método para ler as linhas do arquivo e armazená-las em um array de strings
    public String[] lerLinhas() throws IOException {
        // Abre o arquivo
        File arq = new File(nomeArquivo);

        // Verifica se o arquivo existe
        if (!arq.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado: " + nomeArquivo);
        }

        // Conta o número de linhas no arquivo
        int numLinhas = contarLinhas(arq);

        // Cria o vetor com o tamanho correto para armazenar as linhas
        String[] vetor = new String[numLinhas];

        // Lê as linhas do arquivo e preenche o vetor
        preencherVetor(arq, vetor);

        // Retorna o vetor com as linhas do arquivo
        return vetor;
    }

    public void mostrarQuantidadeCaracteresPalavras() {
        try {
            // Cria um BufferedReader para ler o arquivo
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            // Itera sobre cada linha do arquivo
            while ((linha = leitor.readLine()) != null) {
                // Divide a linha em palavras usando o espaço como delimitador
                String[] palavras = linha.split("\\s+");

                // Itera sobre cada palavra
                for (String palavra : palavras) {
                    // Calcula e exibe o número de caracteres na palavra
                    int quantidadeCaracteres = palavra.length();
                    System.out.println(palavra + " " + quantidadeCaracteres);
                }
            }
            // Fecha o leitor
            leitor.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
