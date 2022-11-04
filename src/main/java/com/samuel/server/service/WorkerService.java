/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.service;

import com.samuel.server.database.Database;
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
public class WorkerService {
    
        
    LinkService linkService = new LinkService();
    Database data = new Database();
    Connection con = data.Conexao();
    
    public List<Worker> getWorkers(UriInfo uriInfo){
        
        List<Worker> workers = new ArrayList();        
        ResultSet resultWorker;
        try {
            resultWorker = con.createStatement().executeQuery("SELECT * FROM WORKER");
            while(resultWorker.next()){
            Worker worker = new Worker(
                resultWorker.getInt("Id"),
                resultWorker.getString("Nome"),
                resultWorker.getString("Email"),
                resultWorker.getFloat("Salario"),
                resultWorker.getInt("Departament_id")
                );

            worker.addLink(linkService.getUrlforWorkers(uriInfo, worker), "Detalhes");
            workers.add(worker);
        }
        
        return workers;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    
    }
    
    public Worker getWorker(long id, UriInfo uriInfo){
        
        ResultSet resultWorker;
        try {
            resultWorker = con.createStatement().executeQuery("SELECT * FROM WORKER WHERE Id = "+id);
            resultWorker.next();
            Worker worker = new Worker(
                    resultWorker.getInt("Id"),
                    resultWorker.getString("Nome"),
                    resultWorker.getString("Email"),
                    resultWorker.getFloat("Salario"),
                    resultWorker.getInt("Departament_id")
                    );
            worker.addLink(linkService.getUrlforWorker(uriInfo, "/editWorker/", worker), "Editar");
            worker.addLink(linkService.getUrlforWorker(uriInfo, "/delWorker/", worker), "Deletar");
            return worker;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return null;
    }
    
    public Worker insertWorker(Worker worker){
        
        String insert = "INSERT INTO WORKER VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setLong(1, worker.getId());
            statement.setString(2, worker.getNome());
            statement.setString(3, worker.getEmail());
            statement.setDouble(4, worker.getSalario());
            statement.setLong(5, worker.getDepartament_id());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return worker;
    }
    
    public Worker editWorker(long id, Worker worker){
        String insert = "UPDATE WORKER SET Nome = ?, Email = ?, Salario = ?, Departament_id = ? WHERE Id = ?";
        
        try {

            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1, worker.getNome());
            statement.setString(2, worker.getEmail());
            statement.setDouble(3, worker.getSalario());
            statement.setLong(4, worker.getDepartament_id());
            statement.setLong(5, id);

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return worker;
    }
    
    public String deleteWorker(long id){
        String delete = "DELETE FROM WORKER WHERE Id = ?";

        try {
            ResultSet resultWorker = con.createStatement().executeQuery("SELECT * FROM WORKER WHERE Id = "+id);
            resultWorker.next();
            if(resultWorker.getInt("id") != id)
            {
                return "Não existe esse id no banco de dados";
            }
            else
            {
                PreparedStatement statement = con.prepareStatement(delete);
                statement.setLong(1, id);
                statement.execute();
                return "Trabalhador deletado!";
            }

        } catch (SQLException ex) {
            Logger.getLogger(WorkerService.class.getName()).log(Level.SEVERE, null, ex);
            return "Trabalhador não deletado!";
        } 
    }
    
}
