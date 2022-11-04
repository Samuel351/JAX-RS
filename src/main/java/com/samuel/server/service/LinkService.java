/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.service;

import com.samuel.server.model.Departament;
import com.samuel.server.model.Worker;
import com.samuel.server.resource.DepartamentResource;
import com.samuel.server.resource.WorkerResource;
import jakarta.ws.rs.core.UriInfo;

/**
 *
 * @author sscos
 */
public class LinkService {
    
    public String getUrlforWorkers(UriInfo uriInfo, Worker worker){
        
            String uri = uriInfo.getBaseUriBuilder()
           .path(WorkerResource.class)
           .path(Long.toString(worker.getId()))
           .build()
           .toString();

           return uri;
        }    
        
        public String getUrlforWorker(UriInfo uriInfo, String pathUri ,Worker worker){
            
            String uri = uriInfo.getBaseUriBuilder()
           .path(WorkerResource.class)
           .path(pathUri)
           .path(Long.toString(worker.getId()))
           .build()
           .toString();
            
            return uri;
        }
        
        public String getUrlforDepartaments(UriInfo uriInfo, Departament departament){
            String uri = uriInfo.getBaseUriBuilder()
           .path(DepartamentResource.class)
           .path(Long.toString(departament.getId()))
           .build()
           .toString();

           return uri;
        }
        
        public String getUrlforDepartament(UriInfo uriInfo, String pathUri, Departament departament){
            String uri = uriInfo.getBaseUriBuilder()
           .path(DepartamentResource.class)
           .path(pathUri)
           .path(Long.toString(departament.getId()))
           .build()
           .toString();
            
            return uri;
        }
    
}
