package com.jujubaprojects.empresatech.Service;

import java.util.Scanner;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jujubaprojects.empresatech.Repository.DesenvolvedorRepository;
import com.jujubaprojects.empresatech.model.Desenvolvedor;


@Service
@Transactional
public class DesenvolvedorService {
    
    private DesenvolvedorRepository desenvolvedorRepository;

    public DesenvolvedorService(DesenvolvedorRepository desenvolvedorRepository){
      this.desenvolvedorRepository = desenvolvedorRepository;
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

        default: isTrue = false ; break;

      }

        }while(isTrue);
        
      } catch (RuntimeException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }

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

        System.out.println("====================");

        Desenvolvedor desenvolvedor = new Desenvolvedor();
        desenvolvedor.setNome(nome);
        desenvolvedor.setIdade(idade);
        desenvolvedor.setEmail(email);
        desenvolvedor.setCpf(cpf);

       this.desenvolvedorRepository.save(desenvolvedor);

    }

}
