package br.com.datastructure.model;

import java.util.ArrayList;
import java.util.List;

import br.com.datastructure.model.exceptions.FluxoInexistenteException;
import br.com.datastructure.structure.AVLTree;

public class Setor implements Comparable<Setor>{
	private Integer id;
	private List<String> nomes =new ArrayList<String>();
	private AVLTree<Rodovia> rodoviasTree =new AVLTree<Rodovia>();
	public Setor(Integer id) {
		this.id = id;
	}
	public void addNome(String nome) {
		this.nomes.add(nome);
	}
	
	public AVLTree<Rodovia> getRodoviasTree() {
		return rodoviasTree;
	}

	public void setRodovia(Rodovia rodovia) {
		this.rodoviasTree.add(rodovia);
	}
	public Rodovia getRodoviaPorID(Integer Id) {
		Rodovia rTemp = new Rodovia(id, this);
		if(this.rodoviasTree.contains(rTemp))
			for(Rodovia r: rodoviasTree.getBFS()){
				if(r.equals(rTemp))
					return r;
			}
		return null;
	}
	public Integer getId() {
		return id;
	}

	public List<String> getNomes() {
		return nomes.subList(0, nomes.size());
	}

	public void setNome(String nome) {
		this.nomes.add(nome);
	}

	public int compareTo(Setor arg0) {
		return this.id - arg0.id;
	}
	public List<TotalFluxoDiarioSetor> getFLuxosMaioresQueFormula() throws FluxoInexistenteException{
		List<TotalFluxoDiarioSetor> ltfds = new ArrayList<TotalFluxoDiarioSetor>();
		Rodovia[] rodovias = this.rodoviasTree.getLevelOrder();
		for(Rodovia rTemp:rodovias) {
			Fluxo[] fluxos = rTemp.getFluxoDiaTree().getSorted();
			for(Fluxo f: fluxos) {
				ltfds.add(f.FluxosMaioresQueformula());
			}
		}
		return ltfds;
	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Setor other = (Setor) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
}
