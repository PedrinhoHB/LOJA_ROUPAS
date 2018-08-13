package br.com.jpa.loja.impl;

import javax.persistence.EntityManager;

import br.com.jpa.loja.dao.MedidaMasculinaDAO;
import br.com.jpa.loja.entity.MedidaMasculina;

public class MedidaMasculinaDAOImpl extends GenericDAOImpl<MedidaMasculina, Integer> implements MedidaMasculinaDAO {

	public MedidaMasculinaDAOImpl(EntityManager em) {
		super(em);
	}

}
