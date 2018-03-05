/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quidave.cajero;

import com.david.cajero.ElegirOpcion;
import com.david.libreria.*;
import com.quique.cajero.Clientes;
import com.quique.cajero.Display;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author quique
 * @author david
 */
public class Cajero {

    File fich;
    private String line = "";
    private boolean valido = false;
    private PrintWriter escribir;
    private Clientes cliente;
    private static String nom;
    private int credito;

    //Getter para que en el display no cierre la ventana al introducir un usuario incorrecto
    public boolean isValido() {
        return valido;
    }

    public String validarUsuario(String usuario, String ctra) {

        File fich = new File("cajero.txt");

        //Si el usuario o la contraseña son valores en blanco o nulos que no permita continuar
        if (usuario == "" && usuario.contains(null) || ctra == "" && ctra.contains(null)) {
            JOptionPane.showMessageDialog(null, "No puedes meter valores en blanco.");
            Display.txtCtra.setText(null);
        } else {

            try {
                final BufferedReader reader = new BufferedReader(new FileReader("cajero.txt"));

                //Mietras que la linea que le metes el valor reader.readLine() (que lo que hace es
                //leer la linea) sea distinto de null te haga el if
                while ((line = reader.readLine()) != null) {
                    valido = false;

                    //El indexOf si no encuentra el valor que le metes devuelve un -1, por eso la comparacion
                    //Si la busqueda es distinto de -1
                    if (line.indexOf(usuario) != -1 && line.indexOf(ctra) != -1) {

                        //La marca valido es para que si encuentra un usuario salte la marca
                        valido = true;
                        JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente!");
                        Display dis = new Display();
                        cuerpoDelCajero();

                        break;
                    }
                }

                //Si no ha entrado en el if es que no existe el usuario
                if (valido == false) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                    //Con esto borramos el contenido del campo contraseña
                    Display.txtCtra.setText(null);
                }

                reader.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Error " + ex);
            } catch (IOException ex) {
                System.out.println("Error " + ex);
            }
        }
        return usuario;
    }

    public void retornarNombre(String usuario, String ctra) {

        File fich = new File("cajero.txt");
        try {
            final BufferedReader reader = new BufferedReader(new FileReader("cajero.txt"));
            while ((line = reader.readLine()) != null) {
                valido = false;

                if (line.indexOf(usuario) != -1 && line.indexOf(ctra) != -1) {

                    String[] nombre = line.split("\\s*,\\s*");

                    nom = nombre[2];
                    break;
                }
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public static String getNom() {
        return nom;
    }
    
    public void registrarUsuario() {
        /**
         * Estos JOptionPane son para darle valores al constructor de Clientes
         *
         * @param usu Usuario del cliente
         * @param ctra Contraseña de su cuenta
         * @param nom Nombre del cliente
         * @param saldo Saldo de su cuenta
         */
        String usu = JOptionPane.showInputDialog("Usuario");

        //Mientras que el usuario sea un nulo o un valor en blanco que no te deje meterlo.
        while (usu.equals("") || usu == null) {
            usu = JOptionPane.showInputDialog("Usuario inválido.");
        }

        try {

            fich = new File("cajero.txt");
            BufferedReader leer = new BufferedReader(new FileReader("cajero.txt"));
            String line = "";

            while ((line = leer.readLine()) != null) {

                //El indexOf si no encuentra el valor que le metes devuelve un -1, por eso la comparacion
                //Si la busqueda es distinto de -1
                if (line.indexOf(usu) != -1) {
                    usu = JOptionPane.showInputDialog("Usuario existente.");
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error. No se ha encontrado. " + ex);
        } catch (IOException ex) {
            System.out.println("Error. " + ex);
        }

        String ctra = JOptionPane.showInputDialog("Contraseña");

        while (ctra.equals("") || ctra == null) {
            ctra = JOptionPane.showInputDialog("Contraseña inválida.");

        }

        String nom = JOptionPane.showInputDialog("Nombre");
        int saldo = 0;

        try {
            /**
             * Fich pasa a ser un nuevo archivo file
             *
             * @param escribir pasa a ser un nuevo PrintWriter que tiene dentro
             * un FileWriter con el fichero.
             *
             * Introducimos el objeto de tipo libro en el fichero.
             */
            fich = new File("cajero.txt");
            escribir = new PrintWriter(new FileWriter(fich, true));
            escribir.println(cliente = new Clientes(usu, ctra, nom, saldo));

        } catch (FileNotFoundException ex) {
            /**
             * Excepcion mas estricta Excepcion general
             *
             * @param ex Excepcion de tipo FileNotFoundException
             * @param ex (Segundo ex) Excepcion de tipo IOException
             */
            System.out.println("Error de escritura" + ex);

        } catch (IOException ex) {
            System.out.println("Error de escritura" + ex);
        } finally {
            escribir.close();
        }

    }

    public void cuerpoDelCajero() {

        //Este try-catch es para la interfaz de las ventanas.
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Aqui es la llamada la interfaz grafica de las opciones
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirOpcion().setVisible(true);
            }
        });

    }

    File fich2;
    int m;

    public void ingresarDinero(String completo) {
        fich = new File("cajero.txt");
        fich2 = new File("cajero2.txt");

        try {
            Display obxDisplay = new Display();
            //Aqui pedimos el usuario
            String usuario = obxDisplay.getUsuario();

            //En la variable credito parseamos el dinero que introducimos en la interfaz introducir dinero
            credito = Integer.parseInt(completo);
            
            //Creamos un buffer del fichero para leer datos
            final BufferedReader reader = new BufferedReader(new FileReader("cajero.txt"));

            escribir = new PrintWriter(new FileWriter(fich2, true));
            //Mietras que la linea que le metes el valor reader.readLine() (que lo que hace es
            //leer la linea) sea distinto de null te haga el if
            while ((line = reader.readLine()) != null) {
                m = 0;
                String salvadas = line;

                if (salvadas.contains(usuario) != true) {
                    escribir.println(salvadas);
                } else {
                    if(com.david.libreria.ValorBilletes.dineroIngresar(credito)==true){
                    //Separamos la linea por comas
                    String[] lineaEntera = salvadas.split("\\s*,\\s*");

                    //Añadimos el precio a un string
                    String precio = lineaEntera[3];

                    //Separamos la palabra precio del precio en si
                    String[] precioSeparado = precio.split("\\s*:\\s*");
                    //A la posicion del precio en si le damos el valor del precio que introducimos

                    ElegirOpcion opc = new ElegirOpcion();

                    //A la variable dinero le sumamos el dinero que sacamos del fichero junto con el dinero que introducimos
                    int dinero = Integer.parseInt(precioSeparado[1]) + credito;

                    precioSeparado[1] = String.valueOf(dinero);

                    //A la linea le añadimos la cadena entera
                    salvadas = lineaEntera[0] + ", " + lineaEntera[1] + ", " + lineaEntera[2] + ", " + precioSeparado[0] + ": " + precioSeparado[1];
                    escribir.println(salvadas);
                    salvadas = "";
                    precio = "";
                }else{
                        String[] lineaEntera = salvadas.split("\\s*,\\s*");
                        //Añadimos el precio a un string
                        String precio = lineaEntera[3];
                        //Separamos la palabra precio del precio en si
                        String[] precioSeparado = precio.split("\\s*:\\s*");
                        //A la posicion del precio en si le damos el valor del precio que introducimos
                        ElegirOpcion opc = new ElegirOpcion();
                        //A la variable dinero le sumamos el dinero que sacamos del fichero junto con el dinero que introducimos
                        int dinero = Integer.parseInt(precioSeparado[1]);
                        precioSeparado[1] = String.valueOf(dinero);
                        //A la linea le añadimos la cadena entera
                        salvadas = lineaEntera[0] + ", " + lineaEntera[1] + ", " + lineaEntera[2] + ", " + precioSeparado[0] + ": " + precioSeparado[1];
                        escribir.println(salvadas);
                        salvadas = "";
                        precio = "";              
                }
                }
            }

            reader.close();
            escribir.close();
            fich.delete();
            //Renombramos el fichero
            boolean correcto = fich2.renameTo(fich);

            if (correcto) {
                System.out.println("Fichero renombrado.");

            } else {
                System.out.println("fichero no renombrado");
            }

        }catch (ExcepcionPropia ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }

    }

    public void quitarDinero(String completo) {
        fich = new File("cajero.txt");
        fich2 = new File("cajero2.txt");

        try {
            Display obxDisplay = new Display();
            //Aqui pedimos el usuario
            String usuario = obxDisplay.getUsuario();

            //En la variable credito parseamos el dinero que introducimos en la interfaz retirar dinero
            int credito = Integer.parseInt(completo);

            //Creamos un buffer del fichero para leer datos
            final BufferedReader reader = new BufferedReader(new FileReader("cajero.txt"));

            escribir = new PrintWriter(new FileWriter(fich2, true));
            //Mietras que la linea que le metes el valor reader.readLine() (que lo que hace es
            //leer la linea) sea distinto de null te haga el if
            while ((line = reader.readLine()) != null) {
                m = 0;
                String salvadas = line;

                if (salvadas.contains(usuario) != true) {
                    escribir.println(salvadas);
                } else {

                    //Separamos la linea por comas
                    String[] lineaSeparada = salvadas.split("\\s*,\\s*");

                    //Añadimos el precio a un string
                    String saldo = lineaSeparada[3];

                    //Separamos la palabra saldo del dinero en si
                    String[] dineroSeparado = saldo.split("\\s*:\\s*");
                    //A la posicion del dinero en si le damos el valor del dinero que introducimos

                    //ElegirOpcion opc = new ElegirOpcion();
                    //Si tienes menos saldo en el banco que la cantidad que introduces, que vuelva a introducir la linea
                    //sin hacer nada.
                    if (Integer.parseInt(dineroSeparado[1]) < credito) {

                        //A la linea le añadimos la cadena entera
                        salvadas = lineaSeparada[0] + ", " + lineaSeparada[1] + ", " + lineaSeparada[2] + ", " + dineroSeparado[0] + ": " + dineroSeparado[1];
                        escribir.println(salvadas);
                        salvadas = "";
                        saldo = "";
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente en la cuenta.");

                    } else {
                        int dinero = Integer.parseInt(dineroSeparado[1]) - credito;
                        dineroSeparado[1] = String.valueOf(dinero);

                        //A la linea le añadimos la cadena entera
                        salvadas = lineaSeparada[0] + ", " + lineaSeparada[1] + ", " + lineaSeparada[2] + ", " + dineroSeparado[0] + ": " + dineroSeparado[1];
                        escribir.println(salvadas);
                        salvadas = "";
                        saldo = "";
                    }
                }
            }

            reader.close();
            escribir.close();
            fich.delete();
            //Renombramos el fichero
            boolean correcto = fich2.renameTo(fich);

            if (correcto) {
                System.out.println("Fichero renombrado.");

            } else {
                System.out.println("fichero no renombrado");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }
}
