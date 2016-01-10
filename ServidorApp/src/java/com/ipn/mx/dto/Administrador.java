/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dto;

import java.util.Objects;

/**
 *
 * @author dduranr
 */
public class Administrador {
    
    private int idAdministrador;
    private String nombre;
    private String usuario;
    private String correo;
    private String password;
    
    public Administrador(int idAdministrador, String nombre, String usuario, String correo, String password) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
    }
    

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
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
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.password);
        return hash;
    }
    


}
