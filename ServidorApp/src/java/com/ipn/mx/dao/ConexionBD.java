/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dao;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author dduranr
 */
public class ConexionBD {
   
    private Connection conexionBD;
    private String driver;
    private String url;
    private String nombreBD;
    private String usuario;
    private String password;

    public ConexionBD(){
    }

    public void conectar() throws SQLException{
        try{
            Properties prop = new Properties();
            prop.load(getClass().getResourceAsStream("../../properties/dbproperties.properties"));
            Class.forName(prop.getProperty("driver"));
            conexionBD = (Connection) DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usuario"), prop.getProperty("clave"));
        }catch(ClassNotFoundException|IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void close() throws SQLException{
        if(conexionBD != null){
            conexionBD.close();
        }
    }

    public Connection getConexionBD() {
        return conexionBD;
    }

    public void setConexionBD(Connection conexionBD) {
        this.conexionBD = conexionBD;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}