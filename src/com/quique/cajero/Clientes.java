/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.cajero;

/**
 *
 * @author quique
 */
public class Clientes {
    
    
    private String nombre;
    private String usuario;
    private String contraseña;
    private float saldo;

    public Clientes() {
    }

    public Clientes(String nombre, String usuario, String contraseña, float saldo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario + ", Contraseña: " + contraseña + ", Nombre: " + nombre + ", Saldo: " + saldo;
    }
    
    
    
            
}
