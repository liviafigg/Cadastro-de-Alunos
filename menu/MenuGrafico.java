package menu;
import javax.swing.JOptionPane;

/**
 * Implementação de menu utilizando JOptionPane com botões (OptionDialog).
 * Cumpre o requisito de usar novos componentes gráficos do Swing.
 */
public class MenuGrafico implements IMenu {
    
    public int criarMenu(String opcoes[]){
        // Cria uma janela com botões reais clicáveis usando showOptionDialog
        int escolha = JOptionPane.showOptionDialog(null,
                "Selecione a operação desejada:",
                "Menu Principal - Cadastro de Alunos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        // Se o usuário fechar a janela no 'X', o valor retornado é -1. 
        // Nesse caso, forçamos o encerramento retornando a última opção (Sair).
        if (escolha == -1) return opcoes.length; 
        
        // Retorna a escolha + 1 porque os arrays em Java começam em 0,
        // mas o nosso switch-case no App.java começa em 1.
        return escolha + 1; 
    }
}