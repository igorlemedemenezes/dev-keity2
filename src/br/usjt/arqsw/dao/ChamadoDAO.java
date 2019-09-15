package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {
	
	@PersistenceContext
	EntityManager manager;

	public void criar(Chamado chamado) {
		manager.persist(chamado);
	}
	
	public void atualizar(Chamado chamado) {
		manager.merge(chamado);
	}
	
	public void remover(Chamado chamado) {
		manager.remove(chamado);
	}
	
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		//conectei minha fila com a persistencia
		fila = manager.find(Fila.class, fila.getId());

		String jpql = "select c from Chamado c where c.fila = :fila";

		Query query = manager.createQuery(jpql);
		query.setParameter("fila", fila);

		List<Chamado> result = query.getResultList();
		return result;
		}
}
