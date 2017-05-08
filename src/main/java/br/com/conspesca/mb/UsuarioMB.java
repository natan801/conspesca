package br.com.conspesca.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.conspesca.model.Usuario;
import br.com.conspesca.service.UsuarioService;

@Named("usuarioMB")
@RequestScoped
public class UsuarioMB {
	private List<Usuario> usuarios;
	private Usuario usuario;
	private Date data;

	private UsuarioService usuarioService;

	public UsuarioMB() {
		this.usuarios = new ArrayList<>();
		this.usuario = new Usuario();
		this.usuarioService = new UsuarioService();
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		
		this.usuarios = this.usuarioService.findAllUsuario();
		return this.usuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String salvar() {

		this.usuarioService.salvar(this.usuario);

		return "consultausuario";

	}

	public String criarNovo() {
		this.usuario = new Usuario();
		return "cadastrousuario";
	}

	public String verDetalhe(Usuario usuario) {
		this.usuario = usuario;
		return "editausuario";
	}

	public String remover(Usuario usuario) {
		this.usuarioService.removeUsuarioByID(usuario.getIdusuario());
		return "consultausuario";
	}
}
