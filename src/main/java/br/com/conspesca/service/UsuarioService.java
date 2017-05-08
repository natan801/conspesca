package br.com.conspesca.service;

import java.util.List;

import br.com.conspesca.model.Usuario;
import br.com.conspesca.repository.UsuarioRepository;

public class UsuarioService {

	UsuarioRepository usuarioRepository = new UsuarioRepository();

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
	
}
