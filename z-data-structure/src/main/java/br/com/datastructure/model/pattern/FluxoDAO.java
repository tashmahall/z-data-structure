package br.com.datastructure.model.pattern;

import br.com.datastructure.model.Fluxo;
import br.com.datastructure.model.Rodovia;

public class FluxoDAO implements  DAOBasics<Fluxo, Integer>{

	public void persist(Fluxo type) {
		Rodovia r = type.getRodovia();
		r.addFluxo(type);
	}

	public void retrieveById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Fluxo type) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
