package jogodavelha;

import armazenamento.GerenciaJogadoresArrayList;
import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.GerenciaJogadores;
import entradadados.Console;

/**
 * Classe que representa o jogo da velha.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private GerenciaJogadores gerenciaJogadores;

    /**
     * Construtor padrão que inicializa o tabuleiro e a gerência de jogadores.
     */

    public Jogo() {
        tabuleiro = new Tabuleiro();
        gerenciaJogadores = new GerenciaJogadoresArquivo(); // Usa a implementação que salva em arquivo
    }

    /**
     * Método para iniciar os jogadores do jogo.
     * Permite ao usuário escolher entre jogador vs jogador ou jogador vs bot.
     *
     * @throws EscolhaInvalidaException se a escolha feita pelo usuário não for válida.
     */

    public void iniciarJogadores() {
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1 - Jogador vs Jogador");
        System.out.println("2 - Jogador vs Bot");

        try {
            int escolha = lerModoJogo();

            if (escolha == 1) {
                jogador1 = criarJogador('X');
                jogador2 = criarJogador('O');
            } else if (escolha == 2) {
                jogador1 = criarJogador('X');
                jogador2 = criarBot('O');
            } else {
                throw new EscolhaInvalidaException("Escolha inválida! Digite 1 ou 2.");
            }
            jogadorAtual = jogador1;
        } catch (EscolhaInvalidaException e) {
            System.out.println(e.getMessage());
            iniciarJogadores();
        }
    }

    /**
     * Método para ler o modo de jogo escolhido pelo usuário.
     *
     * @return a escolha feita pelo usuário (1 ou 2).
     * @throws EscolhaInvalidaException se a escolha não for válida.
     */

    public int lerModoJogo() throws EscolhaInvalidaException {
        int escolha;
        try {
            String entrada = Console.lerString();
            escolha = Integer.parseInt(entrada);

            if (escolha != 1 && escolha != 2) {
                throw new EscolhaInvalidaException("Escolha inválida! Digite 1 ou 2.");
            }
        } catch (NumberFormatException e) {
            throw new EscolhaInvalidaException("Entrada inválida! Digite apenas números.");
        }
        return escolha;
    }

    /**
     * Método para criar um jogador bot.
     *
     * @param simbolo o símbolo que representa o bot (X ou O).
     * @return o bot criado.
     */

    public Bot criarBot(char simbolo) {
        return new Bot("Bot", simbolo);
    }

    /**
     * Método principal que inicia o jogo da velha.
     * Controla o fluxo do jogo até que haja um vencedor ou empate.
     */

    public void iniciar() {
        tabuleiro.reiniciarTabuleiro();
        iniciarJogadores();
        while (!tabuleiro.estaCompleto() && !tabuleiro.temVencedor()) {
            tabuleiro.exibir();
            realizarJogada();
            trocarJogador();
        }
        tabuleiro.exibir();
        if (tabuleiro.temVencedor()) {
            Jogador vencedor = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            System.out.println("O vencedor é " + vencedor.getNome() + "!");
            gerenciaJogadores.atualizarPontuacao(vencedor.getNome(), 1);
            gerenciaJogadores.exibirPontuacoes();
        } else {
            System.out.println("O jogo terminou em empate.");
        }
    }

    /**
     * Método para criar um jogador humano.
     *
     * @param simbolo o símbolo que representa o jogador (X ou O).
     * @return o jogador criado.
     */

    public Jogador criarJogador(char simbolo) {
        System.out.print("Digite o nome do jogador que usará o símbolo '" + simbolo + "': ");
        String nome = Console.lerString();
        return new Jogador(nome, simbolo);
    }

    /**
     * Método para realizar uma jogada no tabuleiro.
     */

    public void realizarJogada() {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            try {
                Jogada jogada;
                if (jogadorAtual instanceof Bot) {
                    jogada = ((Bot) jogadorAtual).realizarJogada(tabuleiro);
                } else {
                    jogada = Console.lerJogada(jogadorAtual);
                }
                jogadaValida = tabuleiro.fazerJogada(jogada);
                if (!jogadaValida) {
                    System.out.println("Posição já ocupada. Tente novamente.");
                }
            } catch (PosicaoInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Método para trocar o jogador atual.
     */

    public void trocarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }
}
