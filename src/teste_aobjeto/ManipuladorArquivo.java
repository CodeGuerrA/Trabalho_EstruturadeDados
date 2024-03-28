
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste_aobjeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class ManipuladorArquivo {

    private String dicionarioBr; // Declaração da variável para armazenar o nome do arquivo do dicionário em português.
    private String dicionarioEs; // Declaração da variável para armazenar o nome do arquivo do dicionário em italiano.

    public ManipuladorArquivo(String nomeArquivoBr, String nomeArquivoES) { // Construtor da classe ManipuladorArquivo que recebe os nomes dos arquivos dos dicionários em português e italiano.
        this.dicionarioBr = nomeArquivoBr; // Atribui o nome do arquivo do dicionário em português à variável dicionarioBr.
        this.dicionarioEs = nomeArquivoES; // Atribui o nome do arquivo do dicionário em italiano à variável dicionarioIt.
    }

    public void processarDicionario(String nomeDicionario, String[] palavras) { // Método para processar o dicionário, recebendo o nome do dicionário e um array de palavras como parâmetros.
        System.out.println("\n" + nomeDicionario); // Imprime o nome do dicionário.

        int escolhaOrdenacao; // Declaração da variável para armazenar a escolha do tipo de ordenação.

        do { // Início do loop do-while para permitir a seleção da ordenação enquanto o usuário não escolher sair.
            System.out.println("Escolha uma forma de ordenação:"); // Imprime instruções para escolha do tipo de ordenação.
            System.out.println("0-Para voltar ao menu principal"); // Imprime a opção para voltar ao menu principal.
            System.out.println("1-InsertionSort"); // Imprime a opção para selecionar o algoritmo de ordenação Insertion Sort.
            System.out.println("2-SelectionSort"); // Imprime a opção para selecionar o algoritmo de ordenação Selection Sort.

            Scanner sc = new Scanner(System.in); // Instância um objeto Scanner para receber entrada do usuário.
            escolhaOrdenacao = sc.nextInt(); // Lê a escolha de ordenação do usuário.

            switch (escolhaOrdenacao) { // Início do switch-case para executar a ordenação selecionada pelo usuário.
                case 0: // Caso a escolha seja 0, o loop é encerrado.
                    break;
                case 1: // Caso a escolha seja 1, é selecionado o Insertion Sort para ordenar o array de palavras.
                    System.out.println("Iniciando ordenação InsertionSort:"); // Imprime mensagem indicando que a ordenação por Insertion Sort está iniciando.
                    long inicio = System.currentTimeMillis(); // Registra o tempo inicial.
                    Ordenation.insertionSortByLength(palavras); // Chama o método de ordenação Insertion Sort da classe Ordenation.
                    ManipuladorArquivo.mostrarPalavrasComprimentos(palavras); // Chama o método para mostrar as palavras ordenadas e seus comprimentos.
                    long fim = System.currentTimeMillis(); // Registra o tempo final.
                    long total = fim - inicio; // Calcula o tempo total de execução.
                    System.out.println(total + " milissegundos "); // Imprime o tempo total de execução.
                    break;
                case 2: // Caso a escolha seja 2, é selecionado o Selection Sort para ordenar o array de palavras.
                    System.out.println("Iniciando ordenação Selection Sort: "); // Imprime mensagem indicando que a ordenação por Selection Sort está iniciando.
                    inicio = System.currentTimeMillis(); // Registra o tempo inicial.
                    Ordenation.selectionSortBylenght(palavras); // Chama o método de ordenação Selection Sort da classe Ordenation.
                    ManipuladorArquivo.mostrarPalavrasComprimentos(palavras); // Chama o método para mostrar as palavras ordenadas e seus comprimentos.
                    fim = System.currentTimeMillis(); // Registra o tempo final.
                    total = fim - inicio; // Calcula o tempo total de execução.
                    System.out.println(total + "milissegundos"); // Imprime o tempo total de execução.
                    break;
                default: // Caso a escolha seja inválida, imprime mensagem de opção inválida.
                    System.out.println("Opção inválida.");
            }
        } while (escolhaOrdenacao != 0); // Loop continua enquanto a escolha for diferente de 0 (saída do menu).
    }

    public static void mostrarPalavrasComprimentos(String[] palavras) {
        for (String palavra : palavras) { // Itera sobre cada palavra no array de palavras.
            if (palavra != null) { // Verifica se a palavra não é nula.
                System.out.println(palavra + " " + palavra.length()); // Imprime a palavra seguida do seu comprimento.
            } else { // Caso a palavra seja nula, imprime mensagem indicando que uma palavra nula foi encontrada.
                System.out.println("Palavra nula encontrada.");
            }
        }
    }
}

class FileHandler { // Classe auxiliar para manipulação de arquivos.

    public static String[] readFileAndCleanData(String filePath) { // Método estático para ler e limpar os dados de um arquivo, recebendo o caminho do arquivo como parâmetro.
        String[] cleanedLines = null; // Declaração de um array de strings para armazenar as linhas limpas do arquivo.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Utiliza um BufferedReader para ler o arquivo.
            int tamanhoVetor = Integer.parseInt(reader.readLine().replaceAll("\\s+", "").split("/")[0]); // Lê a primeira linha do arquivo, que indica o tamanho do vetor de palavras.
            cleanedLines = new String[tamanhoVetor]; // Inicializa o array cleanedLines com o tamanho especificado.

            String line; // Variável para armazenar cada linha lida do arquivo.
            int i = 0; // Variável para controlar a posição no array cleanedLines.
            while ((line = reader.readLine()) != null && i < tamanhoVetor) { // Loop para ler cada linha do arquivo até o final ou até atingir o tamanho máximo do vetor.
                String cleanedLine = line.replaceAll("\\s+", "").split("/")[0]; // Limpa a linha removendo espaços em branco e separando por '/'.
                // Lê cada linha, limpa e adiciona ao array
                cleanedLines[i++] = cleanedLine.split("/")[0]; // Adiciona a palavra limpa ao array cleanedLines e incrementa o índice.
            }
        } catch (IOException e) { // Tratamento de exceção para erros de leitura de arquivo.
            e.printStackTrace(); // Imprime o rastreamento da pilha de exceção.
        }
        return cleanedLines; // Retorna o array de linhas limpas.
    }
}
