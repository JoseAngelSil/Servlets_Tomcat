package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter implements Filter { 

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("Filtro de autorizacion");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String param = request.getParameter("accion");
		
		HttpSession session = request.getSession();
		Boolean esUsuarioLogueado = session.getAttribute("loginUsuario") == null;
		Boolean esAccionProtegida = !((param.equals("Login")) || (param.equals("LoginForm")));
		if(esUsuarioLogueado && esAccionProtegida){
			response.sendRedirect("entrada?accion=LoginForm"); 
			return;
		}
		
		chain.doFilter(request, response);
	}

}
