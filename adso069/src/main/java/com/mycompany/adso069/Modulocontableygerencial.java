package com.mycompany.adso069;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 *
 * @author ANGELA
 */
public class Modulocontableygerencial extends JFrame {

    private final Color COLOR_ROJO = new Color(220, 40, 70);

    public Modulocontableygerencial() {
        setTitle("Sistema Integral de Activos - Módulo Contable y Gerencial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 730);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        // 1. Título Superior
        JLabel lblTitulo = new JLabel("MODULO CONTABLE Y GERENCIA", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitulo.setForeground(new Color(90, 105, 120));
        lblTitulo.setBounds(20, 15, 300, 25);
        panelPrincipal.add(lblTitulo);

        // 2. Botones Superiores de Navegación
        JButton btnDepreciacion = crearBotonRojo("Depreciacion");
        btnDepreciacion.setBounds(20, 50, 100, 28);
        panelPrincipal.add(btnDepreciacion);

        JButton btnCosto = crearBotonRojo("Costo");
        btnCosto.setBounds(125, 50, 70, 28);
        panelPrincipal.add(btnCosto);

        JButton btnReportes = crearBotonRojo("Reportes");
        btnReportes.setBounds(200, 50, 85, 28);
        panelPrincipal.add(btnReportes);

        JButton btnProyecciones = crearBotonRojo("Proyecciones");
        btnProyecciones.setBounds(290, 50, 110, 28);
        panelPrincipal.add(btnProyecciones);

        // 3. Campo: ACTIVO (ComboBox)
        JLabel lblActivo = crearBadgeEtiqueta("ACTIVO");
        lblActivo.setBounds(20, 105, 80, 22);
        panelPrincipal.add(lblActivo);

        String[] opcionesActivos = {"Seleccione un activo...", "Torno CNC #T-403", "Nevera Industrial", "Horno Microondas"};
        JComboBox<String> cbxActivo = new JComboBox<>(opcionesActivos);
        cbxActivo.setBounds(20, 130, 380, 32);
        cbxActivo.setBackground(Color.WHITE);
        cbxActivo.setFont(new Font("Arial", Font.PLAIN, 12));
        panelPrincipal.add(cbxActivo);

        // 4. Campo: VALOR ORIGINAL
        JLabel lblValorOriginal = crearBadgeEtiqueta("VALOR ORIGINAL");
        lblValorOriginal.setBounds(20, 180, 130, 22);
        panelPrincipal.add(lblValorOriginal);

        JPanel panelValorOrig = crearCampoMoneda();
        panelValorOrig.setBounds(20, 205, 350, 32);
        panelPrincipal.add(panelValorOrig);

        // 5. Campo: VIDA UTIL
        JLabel lblVidaUtil = crearBadgeEtiqueta("VIDA UTIL");
        lblVidaUtil.setBounds(20, 255, 90, 22);
        panelPrincipal.add(lblVidaUtil);

        JTextField txtVidaUtil = new JTextField();
        txtVidaUtil.setBounds(20, 280, 370, 32);
        estilarCampoTexto(txtVidaUtil);
        panelPrincipal.add(txtVidaUtil);

        // 6. Campo: METODO
        JLabel lblMetodo = crearBadgeEtiqueta("METODO");
        lblMetodo.setBounds(20, 330, 80, 22);
        panelPrincipal.add(lblMetodo);

        JTextField txtMetodo = new JTextField();
        txtMetodo.setBounds(20, 355, 370, 32);
        estilarCampoTexto(txtMetodo);
        panelPrincipal.add(txtMetodo);

        // 7. Campo: VALOR ACTUAL
        JLabel lblValorActual = crearBadgeEtiqueta("VALOR ACTUAL");
        lblValorActual.setBounds(20, 405, 120, 22);
        panelPrincipal.add(lblValorActual);

        JPanel panelValorAct = crearCampoMoneda();
        panelValorAct.setBounds(20, 430, 350, 32);
        panelPrincipal.add(panelValorAct);

        // 8. Botones de Acción Inferiores
        JButton btnGenerarReporte = crearBotonRojo("Generar reporte");
        btnGenerarReporte.setBounds(20, 490, 150, 42);
        btnGenerarReporte.addActionListener(e -> JOptionPane.showMessageDialog(null, "Generando reporte contable..."));
        panelPrincipal.add(btnGenerarReporte);

        JButton btnExportar = crearBotonRojo("Exportar");
        btnExportar.setBounds(20, 550, 150, 42);
        btnExportar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Exportando datos..."));
        panelPrincipal.add(btnExportar);

        JButton btnSincronizar = crearBotonRojo("Sincronizar");
        btnSincronizar.setBounds(20, 610, 150, 42);
        btnSincronizar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Sincronizando con el sistema..."));
        panelPrincipal.add(btnSincronizar);

        add(panelPrincipal);
    }

    // Crea las insignias/etiquetas rojas para los títulos de los campos
    private JLabel crearBadgeEtiqueta(String texto) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(COLOR_ROJO);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 10));
        label.setBorder(new EmptyBorder(2, 5, 2, 5));
        return label;
    }

    // Construye la caja de texto dividida con el símbolo $ y el valor por defecto
    private JPanel crearCampoMoneda() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JTextField txtInput = new JTextField();
        estilarCampoTexto(txtInput);

        JPanel panelDerecho = new JPanel(new GridLayout(1, 2));
        panelDerecho.setBackground(new Color(240, 243, 246));
        panelDerecho.setBorder(new LineBorder(new Color(190, 195, 200), 1));

        JLabel lblSimbolo = new JLabel("$", SwingConstants.CENTER);
        lblSimbolo.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSimbolo.setForeground(Color.GRAY);

        JLabel lblValor = new JLabel("0.00", SwingConstants.CENTER);
        lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
        lblValor.setForeground(Color.GRAY);

        panelDerecho.add(lblSimbolo);
        panelDerecho.add(lblValor);
        panelDerecho.setPreferredSize(new Dimension(100, 32));

        panel.add(txtInput, BorderLayout.CENTER);
        panel.add(panelDerecho, BorderLayout.EAST);

        return panel;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Modulocontableygerencial().setVisible(true);
        });
    }
}
