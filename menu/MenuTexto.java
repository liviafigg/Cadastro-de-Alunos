package menu;

import java.util.Scanner;

/**
 * Classe responsável por exibir o menu em modo texto.
 */
public class MenuTexto implements IMenu {
    
    // É uma boa prática criar o Scanner como atributo da classe, 
    // assim você não cria um novo objeto Scanner toda vez que o menu for chamado.
    private Scanner sc = new Scanner(System.in);

    public int criarMenu(String opcoes[]){
        int opcao;
        
        // monta menu
        String itens = "";
        for (int i = 0; i < opcoes.length; i++){
            itens = itens + "\n" + opcoes[i];
        }
        
        itens = itens + "\n\nSelecione a opcao: ";

        // Mostra msg na console
        System.out.print(itens);
        
        // Faz a leitura pelo teclado
        String s = sc.nextLine();

        // Converte para inteiro
        opcao = Integer.parseInt(s);
        
        return opcao;
    }
}