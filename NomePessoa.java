/**
 * Classe para armazenar o nome de uma pessoa. Possibilita inverter nome e limpar
 * espaços extras (operaçoes herdados da classe pai).
 * Retorna o nome da pessoa em formato de bibliografia
 * 
 * @author Ana Clara Boaventura Dattoli, Gabriel Teixeira Botta, Livia de Aguiar Almeida Figueiredo 
 * @version 1.0 2026/03/31
 */

import java.io.Serializable;

public class NomePessoa implements Serializable {
    // Atributos
    private Texto nome;

    /** 
     * Construtor: constroi objeto NomePessoa utilizando como none a classe Texto
     * 
     * @param nome String com o nome da pessoa que será armazenado
     */
    public NomePessoa(String nome){
        setNome(nome);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome.getTxt();
    }

    /**
     * @param nome the nome to set
     */
    protected void setNome(String nome) {
        
        // Cria objeto da classe Texto
        this.nome = new Texto(nome);
    }

    /**
     * Retorna quantidade de palavras do nome
     * @return qtd numero de palavras
     */
    public int getQtdePalavras(){
        return this.nome.getQtdePalavras();
    }
    
    /**
     * Retorna nome invertido
     * @return sInv nome invertido
     */
    public String getNomeInvertido(){
        return this.nome.inverterTexto();
    }

    /**
     * Retorna nome bibliografico
     * @return sBib nome bibliografico
     */
    public String getNomeBiblio(){

        // Separa as palavras
        String vts[] = this.nome.getTxt().split(" ");
        int qtd = vts.length;

        String sBib = vts[qtd-1] + ", "; // ultimo nome + a virgula
        // Monta o texto
        for (int i=0; i < (qtd-1); i++){
            String pal = vts[i].toLowerCase(); // pega palavra
            if(!verificaStr(pal)){ // Se nao for preposicao concatena
                sBib = sBib + vts[i].toUpperCase().charAt(0) + ". ";
            }
        }
        return sBib;
    }

    /**
     * Verifica se string eh uma String a ser retirada
     * @param s string a ser verificada
     * @return true eh preposicao false nao eh preposicao
     */
    private boolean verificaStr(String s){
        // Vetor de strings a serem retiradas
        final String sRet[]={"da", "de", "do", "di", "das", "dos", "e",};

        for (int i = 0; i < sRet.length; i++){
            if(sRet[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna os atributos como string
     */
    public String toString(){
        return "Nome: " + this.nome.toString();
    }

}

