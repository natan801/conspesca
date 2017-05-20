package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.conspesca.model.Peixe;

@Named
public class PeixeRepository {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Peixe peixe) {
		this.em.persist(peixe);

	}

	public void delete(int id) {
		Peixe peixeParaRemover = this.find(id);
		this.em.remove(peixeParaRemover);
	}

	public Peixe update(Peixe peixe) {
		return this.em.merge(peixe);
	}

	public Peixe find(int id) {
		return this.em.find(Peixe.class, id);
	}

	public List<Peixe> findAll() {
		CriteriaQuery<Peixe> cq = this.em.getCriteriaBuilder().createQuery(Peixe.class);
		cq.select(cq.from(Peixe.class));
		return this.em.createQuery(cq).getResultList();
	}

	public List<Peixe> findPeixeByQuery(String pesquisaPeixe) {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Peixe> cq = builder.createQuery(Peixe.class);
		Root<Peixe> rootP = cq.from(Peixe.class);
		Predicate like = builder.like(rootP.get("nome"), pesquisaPeixe+"%");
		cq.where(like);
		
		return this.em.createQuery(cq).getResultList();
	}

}