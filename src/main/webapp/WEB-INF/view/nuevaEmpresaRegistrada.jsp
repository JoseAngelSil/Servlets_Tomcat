<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>
	<c:if test="${not empty empresa }">
		<h1>La empresa ${empresa} ha sido registrada!!!</h1>
	</c:if>
	<c:if test="${empty empresa }">
		<h1>Ninguna empresa registrada</h1>
	</c:if>

</body>
</html>