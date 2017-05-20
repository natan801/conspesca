package br.com.conspesca.mb;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.conspesca.VO.UserSession;
import br.com.conspesca.security.SessionSecurity;

public class BaseMB  implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Inject
	private SessionSecurity sessionSecurity;
	
	protected UserSession userSession;
	
	
	public void init(){
		this.userSession = this.sessionSecurity.getUserSession();
	}
	
	public void logout(){
		
	}
	
}
