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
public class Producto {
    private int idProducto;
    private String nombre;
    private String imagen;
    private int precio;
    private String descripsion;
    private int existencias;
    private int dimensiones;
    private String peso;
    private int idTienda;

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio + ", descripsion=" + descripsion + ", existencias=" + existencias + ", dimensiones=" + dimensiones + ", peso=" + peso + ", idTienda=" + idTienda + '}';
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripsion() {
        return descripsion;
    }

    public void setDescripsion(String descripsion) {
        this.descripsion = descripsion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public Producto(String nombre, String imagen, int precio, String descripsion, int existencias, int dimensiones, String peso, int idTienda) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.descripsion = descripsion;
        this.existencias = existencias;
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.idTienda = idTienda;
    }
    public Producto(){}
}
