package br.com.conspesca.security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.conspesca.VO.UserSession;

@Named
@SessionScoped
public class SessionSecurity implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	
	private UserSession userSession;

	public UserSession getUserAuthentication(){
		
		return this.userSession;
	}
	
	
	public UserSession getUserSession() {
		return this.userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}


	public void authenticationUser(UserSession userSessionAutenticado) {
		
		this.userSession = userSessionAutenticado;
		
	}
	
	public void logout() throws IOException{
		this.userSession = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
	
	
}
