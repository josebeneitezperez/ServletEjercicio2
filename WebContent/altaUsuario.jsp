<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta usuario</title>
</head>
<body>
	<h1>Bienvenido, ${sessionScope.nombreUsuario}</h1>
	<h3>Sesión iniciada el ${sessionScope.fechaHoraLogin}</h3>
	<%@ include file="altaUsuario.html" %>
	
</body>
</html>