/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sscos
 */
public class Database {
    
    public Connection Conexao(){
        
        Connection con;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "samuel", "");
            return con;
        } catch(SQLException ex){
            return null;
        }   
    }    
    
     public Boolean ConexaoStatus(){
         
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Boolean status;
        Connection con;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            con.close();
            status = true;
        } catch(SQLException ex){
            status = false;
        }   
        
        return status;
    }   
}
