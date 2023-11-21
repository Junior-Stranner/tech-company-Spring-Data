package com.jujubaprojects.empresatech.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class EmpresaTech {

    @EmbeddedId
    private EmpresaTechPK id = new EmpresaTechPK();

    private String nomeEmpresa;

    
    public EmpresaTech(){

    }

    public EmpresaTech( Desenvolvedor desenvolvedor,CargoDev cargoDev , TipoContrato tipoContrato, String nomeEmpresa) {
        this.id.setDesenvolvedor(desenvolvedor);
        this.id.setCargoDev(cargoDev);
        this.id.setTipoContrato(tipoContrato);
        this.nomeEmpresa = nomeEmpresa;

    }


  public Desenvolvedor getDesenvolvedor(){
    return id.getDesenvolvedor();
  }

public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
    id.setDesenvolvedor(desenvolvedor);
}

public CargoDev getCargoDev() {
    return id.getCargoDev();
}

public void setCargoDev(CargoDev cargoDev) {
    id.setCargoDev(cargoDev);
}

public TipoContrato getTipoContrato() {
    return id.getTipoContrato();
}

public void setTipoContrato(TipoContrato tipoContrato) {
    id.setTipoContrato(tipoContrato);
}




public String getNomeEmpresa() {
    return nomeEmpresa;
}

public void setNomeEmpresa(String nomeEmpresa) {
    this.nomeEmpresa = nomeEmpresa;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    EmpresaTech other = (EmpresaTech) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}

public EmpresaTechPK getId() {
    return id;
}

public void setId(EmpresaTechPK id) {
    this.id = id;
}

  
  
}
