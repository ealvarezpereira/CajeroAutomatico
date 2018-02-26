
package com.david.cajero;

/**
 *
 * @author David
 */
public class Dinero {
    private float dineroTotal;
    private float cantidadRetirar;
    private float cantidadIngresar;
    private float dineroCajero;

    public Dinero() {
    }

    public Dinero(float dineroTotal, float cantidadRetirar, float cantidadIngresar, float dineroCajero) {
        this.dineroTotal = dineroTotal;
        this.cantidadRetirar = cantidadRetirar;
        this.cantidadIngresar = cantidadIngresar;
        this.dineroCajero = dineroCajero;
    }

    public float getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(float dineroTotal) {
        this.dineroTotal = dineroTotal;
    }

    public float getCantidadRetirar() {
        return cantidadRetirar;
    }

    public void setCantidadRetirar(float cantidadRetirar) {
        this.cantidadRetirar = cantidadRetirar;
    }

    public float getCantidadIngresar() {
        return cantidadIngresar;
    }

    public void setCantidadIngresar(float cantidadIngresar) {
        this.cantidadIngresar = cantidadIngresar;
    }

    public float getDineroCajero() {
        return dineroCajero;
    }

    public void setDineroCajero(float dineroCajero) {
        this.dineroCajero = dineroCajero;
    }

    @Override
    public String toString() {
        return "Dinero Total: "+dineroTotal+", Cantidad a retirar: "+cantidadRetirar+", Cantidad a ingresar: "+cantidadIngresar+", Dinero Cajero: "+dineroCajero;
    }
    
    
    
    
}
