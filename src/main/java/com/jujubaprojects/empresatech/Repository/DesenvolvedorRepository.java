package com.jujubaprojects.empresatech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.empresatech.model.Desenvolvedor;

public interface DesenvolvedorRepository  extends JpaRepository <Desenvolvedor,Integer>{
    
}
