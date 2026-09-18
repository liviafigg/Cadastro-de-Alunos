package IO;

import java.util.Scanner;

public class IOTexto implements IEntradaSaida {
    private Scanner sc;

    public IOTexto() {
        this.sc = new Scanner(System.in);
    }

    public String lerString(String msg) {
        System.out.print(msg);
        String entrada = sc.nextLine();
        // Simula o botão "Cancelar" se o usuário não digitar nada e der Enter
        if (entrada.trim().isEmpty()) return null; 
        return entrada;
    }

    public void mostrarMensagem(String msg) {
        System.out.println("\n>>> " + msg + "\n");
    }
}
