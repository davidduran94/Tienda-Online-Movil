/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.ipn.mx.dao.ClienteDAO;
import com.ipn.mx.dao.DireccionDAO;
import com.ipn.mx.dto.Cliente;
import com.ipn.mx.dto.Direccion;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author dduranr
 */
public class loginApp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.err.println("Entro get");
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
        System.out.println("peticion recibida");
        response.setContentType("text/html;charset=UTF-8");
        String respuesta= "Revise sus datos e intentelo de nuevo";
        ClienteDAO cli = new ClienteDAO();
        DireccionDAO direccionDAO = new DireccionDAO();
        Cliente c;
        MailSender ms = new MailSender();
        switch(request.getParameter("form")){
            case "REGISTRO":
                String direccionC = request.getParameter("txtDireccionRegistro");
                String calle = direccionC.split(" ")[0];
                String colonia = direccionC.split(" ")[1];
                String estado = direccionC.split(" ")[2];
                int numero = Integer.parseInt(direccionC.split(" ")[3]);
                int cp = Integer.parseInt(direccionC.split(" ")[4]);
                String correo = request.getParameter("txtCorreoRegistro");
                String nombre = request.getParameter("txtNombreRegistro");
                String pass = request.getParameter("txtPassRegistro");
                c = new Cliente(correo, pass, "image", nombre); 
                
                try {
                    if(cli.load(correo)!= null){ //si estan duplicados
                        System.err.println("Correo Duplicado");
                        break;
                    }
                    cli.create(c);
                    Direccion di = new Direccion(calle, colonia, estado, numero, cp, (cli.load(correo).getIdCliente()));
                    direccionDAO.create(di);
                    ms.generateAndSendEmail(correo, "se ha creado una cuenta asociada a este correo con la contraseña : "+ pass, "Bienvenido a nuestra tienda online");
                    respuesta="Registro realizado";
                } catch (SQLException ex) {
                    Logger.getLogger(loginApp.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                } catch (MessagingException ex) {
                    Logger.getLogger(loginApp.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
                
            break;
                
            case "LOGIN":
                String usuario = request.getParameter("txtNombreLogin");
                String contra = request.getParameter("txtPassLogin");
                {
                    try {
                        c = cli.load(usuario);
                        if(c != null){
                            if(c.getPassword().equals(contra)){
                                respuesta="Login realizado";
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(loginApp.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }
            break;
                
            case "RECUPERACION":
                try {
                    correo = request.getParameter("txtEmail");
                    contra = cli.load(correo).getPassword();
                    if ( contra != null){
                        ms = new MailSender();
                        ms.generateAndSendEmail(correo,"Su contraseña de acceso es: "+contra, "Recuperacion contraseña");
                    }
                    respuesta = "Recuperacion realizada";
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            break;
            
            
        }
        try (PrintWriter out = response.getWriter()) { 
            out.println(respuesta);
        }
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
