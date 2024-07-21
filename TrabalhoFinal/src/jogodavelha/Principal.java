package jogodavelha;

import java.util.Scanner;
import armazenamento.GerenciaJogadoresArrayList;
import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.GerenciaJogadores;

/**
 * Classe Principal que contém o método main e gerencia o menu principal do jogo da velha.
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class Principal {
    private char opcao;

    /**
     * Método principal que inicializa o jogo da velha e gerencia o menu principal.
     * @param args Argumentos de linha de comando (não utilizado neste programa).
     */
    public static void main(String[] args) {
        Principal principal = new Principal();

        Jogo jogo = new Jogo();
        Scanner scanner = new Scanner(System.in);
        GerenciaJogadores gerenciajogadores = new GerenciaJogadoresArquivo();
        ExibirCreditos exibir = new ExibirCreditos();

        // Loop principal para manter o menu ativo até a opção de sair ser escolhida
        while (true) {
            // Exibindo o menu
            System.out.println("=== Menu ===");
            System.out.println("1 - Jogar");
            System.out.println("2 - Créditos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lendo a opção do usuário
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Para consumir a quebra de linha após o nextInt()

            // Switch-case para escolher a opção
            switch (opcao) {
                case 1:
                    System.out.println("Opção selecionada: Jogar");
                    jogo.iniciar();
                    break;
                case 2:
                    System.out.println("Opção selecionada: Créditos");
                    exibir.exibirCreditos();
                    break;
                case 3:
                    System.out.println("Opção selecionada: Sair");

                    System.out.println("Encerrando o jogo...");
                    System.out.println("Jogo encerrado.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }
}