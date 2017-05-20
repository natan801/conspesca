package br.com.conspesca.mb;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.conspesca.VO.UserSession;
import br.com.conspesca.security.SessionSecurity;
import br.com.conspesca.service.UsuarioService;

@Named
@RequestScoped
public class LoginMB {
	
	private String login;
	private String senha;
	
	@EJB
	private UsuarioService usuarioService;
	
	@Inject
	private SessionSecurity sessionSecurity;
	
	public String logar(){
		
		UserSession userSession = this.usuarioService.findUserSession(this.login, this.senha);
		
		if(userSession == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Inválido","Usuário Inválido"));
			
		}else{
			this.sessionSecurity.authenticationUser(userSession);
			return "pesquisaprincipal";
		}
		
		return null;
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
