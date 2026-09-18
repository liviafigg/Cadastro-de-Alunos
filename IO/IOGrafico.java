package IO;

import javax.swing.JOptionPane;

public class IOGrafico implements IEntradaSaida {
    
    public String lerString(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public void mostrarMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
