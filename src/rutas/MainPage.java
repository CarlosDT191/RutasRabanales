package rutas;

import java.awt.*;
import javax.swing.*;

import bundle.LanguageManager;

public class MainPage extends JPanel {

    public MainPage(AppFrame appFrame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 1. Panel superior: Logo + título + botón
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        // Subpanel Izquierdo (WEST) - Título y subtítulo
        JPanel leftTextPanel = new JPanel();
        leftTextPanel.setLayout(new BoxLayout(leftTextPanel, BoxLayout.Y_AXIS));
        leftTextPanel.setBackground(Color.WHITE);
        leftTextPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel(LanguageManager.getBundle().getString("welcome"));
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        JLabel subtitleLabel = new JLabel(LanguageManager.getBundle().getString("main_text"));
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        leftTextPanel.add(titleLabel);
        leftTextPanel.add(subtitleLabel);
        headerPanel.add(leftTextPanel, BorderLayout.WEST);
        
        // Subpanel Derecho - Logo
        ImageIcon logo = new ImageIcon("data/uco_logo.png"); // Ruta al logo
        Image scaledImage = logo.getImage().getScaledInstance(340, 120, Image.SCALE_SMOOTH);
        JLabel icon_logo = new JLabel(new ImageIcon(scaledImage));
        headerPanel.add(icon_logo, BorderLayout.EAST);
        
        // Subpanel Inferior - Botón centrado
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomButtonPanel.setBackground(Color.WHITE); // Color similar al original
        JButton loginButton = new JButton(LanguageManager.getBundle().getString("login"));
        loginButton.addActionListener(e -> appFrame.setContent(new Login()));
        bottomButtonPanel.add(loginButton);
        headerPanel.add(bottomButtonPanel, BorderLayout.SOUTH);
        
        JPanel headerWrapper = new JPanel(new BorderLayout());
        headerWrapper.setBackground(Color.WHITE);
        headerWrapper.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60)); // top, left, bottom, right
        headerWrapper.add(headerPanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        // 2. Mapa central
        ImageIcon map = new ImageIcon("data/mapa_rabanales.jpg"); // Ruta al logo
        Image scaledMap = map.getImage().getScaledInstance(1000, 320, Image.SCALE_SMOOTH);
        JLabel icon_map = new JLabel(new ImageIcon(scaledMap));
        add(icon_map, BorderLayout.CENTER);

        // 3. Panel inferior: Tarjetas
        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cardsPanel.setBackground(Color.WHITE);

        cardsPanel.add(createCard("data/left_image_menu.jpg",
            LanguageManager.getBundle().getString("main_t1"),
            LanguageManager.getBundle().getString("main_txt1")));

        cardsPanel.add(createCard("data/center_img_main.jpeg",
            LanguageManager.getBundle().getString("main_t2"),
            LanguageManager.getBundle().getString("main_txt2")));

        cardsPanel.add(createCard("data/right_main_menu.jpg",
            LanguageManager.getBundle().getString("main_t3"),
            LanguageManager.getBundle().getString("main_txt3")));

        add(cardsPanel, BorderLayout.SOUTH);
    }

    private JPanel createCard(String imagePath, String title, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        card.setPreferredSize(new Dimension(250, 280)); // Cambia ancho y alto aquí

        // Imagen redimensionada
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(250, 140, Image.SCALE_SMOOTH); // Más baja
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

        card.add(imageLabel, BorderLayout.NORTH);

        // Panel de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("<html><b>" + title + "</b></html>");
        JLabel descLabel = new JLabel("<html>" + description + "</html>");
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        textPanel.add(titleLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio
        textPanel.add(descLabel);

        card.add(textPanel, BorderLayout.CENTER);
        return card;
    }

}
