package com.jujubaprojects.empresatech.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "contratos")
public class TipoContrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contrato;


    public TipoContrato() {
    
    }


    public TipoContrato(int id, String contrato) {
        this.id = id;
        this.contrato = contrato;
  
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContrato() {
        return contrato;
    }
    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    @Override
    public String toString() {
        return "TipoContrato [id=" + id + 
               ", contrato=" + contrato + "]";
    }

    public boolean autenticar(String login,String senha ){
        return login.equals("admin123") && senha.equals("admin5432");

    }

    
}
