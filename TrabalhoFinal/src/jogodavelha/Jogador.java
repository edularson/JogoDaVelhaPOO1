package jogodavelha;

/**
 * Representa um jogador no jogo da velha.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class Jogador {
    private String nome;
    private char simbolo;
    private int pontuacao;

    /**
     * Construtor para criar um novo jogador.
     *
     * @param nome O nome do jogador.
     * @param simbolo O símbolo usado pelo jogador no jogo (normalmente 'X' ou 'O').
     */
    public Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.pontuacao = 0;
    }

    /**
     * Obtém o nome do jogador.
     *
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o símbolo do jogador.
     *
     * @return O símbolo do jogador.
     */
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * Obtém a pontuação atual do jogador.
     *
     * @return A pontuação do jogador.
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Adiciona pontos à pontuação atual do jogador.
     *
     * @param pontos Os pontos a serem adicionados à pontuação do jogador.
     */
    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
    }
}
