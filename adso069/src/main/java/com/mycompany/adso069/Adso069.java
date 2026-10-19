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
public class Adso069 extends JFrame { // <-- Cambiado de Login a Adso069

    public Adso069() { // <-- Cambiado el constructor
        // Configuración de la ventana principal
        setTitle("Sistema Integral de Activos - MILAGROS GROUP S.A.S");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(245, 247, 250));
        panelPrincipal.setLayout(null);

        JLabel lblEmpresa = new JLabel("MILAGROS GROUP S.A.S", SwingConstants.CENTER);
        lblEmpresa.setFont(new Font("Arial", Font.BOLD, 22));
        lblEmpresa.setBounds(20, 20, 400, 30);
        panelPrincipal.add(lblEmpresa);

        JLabel lblSubtitulo = new JLabel("SISTEMA INTEGRAL DE ACTIVOS", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 12));
        lblSubtitulo.setBounds(20, 55, 400, 20);
        panelPrincipal.add(lblSubtitulo);

        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setLayout(null);
        cardPanel.setBounds(50, 95, 330, 380);
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220), 1, true));

        JLabel lblEmail = new JLabel("Email address");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        lblEmail.setBounds(25, 20, 200, 20);
        cardPanel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(25, 45, 280, 35);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        txtEmail.setForeground(Color.GRAY);
        txtEmail.setText("email@example.com");
        estilarCampoTexto(txtEmail);
        cardPanel.add(txtEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
        lblPassword.setBounds(25, 95, 200, 20);
        cardPanel.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(25, 120, 280, 35);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 13));
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setText("Password");
        estilarCampoTexto(txtPassword);
        cardPanel.add(txtPassword);

        JCheckBox chkRemember = new JCheckBox("Remember me");
        chkRemember.setFont(new Font("Arial", Font.PLAIN, 13));
        chkRemember.setBackground(Color.WHITE);
        chkRemember.setFocusPainted(false);
        chkRemember.setBounds(23, 168, 200, 25);
        cardPanel.add(chkRemember);

        JButton btnSignIn = new JButton("Sign in");
        btnSignIn.setBounds(25, 205, 100, 38);
        btnSignIn.setFont(new Font("Arial", Font.BOLD, 13));
        btnSignIn.setForeground(Color.WHITE);
        btnSignIn.setBackground(new Color(0, 123, 255));
        btnSignIn.setFocusPainted(false);
        btnSignIn.setBorderPainted(false);
        btnSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String pass = new String(txtPassword.getPassword());
                JOptionPane.showMessageDialog(null, "Intentando ingresar con:\nEmail: " + email);
            }
        });
        cardPanel.add(btnSignIn);

        JSeparator separador = new JSeparator();
        separador.setBounds(0, 265, 330, 2);
        separador.setForeground(new Color(220, 224, 230));
        cardPanel.add(separador);

        JLabel lblSignUp = new JLabel("New around here? Sign up");
        lblSignUp.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSignUp.setBounds(25, 285, 250, 20);
        lblSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardPanel.add(lblSignUp);

        JLabel lblForgot = new JLabel("Forgot password?");
        lblForgot.setFont(new Font("Arial", Font.PLAIN, 12));
        lblForgot.setBounds(25, 320, 250, 20);
        lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardPanel.add(lblForgot);

        panelPrincipal.add(cardPanel);
        add(panelPrincipal);
    }

    private void estilarCampoTexto(JComponent campo) {
        Border line = new LineBorder(new Color(200, 205, 210), 1, true);
        Border margin = new EmptyBorder(5, 10, 5, 10);
        campo.setBorder(new CompoundBorder(line, margin));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Adso069().setVisible(true); // <-- Cambiado de Login a Adso069
        });
    }
}