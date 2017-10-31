package br.com.datastructure.controller;

import java.util.Scanner;

public class DataStructureMain {

	public static void main(String[] args) {
		while (true){
			System.out.println("Escolha uma Opção:");
			System.out.println("01- Cadastrar Setor");
			System.out.println("02- Cadastrar Rodovia");
			System.out.println("03- Cadastrar Fluxo");
			System.out.println("04- Listar Setores");
			System.out.println("05- Listar Rodovias");
			System.out.println("06- Listar Fluxos");
			System.out.println("07- Listar Fluxos que atendam a Fórmula Determinada");
			Scanner entrada = new Scanner (System.in);
			System.out.print("Aguardando a escolha da opção: ");
			Integer opcao = Integer.parseInt(entrada.nextLine());
			switch (opcao) {
			case 1:
				cadastrarSetor();
				break;
			case 2:
				cadastrarRodovia();
				break;
			case 3:
				cadastrarFluxo();
				break;
			case 4:
				listarSetor();
				break;
			case 5:
				listarRodovia();
				break;
			case 6:
				listarFluxo();
				break;
			case 7:
				listarFluxosFormula();
				break;
			default:
				System.out.print("Opção Inválida ");
				entrada.nextLine();
				break;
			}
			entrada.close();
		}
	}
	public static void cadastrarSetor(){
		
	}
	public static void cadastrarRodovia(){
		
	}
	public static void cadastrarFluxo(){
		
	}
	public static void listarSetor(){
		
	}
	public static void listarRodovia(){
		
	}
	public static void listarFluxo(){
		
	}
	public static void listarFluxosFormula(){
		
	}
	

}
