package com.jujubaprojects.empresatech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.empresatech.model.Desenvolvedor;

@Repository
public interface DesenvolvedorRepository  extends JpaRepository <Desenvolvedor,Integer>{
    
}
