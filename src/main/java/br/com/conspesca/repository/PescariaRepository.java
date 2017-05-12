package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Pescaria;


@Named
public class PescariaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Pescaria> findAll(){
		CriteriaQuery<Pescaria> cq = this.em.getCriteriaBuilder().createQuery(Pescaria.class);
		cq.select(cq.from(Pescaria.class));
		return this.em.createQuery(cq).getResultList();
	}

}
