/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.resource;

import com.samuel.server.model.Departament;
import com.samuel.server.service.DepartamentService;
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

/**
 *
 * @author sscos
 */
@Path("departament")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartamentResource {
DepartamentService service = new DepartamentService();
    
    @GET
    @Path("/getDepartaments")
    public List<Departament> getDepartaments(@Context UriInfo uriInfo) {
        return service.getDepartaments(uriInfo);
    }
    
    @GET
    @Path("/{departamentID}")
    public Departament getDepartament(@PathParam("departamentID") int id, @Context UriInfo uriInfo){
        return service.getDepartament(id, uriInfo);
    }
    
    @POST
    public Departament addDepartament(Departament departament){
        return service.insertDepartament(departament);
    }
    
    @PUT
    @Path("/{departamentID}")
    public Departament editDepartament(@PathParam("departamentID") long id, Departament departament){
        return service.editDepartament(id, departament);
    }
    
    @DELETE
    @Path("/{departamentID}")
    public String delDepartament(@PathParam("departamentID") long id){
        return service.deleteDepartament(id);
    }  
}
