/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dto;

/**
 *
 * @author dduranr
 */
public class Cliente {
    private int idCliente;
    private String correo;
    private String password;
    private String imagen;
    private String nombre;
    
    public Cliente(){}
    
    public Cliente(String correo, String password, String imagen, String nombre) {
        this.correo = correo;
        this.password = password;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", correo=" + correo + ", password=" + password + ", imagen=" + imagen + ", nombre=" + nombre+"}";
    }
}
