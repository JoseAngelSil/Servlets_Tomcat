<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServermodificarEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Empresa</title>
</head>
<body>
	<h1>Editar empresa ${empresa.nombre }</h1>
	<form action="${linkServermodificarEmpresa}" method="post">
		Nombre de la empresa: <input type="text" name ="nombre" value="${empresa.nombre }"/>
		fecha de abertura: <input type="text" name="fecha" value='<fmt:formatDate value="${empresa.fechaAbertura}" pattern="dd/MM/yyyy"/>'>
		<input type="hidden" name="id" value="${empresa.id }"/>
		<input type="hidden" name="accion" value="ModificarEmpresa"/>
		<input type="submit" />
	</form>
</html>