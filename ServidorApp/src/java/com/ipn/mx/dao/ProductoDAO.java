/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ipn.mx.dto.Producto;
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
public class ProductoDAO extends ConexionBD{
    
    private static final String SQL_INSERT = "INSERT INTO `FinalDistributed`.`Producto` (`nombre`, `imagen`, `precio`, `descripcion`, `existencias`, `dimesiones`, `peso`, `idTienda`) VALUES (?,?,?,?,?,?,?,?);";
    
    private static final String SQL_UPDATE = "UPDATE Alumno SET matricula=?, nombreAlumno=?, paternoAlumno=?, maternoAlumno=?, fechaNacimiento=?," +
                                             "calle=?, colonia=?, numero=?, codigoPostal=?, sexo=?, eMail=?, idCarrera=?  WHERE matricula=?;";
    
    private static final String SQL_DELETE = "DELETE FROM Alumno WHERE matricula=?;";
    
    private static final String SQL_SELECT = "SELECT * FROM Producto WHERE idTienda=?;";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM Producto;";
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ProductoDAO(){
        super();
        ps = null;
        rs = null;
    }
    
    public void create(Producto product) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, product.getNombre());
            ps.setString(2, product.getImagen());
            ps.setInt(3, product.getPrecio());
            ps.setString(4, product.getDescripsion());
            ps.setInt(5, product.getExistencias());
            ps.setInt(6, product.getDimensiones());
            ps.setString(7, product.getPeso());
            ps.setInt(8, product.getIdTienda());
            
            ps.executeUpdate();
        }finally{
            if(ps != null){
                ps.close();
            }
            close();
        }
    }
    
    public List<Producto> load(String idTienda) throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setString(1, idTienda);
            rs = ps.executeQuery();
            List<Producto> resultados = obtenerResultados(rs);
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
    
    public List<Producto> obtenerResultados(ResultSet rs) throws SQLException{
        List<Producto> resultados = new ArrayList<>();
        while(rs.next()){
            Producto cli = new Producto();
            cli.setIdProducto(rs.getInt("idProducto"));
            cli.setNombre(rs.getString("nombre"));
            cli.setImagen(rs.getString("imagen"));
            cli.setPrecio(rs.getInt("precio"));
            cli.setDescripsion(rs.getString("descripcion"));
            cli.setExistencias(rs.getInt("existencias"));
            cli.setDimensiones(rs.getInt("dimesiones"));
            cli.setPeso(rs.getString("peso"));
            cli.setIdTienda(rs.getInt("idTienda"));
            resultados.add(cli);
        }
        return resultados;
    }
    
    public List<Producto> loadAll() throws SQLException{
        conectar();
        Connection con = getConexionBD();
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List<Producto> resultados = obtenerResultados(rs);
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
    
    
    
    
    
    
    
  */  
}
