package com.jujubaprojects.empresatech.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jujubaprojects.empresatech.Repository.DesenvolvedorRepository;
import com.jujubaprojects.empresatech.model.Desenvolvedor;


@Service
@Transactional
public class DesenvolvedorService {
   
    private DesenvolvedorRepository desenvolvedorRepository;
   /*  private CargoDevRepository cargoDevRepository;
    private TipoContratoRepository tipoContratoRepository;*/

    public DesenvolvedorService(DesenvolvedorRepository desenvolvedorRepository){
      this.desenvolvedorRepository = desenvolvedorRepository;
   /* this.cargoDevRepository = cargoDevRepository;
      this.tipoContratoRepository = tipoContratoRepository;*/
    }

    public void menu(){
        Scanner in = new Scanner(System.in);

        boolean isTrue = true;

        do{
            System.out.println("MENU"
            +"\n =======================\n" 
            +"DESENVOLVEDORES"
            +"\n======================= "
            +"\n 0 - Voltar"
            +"\n 1 - cadastrar Dev (funções)"
            +"\n 2 - visualizar Devs cadastrados"
            +"\n 3 - visualizar id Dev "
            +"\n 4 - atualizar dados "
            +"\n 5 - deletar Dev");
            int op = Integer.parseInt(in.nextLine());
      switch(op){

        case 1: cadastroDev(in);break;
        case 2: visualizarDevs(in);break;
        case 3: visualizarDevId(in);break;

        default: 
            isTrue = false ; break;

      }

        }while(isTrue);
    }

    private void visualizarDevId(Scanner in) {

      System.out.println("Digite o id do dev");
      int DevId = Integer.parseInt(in.nextLine());

     Optional<Desenvolvedor> devOptional = this.desenvolvedorRepository.findById(DevId);

     if(devOptional.isPresent()){
      Desenvolvedor desenvolvedor = devOptional.get();

      System.out.println(desenvolvedor);
     }

    }

    private void visualizarDevs(Scanner in) {

      List<Desenvolvedor> desenvolvedores = this.desenvolvedorRepository.findAll();

      for (Desenvolvedor desenvolvedor : desenvolvedores) {
        System.out.println(desenvolvedores);
      }
    }

    @Transactional
    private void cadastroDev(Scanner in) {
        
     
        System.out.println("===================="
        +"\n Desenvolvedor \n "
        +"====================");

        System.out.println("Digite o nome ");
        String nome = in.nextLine();
        System.out.println("Digite a idade  ");
        int idade = Integer.parseInt(in.nextLine());
        System.out.println("Digite o email ");
        String email = in.nextLine();
        System.out.println("Digite o cpf");
        String cpf = in.nextLine();

        Desenvolvedor desenvolvedor = new Desenvolvedor(nome,idade,email,cpf);
     /*   desenvolvedor.setNome(nome);
        desenvolvedor.setIdade(idade);
        desenvolvedor.setEmail(email);
        desenvolvedor.setCpf(cpf);*/

        System.out.println("Dev Salvo com sucesso ");
        System.out.println("Before saving to the database");
        this.desenvolvedorRepository.save(desenvolvedor);
        System.out.println("After saving to the database");
        
 }

}
