package com.jujubaprojects.empresatech.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.jujubaprojects.empresatech.Repository.CargoDevRepository;
import com.jujubaprojects.empresatech.Repository.DesenvolvedorRepository;
import com.jujubaprojects.empresatech.Repository.EmpresaTechRepository;
import com.jujubaprojects.empresatech.Repository.TipoContratoRepository;
import com.jujubaprojects.empresatech.model.CargoDev;
import com.jujubaprojects.empresatech.model.Desenvolvedor;
import com.jujubaprojects.empresatech.model.EmpresaTech;
import com.jujubaprojects.empresatech.model.TipoContrato;

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
            +"\n 1 - Cadastrar Empresa"
            +"\n 2 - visualizar Devs"
            +"\n 3 - Embregar Dev");
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

        List<Desenvolvedor> devNovos = new ArrayList<>();
        List<CargoDev> cargoDevs = new ArrayList<>();
        List<TipoContrato> tipoContratos = new ArrayList<>();


        System.out.println("========================="
        +"\n CONTRATAÇÂO dos DEVS"
        +"\n =========================");

         System.out.println("id da Empresa-Tech ");
        int empesaId =  Integer.parseInt(in.nextLine());

        System.out.println("id do Dev ");
        int devId =  Integer.parseInt(in.nextLine());
        
        System.out.println("Id do Cargo");
        int cargoDevId = Integer.parseInt(in.nextLine());

         System.out.println("Id do tipo Contrato");
        int tipoContratoIId = Integer.parseInt(in.nextLine());

        
        Optional<Desenvolvedor> devOptional = this.desenvolvedorRepository.findById(devId);

        if (devOptional.isPresent()) {
            Desenvolvedor desenvolvedor = devOptional.get();
        //    devNovos.add(devOptional.get());
        
            Optional<CargoDev> cargoDevOptional = this.cargoDevRepository.findById(cargoDevId);
        
            if (cargoDevOptional.isPresent()) {
                CargoDev cargoDev = cargoDevOptional.get(); 
              //  cargoDevs.add(cargoDevOptional.get());
        
                Optional<TipoContrato> tipoContratoOptional = this.tipoContratoRepository.findById(tipoContratoIId);
        
                if (tipoContratoOptional.isPresent()) {
                    TipoContrato tipoContrato = tipoContratoOptional.get();
              //      tipoContratos.add(tipoContratoOptional.get());

                    Optional<EmpresaTech> empresaTechOptional = this.empresaTechRepository.findById(empesaId);

                  if(empresaTechOptional.isPresent()){
                   EmpresaTech empresaTech = empresaTechOptional.get();

                       empresaTech.setDesenvolvedor(desenvolvedor);
                       empresaTech.setCargoDev(cargoDev);
                       empresaTech.setTipoContrato(tipoContrato);
                       this.empresaTechRepository.save(empresaTech);
                }else{
                      System.out.println("Empresa Tech  inexistente !");
                  }
                } else {
                    System.out.println("Tipo de Contrato inexistente !");
                }
            } else {
                System.out.println("Cargo inexistente !");
            }
        } else {
            System.out.println("Desenvolvedor inexistente !");
        }

   /*  Optional<Desenvolvedor> devOptional = this.desenvolvedorRepository.findById(devId);

if (!devOptional.isPresent()) {
    System.out.println("Desenvolvedor inexistente !");
    return; // ou lançar uma exceção, dependendo do seu fluxo de controle
}

Desenvolvedor desenvolvedor = devOptional.get();

Optional<CargoDev> cargoDevOptional = this.cargoDevRepository.findById(cargoDevId);

if (!cargoDevOptional.isPresent()) {
    System.out.println("Cargo inexistente !");
    return;
}

CargoDev cargoDev = cargoDevOptional.get();

Optional<TipoContrato> tipoContratoOptional = this.tipoContratoRepository.findById(tipoContratoIId);

if (!tipoContratoOptional.isPresent()) {
    System.out.println("Tipo de Contrato inexistente !");
    return;
}

TipoContrato tipoContrato = tipoContratoOptional.get();

Optional<EmpresaTech> empresaTechOptional = this.empresaTechRepository.findById(empesaId);

if (!empresaTechOptional.isPresent()) {
    System.out.println("Empresa Tech inexistente !");
    return;
}

EmpresaTech empresaTech = empresaTechOptional.get();
empresaTech.setDesenvolvedor(desenvolvedor);
empresaTech.setCargoDev(cargoDev);
empresaTech.setTipoContrato(tipoContrato);
this.empresaTechRepository.save(empresaTech);*/


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
