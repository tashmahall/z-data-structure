package br.com.datastructure.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.datastructure.model.exceptions.FluxoInexistenteException;

public class Fluxo implements Comparable<Fluxo>{
	private Rodovia rodovia;
	private Date dia;
	private List<Integer> listaQtdFluxo = new ArrayList<Integer>();
	public Fluxo (Rodovia rodovia,Date dia) {
		this.rodovia=rodovia;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.dia=sdf.parse(sdf.format(dia));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getDia() {
		return dia;
	}
	public void addQtdFluxo(Integer qtdFluxo){
		listaQtdFluxo.add(qtdFluxo);
		Collections.sort(listaQtdFluxo);
	}
	public void addListaQtdFluxo(List<Integer> qtdFluxo){
		listaQtdFluxo.addAll(qtdFluxo);
		Collections.sort(listaQtdFluxo);
	}
	public Rodovia getRodovia() {
		return rodovia;
	}
	public List<Integer> getListaQtdFluxo() {
		return listaQtdFluxo.subList(0, listaQtdFluxo.size());
	}
	
	public int compareTo(Fluxo arg0) {
		return this.dia.compareTo(arg0.dia);
	}
	public double fluxoMedioDia(){
		int total =0;
		for(int i : listaQtdFluxo){
			total = total+i;
		}
		return (total/listaQtdFluxo.size());
	}
	public Integer getQtdFluxoMinimoDia() throws FluxoInexistenteException{
		if(listaQtdFluxo.size()>0)
			return listaQtdFluxo.get(0);
		throw new FluxoInexistenteException("Não existe Fluxo para o dia "+dia);
	}
	public Integer getQtdFluxoMaximoDia() throws FluxoInexistenteException{
		if(listaQtdFluxo.size()>0)
			return listaQtdFluxo.get(listaQtdFluxo.size()-1);
		throw new FluxoInexistenteException("Não existe Fluxo para o dia "+dia);
	}
	public TotalFluxoDiarioSetor FluxosMaioresQueformula() throws FluxoInexistenteException{
		Double solForm = calcularFormula();
		List<Integer> listTotFluxDiaSet = procuraFluxosMaioresQueResultadoFormula(solForm);
		try {
			TotalFluxoDiarioSetor ttFlDiaSet = new TotalFluxoDiarioSetor(this.rodovia.getSetor(), dia, listTotFluxDiaSet);
			return ttFlDiaSet;			
		} catch (FluxoInexistenteException e) {
			throw new FluxoInexistenteException("Não existem fluxos cadastrados para esse dia nessa rodovia");
		}

	}
	private List<Integer> procuraFluxosMaioresQueResultadoFormula(Double solForm){
		List<Integer> ttFlDiaSet = new ArrayList<Integer>();
		for(Integer in: listaQtdFluxo){
			if(solForm.compareTo(new Double(in))<0){
				ttFlDiaSet.add(in);
			}
		}
		return ttFlDiaSet;
	}
	private double calcularFormula(){
		Integer flMin = listaQtdFluxo.get(0);
		Integer flMax = listaQtdFluxo.get(listaQtdFluxo.size()-1);
		Integer delta = flMax-flMin;
		return flMin + 0.8*delta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((rodovia == null) ? 0 : rodovia.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fluxo other = (Fluxo) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (rodovia == null) {
			if (other.rodovia != null)
				return false;
		} else if (!rodovia.equals(other.rodovia))
			return false;
		return true;
	}
	
}
