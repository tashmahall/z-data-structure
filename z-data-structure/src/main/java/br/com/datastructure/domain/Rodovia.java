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
		
		this.fluxoDiaTree.contains(value)
	}
	public void setFluxoDiaTree(AVLTree<Fluxo> fluxoDiaTree) {
		this.fluxoDiaTree = fluxoDiaTree;
	}
	

}
