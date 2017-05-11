package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Peixe;

@Named
public class PeixeRepository {
	
	
	public PeixeRepository() {
	}

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

}
