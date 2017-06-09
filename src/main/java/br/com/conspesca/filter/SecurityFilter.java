package br.com.conspesca.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.conspesca.VO.UserSessionVO;
import br.com.conspesca.security.SessionSecurity;

@WebFilter
public class SecurityFilter implements Filter{

	@Inject
	private SessionSecurity sessionSecurity;
	
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			if(httpServletRequest.getRequestURI().contains("resource")){
				chain.doFilter(request, response);
				return;
			}
		
			UserSessionVO userAuthentication = this.sessionSecurity.getUserAuthentication();
			
			String paginaAtual = httpServletRequest.getServletPath();
			
			
			if(userAuthentication==null 
				&& !paginaAtual.equalsIgnoreCase("/pages/login.xhtml") 
				&& !paginaAtual.equalsIgnoreCase("/pages/pesquisaprincipal.xhtml")
				&& !paginaAtual.equalsIgnoreCase("/pages/map.xhtml")){
				
				String contextPath = httpServletRequest.getContextPath(); 
				httpServletResponse.sendRedirect(contextPath+"/pages/login.xhtml");
				return;
			}
			
			
			
			chain.doFilter(request, response);
		
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
