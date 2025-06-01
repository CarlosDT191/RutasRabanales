package rutas;

import bundle.LanguageManager;
import java.awt.*;
import javax.swing.*;

import rutas.components.RoundedButton;
import rutas.components.RoundedPanel;

public class LoginFallido extends JPanel {
    public LoginFallido(AppFrame appFrame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Panel superior
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

        // Formulario
        RoundedPanel contentPanel = new RoundedPanel(20);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        contentPanel.setBackground(new Color(217, 217, 217));

        JPanel formInnerPanel = new JPanel();
        formInnerPanel.setLayout(new BoxLayout(formInnerPanel, BoxLayout.Y_AXIS));
        formInnerPanel.setOpaque(false);
        formInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formInnerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Mensaje de error
        JLabel errorLabel = new JLabel(LanguageManager.getBundle().getString("login_error"));
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        errorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        errorLabel.setMaximumSize(new Dimension(400, 20));
        errorLabel.setPreferredSize(new Dimension(400, 20));

        formInnerPanel.add(errorLabel);
        formInnerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

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
        RoundedButton loginButton = new RoundedButton(LanguageManager.getBundle().getString("login"), 20, false, false);
        loginButton.setBackground(new Color(36, 30, 78));
        loginButton.setPreferredSize(new Dimension(200, 40));

        // Podrías hacer que al hacer clic vuelva a intentar el login
        loginButton.addActionListener(e -> {
            // Validación aquí y setContent() dependiendo del resultado
            appFrame.setContent(new Login(appFrame)); // vuelve al login normal
        });

        bottomButtonPanel.add(loginButton);
        formInnerPanel.add(bottomButtonPanel);

        contentPanel.add(formInnerPanel);

        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBackground(Color.WHITE);
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(50, 500, 100, 500));
        centerWrapper.add(contentPanel, BorderLayout.CENTER);

        add(centerWrapper, BorderLayout.CENTER);
    }
}
