package estruturarakig;

import java.util.Scanner;

public class SistemaRanking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArvoreABB ranking = new ArvoreABB();

        int opcao = -1;

        do {

            System.out.println("\n===== SISTEMA DE RANKING =====");
            System.out.println("1 - Inserir Jogador");
            System.out.println("2 - Buscar Jogador");
            System.out.println("3 - Remover Jogador");
            System.out.println("4 - Mostrar Ranking");
            System.out.println("5 - Mostrar Maior Pontuação");
            System.out.println("6 - Mostrar Menor Pontuação");
            System.out.println("7 - Quantidade de Jogadores");
            System.out.println("8 - Altura da Árvore");
            System.out.println("9 - Pré-Ordem");
            System.out.println("10 - Pós-Ordem");
            System.out.println("11 - Mostrar Estrutura da Árvore");
            System.out.println("12 - Encerrar");
            System.out.print("Opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERRO: Digite apenas números!");
                sc.nextLine();
                opcao = -1;
                continue;
            }

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    int pontuacao;

                    while (true) {
                        try {
                            System.out.print("Pontuação: ");
                            pontuacao = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("ERRO: Digite um número inteiro!");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Fase alcançada: ");
                    String fase = sc.nextLine();

                    double tempo;

                    while (true) {
                        try {
                            System.out.print("Tempo de jogo: ");
                            tempo = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("ERRO: Digite um número válido!");
                            sc.nextLine();
                        }
                    }

                    ranking.inserir(
                            new Jogador(
                                    nome,
                                    pontuacao,
                                    fase,
                                    tempo));

                    System.out.println("Jogador cadastrado com sucesso!");
                    break;

                case 2:

                    try {
                        System.out.print("Pontuação para busca: ");
                        int busca = sc.nextInt();
                        sc.nextLine();

                        Jogador jogador = ranking.buscar(busca);

                        if (jogador != null) {
                            System.out.println(jogador);
                        } else {
                            System.out.println("Jogador não encontrado.");
                        }

                    } catch (Exception e) {
                        System.out.println("Digite uma pontuação válida!");
                        sc.nextLine();
                    }

                    break;

                case 3:

                    try {
                        System.out.print("Pontuação do jogador a remover: ");
                        int remover = sc.nextInt();
                        sc.nextLine();

                        if (ranking.buscar(remover) != null) {

                            ranking.remover(remover);

                            System.out.println("Jogador removido com sucesso!");

                        } else {

                            System.out.println("Jogador não encontrado.");

                        }

                    } catch (Exception e) {
                        System.out.println("Digite uma pontuação válida!");
                        sc.nextLine();
                    }

                    break;

                case 4:

                    System.out.println("\n===== RANKING =====");
                    ranking.emOrdem();

                    break;

                case 5:

                    if (ranking.maiorPontuacao() != null)
                        System.out.println(ranking.maiorPontuacao());
                    else
                        System.out.println("Não há jogadores cadastrados.");

                    break;

                case 6:

                    if (ranking.menorPontuacao() != null)
                        System.out.println(ranking.menorPontuacao());
                    else
                        System.out.println("Não há jogadores cadastrados.");

                    break;

                case 7:

                    System.out.println("Quantidade de jogadores: "
                            + ranking.quantidade());

                    break;

                case 8:

                    System.out.println("Altura da árvore: "
                            + ranking.altura());

                    break;

                case 9:

                    System.out.println("\n===== PRÉ-ORDEM =====");
                    ranking.preOrdem();

                    break;

                case 10:

                    System.out.println("\n===== PÓS-ORDEM =====");
                    ranking.posOrdem();

                    break;

                case 11:

                    ranking.mostrarArvore();

                    break;

                case 12:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 12);

        sc.close();
    }
}
