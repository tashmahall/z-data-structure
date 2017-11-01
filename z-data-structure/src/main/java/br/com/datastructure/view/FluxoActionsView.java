package br.com.datastructure.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.datastructure.model.Fluxo;
import br.com.datastructure.model.Rodovia;
import br.com.datastructure.model.Setor;
import br.com.datastructure.model.SetorTree;
import br.com.datastructure.model.exceptions.FluxoInexistenteException;
import br.com.datastructure.view.exceptions.RetornarMenuAnteriorException;



public class FluxoActionsView {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SetorTree setorTree = SetorTree.getInstancia();

	public void cadastrarFluxo(){
		Scanner entradaFluxo = new Scanner (System.in);
		try{
			Setor sTemp =null;
			do{
				System.out.print("Informe o ID de um novo Setor ou 0 para retornar ao menu anterior: ");
				Integer idSetor = Integer.parseInt(entradaFluxo.nextLine());
				if(idSetor.equals(0))
					throw new RetornarMenuAnteriorException();
				sTemp = setorTree.getSetor(idSetor);
			}while(sTemp==null);
			Rodovia rTemp=null;
			do{
				System.out.print("Informe o ID da Rodovia ou 0 para retornar ao menu anterior: ");
				Integer idRodovia = Integer.parseInt(entradaFluxo.nextLine());
				if(idRodovia.equals(0))
					throw new RetornarMenuAnteriorException();
				rTemp=sTemp.getRodoviaPorID(idRodovia);
			}while(rTemp==null);
			Date dataFluxo = null;
			do{
				System.out.print("Informe o dia do Fluxo no padrão dd/MM/yyyy: ");
				try {
					sdf.setLenient(false);
					dataFluxo = sdf.parse(entradaFluxo.nextLine());
				} catch (ParseException e) {
					System.out.print("A data informada não atende o padrão dd/MM/yyyy: ");
				}
			}while (dataFluxo==null);
			System.out.print("Informe a quantidade de veiculos do Fluxo ");
			Integer qtdFluxo = Integer.parseInt(entradaFluxo.nextLine());
			Fluxo fTemp = new Fluxo(rTemp,dataFluxo);
			fTemp.addQtdFluxo(qtdFluxo);
			rTemp.addFluxo(fTemp);
			System.out.println("Fluxo Adicionado ");
		}catch(RetornarMenuAnteriorException se){}
		finally{entradaFluxo.reset();}
	}
	public void listarFluxos(){
		Scanner entradaFluxo = new Scanner (System.in);
		System.out.print("Informe o ID do Setor: ");
		Integer idSetor = Integer.parseInt(entradaFluxo.nextLine());
		System.out.print("Informe o ID da Rodovia: ");
		Setor sTemp=null;
		Rodovia rTemp=null;
		Integer idRodovia = Integer.parseInt(entradaFluxo.nextLine());
		System.out.println("A Rodovia ID ["+rTemp.getId()+"] do setor ["+sTemp.getId()+"] possui os seguintes Fluxos:");
		Fluxo[] arrayFluxoTemp = rTemp.getFluxoDiaTree().getSorted();
		for(Fluxo fTemp: arrayFluxoTemp){
			descreverFuxo(fTemp);
		}
		entradaFluxo.reset();
	}
	private void descreverFuxo(Fluxo fTemp){
		String data = sdf.format(fTemp.getDia());
		System.out.println("O dia ["+data+"] possui os seguintes fluxos:");
		for(Integer i:fTemp.getListaQtdFluxo()){
			System.out.println(i);
		}
		System.out.println("Fluxo médio: ["+fTemp.getFluxoMedioDia()+"]");
		try {
			System.out.println("Fluxo minimo: ["+fTemp.getQtdFluxoMinimoDia()+"]");
		} catch (FluxoInexistenteException e) {
			System.out.println("Fluxo minimo: ["+e.getLocalizedMessage()+"]");
		}
		try {
			System.out.println("Fluxo máximo: ["+fTemp.getQtdFluxoMaximoDia()+"]");
		} catch (FluxoInexistenteException e) {
			System.out.println("Fluxo máximo: ["+e.getLocalizedMessage()+"]");
		}
		System.out.println("------------------------------------------------------------------------------");
	}
}
