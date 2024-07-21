package jogodavelha;

/**
 * Representa o tabuleiro do jogo da velha.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class Tabuleiro {
    private char[][] tabuleiro;
    private static final int TAMANHO = 3;

    /**
     * Construtor que inicializa o tabuleiro e o reinicia.
     */
    public Tabuleiro() {
        tabuleiro = new char[TAMANHO][TAMANHO];
        reiniciarTabuleiro();
    }

    /**
     * Reinicia o tabuleiro preenchendo todas as posições com espaços em branco.
     */
    public void reiniciarTabuleiro() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    /**
     * Verifica se a posição especificada no tabuleiro está vazia.
     *
     * @param linha a linha da posição a ser verificada
     * @param coluna a coluna da posição a ser verificada
     * @return true se a posição está vazia, false caso contrário
     */
    public boolean isPosicaoVazia(int linha, int coluna) {
        return tabuleiro[linha][coluna] == ' ';
    }

    /**
     * Realiza uma jogada no tabuleiro na posição especificada pela jogada.
     *
     * @param jogada a jogada a ser realizada
     * @return true se a jogada foi feita com sucesso, false se a posição já está ocupada
     * @throws PosicaoInvalidaException se a posição especificada na jogada é inválida
     */
    public boolean fazerJogada(Jogada jogada) throws PosicaoInvalidaException {
        if (jogada.getLinha() < 0 || jogada.getLinha() >= TAMANHO || jogada.getColuna() < 0 || jogada.getColuna() >= TAMANHO) {
            throw new PosicaoInvalidaException("Posição inválida! Tente novamente.");
        }
        if (tabuleiro[jogada.getLinha()][jogada.getColuna()] != ' ') {
            return false;
        }
        tabuleiro[jogada.getLinha()][jogada.getColuna()] = jogada.getSimbolo();
        return true;
    }

    /**
     * Exibe o tabuleiro na saída padrão.
     */
    public void exibir() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
                if (j < TAMANHO - 1) System.out.print("|");
            }
            System.out.println();
            if (i < TAMANHO - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    /**
     * Verifica se o tabuleiro está completamente preenchido (sem espaços vazios).
     *
     * @return true se o tabuleiro está completo, false caso contrário
     */
    public boolean estaCompleto() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica se há um vencedor no jogo da velha, analisando linhas, colunas e diagonais.
     *
     * @return true se há um vencedor, false caso contrário
     */
    public boolean temVencedor() {
        // Verificar linhas, colunas e diagonais
        for (int i = 0; i < TAMANHO; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
                return true;
            }
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ') {
                return true;
            }
        }
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ') {
            return true;
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ') {
            return true;
        }
        return false;
    }
}