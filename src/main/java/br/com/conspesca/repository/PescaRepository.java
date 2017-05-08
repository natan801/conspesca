package br.com.conspesca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Pesca;

public class PescaRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("conspesca");
	EntityManager em  = this.emf.createEntityManager();
	
	public void save(Pesca pesca){
		this.em.getTransaction().begin();
		this.em.merge(pesca);
		this.em.getTransaction().commit();
	}
	
	public Pesca find(int id){
		return this.em.find(Pesca.class, id);
		
				
	}
	
	public Pesca update(Pesca pesca) {
		return this.em.merge(pesca);
	}

	
	public List<Pesca> findAll() {
		this.em.getTransaction().begin();
		CriteriaQuery<Pesca> cq = this.em.getCriteriaBuilder().createQuery(Pesca.class);
		cq.select(cq.from(Pesca.class));
		List<Pesca> listaPesca= this.em.createQuery(cq).getResultList();
		this.em.close();
		return listaPesca;	
	}

}
