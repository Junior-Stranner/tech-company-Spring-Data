package com.jujubaprojects.empresatech.Service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.jujubaprojects.empresatech.Repository.CargoDevRepository;
import com.jujubaprojects.empresatech.enums.NivelVaga;
import com.jujubaprojects.empresatech.model.CargoDev;

@Service
public class CargoDevService {

    private CargoDevRepository cargoDevRepository;

    public CargoDevService( CargoDevRepository cargoDevRepository){
     this.cargoDevRepository = cargoDevRepository;
    }
    
     public void menu(){
        Scanner in = new Scanner(System.in);

        boolean isTrue = true;

        do{

            System.out.println("MENU"
            +"\n =======================\n" 
            +"Cargo dos Devs"
            +"\n======================= "
            +"\n 0 - Voltar"
            +"\n 1 - Cadastrar os Contratos"
            +"\n 2 - visualizar Contratos");
            int op = Integer.parseInt(in.nextLine());
      switch(op){
        
        case 1: cadastrarCargoDev(in);break;
        case 2: visualizarCargos(in);break;

        default: isTrue = false ; break;

      }

        }while(isTrue);
        
    }

    private void calculaSalario(Scanner in) {
        
    }

    private void teste(Scanner in) {
     /*  NivelVaga nivelVaga = new NivelVaga();

      System.out.println("Salário Mínimo: " + .getSalarioMinimo());
      System.out.println("Salário Máximo: " + nivel.getSalarioMaximo());*/
    }

    private void visualizarCargos(Scanner in) {

      List<CargoDev> cargoDevs = this.cargoDevRepository.findAll();

      for (CargoDev cargoDev : cargoDevs) {
         System.out.println(cargoDevs);
      }

    }

    private void cadastrarCargoDev(Scanner in) {
      CargoDev cargoDev = new CargoDev();
  
      System.out.println("Tecnologias disponíveis "
              + "\n 1 - Java "
              + "\n 2 - Banco de Dados - postgresql"
              + "\n 3 - C"
              + "\n 4 - C++"
              + "\n 5 - C#"
              + "\n 6 - Python"
              + "\n 7 - JavaScript"
              + "\n 8 - Ruby"
              + "\n 9 - Lua");
      int opTecnologia = Integer.parseInt(in.nextLine());
  
      String tecnologia = null;
      switch (opTecnologia) {
          case 1: tecnologia = "Java"; break;
          case 2: tecnologia = "Banco de Dados - postgresql"; break;
          case 3: tecnologia = "C"; break;
          case 4: tecnologia = "C++"; break;
          case 5: tecnologia = "C#"; break;
          case 6: tecnologia = "Python"; break;
          case 7: tecnologia = "JavaScript"; break;
          case 8: tecnologia = "Ruby"; break;
          case 9: tecnologia = "Lua"; break;
      }
  
      System.out.println("Salario Por Hora");
      double salarioPorHora = Double.parseDouble(in.nextLine());
      System.out.println("horas Trabalhadas");
      double hrsTrabalhadas = Double.parseDouble(in.nextLine());
  
      // Obtendo o nível da vaga
      System.out.println("Níveis de vaga disponíveis: ");
      for (int i = 0; i < NivelVaga.values().length; i++) {
          System.out.println(i + 1 + " - " + NivelVaga.values()[i]);
      }
  
      int opNivel = Integer.parseInt(in.nextLine());
      NivelVaga nivelVaga = NivelVaga.values()[opNivel - 1];
      System.out.println("Você escolheu : " + nivelVaga.getCargo());
  
      try {
          // Configuração dos valores antes de chamar calculaSalario()
          cargoDev.setTecnologia(tecnologia);
          cargoDev.setSalarioPorHora(salarioPorHora);
          cargoDev.setHrsTrabalhadas(hrsTrabalhadas);
          cargoDev.setNivelVaga(nivelVaga);
          double salarioCalculado = cargoDev.calculaSalario();
          cargoDev.setSalario(salarioCalculado);
  
          System.out.println("Debug - verificação se há valor ou é null\n {");
          System.out.println("Salario Por Hora " + salarioPorHora);
          System.out.println("horas Trabalhadas " + hrsTrabalhadas);
          System.out.println("Salário Total " + salarioCalculado);
          System.out.println("}");

          if (cargoDev.verificaSalario()) {
            System.out.println("Salário compatível com o cargo!");
            System.out.println("Cargo salvo com sucesso!");
            this.cargoDevRepository.save(cargoDev);
        } else {
            System.out.println("Salário de: " + salarioCalculado + " é muito inferior ou superior ao cargo de: " + nivelVaga.getCargo()
                    + "\nDeseja escolher outro? (Digite 's' para sim)");
            String resposta = in.nextLine();
        
            if (!resposta.toLowerCase().contains("s")) {
                System.out.println("Você continuará com o cargo: " + nivelVaga.getCargo()
                        + "\nPorém o seu salário de: " + salarioCalculado + " será abaixo ou acima ");
                // Adicione lógica adicional aqui, se necessário.
                this.cargoDevRepository.save(cargoDev);

            } else {
                System.out.println("Cargo não salvo.");
                return;
            }
        }
        
      } catch (Exception e) {
          System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
          e.printStackTrace(); // Imprima o rastreamento da pilha para debug
      }
  }
  
}
