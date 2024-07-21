package entradadados;

import java.util.Scanner;
import jogodavelha.Jogada;
import jogodavelha.Jogador;

/**
 * Classe para lidar com entrada de dados pelo console.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class Console {
    // Scanner para ler entrada do teclado
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Lê uma linha de texto do console.
     *
     * @return A linha de texto lida.
     */
    public static String lerString() {
        return scanner.nextLine();
    }

    /**
     * Lê um número inteiro do console.
     *
     * @return O número inteiro lido.
     */
    public static int lerInt() {
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer de entrada
        return valor;
    }

    /**
     * Lê uma jogada do jogador especificado pelo console.
     *
     * @param jogador O jogador que está fazendo a jogada.
     * @return A jogada feita pelo jogador.
     */
    public static Jogada lerJogada(Jogador jogador) {
        System.out.print(jogador.getNome() + " (" + jogador.getSimbolo() + "), digite a linha (0, 1 ou 2) e a coluna (0, 1 ou 2) separados por espaço: ");
        int linha = scanner.nextInt();
        int coluna = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer de entrada
        return new Jogada(linha, coluna, jogador.getSimbolo());
    }
}
