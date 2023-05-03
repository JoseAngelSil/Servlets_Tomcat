package com.alura.gerenciador.accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListaEmpresas implements Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Listando de empresa");
		// TODO Auto-generated method stub
		DB database = new DB();
		List<Empresa> listasEmpresas = database.getEmpresas();

		request.setAttribute("empresas", listasEmpresas);
		return "forward:listaEmpresas.jsp";
	}

	

}
