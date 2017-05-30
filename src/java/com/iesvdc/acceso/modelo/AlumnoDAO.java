/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juangu
 */
public class AlumnoDAO {
    // CRUD, findAll, finById, count
    Connection conn;
    
    public boolean create(AlumnoPOJO al){
        boolean exito=true;
        try {            
            conn = FactoriaBBDD.Conecta();
            String sql = 
                "INSERT INTO ALUMNO VALUES (ALUMNO_SEQ.NEXTVAL,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(0, al.getNombre());
            pstmt.setString(1, al.getApellido());
            pstmt.executeUpdate();  
            conn.close();
        } catch (SQLException ex) {
            exito = false;
        } 
        return exito;
    }
    
    public AlumnoPOJO findById(Integer id){
        AlumnoPOJO al=null;
        try {            
            conn = FactoriaBBDD.Conecta();
            String sql = 
                "SELECT * FROM ALUMNO WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(0, id);
            ResultSet rs  = pstmt.executeQuery();
            rs.first();
            al = new AlumnoPOJO(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"));
                    
            conn.close();
        } catch (SQLException ex) {
            al = null;
        } 
        return al;
    } 
    
    public List<AlumnoPOJO> findAll() {
        
    }
    
    public List<AlumnoPOJO> findByNombre(String nombre){
        
    }
    
    public List<AlumnoPOJO> findByApellido(String apellido){
        
    }
    
    public boolean update(AlumnoPOJO old_al, AlumnoPOJO new_al) {
        
    }
    
    public boolean update(Integer old_id, AlumnoPOJO new_al) {
        
    }
    
    public boolean delete(AlumnoPOJO al){
        
    }
    
    public boolean delete(Integer id_al){
        
    }
    
}
