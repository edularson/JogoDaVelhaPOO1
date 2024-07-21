package jogodavelha;
/**
 * Exceção lançada quando uma posição inválida é especificada.
 *
 * @author Eduardo Larson, Thiago Ceron de Almeida
 * @version 1.0
 */

public class PosicaoInvalidaException extends Exception {
    public PosicaoInvalidaException(String message) {

        /**
         * Construtor que recebe uma mensagem de erro.
         *
         * @param message a mensagem de erro detalhando a razão da exceção.
         */

        super(message);
    }
}
