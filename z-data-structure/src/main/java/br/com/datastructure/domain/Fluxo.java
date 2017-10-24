package br.com.datastructure.domain;

import java.util.Date;

public class Fluxo implements Comparable<Fluxo>{
	private Rodovia rodovia;
	private Date dia;
	private Integer qtdFluxo;
	public Rodovia getRodovia() {
		return rodovia;
	}
	public void setRodovia(Rodovia rodovia) {
		this.rodovia = rodovia;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Integer getQtdFluxo() {
		return qtdFluxo;
	}
	public void setQtdFluxo(Integer qtdFluxo) {
		this.qtdFluxo = qtdFluxo;
	}
	public int compareTo(Fluxo o) {
		
		return this.qtdFluxo-o.qtdFluxo;
	}
}
