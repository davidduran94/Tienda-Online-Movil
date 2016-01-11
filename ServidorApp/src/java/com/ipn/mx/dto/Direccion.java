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
public class Direccion {

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getNumExt() {
        return numExt;
    }

    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Direccion(String calle, String colonia, String estado, int cp, int numExt, int idCliente) {
        this.calle = calle;
        this.colonia = colonia;
        this.estado = estado;
        this.cp = cp;
        this.numExt = numExt;
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", colonia=" + colonia + ", estado=" + estado + ", cp=" + cp + ", numExt=" + numExt + ", idCliente=" + idCliente + '}';
    }
    private int idDireccion;
    private String calle;
    private String colonia;
    private String estado;
    private int cp;
    private int numExt;
    private int idCliente;
}
