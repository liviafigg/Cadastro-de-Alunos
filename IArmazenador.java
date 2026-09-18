/**
 * Interface padronizada para armazenamento de dados dinâmicos.
 */
public interface IArmazenador {
    void adicionar(Object obj);
    Object remover(int i);
    Object buscar(int i);
    boolean estaVazia();
    int getQtd(); // Adicionado para permitir a contagem sem quebrar o encapsulamento
}