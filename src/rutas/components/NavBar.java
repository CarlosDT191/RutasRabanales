package rutas.components;

import java.awt.*;
import javax.swing.*;

public class NavBar extends JPanel {
    public NavBar() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(36, 30, 78));

        // Panel izquierdo
        JPanel left_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left_panel.setOpaque(false);

        JButton menu = new JButton("Rutas de Rabanales");
        ImageIcon logo = new ImageIcon("data/logo_rr.png");
        Image scaledImage = logo.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH);
        JLabel icon_logo = new JLabel(new ImageIcon(scaledImage));

        left_panel.add(icon_logo);
        left_panel.add(menu);

        // Panel derecho
        JPanel right_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right_panel.setOpaque(false);

        JButton help = new JButton("Ayuda");
        JButton language = new JButton("Cambiar idioma a Inglés");
        JButton login = new JButton("Inicio de sesión");

        right_panel.add(help);
        right_panel.add(language);
        right_panel.add(login);

        this.add(left_panel, BorderLayout.WEST);
        this.add(right_panel, BorderLayout.EAST);
    }
}