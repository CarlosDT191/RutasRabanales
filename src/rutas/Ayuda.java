package rutas;
import bundle.LanguageManager;
import java.awt.*;
import javax.swing.*;
import rutas.components.RoundedPanel;

public class Ayuda extends JPanel {
    public Ayuda() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 1. Parte superior (cuadro azul y logo)
        setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        // Subpanel Izquierdo (WEST) - Cuadro azul
        RoundedPanel leftTextPanel = new RoundedPanel(25);
        leftTextPanel.setLayout(new BoxLayout(leftTextPanel, BoxLayout.Y_AXIS));
        leftTextPanel.setBackground(new Color(36, 30, 78));
        leftTextPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel(LanguageManager.getBundle().getString("help_t1"));
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        JLabel subtitleLabel = new JLabel(LanguageManager.getBundle().getString("help_blue_txt"));

        titleLabel.setForeground(Color.WHITE);
        subtitleLabel.setForeground(Color.WHITE);

        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        leftTextPanel.add(titleLabel);
        leftTextPanel.add(subtitleLabel);
        headerPanel.add(leftTextPanel, BorderLayout.WEST);
        
        // Subpanel Derecho - Logo
        ImageIcon logo = new ImageIcon("data/uco_logo.png"); // Ruta al logo
        Image scaledImage = logo.getImage().getScaledInstance(340, 120, Image.SCALE_SMOOTH);
        JLabel icon_logo = new JLabel(new ImageIcon(scaledImage));
        headerPanel.add(icon_logo, BorderLayout.EAST);


        // 2. Parte central: Búsqueda y preguntas frecuentes
        RoundedPanel contentPanel = new RoundedPanel(20);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(new Color(81, 79, 92)); // Gris oscuro

        // Campo de búsqueda
        JTextField searchField = new JTextField();
        searchField.setMaximumSize(new Dimension(new Dimension(1000, 30)));
        searchField.setAlignmentX(Component.CENTER_ALIGNMENT); 
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Etiqueta simulando "placeholder"
        JLabel placeholder = new JLabel(LanguageManager.getBundle().getString("help_gray_t"));
        placeholder.setForeground(Color.WHITE);
        placeholder.setFont(new Font("SansSerif", Font.BOLD, 24));
        placeholder.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

        contentPanel.add(placeholder);
        contentPanel.add(searchField);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado

        // Pregunta 1
        JLabel q1 = new JLabel(LanguageManager.getBundle().getString("help_gray_t1"));
        q1.setFont(new Font("SansSerif", Font.BOLD, 24));
        q1.setForeground(Color.WHITE);
        q1.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea a1 = new JTextArea(LanguageManager.getBundle().getString("help_gray_txt1"));
        a1.setFont(new Font("SansSerif", Font.PLAIN, 18));
        a1.setForeground(Color.WHITE);
        a1.setBackground(new Color(81, 79, 92)); // mismo fondo que el contentPanel
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        a1.setEditable(false);
        a1.setOpaque(false); // Para fondo transparente si prefieres
        a1.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        a1.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        contentPanel.add(q1);
        contentPanel.add(a1);

        // Pregunta 2
        JLabel q2 = new JLabel(LanguageManager.getBundle().getString("help_gray_t2"));
        q2.setFont(new Font("SansSerif", Font.BOLD, 24));
        q2.setForeground(Color.WHITE);
        q2.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea a2 = new JTextArea(LanguageManager.getBundle().getString("help_gray_txt2"));
        a2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        a2.setForeground(Color.WHITE);
        a2.setBackground(new Color(81, 79, 92)); // mismo fondo que el contentPanel
        a2.setLineWrap(true);
        a2.setWrapStyleWord(true);
        a2.setEditable(false);
        a2.setOpaque(false); // Para fondo transparente si prefieres
        a2.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        a2.setAlignmentX(Component.LEFT_ALIGNMENT);

        contentPanel.add(q2);
        contentPanel.add(a2);

        // Pregunta 3
        JLabel q3 = new JLabel(LanguageManager.getBundle().getString("help_gray_t3"));
        q3.setFont(new Font("SansSerif", Font.BOLD, 24));
        q3.setForeground(Color.WHITE);
        q3.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea a3 = new JTextArea(LanguageManager.getBundle().getString("help_gray_txt3"));
        a3.setFont(new Font("SansSerif", Font.PLAIN, 18));
        a3.setForeground(Color.WHITE);
        a3.setBackground(new Color(81, 79, 92)); // mismo fondo que el contentPanel
        a3.setLineWrap(true);
        a3.setWrapStyleWord(true);
        a3.setEditable(false);
        a3.setOpaque(false); // Para fondo transparente si prefieres
        a3.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        a3.setAlignmentX(Component.LEFT_ALIGNMENT);

        contentPanel.add(q3);
        contentPanel.add(a3);

        // Añadir el panel al centro del layout principal
        // Contenedor intermedio para añadir márgenes externos al contentPanel
        JPanel centerWrapper = new JPanel();
        centerWrapper.setLayout(new BorderLayout());
        centerWrapper.setBackground(Color.WHITE); // Fondo blanco como el resto
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); // Margen superior, izq, inf, der

        centerWrapper.add(contentPanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(centerWrapper, BorderLayout.CENTER);

    }
}
