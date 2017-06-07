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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juangu
 */
public class Alumno extends HttpServlet {


   
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
        List<AlumnoPOJO> li_al;
        AlumnoDAO dal;
        
        dal = new AlumnoDAO();
        li_al = dal.findAll();
        
        try (PrintWriter out = response.getWriter()) {           
            
            VistaAlumno va = new VistaAlumno(out);
            
            va.pintaCabecera("Listado de alumnos");
            
            out.println("<table id='listadoAlumnos' class='tablesorter' width='80%'>");
            out.println("<thead><tr><th>ID</th><th>Nombre</th><th>"
                    + "Apellido</th><th>acción</th></tr></thead><tbody>");
            if(li_al!=null) {
                for (AlumnoPOJO al : li_al) {
                    out.println("<tr>");
                    out.println("<td>"+al.getId()+"</td>");
                    out.println("<td>"+al.getNombre()+"</td>");
                    out.println("<td>"+al.getApellido()+"</td>");
                    out.println("<td>");
                    out.println(
                            "<a class=\"btn btn-info\" href=\"AlumnoUpdate?id="
                                    +al.getId()
                                    +"&nombre="+al.getNombre()
                                    +"&apellido="+al.getApellido()
                                    +"\">Actualizar</a>");
                    out.println("<a class=\"btn btn-danger\" href=\"AlumnoDelete?id="+al.getId()+"\">Borrar</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            } else {
                va.error("Error al listar alumnos", "No ha sido posible conectar a la base de datos. Intentelo de nuevo pasados unos minutos. Si el error persiste, contacte con el servicio técnico.");                
            }
            out.println("</tbody></table>");
            
            va.pintaPie();
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
