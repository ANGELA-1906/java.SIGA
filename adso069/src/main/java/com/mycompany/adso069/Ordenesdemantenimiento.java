package com.mycompany.adso069;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author ANGELA
 */
public class Ordenesdemantenimiento extends JFrame {

    private final Color COLOR_ROJO = new Color(220, 40, 70);
    private final Color COLOR_AZUL_LINK = new Color(0, 102, 204);

    public Ordenesdemantenimiento() {
        setTitle("Sistema Integral de Activos - Órdenes de Mantenimiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);

        // 1. Título Superior
        JLabel lblTitulo = new JLabel("Órdenes de Mantenimiento", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(20, 15, 440, 30);
        panelPrincipal.add(lblTitulo);

        // 2. Secciones / Pestañas superiores
        JLabel lblAsignadas = new JLabel("<html><b>Ordenes<br>asignadas: 5</b></html>");
        lblAsignadas.setFont(new Font("Arial", Font.PLAIN, 12));
        lblAsignadas.setBounds(30, 50, 120, 35);
        panelPrincipal.add(lblAsignadas);

        JLabel lblHistorial = new JLabel("Historial");
        lblHistorial.setFont(new Font("Arial", Font.BOLD, 15));
        lblHistorial.setForeground(new Color(90, 90, 90));
        lblHistorial.setBounds(220, 55, 90, 25);
        lblHistorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelPrincipal.add(lblHistorial);

        JLabel lblRepuestosTab = new JLabel("Repuestos");
        lblRepuestosTab.setFont(new Font("Arial", Font.PLAIN, 15));
        lblRepuestosTab.setForeground(new Color(110, 110, 110));
        lblRepuestosTab.setBounds(340, 55, 100, 25);
        lblRepuestosTab.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelPrincipal.add(lblRepuestosTab);

        // 3. Tabla de Órdenes de Mantenimiento
        String[] columnas = {"ORDEN", "ACTIVO", "TIPO", "GRAVEDAD", "FECHA", "ESTADO"};
        Object[][] datos = {
            {"#M-2026-042", "<html>Nevera<br>industrial</html>", "Correctivo", "Crítico", "18/06/2026", "Pendiente"},
            {"#M-2026-041", "<html>Horno<br>microhondas<br>industrial</html>", "Preventivo", "—", "19/06/2026", "<html>En<br>ejecución</html>"},
            {"#M-2026-040", "<html>Utencilios<br>cocina</html>", "Correctivo", "Moderado", "17/06/2026", "Completado"}
        };

        DefaultTableModel model = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabla de solo lectura
            }
        };

        JTable tablaOrdenes = new JTable(model);
        tablaOrdenes.setRowHeight(48);
        tablaOrdenes.setFont(new Font("Arial", Font.PLAIN, 10));
        tablaOrdenes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 10));
        tablaOrdenes.getTableHeader().setBackground(new Color(245, 245, 245));
        tablaOrdenes.setShowGrid(true);
        tablaOrdenes.setGridColor(new Color(180, 180, 180));

        // Renderizador personalizado para centrar texto y aplicar colores en "GRAVEDAD"
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                setFont(new Font("Arial", Font.PLAIN, 10));

                String valStr = value != null ? value.toString() : "";
                if (column == 3) { // Columna GRAVEDAD
                    if (valStr.equals("Crítico")) {
                        setForeground(new Color(200, 0, 0));
                        setFont(new Font("Arial", Font.BOLD, 10));
                    } else if (valStr.equals("Moderado")) {
                        setForeground(new Color(210, 130, 0));
                        setFont(new Font("Arial", Font.BOLD, 10));
                    } else if (valStr.equals("—")) {
                        setForeground(new Color(0, 150, 100));
                        setFont(new Font("Arial", Font.BOLD, 12));
                    } else {
                        setForeground(Color.BLACK);
                    }
                } else {
                    setForeground(Color.BLACK);
                }
                return c;
            }
        };

        for (int i = 0; i < tablaOrdenes.getColumnCount(); i++) {
            tablaOrdenes.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
        }

        JScrollPane scrollTabla = new JScrollPane(tablaOrdenes);
        scrollTabla.setBounds(15, 110, 455, 175);
        panelPrincipal.add(scrollTabla);

        // 4. Sección de Ejecución de Orden
        JLabel lblEjecutar = new JLabel("➤ Ejecutar orden #M-2026-042");
        lblEjecutar.setFont(new Font("Arial", Font.BOLD, 15));
        lblEjecutar.setBounds(15, 300, 300, 25);
        panelPrincipal.add(lblEjecutar);

        JLabel lblObsTitulo = new JLabel("Observaciones");
        lblObsTitulo.setFont(new Font("Arial", Font.BOLD, 11));
        lblObsTitulo.setBounds(15, 330, 200, 20);
        panelPrincipal.add(lblObsTitulo);

        JTextArea txtObservaciones = new JTextArea("Rodamiento principal con desgaste severo. Se requiere reemplazo y lubricación general.");
        txtObservaciones.setFont(new Font("Arial", Font.PLAIN, 11));
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        txtObservaciones.setEditable(false);
        txtObservaciones.setBackground(Color.WHITE);
        txtObservaciones.setBounds(15, 355, 455, 40);
        panelPrincipal.add(txtObservaciones);

        JLabel lblRepuestos = new JLabel("Repuestos utilizados");
        lblRepuestos.setFont(new Font("Arial", Font.BOLD, 11));
        lblRepuestos.setBounds(15, 405, 200, 20);
        panelPrincipal.add(lblRepuestos);

        // Filas de repuestos
        JPanel filaRep1 = crearFilaRepuesto("Rodamiento SKF 6205", "2");
        filaRep1.setBounds(15, 430, 380, 32);
        panelPrincipal.add(filaRep1);

        JPanel filaRep2 = crearFilaRepuesto("Grasa lubricante NLGI 2", "1");
        filaRep2.setBounds(15, 470, 380, 32);
        panelPrincipal.add(filaRep2);

        // 5. Botones Inferiores de Acción
        JButton btnCompletar = new JButton("COMPLETAR ORDEN");
        btnCompletar.setFont(new Font("Arial", Font.BOLD, 12));
        btnCompletar.setForeground(Color.WHITE);
        btnCompletar.setBackground(COLOR_ROJO);
        btnCompletar.setFocusPainted(false);
        btnCompletar.setBorderPainted(false);
        btnCompletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCompletar.setBounds(15, 530, 210, 40);
        btnCompletar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Orden completada exitosamente"));
        panelPrincipal.add(btnCompletar);

        JButton btnBorrador = new JButton("GUARDAR BORRADOR");
        btnBorrador.setFont(new Font("Arial", Font.BOLD, 11));
        btnBorrador.setForeground(COLOR_AZUL_LINK);
        btnBorrador.setContentAreaFilled(false);
        btnBorrador.setBorderPainted(false);
        btnBorrador.setFocusPainted(false);
        btnBorrador.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBorrador.setBounds(250, 530, 200, 40);
        btnBorrador.addActionListener(e -> JOptionPane.showMessageDialog(null, "Borrador guardado"));
        panelPrincipal.add(btnBorrador);

        add(panelPrincipal);
    }

    // Método para construir la fila estilizada de cada repuesto con su cantidad circular azul
    private JPanel crearFilaRepuesto(String nombreRepuesto, String cantidad) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
            new EmptyBorder(3, 10, 3, 10)
        ));

        JLabel lblNombre = new JLabel(nombreRepuesto);
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNombre.setForeground(new Color(40, 40, 40));

        // Círculo/Insignia azul con el número de cantidad
        JLabel lblCantidad = new JLabel(cantidad, SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(0, 122, 255));
                g2d.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
                super.paintComponent(g);
            }
        };
        lblCantidad.setPreferredSize(new Dimension(22, 22));
        lblCantidad.setFont(new Font("Arial", Font.BOLD, 11));
        lblCantidad.setForeground(Color.WHITE);

        panel.add(lblNombre, BorderLayout.WEST);
        panel.add(lblCantidad, BorderLayout.EAST);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ordenesdemantenimiento().setVisible(true);
        });
    }
}
