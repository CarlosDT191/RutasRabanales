package rutas;
import javax.swing.*;

import bundle.LanguageManager;

import java.awt.*;

public class Ayuda extends JPanel {
    public Ayuda() {
        setLayout(new BorderLayout());
        add(new JLabel(LanguageManager.getBundle().getString("help_title"), SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
