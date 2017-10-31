package br.com.datastructure.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.datastructure.services.AVLTree;

public class Rodovia implements Comparable<Rodovia>{
	
	private Integer id;
	private List<String> nomes =new ArrayList<String>();
	private AVLTree<Fluxo> fluxoDiaTree=new AVLTree<>();
	private Setor setor;
	public Rodovia(Integer id, String nome, Setor setor) {
		this.id= id;
		this.nomes.add(nome);
		this.setor = setor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<String> getNomes() {
		return nomes;
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
//		Fluxo fTemp = new Fluxo(this, data);
//		if(this.fluxoDiaTree.contains(fTemp))
//			
		return null;
	}
	public void setFluxoDiaTree(AVLTree<Fluxo> fluxoDiaTree) {
		this.fluxoDiaTree = fluxoDiaTree;
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
