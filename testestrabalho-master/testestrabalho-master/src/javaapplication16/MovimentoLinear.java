/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication16;

/**
 *
 * @author carlo
 */import java.util.ArrayList;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MovimentoLinear {
    
    // Método para calcular a velocidade instantânea a partir da função de posição
    public static double calcularVelocidade(double posicaoInicial, double posicaoFinal, double tempoInicial, double tempoFinal) {
        return (posicaoFinal - posicaoInicial) / (tempoFinal - tempoInicial);
    }
    
    // Método para calcular a aceleração a partir da função de velocidade
    public static double calcularAceleracao(double velocidadeInicial, double velocidadeFinal, double tempoInicial, double tempoFinal) {
        return (velocidadeFinal - velocidadeInicial) / (tempoFinal - tempoInicial);
    }
    
    // Método para verificar se os tempos estão em ordem crescente
    public static boolean isTemposOrdenados(double[] tempos) {
        for (int i = 1; i < tempos.length; i++) {
            if (tempos[i] < tempos[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definindo o tamanho do vetor
        System.out.print("Digite o número de valores de tempo e posição: ");
        int tamanho = scanner.nextInt();
        
        // Vetores para armazenar os valores de tempo e posição
        double[] tempos = new double[tamanho];
        double[] posicoes = new double[tamanho];
        
        // Primeiro valor inicial tanto no tempo quanto na posição é zero
        tempos[0] = 0.0;
        posicoes[0] = 0.0;
        
        // Preenchendo os vetores com os valores inseridos pelo usuário
        for (int i = 1; i < tamanho; i++) {
            System.out.print("Digite o valor do tempo " + (i + 1) + ": ");
            tempos[i] = scanner.nextDouble();
            
            System.out.print("Digite o valor da posição " + (i + 1) + ": ");
            posicoes[i] = scanner.nextDouble();
        }
        
        // Verificando se os tempos estão em ordem crescente e ordenando se necessário
        if (!isTemposOrdenados(tempos)) {
            Arrays.sort(tempos);
            // Ajustando a posição correspondente ao tempo inicial (mantendo-a como 0)
            posicoes[0] = posicoes[Arrays.binarySearch(tempos, 0)];
        }
        
        // Calculando a velocidade instantânea
        double velocidadeInstantanea = calcularVelocidade(posicoes[0], posicoes[tamanho - 1], tempos[0], tempos[tamanho - 1]);
        
        // Calculando a aceleração usando a derivada da velocidade
        double aceleracao = calcularAceleracao(0, velocidadeInstantanea, tempos[0], tempos[tamanho - 1]);
        
        // Exibindo os resultados com duas casas decimais
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Velocidade instantânea: " + df.format(velocidadeInstantanea) + " m/s");
        System.out.println("Aceleração: " + df.format(aceleracao) + " m/s^2");
        
        // Listando os valores de tempo e posição
        System.out.println("\nValores inseridos:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Tempo " + (i + 1) + ": " + df.format(tempos[i]) + " s");
            System.out.println("Posição " + (i + 1) + ": " + df.format(posicoes[i]) + " m");
        }
        
        scanner.close();
    }
}