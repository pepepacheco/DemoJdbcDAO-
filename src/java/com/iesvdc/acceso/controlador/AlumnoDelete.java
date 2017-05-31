/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controlador;

import com.iesvdc.acceso.modelo.AlumnoDAO;
import com.iesvdc.acceso.modelo.AlumnoPOJO;
import com.iesvdc.acceso.vista.VistaAlumno;
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
public class AlumnoDelete extends HttpServlet {


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
        
        response.setContentType("text/html;charset=UTF-8");
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        try (PrintWriter out = response.getWriter()) {
            VistaAlumno va = new VistaAlumno(out);
            va.pintaCabecera("Borrado de Alumno");
            
            if (id!=null) {
                AlumnoDAO al_dao = new AlumnoDAO();
                AlumnoPOJO al = al_dao.findById(id);
                if (al!=null) {
                // formulario (obj alumno, destino post, enabled) 
                    va.formulario(al,"AlumnoDelete", false);
                } else {
                    va.error("Borrando Alumno", "No puedo encontrar ese ID de alumno");
                }
            } else {
                va.error("Borrando Alumno", "No puedo encontrar el alumno");
            }
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
        
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
