package com.jujubaprojects.empresatech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.empresatech.model.EmpresaTech;

public interface EmpresaTechRepository extends JpaRepository<EmpresaTech , Integer>{
    
}
