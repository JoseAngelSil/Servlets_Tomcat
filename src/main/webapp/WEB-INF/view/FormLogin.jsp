<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServerNuevaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Alura</title>
</head>
<body>
	<h1>Formulario de empresa</h1>
	<form action="${linkServerNuevaEmpresa}" method="post">
		Nombre: <input type="text" name ="login"/> <br />
		Contraseña: <input type="password" name="pass"> <br />
		<input type="hidden" name="accion" value="Login"/>
		<input type="submit" />
	</form>
</body>
</html>