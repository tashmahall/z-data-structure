package br.com.datastructure.controller;

import java.util.Scanner;

import br.com.datastructure.controller.exceptions.SaidaException;
import br.com.datastructure.view.FluxoActionsView;
import br.com.datastructure.view.RodoviaActionsView;
import br.com.datastructure.view.SetorActionsView;

public class DataStructureMain {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		try{
			while (true){
				System.out.println("Escolha uma Opção:");
				System.out.println("01- Cadastrar Setor");
				System.out.println("02- Cadastrar Rodovia");
				System.out.println("03- Cadastrar Fluxo");
				System.out.println("04- Listar Setores");
				System.out.println("05- Listar Rodovias");
				System.out.println("06- Listar Fluxos");
				System.out.println("07- Listar Fluxos que atendam a Fórmula Determinada");
				System.out.println("08- Para sair");
				
				System.out.print("Aguardando a escolha da opção: ");
				Integer opcao=0 ;
				opcao= Integer.parseInt(entrada.nextLine());
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
				case 8:
					entrada.close();
					throw new SaidaException();
				default:
					System.out.println("Opção Inválida ");
					entrada.nextLine();
					break;
				}
				entrada.reset();
			}
		}catch(SaidaException s){System.out.println("Bye!!!");}
	}
	public static void cadastrarSetor(){
		new SetorActionsView().cadastrarSetor();
	}
	public static void cadastrarRodovia(){
		new RodoviaActionsView().cadastrarRodovia();
	}
	public static void cadastrarFluxo(){
		new FluxoActionsView().cadastrarFluxo();
	}
	public static void listarSetor(){
		new SetorActionsView().listarSetoresCadastrados();
	}
	public static void listarRodovia(){
		new RodoviaActionsView().listarRodovia();
	}
	public static void listarFluxo(){
		new FluxoActionsView().listarFluxos();
	}
	public static void listarFluxosFormula(){
		new SetorActionsView().listarFluxosFormula();
	}
	

}
