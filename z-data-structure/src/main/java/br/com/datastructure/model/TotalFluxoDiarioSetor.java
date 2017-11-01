package br.com.datastructure.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.datastructure.model.exceptions.FluxoInexistenteException;

public class TotalFluxoDiarioSetor {
	private Setor setor;
	private Date dia;
	private List<Integer> qtdFluxoMaiorQueFormula;
	public TotalFluxoDiarioSetor(Setor setor,Date dia,List<Integer> fluxosMaioresQueFormula ) throws FluxoInexistenteException{
		this.setor=setor;
		if(fluxosMaioresQueFormula == null || fluxosMaioresQueFormula.isEmpty())
			throw new FluxoInexistenteException("A lista com os fluxos maiores que a formula não pode ser vazio");
		this.qtdFluxoMaiorQueFormula = fluxosMaioresQueFormula;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.dia=sdf.parse(sdf.format(dia));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	public List<Integer> getQtdFluxoMaiorQueFormula() {
		return qtdFluxoMaiorQueFormula.subList(0, qtdFluxoMaiorQueFormula.size());
	}
//	System.out.println("Fluxo maiores que a fórmula: min(fluxo)+0.8x(max(fluxo)-min(fluxo)):");
//	for( Interger i2: fTemp.FluxosMaioresQueformula())
	
}
