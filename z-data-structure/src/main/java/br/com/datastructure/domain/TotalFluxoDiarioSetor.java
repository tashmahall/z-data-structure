package br.com.datastructure.domain;

import java.util.Date;

public class TotalFluxoDiarioSetor {
	private Setor setor;
	private Date dia;
	private Integer totalFluxoDiario;
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Integer getTotalFluxoDiario() {
		return totalFluxoDiario;
	}
	public void setTotalFluxoDiario(Integer totalFluxoDiario) {
		this.totalFluxoDiario = totalFluxoDiario;
	}

	

}
