package br.com.datastructure.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Fluxo implements Comparable<Fluxo>{
	private Rodovia rodovia;
	private Date dia;
	private List<Integer> listaQtdFluxo = new ArrayList<Integer>();
	public Fluxo (Rodovia rodovia,Date dia) {
		this.rodovia=rodovia;
		this.dia=dia;
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
		return listaQtdFluxo;
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
