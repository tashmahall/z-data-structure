package br.com.datastructure.view;

import java.util.Scanner;

import br.com.datastructure.model.Setor;
import br.com.datastructure.model.SetorTree;
import br.com.datastructure.view.exceptions.RetornarMenuAnteriorException;

public class SetorActionsView {
	private SetorTree setorTree = SetorTree.getInstancia();
	public void cadastrarSetor() {
		Scanner entradaFluxo = new Scanner (System.in);
		try{
			Integer idSetor;
			do{
				System.out.print("Informe o ID de um novo Setor ou 0 para retornar ao menu anterior: ");
				idSetor = Integer.parseInt(entradaFluxo.nextLine());
				if(idSetor.equals(0))
					throw new RetornarMenuAnteriorException();
			}while(setorTree.getSetor(idSetor)!=null);
			System.out.print("Informe um nome para o setor: ");
			String nome = entradaFluxo.nextLine();
			Setor sTemp = new Setor(idSetor);
			sTemp.addNome(nome);
			setorTree.setSetor(sTemp);
			entradaFluxo.reset();
		}catch(RetornarMenuAnteriorException ae){}
		finally{entradaFluxo.reset();}
	}
	public void listarSetoresCadastrados(){
		System.out.println("Os setores cadastrados são: ");
		for(Setor sTemp:setorTree.getSetorTree().getSorted())
			descreverSetor(sTemp);
	}
	private void descreverSetor(Setor sTemp){
		System.out.println("ID do setor: ["+sTemp.getId()+"]");
		System.out.println("Nomes do Setor: ");
		for(String nome: sTemp.getNomes()){
			System.out.println(nome);
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
}
