package com.mycompany.adso069;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Dashboard extends JFrame {

    private final Color COLOR_ROJO = new Color(220, 40, 70);

    public Dashboard() {
        setTitle("Sistema Integral de Activos - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 620);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        // 1. Título Superior
        JLabel lblBienvenido = new JLabel("BIENVENIDO:", SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Arial", Font.BOLD, 20));
        lblBienvenido.setBounds(140, 15, 400, 25);
        panelPrincipal.add(lblBienvenido);

        // Caja de nombre de usuario
        JPanel boxUsuario = new JPanel(new BorderLayout());
        boxUsuario.setBackground(Color.WHITE);
        boxUsuario.setBounds(170, 45, 340, 50);
        boxUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel lblUsuario = new JLabel("SERGIO ALEJANDRO:", SwingConstants.CENTER);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 17));
        boxUsuario.add(lblUsuario, BorderLayout.CENTER);
        panelPrincipal.add(boxUsuario);

        // 2. Botón + NUEVO REPORTE
        JButton btnNuevoReporte = crearBotonRojo("+ NUEVO REPORTE");
        btnNuevoReporte.setBounds(440, 110, 190, 35);
        btnNuevoReporte.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Abrir formulario de nuevo reporte");
        });
        panelPrincipal.add(btnNuevoReporte);

        // 3. Menú de navegación lateral
        JButton btnResumen = crearBotonRojo("RESUMEN");
        btnResumen.setBounds(35, 125, 140, 38);
        panelPrincipal.add(btnResumen);

        JButton btnActivos = crearBotonRojo("ACTIVOS");
        btnActivos.setBounds(35, 175, 140, 38);
        panelPrincipal.add(btnActivos);

        JButton btnReportes = crearBotonRojo("REPORTES");
        btnReportes.setBounds(35, 225, 140, 38);
        panelPrincipal.add(btnReportes);

        // 4. Tarjetas informativas
        JPanel card1 = crearTarjeta("Activos registrados hoy", "Último: Torno CNC #T-403");
        card1.setBounds(25, 310, 280, 100);
        panelPrincipal.add(card1);

        JPanel card2 = crearTarjeta("Reportes de daño\npendientes", "2 críticos · 1 moderado");
        card2.setBounds(340, 310, 280, 100);
        panelPrincipal.add(card2);

        JPanel card3 = crearTarjeta("Escaneos QR hoy", "Tiempo promedio: 1.2s");
        card3.setBounds(25, 440, 280, 100);
        panelPrincipal.add(card3);

        JPanel card4 = crearTarjeta("Mant. programados esta\nsemana", "3 preventivos · 9\ncorrectivos");
        card4.setBounds(340, 440, 280, 100);
        panelPrincipal.add(card4);

        add(panelPrincipal);
    }

    private JButton crearBotonRojo(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setForeground(Color.WHITE);
        btn.setBackground(COLOR_ROJO);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JPanel crearTarjeta(String titulo, String detalle) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        Border line = new LineBorder(new Color(100, 100, 100), 1, true);
        Border margin = new EmptyBorder(12, 15, 12, 15);
        panel.setBorder(new CompoundBorder(line, margin));

        String htmlTitulo = "<html><b>" + titulo.replace("\n", "<br>") + "</b></html>";
        JLabel lblTitulo = new JLabel(htmlTitulo);
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
        lblTitulo.setForeground(new Color(40, 40, 40));

        String htmlDetalle = "<html>" + detalle.replace("\n", "<br>") + "</html>";
        JLabel lblDetalle = new JLabel(htmlDetalle);
        lblDetalle.setFont(new Font("Arial", Font.PLAIN, 13));
        lblDetalle.setForeground(new Color(60, 60, 60));

        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(8));
        panel.add(lblDetalle);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }
}