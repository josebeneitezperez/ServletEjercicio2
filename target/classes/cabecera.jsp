<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Bienvenido, ${session.nombreUsuario} con rol ${sessionScope.rolUsuario}</h1>
	<h3>Sesión iniciada el ${sessionScope.fechaHoraLogin}</h3>
	
	<form action="${sessionScope.urlAnterior}" method="post">
		<input type="submit" name="volver" value="Volver" class="button" />
	</form>
	
	<form action="<%session.invalidate();%> login.html" method="post">
		<input type="submit" name="cerrar" value="Cerrar sesión" class="button" />
	</form>
	<br>
</body>
</html>