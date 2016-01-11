/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import com.google.gson.Gson;
import com.ipn.mx.dao.ProductoDAO;
import com.ipn.mx.dao.TiendaDAO;
import com.ipn.mx.dto.Cliente;
import com.ipn.mx.dto.Producto;
import com.ipn.mx.dto.Tienda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dduranr
 */
@WebServlet(name = "Tiendas", urlPatterns = {"/Tiendas"})
public class Tiendas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String peticion = request.getParameter("peticion");
        System.err.println("Peticion: "+peticion);
        ControladorDeSesion cs = new ControladorDeSesion();
        
        switch (peticion){
            case "TIENDAS":
                if(!cs.existeSesionIniciada(request)){
                    System.err.println("Sesion activa");
                    Cliente cli = (Cliente)request.getAttribute("usuario");
                    TiendaDAO td = new TiendaDAO();
                    try {
                        List<Tienda> tiendas = td.loadAll();
                        Gson yeison = new Gson();
                        String respuesta = yeison.toJson(tiendas);
                        response.setContentType("text/plain; charset=UTF-8");
                        try (PrintWriter out = response.getWriter()) {  
                            out.println(respuesta);
                            System.err.println("Se envio respuesta");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Tiendas.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }
                else{
                    response.setContentType("text/plain;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) { 
                        out.println("error");
                    }
                }
            break;
                
            case "PRODUCTOS":
                if(!cs.existeSesionIniciada(request)){
                    System.err.println("Sesion activa");
                    Cliente cli = (Cliente)request.getAttribute("usuario");
                    ProductoDAO td = new ProductoDAO();
                    try {
                        List<Producto> productos = td.load(request.getParameter("idTienda"));
                        Gson yeison = new Gson();
                        String respuesta = yeison.toJson(productos);
                        System.err.println(respuesta);
                        response.setContentType("text/plain; charset=UTF-8");
                        try (PrintWriter out = response.getWriter()) {  
                            out.println(respuesta);
                            System.err.println("Se envio respuesta");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Tiendas.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }
                else{
                    response.setContentType("text/plain;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) { 
                        out.println("error");
                    }
                }
            break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entro get");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
