package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Usuario;

@Named
public class UsuarioRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Usuario usuario) {
		this.em.persist(usuario);

	}

	public void delete(int id) {
		Usuario usuarioParaRemover = this.find(id);
		this.em.remove(usuarioParaRemover);
	}

	public Usuario update(Usuario usuario) {
		return this.em.merge(usuario);
	}

	public Usuario find(int usuarioID) {
		return this.em.find(Usuario.class, usuarioID);
	}

	public List<Usuario> findAll() {
		CriteriaQuery<Usuario> cq = this.em.getCriteriaBuilder().createQuery(Usuario.class);
		cq.select(cq.from(Usuario.class));
		return this.em.createQuery(cq).getResultList();
	}

}
