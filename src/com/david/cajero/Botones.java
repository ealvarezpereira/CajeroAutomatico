/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.cajero;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Botones implements ActionListener{
    JButton jBoton1, jBoton2, jBoton3, jBoton4, jBoton5, jBoton6, jBoton7, jBoton8, jBoton9;
    JPanel jPanel1, jPanel2, jPanel3;
    JLabel jLabel1, jLabel2;
 
    public Botones (){//constructor de la clase
 
        JFrame obxFrame=new JFrame("Cajero Automático");
        obxFrame.setLayout(new BorderLayout(60, 20));
 
//        jLabel1=new JLabel(); //Creo el jLabel que muestra el número pulsado
//        jLabel1.setText("TEXTO DE ENCIMA DE LOS BOTONES");
 
        mostrarBotones();
 
//        obxFrame.add(jLabel1, BorderLayout.NORTH);
        obxFrame.add(jPanel2, BorderLayout.SOUTH);
 
        obxFrame.setSize(400, 300);
        obxFrame.setLocation(300, 200);
        obxFrame.setVisible(true);
        obxFrame.setResizable(false);
        obxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    //Método en el que está el Jpanel y contiene los botones.
    public void mostrarBotones(){
        jPanel2 = new JPanel(new GridLayout(3, 3, 20, 5));
 
        //Creo los botones:
        jBoton1=new JButton("1"); jBoton2=new JButton("2"); jBoton3=new JButton("3");
        jBoton4=new JButton("4"); jBoton5=new JButton("5"); jBoton6=new JButton("6");
        jBoton7=new JButton("7"); jBoton8=new JButton("8"); jBoton9=new JButton("9");
 
        //Añado los botones al JPanel:
        jPanel2.add(jBoton9); jPanel2.add(jBoton8); jPanel2.add(jBoton7); 
        jPanel2.add(jBoton6); jPanel2.add(jBoton5); jPanel2.add(jBoton4); 
        jPanel2.add(jBoton3); jPanel2.add(jBoton2); jPanel2.add(jBoton1); 
 
        //Añado el listener para hacer "click"
        this.jBoton1.addActionListener(this); this.jBoton2.addActionListener(this); this.jBoton3.addActionListener(this);
        this.jBoton4.addActionListener(this); this.jBoton5.addActionListener(this); this.jBoton6.addActionListener(this);
        this.jBoton7.addActionListener(this); this.jBoton8.addActionListener(this); this.jBoton9.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        jLabel1.setText(ae.getActionCommand());
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
