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
            System.out.println("1-Adicionar elementos\n2-Listar elementos\n0-Parar");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a posição: ");
                    posição = ler.nextInt();
                    System.out.print("Digite o tempo: ");
                    tempo = ler.nextInt();

                    while (tempoRepetido(objeto, tempo) == false) {
                        System.out.print("Tempo repetido, digite outro valor: ");
                        tempo = ler.nextInt();
                    }
                    ;
                    objeto.add(new obj(posição, tempo));
                    Collections.sort(objeto);
                    break;

                case 2:
                    for (obj n : objeto) {
                        System.out.println(n);
                    }
                    if(tempoZero(objeto) == true){
                        System.out.println("Array tem zero!");
                    }else{
                        System.out.println("Array não tem zero!");
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
    
    public static boolean tempoZero(List<obj> objeto){
        for(obj n : objeto){
            if(n.getTempo() == 0){
                return true;
            }
        }
        return false;
    }
    
}
