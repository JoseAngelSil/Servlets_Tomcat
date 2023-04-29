package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EleminarEmpresa {
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("eleminadoEmpresa");
		// TODO Auto-generated method stub
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID); // castear
		
		System.out.println(id);
		
		DB db = new DB();
		db.eleminarEmpresa(id);
		response.sendRedirect("entrada?accion=listaempresas");
	}
}
