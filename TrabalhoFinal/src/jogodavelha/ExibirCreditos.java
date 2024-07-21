package jogodavelha;

/**
 * Classe concreta que exibe os créditos do jogo da velha.
 * Estende a classe abstrata Creditos e implementa o método exibirCreditos para mostrar informações sobre o trabalho realizado.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class ExibirCreditos extends Creditos {

    /**
     * Sobrescreve o método exibirCreditos para mostrar os créditos específicos do trabalho.
     */
    @Override
    public void exibirCreditos() {
        System.out.println("ESTE É UM TRABALHO REALIZADO PELOS ALUNOS: EDUARDO LARSON e THIAGO CERON DE ALMEIDA.");
        System.out.println();
        System.out.println("NESTE TRABALHO REALIZAMOS UM CÓDIGO PARA DEMONSTRAR A CRIAÇÃO DE UM JOGO DA VELHA.");
        System.out.println();
        System.out.println("A FUNCIONALIDADE EXTRA É O USUÁRIO PODER JOGAR CONTRA UM BOT.");
    }
}
