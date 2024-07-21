package jogodavelha;

import java.util.Random;

/**
 * Representa um jogador controlado por um algoritmo aleatório (bot) no jogo da velha.
 * Extende a classe abstrata Jogador.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class Bot extends Jogador {
    private Random random;

    /**
     * Construtor da classe Bot.
     *
     * @param nome    O nome do jogador.
     * @param simbolo O símbolo que representa o jogador no tabuleiro (normalmente 'X' ou 'O').
     */
    public Bot(String nome, char simbolo) {
        super(nome, simbolo);
        random = new Random();
    }

    /**
     * Realiza a jogada aleatória do bot no tabuleiro.
     *
     * @param tabuleiro O tabuleiro atual do jogo.
     * @return A jogada realizada pelo bot.
     */
    public Jogada realizarJogada(Tabuleiro tabuleiro) {
        int linha, coluna;
        do {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);
        } while (!tabuleiro.isPosicaoVazia(linha, coluna));

        System.out.println("Jogada do BOT...");
        return new Jogada(linha, coluna, getSimbolo());
    }
}
