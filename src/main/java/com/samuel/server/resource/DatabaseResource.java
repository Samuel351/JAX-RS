/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.resource;

import com.samuel.server.database.Database;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author sscos
 */
@Path("data")
public class DatabaseResource {
    
    Database data = new Database();
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean getStatus(){
        return data.ConexaoStatus();
    }
    
}
