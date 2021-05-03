<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
	<%@ include file="cabecera.jsp" %>
	
	<form action="listadoProductos.jsp" method="post">
		<input type="submit" name="listadoProductos" value="Listado de productos" class="button" />
	</form>
	
 	<c:choose>
        <c:when test="${sessionScope.rolUsuario == 'Admin'}">
        	<input type="button" disabled="disabled"/>
        </c:when>
        <c:otherwise>undefined</c:otherwise>
    </c:choose>
 	
</body>
</html>






