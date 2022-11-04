/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.resource;

import com.samuel.server.model.Worker;
import com.samuel.server.service.LinkService;
import com.samuel.server.service.WorkerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import java.util.List;

@Path("worker")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkerResource {
    
    WorkerService service = new WorkerService();
    
    @GET
    @Path("/getWorkers")
    public List<Worker> getWorkers(@Context UriInfo uriInfo){
        return service.getWorkers(uriInfo);
    }
    
    @GET
    @Path("/{workerID}")
    public Worker getWorker(@PathParam("workerID") int id, @Context UriInfo uriInfo){
        return service.getWorker(id, uriInfo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Worker addWorker(Worker worker){
        return service.insertWorker(worker);
    }

    @PUT
    @Path("/{workerID}")
    public Worker editWorker(@PathParam("workerID") long id, Worker worker){
        return service.editWorker(id, worker);
    }
    
    @DELETE
    @Path("/{workerID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String delWorker(@PathParam("workerID") int id){
        return service.deleteWorker(id);
    }
}
