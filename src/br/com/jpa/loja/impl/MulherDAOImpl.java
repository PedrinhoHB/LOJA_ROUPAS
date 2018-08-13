package br.com.jpa.loja.impl;

import javax.persistence.EntityManager;

import br.com.jpa.loja.dao.MulherDAO;
import br.com.jpa.loja.entity.Mulher;

public class MulherDAOImpl extends GenericDAOImpl<Mulher, Integer> implements MulherDAO {

	public MulherDAOImpl(EntityManager em) {
		super(em);
	}

}
