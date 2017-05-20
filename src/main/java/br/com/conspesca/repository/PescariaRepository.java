package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.model.Peixe;
import br.com.conspesca.model.Pescaria;


@Named
public class PescariaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Pescaria> findByPeixeId(Integer idPeixe){
		
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Pescaria> query = builder.createQuery(Pescaria.class);
		Root<Pescaria> rootP = query.from(Pescaria.class);
		
		query.where(builder.equal(rootP.get("peixe").get("idPeixe"), idPeixe));

		return this.em.createQuery(query).getResultList();
		
	}
	
	public List<Pescaria> findAll(){
		CriteriaQuery<Pescaria> cq = this.em.getCriteriaBuilder().createQuery(Pescaria.class);
		cq.select(cq.from(Pescaria.class));
		return this.em.createQuery(cq).getResultList();
	}
	
	public List<Pescaria> findByPeixe(Peixe peixe){
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Pescaria> query = builder.createQuery(Pescaria.class);
		Root<Pescaria> from = query.from(Pescaria.class);
		TypedQuery<Pescaria> typedQuery = this.em.createQuery(query.select(from).where(builder.equal(from.get("peixe"), peixe)));
		return typedQuery.getResultList();
		
	}
	
	public List<Pescaria> findByFerramenta(Ferramenta ferramenta){
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Pescaria> query = builder.createQuery(Pescaria.class);
		Root<Pescaria> from = query.from(Pescaria.class);
		TypedQuery<Pescaria> typedQuery = this.em.createQuery(query.select(from).where(builder.equal(from.get("ferramenta"), ferramenta)));
		return typedQuery.getResultList();
		
	}
	

}
