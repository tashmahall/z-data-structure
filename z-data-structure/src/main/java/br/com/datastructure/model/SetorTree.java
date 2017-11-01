package br.com.datastructure.model;

import br.com.datastructure.structure.AVLTree;

public class SetorTree {
	private AVLTree<Setor> setorTree=new AVLTree<Setor>();
	private static SetorTree instancia;
	public AVLTree<Setor> getSetorTree() {
		return setorTree;
	}
	public void setSetor(Setor setor) {
		setorTree.add(setor);
	}
	public Setor getSetor(Integer idSetor) {
		Setor set = new Setor(idSetor);
		if(setorTree.contains(set))
			for(Setor sTemp: setorTree.getBFS()) {
				if(sTemp.equals(set)) {
					return sTemp;
				}
			}
		return null;
	}
	private SetorTree() {}
	public static SetorTree getInstancia() {
		if(instancia == null) {
			instancia=new SetorTree();
		}
		return instancia;
	}

}
