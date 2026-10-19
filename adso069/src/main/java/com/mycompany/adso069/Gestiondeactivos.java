package com.mycompany.adso069;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ANGELA
 */
public class Gestiondeactivos extends JFrame {

    private final Color COLOR_ROJO = new Color(220, 40, 70);
    private final Color COLOR_GRIS_OSCURO = new Color(50, 60, 70);

    // Campos del formulario
    private JTextField txtNombreEquipo, txtCategoria, txtMarca, txtModelo, txtNumSerie, txtValorInicial, txtUbicacion;

    public Gestiondeactivos() {
        setTitle("Sistema Integral de Activos - Gestión de Activos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 750);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        // 1. Botones de Navegación Superior
        JButton btnNuevoActivo = crearBotonRojo("NUEVO ACTIVO");
        btnNuevoActivo.setBounds(25, 20, 140, 40);
        panelPrincipal.add(btnNuevoActivo);

        JButton btnConsultarEscanear = crearBotonRojo("CONSULTAR/ESCANEAR");
        btnConsultarEscanear.setBounds(180, 20, 230, 40);
        panelPrincipal.add(btnConsultarEscanear);

        JButton btnReportarDano = crearBotonRojo("REPORTAR DAÑO");
        btnReportarDano.setBounds(425, 20, 175, 40);
        panelPrincipal.add(btnReportarDano);

        // 2. Formulario de Campos
        int startY = 110;
        int spacingY = 40;

        txtNombreEquipo = agregarCampoFormulario(panelPrincipal, "NOMBRE DEL EQUIPO", startY);
        txtCategoria = agregarCampoFormulario(panelPrincipal, "CATEGORIA", startY + spacingY);
        txtMarca = agregarCampoFormulario(panelPrincipal, "MARCA", startY + (spacingY * 2));
        txtModelo = agregarCampoFormulario(panelPrincipal, "MODELO", startY + (spacingY * 3));
        txtNumSerie = agregarCampoFormulario(panelPrincipal, "N. SERIE", startY + (spacingY * 4));
        txtValorInicial = agregarCampoFormulario(panelPrincipal, "VALOR INICIAL", startY + (spacingY * 5));

        // Ubicación (campo un poco más ancho en la interfaz)
        JLabel lblUbicacion = new JLabel("UBICACION");
        lblUbicacion.setFont(new Font("Arial", Font.BOLD, 11));
        lblUbicacion.setForeground(new Color(60, 60, 60));
        lblUbicacion.setBounds(25, startY + (spacingY * 6), 160, 25);
        panelPrincipal.add(lblUbicacion);

        txtUbicacion = new JTextField();
        txtUbicacion.setBounds(200, startY + (spacingY * 6), 380, 28);
        estilarCampoTexto(txtUbicacion);
        panelPrincipal.add(txtUbicacion);

        // 3. Botones de Acción Formulario (Guardar y Limpiar)
        JButton btnGuardarActivo = crearBotonRojo("GUARDAR ACTIVO");
        btnGuardarActivo.setBounds(25, 430, 230, 42);
        btnGuardarActivo.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "¡Activo guardado exitosamente!");
        });
        panelPrincipal.add(btnGuardarActivo);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 13));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setBackground(COLOR_GRIS_OSCURO);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLimpiar.setBounds(25, 490, 230, 42);
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        panelPrincipal.add(btnLimpiar);

        // 4. Sección Derecha: Código QR
        JPanel panelQR = crearPanelQRSimulado();
        panelQR.setBounds(350, 390, 160, 160);
        panelPrincipal.add(panelQR);

        JLabel lblCodigoQR = new JLabel("codigo QR generado", SwingConstants.CENTER);
        lblCodigoQR.setFont(new Font("Arial", Font.PLAIN, 12));
        lblCodigoQR.setForeground(Color.GRAY);
        lblCodigoQR.setBounds(330, 555, 200, 20);
        panelPrincipal.add(lblCodigoQR);

        // Caja de instrucción inferior
        JPanel boxInstruccion = new JPanel(new BorderLayout());
        boxInstruccion.setBackground(Color.WHITE);
        boxInstruccion.setBounds(330, 590, 200, 50);
        boxInstruccion.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));

        JLabel lblInstruccion = new JLabel("<html><center>Tras guardar, el código QR se asigna automáticamente al activo</center><html>", SwingConstants.CENTER);
        lblInstruccion.setFont(new Font("Arial", Font.PLAIN, 10));
        lblInstruccion.setForeground(new Color(70, 70, 70));
        boxInstruccion.add(lblInstruccion, BorderLayout.CENTER);
        panelPrincipal.add(boxInstruccion);

        // Botón Imprimir QR
        JButton btnImprimirQR = crearBotonRojo("<html><center>imprimir<br>QR</center></html>");
        btnImprimirQR.setFont(new Font("Arial", Font.BOLD, 11));
        btnImprimirQR.setBounds(380, 650, 100, 40);
        panelPrincipal.add(btnImprimirQR);

        add(panelPrincipal);
    }

    // Método auxiliar para agregar etiquetas y campos de texto alineados
    private JTextField agregarCampoFormulario(JPanel container, String textoLabel, int y) {
        JLabel label = new JLabel(textoLabel);
        label.setFont(new Font("Arial", Font.BOLD, 11));
        label.setForeground(new Color(60, 60, 60));
        label.setBounds(25, y, 160, 25);
        container.add(label);

        JTextField txt = new JTextField();
        txt.setBounds(200, y, 200, 28);
        estilarCampoTexto(txt);
        container.add(txt);
        return txt;
    }

    private void estilarCampoTexto(JTextField campo) {
        Border line = new LineBorder(new Color(190, 195, 200), 1, true);
        Border margin = new EmptyBorder(3, 8, 3, 8);
        campo.setBorder(new CompoundBorder(line, margin));
        campo.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private JButton crearBotonRojo(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setBackground(COLOR_ROJO);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void limpiarFormulario() {
        txtNombreEquipo.setText("");
        txtCategoria.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtNumSerie.setText("");
        txtValorInicial.setText("");
        txtUbicacion.setText("");
    }

    // Genera un patrón visual dibujado en Swing que simula el código QR
    private JPanel crearPanelQRSimulado() {
        JPanel qrPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                
                // Cuadros exteriores estándar del QR
                g2d.fillRect(10, 10, 40, 40);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(18, 18, 24, 24);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(24, 24, 12, 12);

                g2d.fillRect(110, 10, 40, 40);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(118, 18, 24, 24);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(124, 24, 12, 12);

                g2d.fillRect(10, 110, 40, 40);
                g2d.setColor(Color.WHITE);
                g2d.fillRect(18, 118, 24, 24);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(24, 124, 12, 12);

                // Patrones aleatorios de píxeles internos
                g2d.fillRect(60, 20, 35, 12);
                g2d.fillRect(70, 45, 20, 20);
                g2d.fillRect(20, 65, 30, 12);
                g2d.fillRect(65, 75, 40, 15);
                g2d.fillRect(115, 65, 30, 25);
                g2d.fillRect(70, 105, 70, 15);
                g2d.fillRect(100, 125, 45, 15);
            }
        };
        qrPanel.setBackground(Color.WHITE);
        return qrPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gestiondeactivos().setVisible(true);
        });
    }
}
