package br.com.jpa.loja.dao;

import java.util.List;

import br.com.jpa.loja.exception.CommitException;
import br.com.jpa.loja.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	List<T> listar();
	
	void commit() throws CommitException;
	
}



