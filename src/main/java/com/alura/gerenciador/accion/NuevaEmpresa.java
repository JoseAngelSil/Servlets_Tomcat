package com.alura.gerenciador.accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresa {
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Empresa empresa = new Empresa(); // clase empresa
		String nombreEmpresa = request.getParameter("nombre");
		String fecha = request.getParameter("fecha");
		
		//formatear la fecha ingresada
		Date fechaApertura;
		try {
			SimpleDateFormat sDateformat = new SimpleDateFormat("dd/MM/yyy");
			fechaApertura = sDateformat.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			 throw new ServletException(e);	
		}
		
		empresa.setNombre(nombreEmpresa); // enviando el nombre de la empresa al objeto
		empresa.setFechaAbertura(fechaApertura);
		
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);
		
		// llamar el JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaempresas");
//		request.setAttribute("empresa", empresa.getNombre()); // enviar el nombre de la empresa
//		rd.forward(request, response);
		
		// Direccionamiento por servidor
		response.sendRedirect("entrada?accion=listaempresas");// se manda al servlet pero sin el caracter /	
	}
}
