package com.jujubaprojects.empresatech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.empresatech.model.CargoDev;

public interface CargoDevRepository extends JpaRepository <CargoDev , Integer>{
    
}
