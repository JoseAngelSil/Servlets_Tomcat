package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String paramLogin = request.getParameter("login");
		String paramContrasena = request.getParameter("pass");
		
		DB db = new DB();
		Usuario user = db.existeUsuario(paramLogin, paramContrasena);
		if(user != null) {
			HttpSession sesion = request.getSession(); // obteniendo la sesion de tomcat, relacionado a un usuario
			sesion.setAttribute("loginUsuario", user);
			return "redirect:entrada?accion=ListaEmpresas";
		}else
			return "redirect:entrada?accion=LoginForm";
	}

}
