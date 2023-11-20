package com.jujubaprojects.empresatech.enums;

public enum NivelVaga {
    DEV_ESTAGIO("Estágio", 1000.0, 2000.0),
    DEV_JUNIOR("Júnior", 2500.0, 5000.0),
    DEV_PLENO("Pleno", 6000.0, 9000.0),
    DEV_SENIOR("Sênior", 10000.0, 15000.0),
    DEV_DIRETOR("Diretor", 15000.0, 20000.0);

    private String cargo;
    private final double salarioMinimo;
    private final double salarioMaximo;

    NivelVaga(String cargo, double salarioMinimo, double salarioMaximo) {
        this.cargo = cargo;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
    }

public String getCargo() {
     return cargo;
}

public void setCargo(String cargo) {
     this.cargo = cargo;
}

public double getSalarioMinimo() {
     return salarioMinimo;
}


public double getSalarioMaximo() {
     return salarioMaximo;
}


}

