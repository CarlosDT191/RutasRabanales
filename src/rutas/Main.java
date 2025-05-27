package rutas;

import javax.swing.*;
import java.awt.*;
import rutas.components.NavBar;
import rutas.components.Footer;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Rutas de Rabanales");
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());

        // Agregar componentes externos
        jf.add(new NavBar(), BorderLayout.NORTH);
        jf.add(new Footer(), BorderLayout.SOUTH);

        // Aquí podrías agregar un panel central (MainPage, etc.)
        jf.setVisible(true);
    }
}
