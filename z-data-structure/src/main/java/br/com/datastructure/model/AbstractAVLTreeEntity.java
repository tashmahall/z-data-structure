package br.com.datastructure.model;

import br.com.datastructure.structure.AVLTree;

public abstract class AbstractAVLTreeEntity<E extends Comparable<E>,ID, T> implements Comparable<T> {
	
	private AVLTree<E> tree =new AVLTree<E>();

	public E getFluxoPorData(E e) {
		if(this.tree.contains(e))
			for(E f: tree.getBFS()){
				if(e.equals(f))
					return f;
			}
		return null;
	}
}
