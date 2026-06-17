package estruturarakig;

public class ArvoreABB {

    private No raiz;

    public void inserir(Jogador jogador) {
        raiz = inserirRec(raiz, jogador);
    }

    private No inserirRec(No no, Jogador jogador) {

        if (no == null)
            return new No(jogador);

        if (jogador.getPontuacao() < no.getJogador().getPontuacao()) {
            no.setEsquerda(inserirRec(no.getEsquerda(), jogador));
        } else {
            no.setDireita(inserirRec(no.getDireita(), jogador));
        }

        return no;
    }

    public Jogador buscar(int pontuacao) {
        No resultado = buscarRec(raiz, pontuacao);
        return resultado != null ? resultado.getJogador() : null;
    }

    private No buscarRec(No no, int pontuacao) {

        if (no == null ||
                no.getJogador().getPontuacao() == pontuacao)
            return no;

        if (pontuacao < no.getJogador().getPontuacao())
            return buscarRec(no.getEsquerda(), pontuacao);

        return buscarRec(no.getDireita(), pontuacao);
    }

    public void remover(int pontuacao) {
        raiz = removerRec(raiz, pontuacao);
    }

    private No removerRec(No no, int pontuacao) {

        if (no == null)
            return null;

        if (pontuacao < no.getJogador().getPontuacao()) {
            no.setEsquerda(removerRec(no.getEsquerda(), pontuacao));
        } else if (pontuacao > no.getJogador().getPontuacao()) {
            no.setDireita(removerRec(no.getDireita(), pontuacao));
        } else {

            if (no.getEsquerda() == null &&
                    no.getDireita() == null)
                return null;

            if (no.getEsquerda() == null)
                return no.getDireita();

            if (no.getDireita() == null)
                return no.getEsquerda();

            No sucessor = menorNo(no.getDireita());

            no.setJogador(sucessor.getJogador());

            no.setDireita(
                    removerRec(
                            no.getDireita(),
                            sucessor.getJogador().getPontuacao()
                    )
            );
        }

        return no;
    }

    private No menorNo(No no) {

        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }

        return no;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No no) {

        if (no != null) {

            emOrdemRec(no.getEsquerda());

            System.out.println(no.getJogador());

            emOrdemRec(no.getDireita());
        }
    }

    public void preOrdem() {
        preOrdemRec(raiz);
    }

    private void preOrdemRec(No no) {

        if (no != null) {

            System.out.println(no.getJogador());

            preOrdemRec(no.getEsquerda());

            preOrdemRec(no.getDireita());
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
    }

    private void posOrdemRec(No no) {

        if (no != null) {

            posOrdemRec(no.getEsquerda());

            posOrdemRec(no.getDireita());

            System.out.println(no.getJogador());
        }
    }

    public Jogador maiorPontuacao() {

        if (raiz == null)
            return null;

        No atual = raiz;

        while (atual.getDireita() != null) {
            atual = atual.getDireita();
        }

        return atual.getJogador();
    }

    public Jogador menorPontuacao() {

        if (raiz == null)
            return null;

        No atual = raiz;

        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }

        return atual.getJogador();
    }

    public int quantidade() {
        return contar(raiz);
    }

    private int contar(No no) {

        if (no == null)
            return 0;

        return 1 +
                contar(no.getEsquerda()) +
                contar(no.getDireita());
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no) {

        if (no == null)
            return -1;

        return Math.max(
                alturaRec(no.getEsquerda()),
                alturaRec(no.getDireita())
        ) + 1;
    }


    public void mostrarArvore() {

        System.out.println("\n===== ESTRUTURA DA ÁRVORE =====");

        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        mostrarArvoreRec(raiz, "", true);
    }

    private void mostrarArvoreRec(No no, String espaco, boolean ultimo) {

        if (no != null) {

            System.out.println(
                    espaco +
                    (ultimo ? "└── " : "├── ") +
                    no.getJogador().getPontuacao()
            );

            espaco += ultimo ? "    " : "│   ";

            mostrarArvoreRec(no.getEsquerda(), espaco, false);
            mostrarArvoreRec(no.getDireita(), espaco, true);
        }
    }
}
