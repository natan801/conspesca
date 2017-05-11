package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Ferramenta;

@Named
public class FerramentaRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Ferramenta ferramenta) {
		this.em.persist(ferramenta);

	}

	public void delete(int id) {
		Ferramenta ferramentaParaRemover = this.find(id);
		this.em.remove(ferramentaParaRemover);
	}

	public Ferramenta update(Ferramenta ferramenta) {
		return this.em.merge(ferramenta);
	}

	public Ferramenta find(int id) {
		return this.em.find(Ferramenta.class, id);
	}

	public List<Ferramenta> findAll() {
		CriteriaQuery<Ferramenta> cq = this.em.getCriteriaBuilder().createQuery(Ferramenta.class);
		cq.select(cq.from(Ferramenta.class));
		return this.em.createQuery(cq).getResultList();

	}

}
