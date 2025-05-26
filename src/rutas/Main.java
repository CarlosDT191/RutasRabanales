package rutas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Rutas de Rabanales");
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());    

        // Barra de navegación superior
        JPanel nav_bar = new JPanel(new BorderLayout());
        nav_bar.setBackground(new Color(36, 30, 78));
        
        JPanel left_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left_panel.setOpaque(false);
        
        JButton menu= new JButton("Rutas de Rabanales");
        ImageIcon logo= new ImageIcon("data/logo_rabanales.png");

        Image scaledImage = logo.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        JLabel icon_logo = new JLabel(resizedIcon);
        left_panel.add(icon_logo);
        left_panel.add(menu);

        JPanel right_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right_panel.setOpaque(false);
        
        JButton help= new JButton("Ayuda");
        JButton language= new JButton("Cambiar idioma a Inglés");
        JButton login= new JButton("Inicio de sesión");

        right_panel.add(help);
        right_panel.add(language);
        right_panel.add(login);

        nav_bar.add(left_panel, BorderLayout.WEST);
        nav_bar.add(right_panel, BorderLayout.EAST);

        jf.add(nav_bar, BorderLayout.NORTH);

        // Permitir la visibilidad de todo lo añadido
        jf.setVisible(true);    
    }
}
