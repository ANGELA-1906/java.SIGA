package com.mycompany.adso069;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author ANGELA
 */
public class Paneldeadministracion extends JFrame {

    private final Color COLOR_ROJO = new Color(220, 40, 70);

    public Paneldeadministracion() {
        setTitle("Sistema Integral de Activos - Panel de Administración");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 750);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        // 1. Título Superior
        JLabel lblTitulo = new JLabel("PANEL DE ADMINISTRACION", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitulo.setForeground(new Color(90, 105, 120));
        lblTitulo.setBounds(20, 15, 300, 25);
        panelPrincipal.add(lblTitulo);

        // 2. Botones de Navegación Superiores
        JButton btnUsuarios = crearBotonRojo("USUARIOS");
        btnUsuarios.setBounds(20, 50, 110, 30);
        panelPrincipal.add(btnUsuarios);

        JButton btnBackups = crearBotonRojo("BACKUPS");
        btnBackups.setBounds(20, 90, 110, 30);
        panelPrincipal.add(btnBackups);

        JButton btnLogAudit = crearBotonRojo("LOG DE AUDITORIA");
        btnLogAudit.setBounds(20, 130, 170, 30);
        panelPrincipal.add(btnLogAudit);

        // 3. Tabla de Usuarios
        String[] columnas = {"NOMBRE", "CORREO", "ROL", "ESTADO", "ULTIMO ACCESO"};
        Object[][] datos = {
            {"<html>Roberto<br>Mendez</html>", "<html>roberto@milag.com</html>", "OPERARIO", "ACTIVO", "Hoy 08:32"},
            {"<html>Laura<br>Castillo</html>", "<html>laura@milagros.com</html>", "TECNICO", "ACTIVO", "Hoy 07:15"},
            {"<html>Carlos<br>Vega</html>", "<html>carlos@milagro.com</html>", "CONTADOR", "INACTIVO", "15/06/2026"},
            {"<html>Ana<br>Morales</html>", "<html>ana@milagros.com</html>", "GERENTE", "ACTIVO", "Ayer 17:45"}
        };

        DefaultTableModel model = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Solo lectura
            }
        };

        JTable tablaUsuarios = new JTable(model);
        tablaUsuarios.setRowHeight(42);
        tablaUsuarios.setFont(new Font("Arial", Font.PLAIN, 10));
        tablaUsuarios.getTableHeader().setFont(new Font("Arial", Font.BOLD, 10));
        tablaUsuarios.getTableHeader().setBackground(new Color(245, 245, 245));
        tablaUsuarios.setShowGrid(true);
        tablaUsuarios.setGridColor(new Color(180, 180, 180));

        // Alineación centrada para las celdas de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaUsuarios.getColumnCount(); i++) {
            tablaUsuarios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollTabla = new JScrollPane(tablaUsuarios);
        scrollTabla.setBounds(20, 180, 420, 195);
        panelPrincipal.add(scrollTabla);

        // 4. Botones de Acción sobre Usuarios
        JButton btnNuevoUsuario = crearBotonRojo("NUEVO USUARIO");
        btnNuevoUsuario.setBounds(20, 395, 190, 38);
        btnNuevoUsuario.addActionListener(e -> JOptionPane.showMessageDialog(null, "Crear nuevo usuario"));
        panelPrincipal.add(btnNuevoUsuario);

        JButton btnEditar = crearBotonRojo("EDITAR");
        btnEditar.setBounds(20, 445, 190, 38);
        btnEditar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Editar usuario seleccionado"));
        panelPrincipal.add(btnEditar);

        // 5. Configuración de Backup Inferior
        JLabel lblFrecuencia = new JLabel("Frecuencia de backup");
        lblFrecuencia.setFont(new Font("Arial", Font.PLAIN, 13));
        lblFrecuencia.setForeground(new Color(50, 50, 50));
        lblFrecuencia.setBounds(20, 510, 160, 25);
        panelPrincipal.add(lblFrecuencia);

        String[] opcionesFrecuencia = {"Diaria", "Semanal", "Mensual"};
        JComboBox<String> cbxFrecuencia = new JComboBox<>(opcionesFrecuencia);
        cbxFrecuencia.setBounds(190, 508, 200, 30);
        cbxFrecuencia.setBackground(Color.WHITE);
        cbxFrecuencia.setFont(new Font("Arial", Font.PLAIN, 12));
        panelPrincipal.add(cbxFrecuencia);

        JLabel lblHora = new JLabel("Hora programada");
        lblHora.setFont(new Font("Arial", Font.PLAIN, 13));
        lblHora.setForeground(new Color(50, 50, 50));
        lblHora.setBounds(20, 550, 160, 25);
        panelPrincipal.add(lblHora);

        JTextField txtHora = new JTextField();
        txtHora.setBounds(190, 548, 200, 30);
        estilarCampoTexto(txtHora);
        panelPrincipal.add(txtHora);

        JLabel lblUltimo = new JLabel("Ultimo backup");
        lblUltimo.setFont(new Font("Arial", Font.PLAIN, 13));
        lblUltimo.setForeground(new Color(50, 50, 50));
        lblUltimo.setBounds(20, 590, 160, 25);
        panelPrincipal.add(lblUltimo);

        JTextField txtUltimo = new JTextField();
        txtUltimo.setBounds(190, 588, 200, 30);
        estilarCampoTexto(txtUltimo);
        panelPrincipal.add(txtUltimo);

        add(panelPrincipal);
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
            new Paneldeadministracion().setVisible(true);
        });
    }
}
