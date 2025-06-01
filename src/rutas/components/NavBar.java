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

        RoundedButton menu = new RoundedButton("Rutas de Rabanales", 20, false, false);
        menu.setBackground(new Color(36, 30, 78));
        menu.setPreferredSize(new Dimension(250, 40));
        menu.addActionListener(e -> appFrame.setContent(new MainPage(appFrame)));

        ImageIcon logo = new ImageIcon("data/logo_rr.png");
        Image scaledImage = logo.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH);
        JLabel icon_logo = new JLabel(new ImageIcon(scaledImage));

        left_panel.add(icon_logo);
        left_panel.add(menu);

        JPanel right_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right_panel.setOpaque(false);

        RoundedButton help = new RoundedButton(bundle.getString("help"), 20, false, false);
        help.setBackground(new Color(36, 30, 78));
        help.setPreferredSize(new Dimension(150, 40));
        help.addActionListener(e -> appFrame.setContent(new Ayuda()));

        RoundedButton language = new RoundedButton(bundle.getString("language"), 20, false, false);
        language.setBackground(new Color(36, 30, 78));
        language.setPreferredSize(new Dimension(300, 40));
        language.addActionListener(e -> {
            LanguageManager.toggleLanguage();   // Cambiar idioma
            appFrame.refresh();                 // Refrescar la interfaz
        });

        RoundedButton login = new RoundedButton(bundle.getString("login"), 20, true, false);
        login.setBackground(new Color(36, 30, 78));
        login.setPreferredSize(new Dimension(200, 40));
        login.addActionListener(e -> appFrame.setContent(new Login(appFrame)));

        right_panel.add(help);
        right_panel.add(language);
        right_panel.add(login);

        add(left_panel, BorderLayout.WEST);
        add(right_panel, BorderLayout.EAST);
    }
}
