/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.vista;

import com.iesvdc.acceso.modelo.AlumnoPOJO;
import java.io.PrintWriter;

/**
 *
 * @author juangu
 */
public class VistaAlumno {
    PrintWriter pr;
    private String cabecera = "<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>%%mi_titulo%%</title>\n" +
"        <meta charset=\"iso-8859-1\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <script src=\"js/jquery.min.js\"></script>\n" +
"        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" >\n" +
"        <script src=\"js/bootstrap.min.js\" ></script>\n" +
            "        <script src=\"js/bootstrap3-floating-labels.js\" ></script>\n"+ 
            "<link href=\"css/bootstrap3-floating-labels.css\" rel=\"stylesheet\" type=\"text/css\"/>"+
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container\">\n" +
"            <!-- Static navbar -->\n" +
"            <nav class=\"navbar navbar-default\">\n" +
"                <div class=\"container-fluid\">\n" +
"                    <div class=\"navbar-header\">\n" +
"                        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n" +
"                            <span class=\"sr-only\">Desplegar</span>\n" +
"                            <span class=\"icon-bar\"></span>\n" +
"                            <span class=\"icon-bar\"></span>\n" +
"                            <span class=\"icon-bar\"></span>\n" +
"                        </button>\n" +
"                        <a class=\"navbar-brand\" href=\"#\">Gestión Académica</a>\n" +
"                    </div>\n" +
"                    <div id=\"navbar\" class=\"navbar-collapse collapse\">\n" +
"                        <ul class=\"nav navbar-nav\">\n" +
"                            <li class=\"active\"><a href=\"#\">Inicio</a></li>\n" +
"                            <li class=\"dropdown\">\n" +
"                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Alumno <span class=\"caret\"></span></a>\n" +
"                                <ul class=\"dropdown-menu\">\n" +
"                                    <li><a href=\"Alumno\">Listado</a></li>\n" +
"                                    <li><a href=\"AlumnoCreate\">Alta</a></li>\n" +
"                                    <li><a href=\"Alumno\">Modificación</a></li>\n" +
"                                    <li><a href=\"Alumno\">Borrado</a></li>\n" +
"                                </ul>\n" +
"                            </li>\n" +
"                        </ul>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </nav>";
    
    
    private String pie = "</div>\n" +
"    </body>\n" +
"</html>\n";
    
    private String altaForm = "<div class=\"row\">\n" +
"                    <div class=\"col-sm-8\">\n" +
"                        <h3 class=\"page-header\">Alta alumnos</h3>\n" +
"                        <form role=\"form\" action=\"AlumnoCreate\" method=\"POST\">\n" +
"                            <div class=\"form-group float-label-control\">\n" +
"                                <label for=\"\"></label>\n" +
"                                <input name=\"nombre\" type=\"text\" class=\"form-control\" placeholder=\"Nombre del alumno\"/>\n" +
"                            </div>\n" +
"                            <div class=\"form-group float-label-control\">\n" +
"                                <label for=\"\"></label>\n" +
"                                <input name=\"apellido\" type=\"text\" class=\"form-control\" placeholder=\"Apellido del alumno\"/>\n" +
"                            </div>\n" +
"                            <button class=\"btn btn-info\">Aceptar</button>\n" +
"                            <div class=\"btn btn-danger\" onclick=\"window.history.back()\">Cancelar</div>\n" +
"                        </form>\n" +
"                    </div>                 \n" +
"                </div>";
    
    public VistaAlumno(PrintWriter pr) {
        this.pr = pr;
    }
    
    public void pintaCabecera(String titulo){
        String resultado = cabecera.replace("%%mi_titulo%%", titulo);
        pr.println(resultado);
    }
    
    public void pintaAltaForm(){
        pr.println(altaForm);
    }
    
    public void error(String titulo, String mensaje){
        
    }
    
    public void formulario(AlumnoPOJO al, String action, boolean enabled){
        
    }
    
    public void pintaPie(){
        pr.println(pie);
    }
}
