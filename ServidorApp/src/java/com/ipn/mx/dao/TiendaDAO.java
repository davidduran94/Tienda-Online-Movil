/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dao;

import com.ipn.mx.dto.Cliente;
import com.ipn.mx.dto.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dduranr
 */
public class TiendaDAO extends ConexionBD{
    
    private static final String SQL_INSERT = "INSERT INTO `FinalDistributed`.`Tienda` (`nombre`, `imagen`, `estrellas`) VALUES (?, ?, ?);";
    
    private static final String SQL_UPDATE = "UPDATE Alumno SET matricula=?, nombreAlumno=?, paternoAlumno=?, maternoAlumno=?, fechaNacimiento=?," +
                                             "calle=?, colonia=?, numero=?, codigoPostal=?, sexo=?, eMail=?, idCarrera=?  WHERE matricula=?;";
    
    private static final String SQL_DELETE = "DELETE FROM Alumno WHERE matricula=?;";
    
    private static final String SQL_SELECT = "SELECT * FROM Tienda WHERE nombre=?;";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM Alumno;";
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    public TiendaDAO(){
        super();
        ps = null;
        rs = null;
    }
    
    public void create(Tienda tienda) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, tienda.getNombre());
            ps.setString(2, tienda.getImagen());
            ps.setInt(3, tienda.getEstrellas());
            
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
    
    public Tienda load(String nombre) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            List<Tienda> resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return resultados.get(0);
            }
            else{
                return null;
            }
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
            if(rs != null){
                rs.close();
            }
        }
    }
    
    public List<Tienda> obtenerResultados(ResultSet rs) throws SQLException{
        List<Tienda> resultados = new ArrayList<>();
        while(rs.next()){
            Tienda cli = new Tienda();
            cli.setIdTienda(rs.getInt("idTienda"));
            cli.setNombre(rs.getString("nombre"));
            cli.setImagen(rs.getString("imagen"));
            cli.setFechaCreacion(rs.getString("creacion"));
            cli.setEstrellas(rs.getInt("estrellas"));
            cli.setIdAdministrador(rs.getInt("idAdministrador"));
            resultados.add(cli);
        }
        return resultados;
    }
    
    /*
    public void update(Cliente cliente) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setLong(1, alumno.getMatricula());
            ps.setString(2, alumno.getNombreAlumno());
            ps.setString(3, alumno.getPaternoAlumno());
            ps.setString(4, alumno.getMaternoAlumno());
            ps.setString(5, alumno.getFechaNacimiento());
            ps.setString(6, alumno.getCalle());
            ps.setString(7, alumno.getColonia());
            ps.setInt(8, alumno.getNumero());
            ps.setLong(9, alumno.getCodigoPostal());
            ps.setString(10, alumno.getSexo());
            ps.setString(11, alumno.geteMail());
            ps.setInt(12, alumno.getIdCarrera().getIdCarrera());
            ps.setLong(13, alumno.getMatricula());
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
    
    public void update(Cliente cliente, long nuevaContra) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setLong(1, nuevaMatricula);
            ps.setString(2, alumno.getNombreAlumno());
            ps.setString(3, alumno.getPaternoAlumno());
            ps.setString(4, alumno.getMaternoAlumno());
            ps.setString(5, alumno.getFechaNacimiento());
            ps.setString(6, alumno.getCalle());
            ps.setString(7, alumno.getColonia());
            ps.setInt(8, alumno.getNumero());
            ps.setLong(9, alumno.getCodigoPostal());
            ps.setString(10, alumno.getSexo());
            ps.setString(11, alumno.geteMail());
            ps.setInt(12, alumno.getIdCarrera().getIdCarrera());
            ps.setLong(13, alumno.getMatricula());
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
    
    public void delete(Cliente cliente) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setLong(1, cliente.getMatricula());
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
    
    
    
    
    
    public List<Cliente> loadAll() throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List<Cliente> resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return resultados;
            }
            else{
                return null;
            }
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
            if(rs != null){
                rs.close();
            }
        }
    }
    
  */  
}
