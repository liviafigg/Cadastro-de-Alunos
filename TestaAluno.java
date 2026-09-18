
/**
 * Write a description of class TestaAluno here.
 *
 * @author Ana Clara Boaventura Dattoli, Gabriel Teixeira Botta, Livia de Aguiar Almeida Figueiredo
 * @version 2026/03/31
 */
public class TestaAluno {
    public static void main(String args[]) {
        Aluno a = new Aluno("Ze da Silva Pereira Antunes", 22, "RA123456", "Engenharia Civil", 3);

        System.out.println(a);
        System.out.println("Nome bibliografico: " + a.getNomeBiblio());
    }
}