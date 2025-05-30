package rutas.components;

import rutas.AppFrame;
import rutas.Ayuda;
import bundle.LanguageManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javax.swing.*;

public class Footer extends JPanel {
    public Footer(AppFrame appFrame) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.setBackground(Color.WHITE);

        ResourceBundle bundle = LanguageManager.getBundle();

        // Parte superior (logo + título)
        JPanel topFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topFooter.setOpaque(false);

        ImageIcon logoIcon = new ImageIcon("data/logo_rabanales.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));

        JLabel titleLabel = new JLabel("Rutas de Rabanales");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(new Color(36, 30, 78));

        topFooter.add(logoLabel);
        topFooter.add(Box.createRigidArea(new Dimension(10, 0)));
        topFooter.add(titleLabel);

        // Parte inferior (ayuda, idioma, logos)
        JPanel bottomFooter = new JPanel(new BorderLayout());
        bottomFooter.setOpaque(false);

        JPanel leftFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftFooter.setOpaque(false);

        JButton help = new JButton(bundle.getString("help"));
        JButton language = new JButton(bundle.getString("language"));

        help.addActionListener((ActionEvent e) -> appFrame.setContent(new Ayuda()));
        language.addActionListener((ActionEvent e) -> {
            LanguageManager.toggleLanguage();
            appFrame.refresh();
        });

        leftFooter.add(help);
        leftFooter.add(new JLabel("|"));
        leftFooter.add(language);

        JPanel rightFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightFooter.setOpaque(false);

        ImageIcon logosIcon = new ImageIcon("data/footer_logos.png");
        Image scaledLogos = logosIcon.getImage().getScaledInstance(350, 70, Image.SCALE_SMOOTH);
        rightFooter.add(new JLabel(new ImageIcon(scaledLogos)));

        bottomFooter.add(leftFooter, BorderLayout.WEST);
        bottomFooter.add(rightFooter, BorderLayout.EAST);

        this.add(topFooter, BorderLayout.NORTH);
        this.add(bottomFooter, BorderLayout.CENTER);
    }
}
