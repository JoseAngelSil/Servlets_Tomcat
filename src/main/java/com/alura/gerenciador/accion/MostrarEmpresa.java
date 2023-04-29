package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarEmpresa {
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Mostrar Empresa");
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID); // castear
		
		DB db = new DB();
		Empresa empBuscada = db.buscarEmpresaID(id);
		System.out.println(empBuscada.getNombre());
		
		request.setAttribute("empresa", empBuscada);
		RequestDispatcher rd = request.getRequestDispatcher("/formModificarEmpresa.jsp");
		rd.forward(request, response);
	}
}
