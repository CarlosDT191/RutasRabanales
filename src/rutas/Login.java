package rutas;
import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login() {
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Usuario:"));
        add(new JTextField());
        add(new JLabel("Contraseña:"));
        add(new JPasswordField());
        add(new JButton("Iniciar sesión"));
    }
}
