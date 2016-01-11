/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dao;

import com.ipn.mx.dto.Cliente;
import com.ipn.mx.dto.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dduranr
 */
public class DireccionDAO extends ConexionBD{
     private static final String SQL_INSERT = "INSERT INTO `FinalDistributed`.`Direccion` (`calle`, `colonia`, `estado`, `cp`, `numeroExt`, `idCliente`) VALUES (?, ?, ?, ?, ?, ?);";
    
    private static final String SQL_UPDATE = "UPDATE Alumno SET matricula=?, nombreAlumno=?, paternoAlumno=?, maternoAlumno=?, fechaNacimiento=?," +
                                             "calle=?, colonia=?, numero=?, codigoPostal=?, sexo=?, eMail=?, idCarrera=?  WHERE matricula=?;";
    
    private static final String SQL_DELETE = "DELETE FROM Alumno WHERE matricula=?;";
    
    private static final String SQL_SELECT = "SELECT * FROM Cliente WHERE correo=?;";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM Alumno;";
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DireccionDAO(){
        super();
        ps = null;
        rs = null;
    }
    
    public void create(Direccion dir) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dir.getCalle());
            ps.setString(2, dir.getColonia());
            ps.setString(3, dir.getEstado());
            ps.setInt(4, dir.getCp());
            ps.setInt(5, dir.getNumExt());
            ps.setInt(6, dir.getIdCliente());
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
}
