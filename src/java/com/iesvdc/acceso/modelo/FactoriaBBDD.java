/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juangu
 */
public class FactoriaBBDD {
    public static Connection Conecta() throws SQLException{
        Connection conn=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String jdbcURL = "jdbc:oracle:thin:@orasrv:1521:XE";
            conn = DriverManager.getConnection(jdbcURL, "damuser23", "damuser");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FactoriaBBDD.class.getName()).log(Level.SEVERE, null, ex);     
        } 
        return conn;        
    }
}
