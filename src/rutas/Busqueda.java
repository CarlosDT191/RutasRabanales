package rutas;

import bundle.LanguageManager;
import java.awt.*;
import javax.swing.*;
import rutas.components.RoundedButton;
import rutas.components.RoundedPanel;

public class Busqueda extends JPanel {

    public Busqueda(AppFrame appFrame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Panel Superior (logo + título)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        // Logo
        ImageIcon logo = new ImageIcon("data/logo_rr2.PNG");
        Image scaledImage = logo.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(logoLabel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Rutas de Rabanales");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(36, 30, 78));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);

        // Panel Central: Origen y Destino
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setBackground(Color.WHITE);

        String[] edificiosDisponiblesOr = {"Seleccione", LanguageManager.getBundle().getString("edificio1")};
        String[] aulasDisponiblesOr = {"Seleccione", LanguageManager.getBundle().getString("aula1")};

        String[] edificiosDisponiblesDst = {"Seleccione", "Celestino Mutis"};
        String[] aulasDisponiblesDst = {"Seleccione", LanguageManager.getBundle().getString("aula2")};

        RoundedPanel origenPanel = createSidePanel(LanguageManager.getBundle().getString("search_t1"), new Color(144, 238, 144), 20, edificiosDisponiblesOr, aulasDisponiblesOr);
        RoundedPanel destinoPanel = createSidePanel(LanguageManager.getBundle().getString("search_t2"), new Color(240, 128, 128), 20, edificiosDisponiblesDst ,aulasDisponiblesDst);

        centerPanel.add(origenPanel);
        centerPanel.add(destinoPanel);
        add(centerPanel, BorderLayout.CENTER);

        // Panel Inferior: Botón
        RoundedButton buscarBtn = new RoundedButton(LanguageManager.getBundle().getString("search_search"), 20, false, false);
        buscarBtn.setBackground(new Color(36, 30, 78));
        buscarBtn.setPreferredSize(new Dimension(200, 40));
        buscarBtn.addActionListener(e -> appFrame.setContent(new Mapa(appFrame,"data/ruta1.PNG",1)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(buscarBtn);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Método que crea un bloque redondeado para Origen o Destino
     */
    private RoundedPanel createSidePanel(String title, Color bgColor, int radius, String[] edificios, String[] aulas) {
        RoundedPanel panel = new RoundedPanel(radius);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.setPreferredSize(new Dimension(300, 180));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20));

        JLabel edificioLabel = new JLabel(LanguageManager.getBundle().getString("search_minitxt1"));
        edificioLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        JComboBox<String> edificioBox = new JComboBox<>(edificios);
        edificioBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        panel.add(edificioLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(edificioBox);

        panel.add(Box.createVerticalStrut(160));

        JLabel aulaLabel = new JLabel(LanguageManager.getBundle().getString("search_minitxt2"));
        aulaLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        JComboBox<String> aulaBox = new JComboBox<>(aulas);
        aulaBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        panel.add(aulaLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(aulaBox);

        panel.add(Box.createVerticalGlue());

        return panel;
    }
}
