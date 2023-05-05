<%@page import="com.alura.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de empresas</title>
</head>
<body>

	<c:if test="${not empty empresa }">
		<h1>Empresa ${empresa } ha sido registrada!!!</h1>
		<br />
		<br />
	</c:if>

	<h2>Lista de empresas</h2>

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nombre }- <fmt:formatDate
					value="${empresa.fechaAbertura}" pattern="yy/MM/yyyy" /> <a
				href="/gerenciador/entrada?accion=EleminarEmpresa&id=${empresa.id }">Eleminar</a>
				<a
				href="/gerenciador/entrada?accion=MostrarEmpresa&id=${empresa.id }">Editar</a>
			</li>
		</c:forEach>
	</ul>
	<br>
	<br>
	<h3>Usuario: ${ loginUsuario.login}</h3>
	<c:import url="logout-parcial.jsp"></c:import>
</body>
</html>