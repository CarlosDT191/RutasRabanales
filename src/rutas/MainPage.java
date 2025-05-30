package rutas;

import javax.swing.*;
import java.awt.*;
import bundle.LanguageManager;

public class MainPage extends JPanel {
    public MainPage() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel(LanguageManager.getBundle().getString("welcome"), SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
