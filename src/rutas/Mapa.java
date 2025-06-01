package rutas;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

import bundle.LanguageManager;
import rutas.components.CircularPanel;
import rutas.components.RoundedButton;
import rutas.components.RoundedPanel;

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

        // Si es muy pequeña, la agrandamos artificialmente
        if (imgWidth < 200 || imgHeight < 200) {
            mapImage = rawImage.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        } else {
            mapImage = rawImage;
        }

        // Contenedor para título + barra de pasos
        JPanel topContainer = new JPanel();
        topContainer.setLayout(new BoxLayout(topContainer, BoxLayout.Y_AXIS));
        topContainer.setBackground(Color.WHITE);

        JLabel title = new JLabel("Rutas de Rabanales", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(36, 30, 78));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        // 2. Panel superior: selector de pasos
        JPanel stepPanel = new JPanel();
        stepPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        stepPanel.setBackground(Color.WHITE);

        topContainer.add(title);
        topContainer.add(stepPanel);

        for (int i = 1; i <= 3; i++) {
            final int paso = i;
            JPanel step = new JPanel(new BorderLayout());
            step.setOpaque(false);

            JLabel label = new JLabel(LanguageManager.getBundle().getString("map_step") + i, SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, i == pasoActual ? 16 : 14));
            label.setForeground(i == pasoActual ? new Color(36, 30, 78) : Color.DARK_GRAY);

            Runnable onClick = () -> {
                String nuevaRuta = switch (paso) {
                    case 1 -> "data/ruta1.PNG";
                    case 2 -> "data/ruta2.PNG";
                    case 3 -> "data/ruta3.PNG";
                    default -> rutaImagen;
                };
                appFrame.setContent(new Mapa(appFrame, nuevaRuta, paso));
            };

            Color color = Color.LIGHT_GRAY;
            if(i==pasoActual){
                color= new Color(36, 30, 78);
            }
            else if(i< pasoActual){
                color= new Color(51,45,98);
            }
            else{
                color= Color.LIGHT_GRAY;
            }
            CircularPanel circle = new CircularPanel(color, onClick);
            circle.setPreferredSize(new Dimension(24, 24));

            step.add(label, BorderLayout.NORTH);
            step.add(circle, BorderLayout.CENTER);

            stepPanel.add(step);

            if (i < 3) {
                RoundedPanel separator = new RoundedPanel(10);
                separator.setPreferredSize(new Dimension(350, 10));
        
                // Si el paso actual es mayor que i, entonces coloreamos el separador en azul
                if (pasoActual > i) {
                    separator.setBackground(new Color(51, 45, 98));
                } else {
                    separator.setBackground(Color.LIGHT_GRAY); // o blanco
                }
        
                stepPanel.add(separator);
            }
        }

        add(topContainer, BorderLayout.NORTH);

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

        imagePanel.setPreferredSize(new Dimension(800, 500)); // << Cambia el tamaño del marco aquí
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        imagePanel.addMouseWheelListener(e -> {
            double delta = 0.1f * e.getPreciseWheelRotation();
            scale -= delta;
            scale = Math.max(0.2, Math.min(3.0, scale));
            imagePanel.repaint();
        });

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