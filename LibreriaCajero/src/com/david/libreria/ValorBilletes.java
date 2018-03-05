
package com.david.libreria;

import javax.swing.JOptionPane;

/**
 *
 * @author dfernandezguerreiro
 */
public class ValorBilletes {
    
    public ValorBilletes(){
    }
    
    //Excepcion que solo permita retirar a partir de 10€.
    public static void dineroRetirar(int saldo) throws ExcepcionPropia{
        int[]billetes={10,20,50,100,500};
        int cantidadRetirar=Integer.parseInt(JOptionPane.showInputDialog("Introducir cantidad que desea retirar: "));
        for(int i=0;i<billetes.length;i++){
            if(cantidadRetirar!=billetes[i]){
                throw new ExcepcionPropia("** solo se puede retirar a partir desde 10€ **");
            }  
        }
    }
    
    //Excepcion que solo permita ingresar billetes de 5,10,20,50,100 y 500.
    public static boolean dineroIngresar(int cantIngresar) throws ExcepcionPropia{
        boolean correcto=true;
        if(cantIngresar%5!=0){
            correcto=false;
            throw new ExcepcionPropia("** solo se puede ingresar billetes de 5, 10, 20, 50, 100 y 500 **");
        }
        return correcto;
    }
    
}
