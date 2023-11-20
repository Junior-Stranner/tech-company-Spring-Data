package com.jujubaprojects.empresatech.Service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.jujubaprojects.empresatech.Repository.TipoContratoRepository;
import com.jujubaprojects.empresatech.model.TipoContrato;


@Service
public class TipoContratoService {
    
    private  TipoContratoRepository tipoContratoRepository;

    public TipoContratoService(TipoContratoRepository tipoContratoRepository2){
        this.tipoContratoRepository = tipoContratoRepository2;
    }

     public void menu(){
        Scanner in = new Scanner(System.in);

        boolean isTrue = true;

        do{

            System.out.println("MENU"
            +"\n =======================\n" 
            +"Tipo de Contratos"
            +"\n======================= "
            +"\n 0 - Voltar"
            +"\n 1 - Cadastrar os Contratos"
            +"\n 2 - visualizar Contratos");
            int op = Integer.parseInt(in.nextLine());
      switch(op){

        case 1: cadastroTipoContrato(in);break;
        case 2: visualizarTipoContratos(in);break;

        default: isTrue = false ; break;

      }

        }while(isTrue);
        
    }

    private void visualizarTipoContratos(Scanner in) {

       List<TipoContrato> tipoContratos = this.tipoContratoRepository.findAll();
        
        for (TipoContrato tipoContrato : tipoContratos) {
            System.out.println(tipoContratos);
        }
    }

      public void cadastroTipoContrato(Scanner in) {
        System.out.println("===================="
        +"\n CONTRATOS \n "
        +"====================");

        System.out.println("Escolha o Tipo de Contrato"
        +"\n 1 - PJ "
        +"\n 2 - CLT");
        int opContrato = Integer.parseInt(in.nextLine()); 

        String contrato = null;

      switch(opContrato){

        case 1: contrato = "PJ";break;
        case 2: contrato = "CLT";break;
      }

        TipoContrato tipoContrato = new TipoContrato();
        tipoContrato.setContrato(contrato);

        this.tipoContratoRepository.save(tipoContrato);
        System.out.println("Tipo de Contrato : "+ tipoContrato.getContrato() + " cadastrado");
    }
}
