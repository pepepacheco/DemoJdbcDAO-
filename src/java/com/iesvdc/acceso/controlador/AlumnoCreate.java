/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controlador;

import com.iesvdc.acceso.modelo.AlumnoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

/**
 *
 * @author juangu
 */
import com.iesvdc.acceso.modelo.AlumnoPOJO;
import com.iesvdc.acceso.vista.VistaAlumno;
public class AlumnoCreate extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            VistaAlumno va = new VistaAlumno(out);
            va.pintaCabecera("Alta Alumno");
            
            va.pintaAltaForm();
            
            va.pintaPie();
        } 
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
        
        AlumnoPOJO al = new AlumnoPOJO( 
            request.getParameter("nombre").trim().toUpperCase(),
            request.getParameter("apellido").trim().toUpperCase());
        
        AlumnoDAO al_dao = new AlumnoDAO();
        if (al_dao.create(al)) { // true si exito
            response.sendRedirect("Alumno");
        } else { // false si error
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AlumnoCreate</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error al crear alumno</h1>");
                out.println("</body>");
                out.println("</html>");
            }
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
