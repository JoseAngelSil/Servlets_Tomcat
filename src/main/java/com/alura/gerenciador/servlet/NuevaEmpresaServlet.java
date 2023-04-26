package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
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
		Empresa empresa = new Empresa(); // clase empresa
		String nombreEmpresa = request.getParameter("nombre");
		
		empresa.setNombre(nombreEmpresa); // enviando el nombre de la empresa al objeto
		
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);
		
		// llamar el JSP
		RequestDispatcher rd = request.getRequestDispatcher("/nuevaEmpresaRegistrada.jsp");
		request.setAttribute("empresa", empresa.getNombre()); // enviar el nombre de la empresa
		rd.forward(request, response);
		
	}

}
