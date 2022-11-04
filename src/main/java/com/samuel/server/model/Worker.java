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
public class Worker {
    
    public long id;
    public String nome;
    public String email;
    public double salario;
    public Departament departament;
    public long departament_id;
    private List<Link> links = new ArrayList();

    public Worker() {
    }
    
    public Worker(long id, String nome, String email, double salario, long departament_id) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.departament_id = departament_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public long getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(long departament_id) {
        this.departament_id = departament_id;
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
