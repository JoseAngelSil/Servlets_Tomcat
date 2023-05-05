<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServerNuevaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>
	<h1>Formulario de empresa</h1>
	<form action="${linkServerNuevaEmpresa}" method="post">
		Nombre de la empresa: <input type="text" name ="nombre"/>
		fecha de abertura: <input type="text" name="fecha">
		<input type="hidden" name="accion" value="NuevaEmpresa"/>
		<input type="submit" />
	</form>
</body>
</html>