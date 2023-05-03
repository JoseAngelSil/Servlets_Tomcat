package com.alura.gerenciador.accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaForm implements Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		return  "forward:FormNuevaEmpresa.jsp";
	}
}
