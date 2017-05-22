package br.com.conspesca.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.conspesca.VO.UserSessionVO;
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

	public UserSessionVO findUserSessionByUserSenha(String login, String senha) {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
		Root<Usuario> rootU = query.from(Usuario.class);

		Predicate equalLogin =builder.equal(rootU.get("login"), login);
		Predicate equalSenha = builder.equal(rootU.get("senha"), senha);
		
		query.where(equalLogin, equalSenha);
		
		try {
			Usuario usuarioLogado = this.em.createQuery(query).getSingleResult();
			return new UserSessionVO(usuarioLogado.getIdusuario().toString(),usuarioLogado.getNome(), usuarioLogado.getLogin());
		} catch (Exception e) {
			return null;
		}
	}

}
