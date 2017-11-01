package br.com.datastructure.model.pattern;

public interface DAOBasics<T,ID> {
	public void persist(T type);
	public void retrieveById(ID id);
	public void update(T type);
	public void deleteByID(ID id);
	

}
