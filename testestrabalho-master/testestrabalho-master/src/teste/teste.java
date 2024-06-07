package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class teste {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<obj> objeto = new ArrayList<>();
        int posição = 0;
        int tempo = 0;
        int opcao = 0;

        do {
            System.out.println("1-Adicionar elementos\n2-Listar elementos\n3-Calcular valores\n0-Parar");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a posição: ");
                    posição = ler.nextInt();
                    System.out.print("Digite o tempo: ");
                    tempo = ler.nextInt();

                    while (!tempoRepetido(objeto, tempo)) {
                        System.out.print("Tempo repetido, digite outro valor: ");
                        tempo = ler.nextInt();
                    }

                    objeto.add(new obj(posição, tempo));
                    Collections.sort(objeto);
                    break;

                case 2:
                    for (obj n : objeto) {
                        System.out.println(n);
                    }
                    break;
                case 3:
                    if (objeto.size() < 2) {
                        System.out.println("Não há elementos suficientes para calcular velocidade e aceleração.");
                    } else {
                        double[] vetorVelocidade = calcularVelocidade(objeto);
                        calcularAceleração(objeto, vetorVelocidade);
                    }
                    break;
            }
        } while (opcao != 0);
    }

    public static boolean tempoRepetido(List<obj> objeto, int tempo) {
        for (obj n : objeto) {
            if (n.getTempo() == tempo) {
                return false;
            }
        }
        return true;
    }

    public static boolean tempoZero(List<obj> objeto) {
        for (obj n : objeto) {
            if (n.getTempo() == 0) {
                return true;
            }
        }
        return false;
    }

    public static double[] calcularVelocidade(List<obj> objeto) {
        double[] vetorVelocidade = new double[objeto.size() - 1];
        for (int i = 0; i < vetorVelocidade.length; i++) {
            vetorVelocidade[i] = (double)(objeto.get(i+1).getPosicao() - objeto.get(i).getPosicao()) / (objeto.get(i+1).getTempo() - objeto.get(i).getTempo());
            System.out.println("Velocidade " + (i+1) + ": " + vetorVelocidade[i] + " m/s");
        }
        return vetorVelocidade;
    }

    public static void calcularAceleração(List<obj> objeto, double[] vetorVelocidade) {
        if (vetorVelocidade.length < 2) {
            System.out.println("Não há velocidades suficientes para calcular aceleração.");
            return;
        }
        double[] vetorAceleração = new double[vetorVelocidade.length - 1];
        for (int i = 0; i < vetorAceleração.length; i++) {
            vetorAceleração[i] = (vetorVelocidade[i+1] - vetorVelocidade[i]) / (objeto.get(i+2).getTempo() - objeto.get(i+1).getTempo());
            System.out.println("Aceleração " + (i+1) + ": " + vetorAceleração[i] + " m²/s");
        }
    }
}
