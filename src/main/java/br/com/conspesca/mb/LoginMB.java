package br.com.conspesca.mb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.conspesca.VO.UserSessionVO;
import br.com.conspesca.security.SessionSecurity;
import br.com.conspesca.service.UsuarioService;
import br.com.conspesca.utils.MessageUtil;

@Named
@RequestScoped
public class LoginMB {

	private String login;
	private String senha;

	@EJB
	private UsuarioService usuarioService;

	@Inject
	private SessionSecurity sessionSecurity;

	public String logar() {

		UserSessionVO userSession = this.usuarioService.findUserSession(this.login, this.senha);

		if (userSession == null) {
			MessageUtil message = new MessageUtil();
			message.sendMessageError("", "Login/Senha inválido");
		} else {
			this.sessionSecurity.authenticationUser(userSession);
			return "/pages/pesquisaprincipal.xhtml?faces-redirect=true";
		}

		return null;
	}

	public String logout() throws IOException {
		MessageUtil messageUtil = new MessageUtil();

		this.sessionSecurity.logout();

		messageUtil.sendMessageInfo("Logout", "Logout realizado com sucesso !");

		return "/pages/pesquisaprincipal.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
