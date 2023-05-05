package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.Class;

import com.alura.gerenciador.accion.Accion;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("accion");
		
		HttpSession session = request.getSession();
		Boolean esUsuarioLogueado = session.getAttribute("loginUsuario") == null;
		Boolean esAccionProtegida = !((param.equals("Login")) || (param.equals("LoginForm")));
		if(esUsuarioLogueado && esAccionProtegida){
			response.sendRedirect("entrada?accion=LoginForm"); 
			return;
		}
		
		String nombreClase = "com.alura.gerenciador.accion." + param;
		String uri = null;

		try {
			Class clase = Class.forName(nombreClase);
			@SuppressWarnings("deprecation")
			Accion accion = (Accion) clase.newInstance();
			uri = accion.ejecutar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		String[] tipoURI = uri.split(":");
		if (tipoURI[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoURI[1]);
			rd.forward(request, response);
		} else if (tipoURI[0].equals("redirect")) {
			response.sendRedirect(tipoURI[1]);
		}
	}

}
