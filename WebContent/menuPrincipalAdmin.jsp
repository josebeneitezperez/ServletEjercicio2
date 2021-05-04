<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú</title>
</head>
<body>
	<%@ include file="cabecera.jsp" %>
	
	<!-- /jsp/altaRol.jsp -->
	<a href="<%=request.getContextPath() %>/altaRol.jsp">Dar de alta un rol</a>
	
	<form action="altaUsuario.jsp" method="post">
		<input type="submit" name="altaUsuario" value="Dar de alta un usuario" class="button" />
	</form>
	
	<form action="listadoRoles.jsp" method="post">
		<input type="submit" name="listadoRoles" value="Listado de roles" class="button" />
	</form>
	
	<form action="listadoUsuarios.jsp" method="post">
		<input type="submit" name="listadoUsuarios" value="Listado de usuarios" class="button" />
	</form>
	
	<!-- -->
	<form action="altaProducto.jsp" method="post">
		<input type="submit" name="altaProductos" value="Alta de productos" class="button" />
	</form>
	
	<form action="altaCategoria.jsp" method="post">
		<input type="submit" name="altaCategorias" value="Alta de categorías" class="button" />
	</form>
	
	<form action="listadoProductos.jsp" method="post">
		<input type="submit" name="listadoProductos" value="Listado de productos" class="button" />
	</form>
	
	<form action="listadoCategorias.jsp" method="post">
		<input type="submit" name="listadoCategorias" value="Listado de categorías" class="button" />
	</form>
 	
 	<!--
 	<c:choose>
        <c:when test="${sessionScope.rolUsuario == 'Admin'}">
        	<input type="button" disabled="disabled"/>
        </c:when>
        <c:otherwise>undefined</c:otherwise>
    </c:choose>
 	-->
 	
</body>
</html>








