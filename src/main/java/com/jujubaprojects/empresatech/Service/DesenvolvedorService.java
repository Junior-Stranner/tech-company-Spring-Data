package com.jujubaprojects.empresatech.Service;

import java.util.List;
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

      try {

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

        default: 
            isTrue = false ; break;

      }

        }while(isTrue);
        
      } catch (RuntimeException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }

    private void visualizarDevs(Scanner in) {

      List<Desenvolvedor> desenvolvedores = this.desenvolvedorRepository.findAll();

      for (Desenvolvedor desenvolvedor : desenvolvedores) {
        System.out.println(desenvolvedores);
      }
    }

    private void cadastroDev(Scanner in) {
        
      try{
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
        System.out.println("Dev Salvo com sucesso ");
        System.out.println("Before saving to the database");
        this.desenvolvedorRepository.save(desenvolvedor);
        this.desenvolvedorRepository.flush();
        System.out.println("After saving to the database");
        
    

  } catch(NumberFormatException e){
    System.out.println("Erro: Entrada inválida. Certifique-se de que o número da mesa e o ID do cardápio sejam números válidos.");
   }
 }

}
