package jogodavelha;

/**
 * Exceção lançada quando uma escolha inválida é feita no jogo da velha.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */
public class EscolhaInvalidaException extends Exception {

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param message Mensagem de erro detalhando a escolha inválida.
     */
    public EscolhaInvalidaException(String message) {
        super(message);
    }
}
