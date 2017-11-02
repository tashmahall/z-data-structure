package br.com.datastructure.view;

import java.util.Scanner;

import br.com.datastructure.model.Rodovia;
import br.com.datastructure.model.Setor;
import br.com.datastructure.model.SetorTree;
import br.com.datastructure.view.exceptions.RetornarMenuAnteriorException;



public class RodoviaActionsView {
	private SetorTree setorTree = SetorTree.getInstancia();

	public void cadastrarRodovia(){
		Scanner entradaFluxo = new Scanner (System.in);
		try{
			Setor sTemp =null;
			boolean erro;
			do{
				erro=false;
				System.out.print("Informe o ID do Setor da nova Rodovia ou 0 para retornar ao menu anterior: ");
				Integer idSetor=null;
				try{ 
					idSetor= Integer.parseInt(entradaFluxo.nextLine());
					if(idSetor!=null&&idSetor.equals(0))
						throw new RetornarMenuAnteriorException();
					sTemp = setorTree.getSetor(idSetor);
				}catch(NumberFormatException e) {
					System.out.println("O ID informado é inválido.");
					erro=true;
				}
			}while(erro||sTemp==null);
			Rodovia rTemp=null;
			Integer idRodovia = null;
			do{
				erro=false;
				rTemp=null;
				System.out.print("Informe o ID da nova Rodovia ou 0 para retornar ao menu anterior: ");
				try{
					idRodovia = Integer.parseInt(entradaFluxo.nextLine());
					if(idRodovia!=null&&idRodovia.equals(0))
						throw new RetornarMenuAnteriorException();
					rTemp=sTemp.getRodoviaPorID(idRodovia);
				}catch(NumberFormatException e) {
					System.out.println("O ID informado é inválido.");
					erro=true;
				}
			}while(erro||rTemp!=null);
			System.out.print("Informe um nome para a nova Rodovia: ");
			String nome = entradaFluxo.nextLine();
			rTemp = new Rodovia(idRodovia,sTemp);
			rTemp.setNome(nome);
			sTemp.setRodovia(rTemp);
			System.out.println("Rodovia Adicionado ");
		}catch(RetornarMenuAnteriorException se){}
		finally{entradaFluxo.reset();}
	}
	public void listarRodovia(){
		Scanner entradaFluxo = new Scanner (System.in);
		try{
			Setor sTemp =null;
			boolean erro;
			do{
				erro=false;
				System.out.print("Informe o ID do Setor da nova Rodovia ou 0 para retornar ao menu anterior: ");
				Integer idSetor=null;
				try{
					idSetor = Integer.parseInt(entradaFluxo.nextLine());
					if(idSetor!=null&&idSetor.equals(0))
						throw new RetornarMenuAnteriorException();
					sTemp = setorTree.getSetor(idSetor);
				}catch(NumberFormatException e) {
					System.out.println("O ID informado é inválido.");
					erro=true;
				}
			}while(erro||sTemp==null);
			System.out.println("Os setores cadastrados são: ");
			Rodovia[] arrayRodoviaTemp = sTemp.getRodoviasTree().getSorted();
			for(Rodovia rTemp: arrayRodoviaTemp){
				descreverRodovia(rTemp);
			}			
		}catch(RetornarMenuAnteriorException se){}
		finally{entradaFluxo.reset();}
	}
	private void descreverRodovia(Rodovia fTemp){
		System.out.println("ID do Rodovia: ["+fTemp.getId()+"]");
		System.out.println("Nomes da Rodovia: ");
		for(String nome: fTemp.getNomes()){
			System.out.println(nome);
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
}
