/**
 * Exceção personalizada lançada quando ocorre uma tentativa de cadastrar 
 * ou atualizar um aluno com uma idade fora do intervalo permitido pelas regras de negócio.
 * * @author Ana Clara Boaventura Dattoli, Gabriel Teixeira Botta, Livia de Aguiar Almeida Figueiredo
 * @version 1.0 2026/03/31
 */
public class IdadeInvalidaException extends Exception {

    /**
     * Construtor padrão da exceção IdadeInvalidaException.
     * Define uma mensagem genérica de erro de idade.
     */
    public IdadeInvalidaException() {
        super("Idade inválida.");
    }
    
    /**
     * Construtor da exceção IdadeInvalidaException que recebe uma mensagem customizada.
     * * @param msg String com os detalhes específicos do erro de validação
     */
    public IdadeInvalidaException(String msg) {
        super(msg);
    }
}