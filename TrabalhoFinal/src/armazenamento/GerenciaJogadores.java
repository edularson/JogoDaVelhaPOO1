package armazenamento;

/**
 * Interface para gerenciar informações de jogadores.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public interface GerenciaJogadores {

    /**
     * Adiciona um jogador com o nome especificado.
     *
     * @param nome Nome do jogador a ser adicionado.
     */
    void adicionarJogador(String nome);

    /**
     * Atualiza a pontuação do jogador especificado.
     *
     * @param nome   Nome do jogador cuja pontuação será atualizada.
     * @param pontos Novo valor da pontuação do jogador.
     */
    void atualizarPontuacao(String nome, int pontos);

    /**
     * Recupera a pontuação atual do jogador especificado.
     *
     * @param nome Nome do jogador cuja pontuação será recuperada.
     * @return Pontuação atual do jogador.
     * @throws IllegalArgumentException Se o jogador especificado não existir.
     */
    int recuperarPontuacao(String nome) throws IllegalArgumentException;

    /**
     * Exibe as pontuações de todos os jogadores.
     */
    void exibirPontuacoes();
}
