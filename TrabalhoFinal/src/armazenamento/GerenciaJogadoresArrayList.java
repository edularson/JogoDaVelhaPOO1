package armazenamento;

import java.util.ArrayList;

/**
 * Implementação da interface GerenciaJogadores usando ArrayList para armazenar informações dos jogadores.
 *
 * @author Seu Nome
 * @version 1.0
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores {
    private ArrayList<JogadorInfo> jogadores;

    /**
     * Construtor da classe GerenciaJogadoresArrayList.
     * Inicializa a lista de jogadores.
     */
    public GerenciaJogadoresArrayList() {
        jogadores = new ArrayList<>();
    }

    /**
     * Adiciona um jogador à lista, se ele ainda não existir.
     *
     * @param nome O nome do jogador a ser adicionado.
     */
    @Override
    public void adicionarJogador(String nome) {
        if (!existeJogador(nome)) {
            jogadores.add(new JogadorInfo(nome));
        }
    }

    /**
     * Atualiza a pontuação de um jogador existente.
     *
     * @param nome   O nome do jogador cuja pontuação será atualizada.
     * @param pontos Os pontos a serem adicionados à pontuação atual do jogador.
     */
    @Override
    public void atualizarPontuacao(String nome, int pontos) {
        JogadorInfo jogador = encontrarJogador(nome);
        if (jogador != null) {
            jogador.adicionarPontos(pontos);
        }
    }

    /**
     * Recupera a pontuação atual de um jogador.
     *
     * @param nome O nome do jogador cuja pontuação será recuperada.
     * @return A pontuação atual do jogador, ou zero se o jogador não existir.
     */
    @Override
    public int recuperarPontuacao(String nome) {
        JogadorInfo jogador = encontrarJogador(nome);
        return (jogador != null) ? jogador.getPontuacao() : 0;
    }

    /**
     * Exibe as pontuações de todos os jogadores na saída padrão.
     */
    @Override
    public void exibirPontuacoes() {
        System.out.println("Pontuações dos jogadores:");
        for (JogadorInfo jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getPontuacao() + " pontos");
        }
    }

    /**
     * Verifica se um jogador existe na lista de jogadores.
     *
     * @param nome O nome do jogador a ser verificado.
     * @return true se o jogador existir na lista, false caso contrário.
     */
    private boolean existeJogador(String nome) {
        return encontrarJogador(nome) != null;
    }

    /**
     * Busca um jogador na lista de jogadores pelo nome.
     *
     * @param nome O nome do jogador a ser buscado.
     * @return O objeto JogadorInfo correspondente ao jogador encontrado, ou null se não encontrado.
     */
    private JogadorInfo encontrarJogador(String nome) {
        for (JogadorInfo jogador : jogadores) {
            if (jogador.getNome().equals(nome)) {
                return jogador;
            }
        }
        return null;
    }

    /**
     * Classe interna para armazenar informações dos jogadores.
     */
    private static class JogadorInfo {
        private String nome;
        private int pontuacao;

        /**
         * Construtor da classe JogadorInfo.
         *
         * @param nome O nome do jogador.
         */
        public JogadorInfo(String nome) {
            this.nome = nome;
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
         * Obtém a pontuação atual do jogador.
         *
         * @return A pontuação atual do jogador.
         */
        public int getPontuacao() {
            return pontuacao;
        }

        /**
         * Adiciona pontos à pontuação atual do jogador.
         *
         * @param pontos Os pontos a serem adicionados à pontuação atual do jogador.
         */
        public void adicionarPontos(int pontos) {
            pontuacao += pontos;
        }
    }
}
