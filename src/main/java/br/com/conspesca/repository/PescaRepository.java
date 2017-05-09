package br.com.conspesca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Pesca;


public class PescaRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("conspesca");
	EntityManager em = emf.createEntityManager();
	
	public void save(Pesca pesca){
		this.em.merge(pesca);
	}
	
	public Pesca find(int id){
		return this.em.find(Pesca.class, id);
		
				
	}
	
	
	public Pesca update(Pesca pesca) {
		return this.em.merge(pesca);
	}

	
	public List<Pesca> findAll() {
		CriteriaQuery<Pesca> cq = this.em.getCriteriaBuilder().createQuery(Pesca.class);
		cq.select(cq.from(Pesca.class));
		List<Pesca> listaPesca= this.em.createQuery(cq).getResultList();
		return listaPesca;	
	}

}
