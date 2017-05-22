package br.com.conspesca.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.inject.Inject;

import br.com.conspesca.VO.UserSessionVO;
import br.com.conspesca.security.SessionSecurity;
import br.com.conspesca.utils.MessageUtil;

public class BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SessionSecurity sessionSecurity;

	protected UserSessionVO userSession;

	public void init() {
		this.userSession = this.sessionSecurity.getUserSession();
	}

	public String logout() throws IOException {
		MessageUtil messageUtil = new MessageUtil();

		this.sessionSecurity.logout();
		
		messageUtil.sendMessageInfo("Logout", "Logout realizado com sucesso !");
		
		return "/pages/pesquisaprincipal.xhtml";
	}

}
