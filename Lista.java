import java.util.ArrayList;
import java.io.Serializable;

/**
 * Implementação da interface IArmazenador utilizando a classe ArrayList do Java.
 * Atende ao requisito do uso de uma nova Estrutura de Dados da biblioteca padrão.
 * * @author Ana Clara Boaventura Dattoli, Gabriel Teixeira Botta, Livia de Aguiar Almeida Figueiredo
 * @version 1.0 2026/03/31
 */
public class Lista implements IArmazenador, Serializable {

    // Utilizando o ArrayList nativo do Java
    private ArrayList<Object> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void adicionar(Object obj) {
        lista.add(obj);
    }

    @Override
    public Object remover(int i) {
        // Verifica se o índice é válido antes de remover
        if (i >= 0 && i < lista.size()) {
            return lista.remove(i);
        }
        return null;
    }

    @Override
    public Object buscar(int i) {
        // Verifica se o índice é válido antes de buscar
        if (i >= 0 && i < lista.size()) {
            return lista.get(i);
        }
        return null;
    }

    @Override
    public boolean estaVazia() {
        return lista.isEmpty();
    }

    @Override
    public int getQtd() {
        return lista.size();
    }
}