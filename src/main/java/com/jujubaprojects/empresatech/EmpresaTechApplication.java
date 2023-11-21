package com.jujubaprojects.empresatech;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jujubaprojects.empresatech.Service.CargoDevService;
import com.jujubaprojects.empresatech.Service.DesenvolvedorService;
import com.jujubaprojects.empresatech.Service.EmpresaTechService;
import com.jujubaprojects.empresatech.Service.TipoContratoService;

@SpringBootApplication
public class EmpresaTechApplication implements CommandLineRunner{


	private DesenvolvedorService desenvolvedorService;
	private TipoContratoService tipoContratoService;
	private CargoDevService cargoDevService;
    private EmpresaTechService empresaTechService;

	public EmpresaTechApplication(DesenvolvedorService desenvolvedorService, TipoContratoService tipoContratoService,
            CargoDevService cargoDevService, EmpresaTechService empresaTechService) {
        this.desenvolvedorService = desenvolvedorService;
        this.tipoContratoService = tipoContratoService;
        this.cargoDevService = cargoDevService;
        this.empresaTechService = empresaTechService;
    }

    public static void main(String[] args) {
		SpringApplication.run(EmpresaTechApplication.class, args);
	}

	@Override
public void run(String... args) {
    Scanner in = new Scanner(System.in);

    boolean isTrue = true;

    try {
        do {
            System.out.println("MENU"
                    + "\n =======================\n"
                    + "MENU Principal"
                    + "\n======================= "
					+ "\n 0 - Voltar"
                    + "\n 1 - TipoContratos"
					+ "\n 2 - CargoDev"
                    + "\n 3 - Desenvolvedor"
                    + "\n 4 - Empresa-Tech");
            
            int op = Integer.parseInt(in.nextLine());

            switch (op) {
                case 1:
                    this.tipoContratoService.menu();
                    break;
                case 2:
                    this.cargoDevService.menu();
                    break;
                case 3:
                    this.desenvolvedorService.menu();
                case 4:
                    this.empresaTechService.menu();
                    break;    
                default:
                    isTrue = false ;break;
            }

        } while (isTrue);

    } catch (NumberFormatException e) {
        System.err.println("Erro ao converter para número: " + e.getMessage());
        // Aqui você pode adicionar mais tratamentos específicos conforme necessário
    } catch (Exception e) {
        System.err.println("Ocorreu um erro: " + e.getMessage());
        // Aqui você pode adicionar mais tratamentos específicos conforme necessário
      }
   }

}
