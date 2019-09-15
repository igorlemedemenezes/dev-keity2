package br.usjt.arqsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author asbonato
 *
 */
@Repository
public class FilaDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public void criar(Fila fila) {
		manager.persist(fila);
	}
	
	public void atualizar(Fila fila) {
		manager.merge(fila);
	}
	
	public void remover(Fila fila) {
		manager.remove(fila);
	}
	
	public Fila carregar(int id) {
		return manager.find(Fila.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fila> listarFilas(){
		return manager.createQuery("select l from Fila l").getResultList();
	}
}
