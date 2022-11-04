/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.service;

import com.samuel.server.database.Database;
import com.samuel.server.model.Departament;
import com.samuel.server.model.Worker;
import jakarta.ws.rs.core.UriInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sscos
 */
public class DepartamentService {
    LinkService linkService = new LinkService();
    Database database = new Database();
    Connection con = database.Conexao();
    
    public List<Departament> getDepartaments(UriInfo uriInfo){
        
        List<Departament> departaments = new ArrayList();        
        ResultSet resultDepartament, resultWorker;
        try {
            resultDepartament = con.createStatement().executeQuery("SELECT * FROM DEPARTAMENT");
           
            while(resultDepartament.next()){
            Departament departament = new Departament(
                    resultDepartament.getInt("Deparment_id"),
                    resultDepartament.getString("Nome")
                    );
            departament.addLink(linkService.getUrlforDepartaments(uriInfo, departament), "Detalhes");
            resultWorker = con.createStatement().executeQuery("SELECT * FROM WORKER WHERE Departament_id ="+departament.getId());
            
            while(resultWorker.next()){
                Worker worker = new Worker(
                    resultWorker.getInt("Id"),
                    resultWorker.getString("Nome"),
                    resultWorker.getString("Email"),
                    resultWorker.getFloat("Salario"),
                    resultWorker.getInt("Departament_id")
                );
                worker.addLink(linkService.getUrlforWorkers(uriInfo, worker), "Detalhes");
                departament.addWorker(worker);
            }
            
            
            departaments.add(departament);
        }
        
        return departaments;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    
    }
    
    public Departament getDepartament(long id, UriInfo uriInfo){
        
        ResultSet resultDepartament, resultWorker;
        try {
            
            resultDepartament = con.createStatement().executeQuery("SELECT * FROM DEPARTAMENT WHERE Departament_id="+id);
            resultDepartament.next();
            Departament departament = new Departament(
                    resultDepartament.getInt("Departament_id"),
                    resultDepartament.getString("Nome")
                    );
            
            departament.addLink(linkService.getUrlforDepartament(uriInfo, "/editDepartament" ,departament), "Editar");
            departament.addLink(linkService.getUrlforDepartament(uriInfo, "/delDepartament" ,departament), "Deletar");
            
            resultWorker = con.createStatement().executeQuery("SELECT * FROM WORKER WHERE Departament_id ="+departament.getId());
            
             while(resultWorker.next()){
                Worker worker = new Worker(
                    resultWorker.getInt("Id"),
                    resultWorker.getString("Nome"),
                    resultWorker.getString("Email"),
                    resultWorker.getFloat("Salario"),
                    resultWorker.getInt("Departament_id")
                );
                
                worker.addLink(linkService.getUrlforWorkers(uriInfo, worker), "Detalhes");
                departament.addWorker(worker);
            }
        
         return departament;
         
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public Departament insertDepartament(Departament departament){
        
        String insert = "INSERT INTO DEPARTAMENT VALUES(?, ?)";
        
        try {
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setLong(1, departament.getId());
            statement.setString(2, departament.getNome());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return departament;
    }
    
    public Departament editDepartament(long id, Departament departament){
        String insert = "UPDATE DEPARTAMENT SET Nome = ? WHERE Departament_id = ?";
        
        try {
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1, departament.getNome());
            statement.setLong(2, id);
            
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return departament;
    }
    
    public String deleteDepartament(long id){
        String delete = "DELETE FROM DEPARTAMENT WHERE Departament_id = ?";

        try {
            ResultSet resultDepartament = con.createStatement().executeQuery("SELECT * FROM DEPARTAMENT WHERE Departament_id = "+id);
            resultDepartament.next();
            if(resultDepartament.getInt("Departament_id") != id)
            {
                return "Não existe esse id no banco de dados";
            }
            else
            {
                PreparedStatement statement = con.prepareStatement(delete);
                statement.setLong(1, id);
                statement.execute();
                return "Departamento deletado!";
            }

        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
            return "Departamento não deletado!";
        } 
    }
}
