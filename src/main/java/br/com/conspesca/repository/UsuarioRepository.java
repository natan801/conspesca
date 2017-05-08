package br.com.conspesca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import br.com.conspesca.model.Usuario;

public class UsuarioRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("conspesca");
	EntityManager em = this.emf.createEntityManager();

	public void save(Usuario usuario) {
		this.em.getTransaction().begin();
		this.em.merge(usuario);
		this.em.getTransaction().commit();

	}

	public void delete(int id) {
		Usuario usuarioParaRemover = this.find(id);
		this.em.getTransaction().begin();
		this.em.remove(usuarioParaRemover);
		this.em.getTransaction().commit();
	}

	public Usuario update(Usuario usuario) {
		return this.em.merge(usuario);
	}

	public Usuario find(int usuarioID) {
		return this.em.find(Usuario.class, usuarioID);
	}

	public List<Usuario> findAll() {
		this.em.getTransaction().begin();
		CriteriaQuery<Usuario> cq = this.em.getCriteriaBuilder().createQuery(Usuario.class);
		cq.select(cq.from(Usuario.class));
		List<Usuario> listaUsuario = this.em.createQuery(cq).getResultList();
		this.em.close();

		return listaUsuario;
	}

}
