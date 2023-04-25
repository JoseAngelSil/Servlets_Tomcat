package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//hola
@WebServlet(urlPatterns = "/hola") // anotacion de webservlet en que la url del servicio pueda comprender
// con el url completo http://localhost:8080/gerenciador/hola
public class HolaMundoServlet extends HttpServlet{ // importar la clase HttpServlet
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		// enviar pagina web
		PrintWriter out = resp.getWriter();
		out.println("<html>");// envia al navegaror
		out.println("<head>");// envia al navegaror
		out.println("</head>");// envia al navegaror
		out.println("<body>");// envia al navegaror
		out.println("<h1>Hola mundo desde servlet</h1>");// envia al navegaror
		out.println("<p> este es mi parrafo</h1>");// envia al navegaror
		out.println("</body>");// envia al navegaror
		out.println("</html>");// envia al navegaror
		
		System.out.println("Se ejecuto el servlet");
	}	
}
