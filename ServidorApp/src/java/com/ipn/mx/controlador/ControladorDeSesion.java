/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

//Importaciones necesarias para la clase
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
Clase que se encarga de controlar una sesión en una aplicación web
*/
public class ControladorDeSesion {
    //Constante que representa el nombre del atributo con el cual se identificará el usuario en la sesión
    public static final String LOGIN_NAME = "usuario";
    
    //Método que inicia una sesión para el usuario que se envía como parámetro
    public void iniciarSesion(HttpServletRequest request, HttpServletResponse response, Object usuario){
        //Se obtiene una nueva sesión del request que se pasa por parámetro
        HttpSession sesion = request.getSession(true);
        //Se coloca como atributo de sesión a nuestro usuario con un identificador definido por una constante
        sesion.setAttribute(LOGIN_NAME, usuario);
    }
    
    //Método que cierra la sesión actual
    public void cerrarSesion(HttpServletRequest request, HttpServletResponse response){
        //Se obtiene una nueva sesión del request que se pasa por parámetro
        HttpSession sesion = request.getSession(true);
        //Si la sesión se obtiene exitosamente
        if(sesion != null){
            //Se elimina el atributo de sesión que almacena al usuario
            sesion.removeAttribute(LOGIN_NAME);
            //Se invalida la sesión actual para que a esta ya no se le pueda colocar atributos
            sesion.invalidate();
        }
    }
    
    //Método que verifica si ya hay alguna sesión iniciada
    public boolean existeSesionIniciada(HttpServletRequest request){
        //Se obtiene la sesión actual
        HttpSession sesion = request.getSession(false);
        //Si no existe una sesión actual
        if(sesion == null){
            //Regresa falso
            return false;
        }
        //Si exite la sesión actual
        else{
            //Regresa verdadero si el usuario está almacenado en sesión
            //Regresa falso si el usuario no está almacenado en sesión
            return sesion.getAttribute(LOGIN_NAME) != null;
        }
    }
}
