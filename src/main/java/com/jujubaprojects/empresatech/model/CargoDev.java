package com.jujubaprojects.empresatech.model;

import java.util.List;

import com.jujubaprojects.empresatech.enums.NivelVaga;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargoDevs")
public class CargoDev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tecnologia;
    private double salarioPorHora;
    private double hrsTrabalhadas;

    private NivelVaga nivelVaga;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Desenvolvedor> desenvolvedores;


    public CargoDev(){

    }


    public CargoDev(int id,String tecnologia , double salarioPorHora, double hrsTrabalhadas , NivelVaga nivelVaga,
            List<Desenvolvedor> desenvolvedores) {
        this.id = id;
        this.tecnologia = tecnologia;
        this.salarioPorHora = salarioPorHora;
        this.hrsTrabalhadas = hrsTrabalhadas;
        this.nivelVaga = nivelVaga;
        this.desenvolvedores = desenvolvedores;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public double getSalarioPorHora() {
        return salarioPorHora;
    }


    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }


    public double getHrsTrabalhadas() {
        return hrsTrabalhadas;
    }


    public void setHrsTrabalhadas(double hrsTrabalhadas) {
        this.hrsTrabalhadas = hrsTrabalhadas;
    }


    public NivelVaga getNivelVaga() {
        return nivelVaga;
    }


    public void setNivelVaga(NivelVaga nivelVaga) {
        this.nivelVaga = nivelVaga;
    }


    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }


    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    
    public double calculaSalario() {

        return this.salarioPorHora * this.hrsTrabalhadas;
    }

    public boolean verificaSalario() {

        if(calculaSalario() > nivelVaga.getSalarioMaximo() && calculaSalario() < nivelVaga.getSalarioMinimo()){
            return true;
        }
        return false;
    }


    public String getTecnologia() {
        return tecnologia;
    }


    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }


    @Override
    public String toString() {
        return "CargoDev [id=" + id + ", tecnologia=" + tecnologia + ", salarioPorHora=" + salarioPorHora
                + ", hrsTrabalhadas=" + hrsTrabalhadas + ", nivelVaga=" + nivelVaga
                + ", desenvolvedores=" + desenvolvedores + "]";
    }





    
}
