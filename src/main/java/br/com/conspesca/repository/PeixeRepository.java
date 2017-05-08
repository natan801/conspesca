package br.com.conspesca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Peixe;

public class PeixeRepository {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("conspesca");
	EntityManager em = this.emf.createEntityManager();

	public void save(Peixe peixe) {
		this.em.getTransaction().begin();
		this.em.merge(peixe);
		this.em.getTransaction().commit();

	}

	public void delete(int id) {
		Peixe peixeParaRemover = this.find(id);
		this.em.getTransaction().begin();
		this.em.remove(peixeParaRemover);
		this.em.getTransaction().commit();
	}

	public Peixe update(Peixe peixe) {
		return this.em.merge(peixe);
	}

	public Peixe find(int id) {
		return this.em.find(Peixe.class, id);
	}

	public List<Peixe> findAll() {
		this.em.getTransaction().begin();
		CriteriaQuery<Peixe> cq = this.em.getCriteriaBuilder().createQuery(Peixe.class);
		cq.select(cq.from(Peixe.class));
		List<Peixe> listaPeixe = this.em.createQuery(cq).getResultList();
		this.em.close();

		return listaPeixe;
	}

}
