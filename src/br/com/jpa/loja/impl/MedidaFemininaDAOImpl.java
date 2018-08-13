package br.com.jpa.loja.impl;

import javax.persistence.EntityManager;

import br.com.jpa.loja.dao.MedidaFemininaDAO;
import br.com.jpa.loja.entity.MedidaFeminina;

public class MedidaFemininaDAOImpl extends GenericDAOImpl<MedidaFeminina, Integer> implements MedidaFemininaDAO {

	public MedidaFemininaDAOImpl(EntityManager em) {
		super(em);
	}

}
