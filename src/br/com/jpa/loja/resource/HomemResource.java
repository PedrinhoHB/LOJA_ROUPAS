package br.com.jpa.loja.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.jpa.loja.dao.HomemDAO;
import br.com.jpa.loja.entity.Homem;
import br.com.jpa.loja.exception.CommitException;
import br.com.jpa.loja.exception.KeyNotFoundException;
import br.com.jpa.loja.impl.HomemDAOImpl;
import br.com.jpa.loja.singleton.EntityManagerFactorySingleton;

@Path("/homem")
public class HomemResource {
	private HomemDAO dao;

	public HomemResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new HomemDAOImpl(em);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Homem homem, @Context UriInfo uri) {
		try {
			dao.inserir(homem);
			dao.commit();
		} catch (CommitException e) {
			return Response.serverError().build();
		}

		UriBuilder b = uri.getAbsolutePathBuilder();
		b.path(String.valueOf(homem.getCodigo()));

		return Response.created(b.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Homem> listar() {
		return dao.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Homem pesquisar(@PathParam("id") int codigo) {
		return dao.pesquisar(codigo);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Homem homem, @PathParam("id") int codigo) {
		try {
			dao.atualizar(homem);
			dao.commit();
		} catch (CommitException e) {
			return Response.serverError().build();
		}

		return Response.ok().build();
	}

	public void remover(int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (CommitException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		} catch (KeyNotFoundException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
