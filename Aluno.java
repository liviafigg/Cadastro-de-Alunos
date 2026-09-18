/**
 * Classe que representa um Aluno no sistema de cadastro.
 * Herda os dados básicos (nome e idade) da classe Pessoa e adiciona 
 * informações específicas do contexto acadêmico (RA, curso e semestre).
 * * @author Ana Clara Boaventura Dattoli, Gabriel Teixeira Botta, Livia de Aguiar Almeida Figueiredo
 * @version 1.0 2026/03/31
 */

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {
    private String ra;
    private String curso;
    private int semestre;
    
    /**
     * Construtor da classe Aluno.
     * Passa o nome e a idade para a superclasse Pessoa inicializar e guarda os dados locais.
     * * @param nome String contendo o nome do aluno
     * @param idade int com a idade do aluno
     * @param ra String contendo o Registro Acadêmico (matrícula)
     * @param curso String indicando o curso do aluno
     * @param semestre int indicando o semestre atual
     */
    
    Aluno(String nome, int idade, String ra, String curso, int semestre){
        super(nome, idade);
        this.ra = ra;
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getRa() { return ra; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    public void setRa(String ra) { this.ra = ra; }

    @Override
    public String toString(){
        return super.toString() + "\nRA: " + ra + "\nCurso: " + curso + "\nSemestre: " + semestre;
    }
}