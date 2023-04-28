package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ModificarEmpresaServlet
 */
public class ModificarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = new Empresa(); // clase empresa
		String nombreEmpresa = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		//formatear la fecha ingresada
		Date fechaApertura;
		try {
			SimpleDateFormat sDateformat = new SimpleDateFormat("dd/MM/yyy");
			fechaApertura = sDateformat.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			 throw new ServletException(e);	
		}
		
		DB baseDeDatos = new DB();
		empresa = baseDeDatos.buscarEmpresaID(id);
		empresa.setNombre(nombreEmpresa);
		empresa.setFechaAbertura(fechaApertura);
		
		
		
		response.sendRedirect("listaempresas");
	}

}
