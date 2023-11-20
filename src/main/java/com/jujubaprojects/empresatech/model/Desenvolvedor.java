package com.jujubaprojects.empresatech.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jujubaprojects.empresatech.enums.NivelVaga;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "desenvolvedores")
public class Desenvolvedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String cpf; 


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargoDev_id")
    private CargoDev cargoDev;

    @ManyToMany(mappedBy = "desenvolvedores")
 //   private Set<TipoContrato> tipoContratos = new HashSet<>();
    private List<TipoContrato> tipoContratos;




    public Desenvolvedor(){

   }

    public Desenvolvedor(int id, String nome, int idade, String email, String cpf, CargoDev cargoDev,
            List<TipoContrato> tipoContratos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        this.cargoDev = cargoDev;
        this.tipoContratos = tipoContratos;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CargoDev getCargoDev() {
        return cargoDev;
    }

    public void setCargoDev(CargoDev cargoDev) {
        this.cargoDev = cargoDev;
    }


    public List<TipoContrato> getTipoContratos() {
        return tipoContratos;
    }


    public void setTipoContratos(List<TipoContrato> tipoContratos) {
        this.tipoContratos = tipoContratos;
    }


    @Override
    public String toString() {
        return "Desenvolvedor [id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email + ", cpf=" + cpf
                + ", cargoDev=" + cargoDev + ", tipoContratos=" + tipoContratos + "]";
    }
}
