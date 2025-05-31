package rutas.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class RoundedButton extends JButton {
    private int radius;
    private boolean showWhiteBorder;
    private Color normalBackground;
    private Color hoverBackground;
    private boolean isHover = false;

    public RoundedButton(String text, int radius, boolean showWhiteBorder) {
        super(text);
        this.radius = radius;
        this.showWhiteBorder = showWhiteBorder;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.BOLD, 16));
        setBorderPainted(false);

        // Guardamos el color base
        normalBackground = getBackground();

        // Listener para hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHover = false;
                repaint();
            }
        });
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        this.normalBackground = bg;
        this.hoverBackground = bg.brighter(); // Automáticamente un poco más claro
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Color base o hover
        Color currentColor = isHover ? hoverBackground : normalBackground;
        g2.setColor(currentColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        if (showWhiteBorder) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, radius, radius);
        }

        super.paintComponent(g);
        g2.dispose();
    }
}
