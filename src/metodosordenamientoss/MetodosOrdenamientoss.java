
package metodosordenamientoss;

import java.awt.EventQueue;

public class MetodosOrdenamientoss {

        public static void main(String[] args) {
        EventQueue.invokeLater(() -> { // Es una buena practica en Swing para crear y mostrar ventanas de forma segura
            GuiMord GUI = new GuiMord();
            GUI.setVisible(true);
            GUI.setLocationRelativeTo(null);
        });
    }
    
}
