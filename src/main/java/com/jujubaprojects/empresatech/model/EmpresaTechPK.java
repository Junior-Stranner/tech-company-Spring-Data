package com.jujubaprojects.empresatech.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EmpresaTechPK {
    
    @ManyToOne
    @JoinColumn(name = "desenvolvedor_id")
    private Desenvolvedor desenvolvedor;

    @ManyToOne
    @JoinColumn(name = "cargoDev_id")
    private CargoDev cargoDev;

    @ManyToOne
    @JoinColumn(name = "tipoContrato_id")
    private TipoContrato tipoContrato;


    
    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public CargoDev getCargoDev() {
        return cargoDev;
    }

    public void setCargoDev(CargoDev cargoDev) {
        this.cargoDev = cargoDev;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((desenvolvedor == null) ? 0 : desenvolvedor.hashCode());
        result = prime * result + ((cargoDev == null) ? 0 : cargoDev.hashCode());
        result = prime * result + ((tipoContrato == null) ? 0 : tipoContrato.hashCode());
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
        EmpresaTechPK other = (EmpresaTechPK) obj;
        if (desenvolvedor == null) {
            if (other.desenvolvedor != null)
                return false;
        } else if (!desenvolvedor.equals(other.desenvolvedor))
            return false;
        if (cargoDev == null) {
            if (other.cargoDev != null)
                return false;
        } else if (!cargoDev.equals(other.cargoDev))
            return false;
        if (tipoContrato == null) {
            if (other.tipoContrato != null)
                return false;
        } else if (!tipoContrato.equals(other.tipoContrato))
            return false;
        return true;
    }



    
}
