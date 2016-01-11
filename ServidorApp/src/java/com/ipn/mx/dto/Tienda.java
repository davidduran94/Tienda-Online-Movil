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
public class Tienda {
    
    public Tienda(){
    }

    public Tienda(int idTienda, String nombre, String imagen, String fechaCreacion, int idAdministrador) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.imagen = imagen;
        this.fechaCreacion = fechaCreacion;
        this.idAdministrador = idAdministrador;
    }
    
    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    
    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "Tienda{" + "idTienda=" + idTienda + ", nombre=" + nombre + ", imagen=" + imagen + ", fechaCreacion=" + fechaCreacion + ", idAdministrador=" + idAdministrador + '}';
    }
    
    private int idTienda;
    private String nombre;
    private String imagen;
    private String fechaCreacion;
    private int estrellas;
    private int idAdministrador;
}
