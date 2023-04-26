<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// esto se conoce como scriptlet
	String empresa = (String) request.getAttribute("empresa");
	System.out.println(empresa);
%>

<h1>Felicidades!!!</h1>
<p>La empresa <%= empresa %> ha sido registrada!!!</p> <!-- como se imprime una variable 
en JSP
 -->
</body>
</html>