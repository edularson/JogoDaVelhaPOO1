package armazenamento;

import java.io.*;
import java.util.HashMap;

/**
 * Classe para gerenciar jogadores e suas pontuações utilizando arquivo de texto.
 * Implementa a interface GerenciaJogadores.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores {
    private HashMap<String, Integer> jogadores;
    private static final String ARQUIVO = "jogadores.txt";

    /**
     * Construtor da classe GerenciaJogadoresArquivo.
     * Inicializa o HashMap e carrega os dados do arquivo.
     */
    public GerenciaJogadoresArquivo() {
        jogadores = new HashMap<>();
        carregarDados();
    }

    /**
     * Carrega os dados dos jogadores a partir do arquivo de texto.
     * Cada linha do arquivo deve estar no formato "nome:pontos".
     * Em caso de erro na leitura do arquivo, uma mensagem de erro é exibida.
     */
    private void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String nome = partes[0].trim();
                    int pontos = Integer.parseInt(partes[1].trim());
                    jogadores.put(nome, pontos);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    /**
     * Salva os dados dos jogadores no arquivo de texto.
     * Cada jogador é salvo em uma linha no formato "nome:pontos".
     * Em caso de erro na escrita do arquivo, uma mensagem de erro é exibida.
     */
    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (String nome : jogadores.keySet()) {
                writer.write(nome + ":" + jogadores.get(nome));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    /**
     * Adiciona um jogador com pontuação inicial zero, se o jogador ainda não existir.
     *
     * @param nome O nome do jogador a ser adicionado.
     */
    @Override
    public void adicionarJogador(String nome) {
        if (!jogadores.containsKey(nome)) {
            jogadores.put(nome, 0);
            salvarDados();
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
        if (jogadores.containsKey(nome)) {
            int pontuacaoAtual = jogadores.get(nome);
            jogadores.put(nome, pontuacaoAtual + pontos);
            salvarDados();
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
        return jogadores.getOrDefault(nome, 0);
    }

    /**
     * Exibe as pontuações de todos os jogadores na saída padrão.
     * Cada linha contém o nome do jogador seguido pela sua pontuação.
     */
    @Override
    public void exibirPontuacoes() {
        System.out.println("Pontuações dos jogadores:");
        for (String nome : jogadores.keySet()) {
            int pontos = jogadores.get(nome);
            System.out.println(nome + ": " + pontos + " pontos");
        }
    }
}
