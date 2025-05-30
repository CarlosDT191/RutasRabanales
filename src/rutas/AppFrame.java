package rutas;

import javax.swing.*;
import java.awt.*;
import rutas.components.NavBar;
import rutas.components.Footer;
import bundle.LanguageManager;

public class AppFrame extends JFrame {
    private JPanel contentPanel;

    public AppFrame() {
        super(LanguageManager.getBundle().getString("title")); // Título según idioma

        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        contentPanel = new JPanel(new BorderLayout());

        // Añadir componentes
        add(new NavBar(this), BorderLayout.NORTH);
        add(new Footer(this), BorderLayout.SOUTH);
        add(contentPanel, BorderLayout.CENTER);

        // Página inicial
        setContent(new MainPage(this));

        setVisible(true);
    }

    /**
     * Cambia el contenido central del frame.
     */
    public void setContent(Component comp) {
        contentPanel.removeAll();
        contentPanel.add(comp, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    /**
     * Recarga toda la interfaz con el idioma actualizado.
     */
    public void refresh() {
        getContentPane().removeAll();  // Elimina todos los componentes

        setTitle(LanguageManager.getBundle().getString("title")); // Actualiza el título del frame

        add(new NavBar(this), BorderLayout.NORTH);
        add(new Footer(this), BorderLayout.SOUTH);
        add(contentPanel, BorderLayout.CENTER); // Reusa contentPanel

        // Por simplicidad: recargamos la página principal
        setContent(new MainPage(this));

        revalidate();
        repaint();
    }
}
