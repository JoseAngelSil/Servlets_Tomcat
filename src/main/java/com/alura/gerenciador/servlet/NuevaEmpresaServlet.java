package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		//System.out.println("Nueva empresa registrada");
		// metodo para recibir parametros con el caso de parametro nombre
		
		Empresa empresa = new Empresa(); // clase empresa
		String nombreEmpresa = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");
		System.out.println("fecha: "+fecha);
		
		//formatear la fecha ingresada
		Date fechaApertura;
		try {
			SimpleDateFormat sDateformat = new SimpleDateFormat("dd/MM/yyy");
			fechaApertura = sDateformat.parse(fecha);
			System.out.println("fechaApertura: " + fechaApertura);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			 throw new ServletException(e);	
		}
		
		empresa.setNombre(nombreEmpresa); // enviando el nombre de la empresa al objeto
		empresa.setFechaAbertura(fechaApertura);
		System.out.println("empresa.getFecha: " + empresa.getFechaAbertura());
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);
		
		// llamar el JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaempresas");
//		request.setAttribute("empresa", empresa.getNombre()); // enviar el nombre de la empresa
//		rd.forward(request, response);
		
		// Direccionamiento por servidor
		response.sendRedirect("listaempresas");// se manda al servlet pero sin el caracter /	
		
	}

}
