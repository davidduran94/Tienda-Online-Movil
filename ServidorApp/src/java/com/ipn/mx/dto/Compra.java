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
public class Compra {
    private int idCompra;
    private int idCliente;
    private int idEnvio;
    private String fecha ;
    private String tipoPago;

    public Compra(int idCompra, int idCliente, int idEnvio, String fecha, String tipoPago ) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.idEnvio = idEnvio;
        this.fecha = fecha;
        this.tipoPago = tipoPago;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
}
