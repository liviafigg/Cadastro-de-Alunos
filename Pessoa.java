/**
 * Classe para armazenar dados de uma pessoa (nome e idade). Utiliza a classe NomePessoa por composicao.
 * 
 * @author Ana Clara Boaventura Dattoli, Gabriel Teixeira Botta, Livia de Aguiar Almeida Figueiredo
 * @version 1.0 2026/03/31
 */

import java.io.Serializable;

public class Pessoa implements Serializable {

    // Atributos
    private NomePessoa nome; // Nome de pessoa como composicao (classe NomePessoa)
    private int idade;

    /** 
     * Construtor: constroi objeto Pessoa utilizando como nome a classe NomePessoa
     * 
     * @param nome String com o nome da pessoa que será armazenado
     * @param idade int com a idade da pessoa que será armazenado
     */
    Pessoa(String nome, int idade){

        // Cria objeto da classe NomePessoa
        this.nome = new NomePessoa(nome);

        this.idade = idade;
    }

    public String getNomeBiblio(){
        return(nome.getNomeBiblio());
    }
    
    /**
     * Retorna os atributos como string
     */
    public String toString(){
        return this.nome.toString() + "\nIdade: " + idade;
    }
    
    public void setNome(String novoNome) {
        // Cria um novo objeto NomePessoa para já limpar espaços extras e preparar o formato bibliográfico
        this.nome = new NomePessoa(novoNome); 
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
