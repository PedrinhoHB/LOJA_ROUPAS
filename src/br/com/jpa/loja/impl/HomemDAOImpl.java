package br.com.jpa.loja.impl;

import javax.persistence.EntityManager;

import br.com.jpa.loja.dao.HomemDAO;
import br.com.jpa.loja.entity.Homem;

public class HomemDAOImpl extends GenericDAOImpl<Homem, Integer> implements HomemDAO {

	public HomemDAOImpl(EntityManager em) {
		super(em);
	}

}
