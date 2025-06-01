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

        // Panel de mensaje de error
        RoundedPanel errorPanel = new RoundedPanel(20);
        errorPanel.setBackground(new Color(246, 124, 124)); // fondo rosado claro
        errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.Y_AXIS));
        errorPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30)); // más padding

        errorPanel.setMaximumSize(new Dimension(600, 150));

        JLabel errorLabel = new JLabel(LanguageManager.getBundle().getString("login_error"));
        errorLabel.setForeground(Color.BLACK); // rojo más oscuro
        errorLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        errorPanel.add(errorLabel);

        // Panel que agrupa título y mensaje de error
        JPanel topWrapper = new JPanel();
        topWrapper.setLayout(new BoxLayout(topWrapper, BoxLayout.Y_AXIS));
        topWrapper.setBackground(Color.WHITE);
        topWrapper.add(headerPanel);
        
        topWrapper.add(errorPanel);

        add(topWrapper, BorderLayout.NORTH);

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
        loginButton.setPreferredSize(new Dimension(300, 40));

        AbstractAction loginAction = new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String username = UserTxtF.getText().trim();
                String password = new String(PasswdField.getPassword()).trim();
        
                LoginManager loginManager = new LoginManager();
        
                if (loginManager.isValid(username, password)) {
                    appFrame.setContent(new Busqueda(appFrame)); // login exitoso
                } else {
                    appFrame.setContent(new LoginFallido(appFrame)); // login fallido
                }
            }
        };
        
        loginButton.addActionListener(loginAction);
        UserTxtF.addActionListener(loginAction);
        PasswdField.addActionListener(loginAction);        

        bottomButtonPanel.add(loginButton);
        formInnerPanel.add(bottomButtonPanel);

        contentPanel.add(formInnerPanel);

        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBackground(Color.WHITE);
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(80, 600, 200, 600));
        centerWrapper.add(contentPanel, BorderLayout.CENTER);

        add(centerWrapper, BorderLayout.CENTER);
    }
}
