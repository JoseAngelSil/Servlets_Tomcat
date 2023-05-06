package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;

@WebServlet(urlPatterns = "/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> listaEmpresas = new DB().getEmpresas();
		
		// importar la clase gson para crear un JSON
		Gson gson = new Gson();
		String json = gson.toJson(listaEmpresas);
		
		response.setContentType("Application/json"); // indicar como interpretar el retorno
		response.getWriter().print(json);
	}

}
