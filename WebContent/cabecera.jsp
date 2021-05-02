<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
	<h1>Bienvenido, ${sessionScope.nombreUsuario} con rol ${sessionScope.rolUsuario}</h1>
	<h3>Sesión iniciada el ${sessionScope.fechaHoraLogin}</h3>
	
	<form action="altaRol.jsp" method="post">
		<input type="submit" name="submit" value="Dar de alta un rol" class="button" />
	</form>
	
	<form action="altaUsuario.jsp" method="post">
		<input type="submit" name="submit" value="Dar de alta un usuario" class="button" />
	</form>
	
	<form action="listadoRoles.jsp" method="post">
		<input type="submit" name="submit" value="Listado de roles" class="button" />
	</form>
	
	<form action="listadoUsuarios.jsp" method="post">
		<input type="submit" name="submit" value="Listado de usuarios" class="button" />
	</form>
</body>
</html>