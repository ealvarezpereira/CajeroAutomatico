/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.cajero;

import com.quidave.cajero.Cajero;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author quique
 */
public class Display extends JFrame implements ActionListener {

    public JButton btnIniciar = new JButton("Iniciar sesion");
    public JButton btnRegistro = new JButton("Registrarse");
    public JButton btnSalir = new JButton("Salir");

    public JLabel lblUsuario = new JLabel("Usuario : ");
    public JLabel lblCtra = new JLabel("Contraseña : ");

    public JTextField txtUsuario = new JTextField(20);
    public JPasswordField txtCtra = new  JPasswordField(20);

    public JPanel pnlMiPanel = new JPanel();

    public Display() {
        //-- CONFIGURAMOS LA VENTANA JFRAME

        super("IDENTIFICARSE");
        this.setSize(400, 270);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //-- LE AGREGAMOS EL GESTIONADOR DE EVENTOS
        this.btnIniciar.addActionListener(this);
        this.btnRegistro.addActionListener(this);
        this.btnSalir.addActionListener(this);

        //-- LE AÑADIMOS UN DISTRIBUIDOR DE OBJETOS AL PANEL
        FlowLayout DISTRIBUIDOR = new FlowLayout(FlowLayout.LEFT, 30, 30);
        this.pnlMiPanel.setLayout(DISTRIBUIDOR);

        //-- PERZONALIZAMOS LOS OBJETOS
        this.pnlMiPanel.setBackground(Color.LIGHT_GRAY);

        //-- LE AGREGAMOS LOS OBJETOS A LA VENTANA
        this.pnlMiPanel.add(this.lblUsuario);
        this.pnlMiPanel.add(this.txtUsuario);
        this.pnlMiPanel.add(this.lblCtra);
        this.pnlMiPanel.add(this.txtCtra);
        this.pnlMiPanel.add(this.btnIniciar);
        this.pnlMiPanel.add(this.btnRegistro);
        this.pnlMiPanel.add(this.btnSalir);

        this.add(this.pnlMiPanel);

    }

    @Override
    public void actionPerformed(ActionEvent AE) {
        //-- CON "getSource()" VEMOS EN QUE BOTON SE HIZO CLICK

        if (AE.getSource() == this.btnIniciar) {
            try {
                String usuario, ctra;

                usuario = this.txtUsuario.getText();
                ctra = this.txtCtra.getText();
                
                
                
                //LLamar a la botonera.

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "ERROR VUELVA A INGRESAR LOS DATOS");
                this.txtUsuario.setText("");
                this.txtCtra.setText("");
            }
        } else if (AE.getSource() == this.btnRegistro) {

            Cajero caj = new Cajero();
            
            caj.registrarUsuario();
            
        } else if (AE.getSource() == this.btnSalir) {
            System.exit(0);
        }
    }

}
