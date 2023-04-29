package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alura.gerenciador.accion.EleminarEmpresa;
import com.alura.gerenciador.accion.ListaEmpresas;
import com.alura.gerenciador.accion.ModificarEmpresa;
import com.alura.gerenciador.accion.MostrarEmpresa;
import com.alura.gerenciador.accion.NuevaEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("accion");
		if(param.equals("listaempresas")) {
			ListaEmpresas accion = new ListaEmpresas();
			accion.ejecutar(request, response);
		} else if (param.equals("mostrarempresa")) {
			MostrarEmpresa accion = new MostrarEmpresa();
			accion.ejecutar(request, response);
		}else if (param.equals("eleminarempresa")) {
			EleminarEmpresa accionEleminar = new EleminarEmpresa();
			accionEleminar.ejecutar(request, response);
		}else if (param.equals("modificarempresa")) {
			ModificarEmpresa accionModificar = new ModificarEmpresa();
			accionModificar.ejecutar(request, response);
		}else if (param.equals("nuevaempresa")) {
			NuevaEmpresa accionNueva = new NuevaEmpresa();
			accionNueva.ejecutar(request, response);
		}
	}

}
