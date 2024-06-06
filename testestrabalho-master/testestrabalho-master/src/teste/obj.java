package teste;

public class obj implements Comparable<obj>{
    private int posicao;
    private int tempo;
    
    public obj(int posicao, int tempo) {
        this.posicao = posicao;
        this.tempo = tempo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "objeto{" + "posicao =" + posicao + ", tempo =" + tempo + '}';
    }
    
    @Override
    public int compareTo(obj objeto){
        if (this.tempo < objeto.tempo){
            return -1;
        }
        if (this.tempo > objeto.tempo){
            return 1;
        }
        return Integer.compare(this.posicao, objeto.posicao);
    }
}
