package br.com.conspesca.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.conspesca.VO.UserSession;
import br.com.conspesca.model.Usuario;
import br.com.conspesca.repository.UsuarioRepository;


@Stateless
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;

	public void salvar(Usuario usuario){
		this.usuarioRepository.save(usuario);
	}
	
	public Usuario findUsuarioByID(int id){
		return this.usuarioRepository.find(id);
	}
	
	public void removeUsuarioByID(int id){
		this.usuarioRepository.delete(id);
	}
	
	public List<Usuario> findAllUsuario(){
		return this.usuarioRepository.findAll();
	}
	
	public UserSession findUserSession(String login, String senha){
		return this.usuarioRepository.findUserSessionByUserSenha(login,senha);
	}
	
	
}
