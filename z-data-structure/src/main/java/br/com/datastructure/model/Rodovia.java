package br.com.datastructure.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.datastructure.structure.AVLTree;

public class Rodovia implements Comparable<Rodovia>{
	
	private Integer id;
	private List<String> nomes =new ArrayList<String>();
	private AVLTree<Fluxo> fluxoDiaTree=new AVLTree<Fluxo>();
	private Setor setor;
	public Rodovia(Integer id, Setor setor) {
		this.id= id;
		this.setor = setor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<String> getNomes() {
		return nomes.subList(0, nomes.size());
	}
	public void setNome(String nome) {
		this.nomes.add(nome) ;
	}
	public Setor getSetor() {
		return setor;
	}
	public int compareTo(Rodovia arg0) {
		
		return this.id - arg0.id;
	}
	public AVLTree<Fluxo> getFluxoDiaTree() {
		return fluxoDiaTree;
	}

	public Fluxo getFluxoPorData(Date data) {
		Fluxo fTemp = new Fluxo(this, data);
		if(this.fluxoDiaTree.contains(fTemp))
			for(Fluxo f: fluxoDiaTree.getBFS()){
				if(data.equals(f.getDia()))
					return f;
			}
		return null;
	}
	public void addFluxo(Fluxo f){
		if(this.fluxoDiaTree.contains(f)){
			//Adiciona uma lista de QtdFluxo a um Fluxo Diário caso já exista o dia informado na arvore
			this.getFluxoPorData(f.getDia()).addListaQtdFluxo(f.getListaQtdFluxo());;
		}else{
			//Adiciona um Fluxo diário caso o dia não exista na arvore
			fluxoDiaTree.add(f);	
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
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
		Rodovia other = (Rodovia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}
	

}
