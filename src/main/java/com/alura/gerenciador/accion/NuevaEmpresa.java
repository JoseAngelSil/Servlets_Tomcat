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

public class NuevaEmpresa implements Accion {
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
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
		
		empresa.setNombre(nombreEmpresa); 
		empresa.setFechaAbertura(fechaApertura);
		
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);
		
		// Direccionamiento por servidor
		return "redirect:entrada?accion=ListaEmpresas";
	}
}
