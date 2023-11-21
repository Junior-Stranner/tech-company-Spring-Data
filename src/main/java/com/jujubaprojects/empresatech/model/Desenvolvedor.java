package com.jujubaprojects.empresatech.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


 /*    @ManyToMany
        @JoinTable(name = "desenvolvedor_cargoDev",
        joinColumns = @JoinColumn(name = "desenvolvedor_id"),
        inverseJoinColumns = @JoinColumn(name = "cargoDev_id"))
    private List<CargoDev>cargoDevs;

    @ManyToMany(mappedBy = "desenvolvedores")
 //   private Set<TipoContrato> tipoContratos = new HashSet<>();
    private List<TipoContrato> tipoContratos;*/

    public Desenvolvedor(){

   }


    public Desenvolvedor(String nome, int idade, String email, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
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

    @Override
    public String toString() {
        return "Desenvolvedor [id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email + ", cpf=" + cpf + "]";
    }

}
