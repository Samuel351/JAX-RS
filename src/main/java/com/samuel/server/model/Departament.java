/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuel.server.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sscos
 */
public class Departament {
    
    public long id;
    public String nome;
    public ArrayList<Worker> workers = new ArrayList();
    private List<Link> links = new ArrayList();

    public Departament() {
    }

    public Departament(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
    public void addLink(String uri, String rel){
      Link link = new Link();
      link.setLink(uri);
      link.setRel(rel);
      links.add(link);
    }
    
}
