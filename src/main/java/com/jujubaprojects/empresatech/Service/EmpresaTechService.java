package com.jujubaprojects.empresatech.Service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.jujubaprojects.empresatech.Repository.CargoDevRepository;
import com.jujubaprojects.empresatech.Repository.DesenvolvedorRepository;
import com.jujubaprojects.empresatech.Repository.EmpresaTechRepository;
import com.jujubaprojects.empresatech.Repository.TipoContratoRepository;
import com.jujubaprojects.empresatech.model.Desenvolvedor;
import com.jujubaprojects.empresatech.model.EmpresaTech;

@Service
public class EmpresaTechService {
    
    private EmpresaTechRepository empresaTechRepository;
    private DesenvolvedorRepository desenvolvedorRepository;
    private CargoDevRepository cargoDevRepository;
    private TipoContratoRepository tipoContratoRepository;


    public EmpresaTechService(EmpresaTechRepository empresaTechRepository,
            DesenvolvedorRepository desenvolvedorRepository, CargoDevRepository cargoDevRepository,
            TipoContratoRepository tipoContratoRepository) {
        this.empresaTechRepository = empresaTechRepository;
        this.desenvolvedorRepository = desenvolvedorRepository;
        this.cargoDevRepository = cargoDevRepository;
        this.tipoContratoRepository = tipoContratoRepository;
    }
     
     public void menu(){
        Scanner in = new Scanner(System.in);

        boolean isTrue = true;

        do{

            System.out.println("MENU"
            +"\n =======================\n" 
            +"Empresa Tech"
            +"\n======================= "
            +"\n 0 - Voltar"
            +"\n 1 - Embreagar Dev"
            +"\n 2 - visualizar Devs");
            int op = Integer.parseInt(in.nextLine());
      switch(op){
        
        case 1: cadastro(in);break;
        case 2: visualizar(in);break;
        case 5: contratandoDev(in);break;

        default: isTrue = false ; break;

      }

        }while(isTrue);
        
    }

    private void contratandoDev(Scanner in) {

        System.out.println("========================="
        +"\n CONTRATAÇÂO dos DEVS"
        +"\n =========================");

        System.out.println("id do Dev ");
        int devId =  Integer.parseInt(in.nextLine());
        
        System.out.println("Id do Cargo");
        int cargoDevId = Integer.parseInt(in.nextLine());

    }

    private void visualizar(Scanner in) {

     List<EmpresaTech> emprsEmpresaTechs = this.empresaTechRepository.findAll();

      for (EmpresaTech empresaTech : emprsEmpresaTechs) {
        System.out.println(emprsEmpresaTechs);
      }
    }

    private void cadastro(Scanner in) {

       System.out.println("Digite o nome da EMpresa ");
       String nomeEmpresa = in.nextLine();
       EmpresaTech empresaTech = new EmpresaTech();
       empresaTech.setNomeEmpresa(nomeEmpresa);
       System.out.println("Empresa : "+nomeEmpresa+" Salvo no Banco !");
       this.empresaTechRepository.save(empresaTech);

    }
    
}
