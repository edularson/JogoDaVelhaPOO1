package jogodavelha;

/**
 * Representa uma jogada feita por um jogador no jogo da velha.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class Jogada {
    private int linha;      // linha da jogada
    private int coluna;     // coluna da jogada
    private char simbolo;   // símbolo utilizado na jogada ('X' ou 'O')

    /**
     * Construtor da classe Jogada.
     *
     * @param linha A linha da jogada.
     * @param coluna A coluna da jogada.
     * @param simbolo O símbolo utilizado na jogada ('X' ou 'O').
     */
    public Jogada(int linha, int coluna, char simbolo) {
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
    }

    /**
     * Obtém a linha da jogada.
     *
     * @return A linha da jogada.
     */
    public int getLinha() {
        return linha;
    }

    /**
     * Obtém a coluna da jogada.
     *
     * @return A coluna da jogada.
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * Obtém o símbolo utilizado na jogada.
     *
     * @return O símbolo da jogada ('X' ou 'O').
     */
    public char getSimbolo() {
        return simbolo;
    }
}
