package br.com.conspesca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Ferramenta;

public class FerramentaRepository {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("conspesca");
	EntityManager em = this.emf.createEntityManager();

	public void save(Ferramenta ferramenta) {
		this.em.getTransaction().begin();
		this.em.merge(ferramenta);
		this.em.getTransaction().commit();

	}

	public void delete(int id) {
		Ferramenta ferramentaParaRemover = this.find(id);
		this.em.getTransaction().begin();
		this.em.remove(ferramentaParaRemover);
		this.em.getTransaction().commit();
	}

	public Ferramenta update(Ferramenta ferramenta) {
		return this.em.merge(ferramenta);
	}

	public Ferramenta find(int id) {
		return this.em.find(Ferramenta.class, id);
	}

	public List<Ferramenta> findAll() {
		this.em.getTransaction().begin();
		CriteriaQuery<Ferramenta> cq = this.em.getCriteriaBuilder().createQuery(Ferramenta.class);
		cq.select(cq.from(Ferramenta.class));
		List<Ferramenta> listaFerramenta = this.em.createQuery(cq).getResultList();
		this.em.close();

		return listaFerramenta;
	}

}
