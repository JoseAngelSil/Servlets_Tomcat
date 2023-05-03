package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Class;

import com.alura.gerenciador.accion.Accion;
import com.alura.gerenciador.accion.EleminarEmpresa;
import com.alura.gerenciador.accion.ListaEmpresas;
import com.alura.gerenciador.accion.ModificarEmpresa;
import com.alura.gerenciador.accion.MostrarEmpresa;
import com.alura.gerenciador.accion.NuevaEmpresa;
import com.alura.gerenciador.accion.NuevaEmpresaForm;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("accion");
		String nombreClase = "com.alura.gerenciador.accion." + param;
		String uri = null;

		try {
			Class clase = Class.forName(nombreClase);
			@SuppressWarnings("deprecation")
			Accion accion = (Accion) clase.newInstance();
			uri = accion.ejecutar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		String[] tipoURI = uri.split(":");
		if (tipoURI[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoURI[1]);
			rd.forward(request, response);
		} else if (tipoURI[0].equals("redirect")) {
			response.sendRedirect(tipoURI[1]);
		}
/*
		if (param.equals("listaempresas")) {
			ListaEmpresas accion = new ListaEmpresas();
			uri = accion.ejecutar(request, response);
		} else if (param.equals("mostrarempresa")) {
			MostrarEmpresa accion = new MostrarEmpresa();
			uri = accion.ejecutar(request, response);
		} else if (param.equals("eleminarempresa")) {
			EleminarEmpresa accionEleminar = new EleminarEmpresa();
			uri = accionEleminar.ejecutar(request, response);
		} else if (param.equals("modificarempresa")) {
			ModificarEmpresa accionModificar = new ModificarEmpresa();
			uri = accionModificar.ejecutar(request, response);
		} else if (param.equals("nuevaempresa")) {
			NuevaEmpresa accionNueva = new NuevaEmpresa();
			uri = accionNueva.ejecutar(request, response);
		} else if (param.equals("nuevaEmpresaForm")) {
			NuevaEmpresaForm accionNueva = new NuevaEmpresaForm();
			uri = accionNueva.ejecutar(request, response);
		}
		*/
	}

}
