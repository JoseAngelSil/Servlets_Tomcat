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

public class ModificarEmpresa implements Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
		
		return "redirect:entrada?accion=ListaEmpresas";
	}
}
