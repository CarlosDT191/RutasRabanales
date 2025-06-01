package rutas;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

import bundle.LanguageManager;
import rutas.components.RoundedButton;

public class Mapa extends JPanel {

    private Image mapImage;
    private double scale = 1.0;
    private Point dragStart;
    private Point imageOffset = new Point(0, 0);

    public Mapa(AppFrame appFrame, String rutaImagen, int pasoActual) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 1. Cargar imagen
        File file = new File(rutaImagen);
        if (!file.exists()) {
            JLabel error = new JLabel("❌ Imagen no encontrada: " + rutaImagen, SwingConstants.CENTER);
            error.setFont(new Font("SansSerif", Font.BOLD, 16));
            error.setForeground(Color.RED);
            add(error, BorderLayout.CENTER);
            return;
        }

        
        ImageIcon icon = new ImageIcon(rutaImagen);
        Image rawImage = icon.getImage();
        int imgWidth = rawImage.getWidth(null);
        int imgHeight = rawImage.getHeight(null);

        // Si es muy pequeña, la agrandamos artificialmente (mejor con una imagen grande real)
        if (imgWidth < 200 || imgHeight < 200) {
            mapImage = rawImage.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        } else {
            mapImage = rawImage;
        }

        // 2. Panel superior: selector de pasos
        JPanel stepPanel = new JPanel();
        stepPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        stepPanel.setBackground(Color.WHITE);

        for (int i = 1; i <= 3; i++) {
            final int paso = i;
            JPanel step = new JPanel(new BorderLayout());
            step.setOpaque(false);

            JLabel label = new JLabel(LanguageManager.getBundle().getString("map_step") + i, SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, i == pasoActual ? 16 : 14));
            label.setForeground(i == pasoActual ? new Color(36, 30, 78) : Color.DARK_GRAY);

            JPanel circle = new JPanel();
            circle.setPreferredSize(new Dimension(20, 20));
            circle.setBackground(i == pasoActual ? new Color(36, 30, 78) : Color.WHITE);
            circle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            circle.setOpaque(true);

            step.add(label, BorderLayout.NORTH);
            step.add(circle, BorderLayout.CENTER);

            step.setCursor(new Cursor(Cursor.HAND_CURSOR));
            step.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    String nuevaRuta = switch (paso) {
                        case 1 -> "data/ruta1.PNG";
                        case 2 -> "data/ruta2.PNG";
                        case 3 -> "data/ruta3.PNG";
                        default -> rutaImagen;
                    };
                    appFrame.setContent(new Mapa(appFrame, nuevaRuta, paso));
                }
            });

            stepPanel.add(step);

            if (i < 3) {
                JSlider slider = new JSlider();
                slider.setEnabled(false);
                slider.setPreferredSize(new Dimension(50, 10));
                slider.setBackground(Color.WHITE);
                stepPanel.add(slider);
            }
        }

        add(stepPanel, BorderLayout.NORTH);

        // 3. Panel central con imagen, zoom y arrastre
        JPanel imagePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (mapImage != null) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2.drawImage(mapImage,
                        imageOffset.x, imageOffset.y,
                        (int) (mapImage.getWidth(null) * scale),
                        (int) (mapImage.getHeight(null) * scale), null);
                }
            }
        };

        imagePanel.setPreferredSize(new Dimension(600, 400));
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Zoom con rueda del ratón
        imagePanel.addMouseWheelListener(e -> {
            double delta = 0.1f * e.getPreciseWheelRotation();
            scale -= delta;
            scale = Math.max(0.2, Math.min(3.0, scale));
            imagePanel.repaint();
        });

        // Arrastrar imagen
        imagePanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }
        });

        imagePanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX() - dragStart.x;
                int dy = e.getY() - dragStart.y;
                imageOffset.translate(dx, dy);
                dragStart = e.getPoint();
                imagePanel.repaint();
            }
        });

        JPanel imageWrapper = new JPanel(new GridBagLayout());
        imageWrapper.setBackground(Color.WHITE);
        imageWrapper.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        imageWrapper.add(imagePanel);

        add(imageWrapper, BorderLayout.CENTER);

        // 4. Botón volver
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));

        RoundedButton volver = new RoundedButton(LanguageManager.getBundle().getString("map_button"), 20, true, false);
        volver.setBackground(new Color(36, 30, 78));
        volver.setForeground(Color.WHITE);
        volver.setPreferredSize(new Dimension(250, 40));
        volver.addActionListener(e -> appFrame.setContent(new Busqueda(appFrame)));

        bottomPanel.add(volver);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
