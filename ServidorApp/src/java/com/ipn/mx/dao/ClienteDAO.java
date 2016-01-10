/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dao;
import com.ipn.mx.dto.Cliente;
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
public class ClienteDAO extends ConexionBD{
    
    private static final String SQL_INSERT = "INSERT INTO `FinalDistributed`.`Cliente` (`correo`, `password`, `imagen`, `nombre`, `idDireccion`) VALUES (?, ?, ?, ?, ?);";
    
    private static final String SQL_UPDATE = "UPDATE Alumno SET matricula=?, nombreAlumno=?, paternoAlumno=?, maternoAlumno=?, fechaNacimiento=?," +
                                             "calle=?, colonia=?, numero=?, codigoPostal=?, sexo=?, eMail=?, idCarrera=?  WHERE matricula=?;";
    
    private static final String SQL_DELETE = "DELETE FROM Alumno WHERE matricula=?;";
    
    private static final String SQL_SELECT = "SELECT * FROM Cliente WHERE correo=?;";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM Alumno;";
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ClienteDAO(){
        super();
        ps = null;
        rs = null;
    }
    
    public void create(Cliente cliente) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, cliente.getCorreo());
            ps.setString(2, cliente.getPassword());
            ps.setString(3, cliente.getImagen());
            ps.setString(4, cliente.getNombre());
            ps.setInt(5, cliente.getIdDireccion());
            
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
    
    public Cliente load(String correo) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            List<Cliente> resultados = obtenerResultados(rs);
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
    
    public List<Cliente> obtenerResultados(ResultSet rs) throws SQLException{
        List<Cliente> resultados = new ArrayList<>();
        while(rs.next()){
            Cliente cli = new Cliente();
            cli.setCorreo(rs.getString("correo"));
            cli.setPassword(rs.getString("password"));
            cli.setImagen(rs.getString("imagen"));
            cli.setNombre(rs.getString("nombre"));
            cli.setIdDireccion(rs.getInt("idDireccion"));
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
