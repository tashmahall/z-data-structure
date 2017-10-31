package br.com.datastructure.domain;

import java.util.ArrayList;
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
	
	public Rodovia getRodovia() {
		return rodovia;
	}
	public List<Integer> getListaQtdFluxo() {
		return listaQtdFluxo;
	}
	
	@Override
	public int compareTo(Fluxo arg0) {
		return this.dia.compareTo(arg0.dia);
	}
}
