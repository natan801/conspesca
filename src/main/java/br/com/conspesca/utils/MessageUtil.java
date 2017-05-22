package br.com.conspesca.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {

	public void sendMessageInfo(String titulo, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, titulo, message);
		messageContext(facesMessage);
	}

	public void sendMessageError(String titulo, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, titulo, message);
		messageContext(facesMessage);
	}

	private FacesMessage createMessage(Severity severity, String titulo, String mensagemErro) {
		return new FacesMessage(severity, titulo, mensagemErro);
	}

	private void messageContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
}
