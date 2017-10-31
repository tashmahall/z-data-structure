package br.com.datastructure.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.datastructure.services.AVLTree;

public class Setor implements Comparable<Setor>{
	private Integer id;
	private List<String> nomes =new ArrayList<String>();
	private AVLTree<Rodovia> rodoviasTree =new AVLTree<Rodovia>();
	public Setor(Integer id, String nome) {
		this.id = id;
		this.nomes.add(nome);
	}
	
	public AVLTree<Rodovia> getRodoviasTree() {
		return rodoviasTree;
	}

	public void setRodovia(Rodovia rodovia) {
		this.rodoviasTree.add(rodovia);
	}

	public Integer getId() {
		return id;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNome(String nome) {
		this.nomes.add(nome);
	}

		@Override
	public int compareTo(Setor arg0) {
		return this.id - arg0.id;
	}
}
