package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.conspesca.model.Pesca;

@Named
public class PescaRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Pesca pesca) {
		this.em.persist(pesca);
	}

	public Pesca find(int id) {
		return this.em.find(Pesca.class, id);

	}

	public Pesca update(Pesca pesca) {
		return this.em.merge(pesca);
	}

	public List<Pesca> findAll() {
		
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Pesca> cq = builder.createQuery(Pesca.class);
		Root<Pesca> rootP = cq.from(Pesca.class);
		rootP.fetch("pescarias");
		cq.select(rootP);
		
		cq.distinct(true);
		
		
		return this.em.createQuery(cq).getResultList();
	}

}
