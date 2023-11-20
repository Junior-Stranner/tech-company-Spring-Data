package com.jujubaprojects.empresatech.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.empresatech.model.CargoDev;

public interface CargoDevRepository extends JpaRepository <CargoDev , Integer>{

    
}
