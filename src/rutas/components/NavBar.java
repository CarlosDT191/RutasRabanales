package rutas.components;

import bundle.LanguageManager;
import java.awt.*;
import java.util.ResourceBundle;
import javax.swing.*;
import rutas.AppFrame;
import rutas.Ayuda;
import rutas.Login;
import rutas.MainPage;

public class NavBar extends JPanel {
    private JButton help;
    private JButton language;
    private JButton login;
    private JButton menu;

    private AppFrame appFrame;

    public NavBar(AppFrame appFrame) {
        this.appFrame = appFrame;
        setLayout(new BorderLayout());
        setBackground(new Color(36, 30, 78));

        ResourceBundle bundle = LanguageManager.getBundle();

        JPanel left_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left_panel.setOpaque(false);

        menu = new JButton("Rutas de Rabanales");
        menu.addActionListener(e -> appFrame.setContent(new MainPage(appFrame)));

        ImageIcon logo = new ImageIcon("data/logo_rr.png");
        Image scaledImage = logo.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH);
        JLabel icon_logo = new JLabel(new ImageIcon(scaledImage));

        left_panel.add(icon_logo);
        left_panel.add(menu);

        JPanel right_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right_panel.setOpaque(false);

        help = new JButton(bundle.getString("help"));
        help.addActionListener(e -> appFrame.setContent(new Ayuda()));

        language = new JButton(bundle.getString("language"));
        language.addActionListener(e -> {
            LanguageManager.toggleLanguage();   // Cambiar idioma
            appFrame.refresh();                 // Refrescar la interfaz
        });

        login = new JButton(bundle.getString("login"));
        login.addActionListener(e -> appFrame.setContent(new Login()));

        right_panel.add(help);
        right_panel.add(language);
        right_panel.add(login);

        add(left_panel, BorderLayout.WEST);
        add(right_panel, BorderLayout.EAST);
    }
}
