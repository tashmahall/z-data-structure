package br.com.datastructure.view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import br.com.datastructure.model.Setor;
import br.com.datastructure.model.SetorTree;
import br.com.datastructure.model.TotalFluxoDiarioSetor;
import br.com.datastructure.model.exceptions.FluxoInexistenteException;
import br.com.datastructure.view.exceptions.RetornarMenuAnteriorException;

public class SetorActionsView {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SetorTree setorTree = SetorTree.getInstancia();
	public void cadastrarSetor() {
		Scanner entradaFluxo = new Scanner (System.in);
		try{
			Integer idSetor=null;
			Setor sEx = null;
			boolean erro;
			do{
				erro=false;
				System.out.print("Informe o ID de um novo Setor ou 0 para retornar ao menu anterior: ");
				try{
					idSetor = Integer.parseInt(entradaFluxo.nextLine());
					if(idSetor!=null&&idSetor.equals(0))
						throw new RetornarMenuAnteriorException();
					sEx = setorTree.getSetor(idSetor);
				}catch(NumberFormatException e) {
					System.out.println("O ID informado é inválido.");
					erro=true;
				}
			}while(erro||sEx!=null);
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
	public void listarFluxosFormula() {
		Scanner entradaFluxo = new Scanner (System.in);
		try{
			Integer idSetor=null;
			Setor sTemp = null;
			do{
				System.out.print("Informe o ID do Setor desejado ou 0 para retornar ao menu anterior: ");
				try{idSetor = Integer.parseInt(entradaFluxo.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("O ID informado é inválido.");
					continue;}
				if(idSetor!=null&&idSetor.equals(0))
					throw new RetornarMenuAnteriorException();
				sTemp = setorTree.getSetor(idSetor);
			}while(sTemp==null);
			descreverTotalFluxoDiarioSetor(sTemp);			
			entradaFluxo.reset();
		}catch(RetornarMenuAnteriorException ae){} 
		catch (FluxoInexistenteException e) {
			System.out.println(e.getLocalizedMessage());
		}
		finally{entradaFluxo.reset();}
	}
	private void descreverTotalFluxoDiarioSetor(Setor setor) throws FluxoInexistenteException {
		for(TotalFluxoDiarioSetor tfds : setor.getFLuxosMaioresQueFormula()) {
			System.out.println("Setor ID ["+tfds.getSetor().getId()+"]");
			System.out.println("Dia ["+sdf.format(tfds.getDia())+"]");
			System.out.println("Fluxos Maiores que a formula:");
			for(Integer i: tfds.getQtdFluxoMaiorQueFormula()) {
				System.out.println(i);
			}
			System.out.println("------------------------------------------------------------------------------------");
		}
	}
}
