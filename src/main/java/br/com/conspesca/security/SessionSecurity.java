package br.com.conspesca.security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.conspesca.VO.UserSessionVO;

@Named
@SessionScoped
public class SessionSecurity implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	
	private UserSessionVO userSession;

	public UserSessionVO getUserAuthentication(){
		
		return this.userSession;
	}
	
	
	public UserSessionVO getUserSession() {
		return this.userSession;
	}

	public void setUserSession(UserSessionVO userSession) {
		this.userSession = userSession;
	}


	public void authenticationUser(UserSessionVO userSessionAutenticado) {
		
		this.userSession = userSessionAutenticado;
		
	}
	
	public void logout() throws IOException{
		this.userSession = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
	
	
}
