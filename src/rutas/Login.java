package rutas;
import bundle.LanguageManager;
import java.awt.*;
import javax.swing.*;
import rutas.components.RoundedPanel;

public class Login extends JPanel {
    public Login() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 1. Panel superior: Logo + título
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        // Logo
        ImageIcon logo = new ImageIcon("data/uco_logo_2.PNG");
        Image scaledImage = logo.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel icon_logo = new JLabel(new ImageIcon(scaledImage));
        headerPanel.add(icon_logo, BorderLayout.CENTER);

        // Título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(LanguageManager.getBundle().getString("login_title"));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setBackground(new Color(36, 30, 78));

        titlePanel.add(titleLabel);
        headerPanel.add(titlePanel, BorderLayout.SOUTH);
        add(headerPanel, BorderLayout.NORTH);

        // 2. FORMULARIO
        RoundedPanel contentPanel = new RoundedPanel(20);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        contentPanel.setBackground(new Color(217,217,217));

        // Panel interno alineado a la izquierda
        JPanel formInnerPanel = new JPanel();
        formInnerPanel.setLayout(new BoxLayout(formInnerPanel, BoxLayout.Y_AXIS));
        formInnerPanel.setOpaque(false);
        formInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formInnerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // Margen interno leve

        // Usuario
        JLabel UserInt = new JLabel(LanguageManager.getBundle().getString("login_t1"));
        UserInt.setFont(new Font("SansSerif", Font.BOLD, 18));
        UserInt.setAlignmentX(Component.LEFT_ALIGNMENT);
        UserInt.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        JTextField UserTxtF = new JTextField();
        UserTxtF.setMaximumSize(new Dimension(400, 30));
        UserTxtF.setFont(new Font("SansSerif", Font.PLAIN, 14));
        UserTxtF.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        UserTxtF.setAlignmentX(Component.LEFT_ALIGNMENT);

        formInnerPanel.add(UserInt);
        formInnerPanel.add(UserTxtF);
        formInnerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Contraseña
        JLabel Passwd = new JLabel(LanguageManager.getBundle().getString("login_t2"));
        Passwd.setFont(new Font("SansSerif", Font.BOLD, 18));
        Passwd.setAlignmentX(Component.LEFT_ALIGNMENT);
        Passwd.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        JPasswordField PasswdField = new JPasswordField();
        PasswdField.setMaximumSize(new Dimension(400, 30));
        PasswdField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        PasswdField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        PasswdField.setAlignmentX(Component.LEFT_ALIGNMENT);

        formInnerPanel.add(Passwd);
        formInnerPanel.add(PasswdField);
        formInnerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botón
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomButtonPanel.setOpaque(false);
        JButton loginButton = new JButton(LanguageManager.getBundle().getString("login"));
        bottomButtonPanel.add(loginButton);

        formInnerPanel.add(bottomButtonPanel);

        // Añadir panel interno al panel gris
        contentPanel.add(formInnerPanel);

        // Centrar todo el formulario en pantalla
        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBackground(Color.WHITE);
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(50, 500, 100, 500)); // Centrado horizontal
        centerWrapper.add(contentPanel, BorderLayout.CENTER);

        add(centerWrapper, BorderLayout.CENTER);
    }
}
