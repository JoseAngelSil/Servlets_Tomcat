package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Usuario;
import com.thoughtworks.xstream.XStream;

@WebServlet(urlPatterns = "/usuarios")
public class UsuariosService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Usuario> listaUsuario = new DB().getUsuarios();
		XStream xstream = new XStream();
		// dar aliar a las etiquetas de xml
		xstream.alias("usuario", Usuario.class);
		String xml = xstream.toXML(listaUsuario);
		response.setContentType("Application/xml");
		response.getWriter().print(xml);
		
	}

}
