package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class NuevaEmpresaServlet
 */
public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// cambiando el estado service a dopost para evitar el envio por metodo get
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Crear una respuesta
		System.out.println("Nueva empresa registrada");
		// metodo para recibir parametros con el caso de parametro nombre
		String nombreEmpresa = request.getParameter("nombre");
		
		PrintWriter out = response.getWriter();
		out.println("<html> "
				+ "<body><h1>"+nombreEmpresa+" empresa registrada!!</h1></body>"
				+ "</html>");
	}

}
