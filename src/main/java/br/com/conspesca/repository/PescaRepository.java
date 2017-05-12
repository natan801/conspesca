package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

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
		CriteriaQuery<Pesca> cq = this.em.getCriteriaBuilder().createQuery(Pesca.class);
		cq.select(cq.from(Pesca.class));
		return this.em.createQuery(cq).getResultList();
	}

}
