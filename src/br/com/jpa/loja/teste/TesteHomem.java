package br.com.jpa.loja.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jpa.loja.dao.HomemDAO;
import br.com.jpa.loja.entity.Homem;
import br.com.jpa.loja.entity.MedidaMasculina;
import br.com.jpa.loja.exception.CommitException;
import br.com.jpa.loja.impl.HomemDAOImpl;
import br.com.jpa.loja.singleton.EntityManagerFactorySingleton;

public class TesteHomem {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		HomemDAO dao = new HomemDAOImpl(em);

		MedidaMasculina medida = new MedidaMasculina();
		medida.setCintura(20);
		medida.setManga(15);
		medida.setPeito(40);
		medida.setQuadril(45);

		Homem homem = new Homem();
		homem.setNome("Pedro");
		homem.setMedida(medida);

		dao.inserir(homem);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}

		List<Homem> lista = dao.listar();
		for (Homem h : lista) {
			System.out.println(h.getNome());
		}

		em.close();

	}
}
