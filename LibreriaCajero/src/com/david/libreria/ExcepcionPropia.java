
package com.david.libreria;

/**
 *
 * @author dfernandezguerreiro
 */
public class ExcepcionPropia extends Exception{
    
    public ExcepcionPropia(){
        super(" solo se permiten billetes de... ");
    }
    
    public ExcepcionPropia(String mensaxe){
        super (mensaxe);
    }
    
}
