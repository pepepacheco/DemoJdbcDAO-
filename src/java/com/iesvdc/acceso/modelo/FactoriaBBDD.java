/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juangu
 */
public class FactoriaBBDD {
    public static Connection Conecta() throws SQLException{
        Connection conn=null;
        String jdbcURL = "jdbc:oracle:thin:@orasrv:1521:XE";
        conn = DriverManager.getConnection(jdbcURL, "damuser23", "damuser");
        return conn;
    }
}
