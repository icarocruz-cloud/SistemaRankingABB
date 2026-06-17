package estruturarakig;

public class Jogador {

    private String nome;
    private int pontuacao;
    private String fase;
    private double tempoJogo;

    public Jogador(String nome, int pontuacao, String fase, double tempoJogo) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.fase = fase;
        this.tempoJogo = tempoJogo;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getFase() {
        return fase;
    }

    public double getTempoJogo() {
        return tempoJogo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Pontuação: " + pontuacao +
                " | Fase: " + fase +
                " | Tempo: " + tempoJogo + "h";
    }
}
