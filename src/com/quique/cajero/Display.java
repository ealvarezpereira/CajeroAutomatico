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
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author quique
 */
public class Display extends JFrame implements ActionListener {

    private static String usuario, ctra;
    File urlImg;

    Cajero caj = new Cajero();

    //Botones de iniciar sesion, registrar usuario y salir.
    public JButton btnIniciar = new JButton("Iniciar sesion");
    public JButton btnRegistro = new JButton("Registrarse");
    public JButton btnSalir = new JButton("Salir");

    //Texto de usuario y contraseña
    public JLabel lblUsuario = new JLabel("Usuario : ");
    public JLabel lblCtra = new JLabel("Contraseña : ");

    ImageIcon icon = new javax.swing.ImageIcon((urlImg = new File("src/com/cajero/imagenes/error.png")).getAbsolutePath());

    JLabel lblIcono = new JLabel();
    JLabel lblIcono2 = new JLabel();

    //Cuadro de texto del usuario y cuadro de texto contraseña de la contraseña
    public JTextField txtUsuario = new JTextField(20);
    public static JPasswordField txtCtra = new JPasswordField(20);

    //Panel que engloba todo
    public JPanel pnlMiPanel = new JPanel();

    public Display() {
        //-- CONFIGURAMOS LA VENTANA JFRAME

        super("IDENTIFICARSE");
        this.setSize(450, 270);
        this.setLocationRelativeTo(null);
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
        this.pnlMiPanel.add(this.lblIcono);
        this.pnlMiPanel.add(this.txtUsuario);
        this.pnlMiPanel.add(this.lblCtra);
        this.pnlMiPanel.add(this.lblIcono2);
        this.pnlMiPanel.add(this.txtCtra);
        this.pnlMiPanel.add(this.btnIniciar);
        this.pnlMiPanel.add(this.btnRegistro);
        this.pnlMiPanel.add(this.btnSalir);

        this.add(this.pnlMiPanel);

        //Eventos mouseClicked que llama al metodo (usuario/ctra)MouseClicked
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });

        txtCtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctraMouseClicked(evt);
            }
        });
    }

    //Metodos que cuando haces clic en los jtextField le cambie el color de fondo a blanco (sirve cuando está en rojo)
    public void usuarioMouseClicked(java.awt.event.MouseEvent evt) {

        txtUsuario.setBackground(Color.white);
        this.lblIcono.removeAll();
        this.lblIcono.setIcon(null);
    }

    public void ctraMouseClicked(java.awt.event.MouseEvent evt) {
        txtCtra.setBackground(Color.white);
        this.lblIcono2.removeAll();
        this.lblIcono2.setIcon(null);
    }

    @Override
    public void actionPerformed(ActionEvent AE) {
        //-- CON "getSource()" VEMOS EN QUE BOTON SE HIZO CLICK

        if (AE.getSource() == this.btnIniciar) {
            //A las variables usuario y contraseña se les dan los valores que se 
            //introdujeron en los cuadros de texto.
            usuario = this.txtUsuario.getText();
            ctra = this.txtCtra.getText();

            if (usuario.isEmpty()) {
                txtUsuario.setBackground(Color.red);
                lblIcono.setIcon(icon);

            }

            if (ctra.isEmpty()) {
                txtCtra.setBackground(Color.red);
                lblIcono2.setIcon(icon);
            }
            //Llamada al metodo que valida que el usuario esté registrado en el fichero
            caj.validarUsuario(usuario, ctra);

            //Si el usuario es valido que cierre la pestaña de iniciar sesion           
            if (caj.isValido() == true) {
                setVisible(false);
            }
            //Este metodo simplemente es para que en el titulo de los JPanel muestre el nombre del usuario.
            caj.retornarNombre(usuario, ctra);

        } else if (AE.getSource() == this.btnRegistro) {

            //Si la accion es del boton registro que vaya al metodo registrar usuario.
            caj.registrarUsuario();

        } else if (AE.getSource() == this.btnSalir) {
            System.exit(0);
        }
    }

    //Getter de usuario para la clase cajero.
    public String getUsuario() {
        return usuario;
    }

    public String getCtra() {
        return ctra;
    }

}
