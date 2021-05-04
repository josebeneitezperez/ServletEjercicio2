<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.*, main.java.clasesDAO.*, main.java.clasesVO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado de usuarios</title>
	</head>
	<body>
		<%!	//declaraciones java
		List<Usuarios> listaUsuarios = UsuariosDAO.getListaUsuarios();%>
		<%pageContext.setAttribute("listaUsuarios", listaUsuarios); %>
		
		<%@ include file="cabecera.jsp" %>
		
		<form action="" method="post">
			<table border="2">
				<tr>
				    <th>ID usuario</th>
				    <th>ID rol</th>
				    <th>Correo electrónico</th>
				    <!-- <th>Clave</th>	-->
				    <th>Primer apellido</th>
				    <th>Segundo apellido</th>
				    <th>Dirección</th>
				    <th>Localidad</th>
				    <th>Provincia</th>
				    <th>Teléfono</th>
				    <th>DNI</th>
			    </tr>
			    <c:forEach items="${pageScope.listaUsuarios}" var="usuario" varStatus="status" begin="0" end="${pageScope.listaUsuarios.size() - 1}">
			        <tr>
			        	<!--<td><input type="checkbox" id="chkItem${usuario.id}" name="listaUsuarios" value="${usuario.id}"></td> -->
			            <td><c:out value="${usuario.id}"></c:out></td>	
			            <td><c:out value="${usuario.idRol}"></c:out></td>
			            <td><c:out value="${usuario.email}"></c:out></td>  
			            <td><c:out value="${usuario.apellido1}"></c:out></td>  
			            <td><c:out value="${usuario.apellido2}"></c:out></td>  
			            <td><c:out value="${usuario.direccion}"></c:out></td>  
			            <td><c:out value="${usuario.localidad}"></c:out></td>  
			            <td><c:out value="${usuario.provincia}"></c:out></td> 
			            <td><c:out value="${usuario.telefono}"></c:out></td> 
			            <td><c:out value="${usuario.dni}"></c:out></td>      
			        </tr>
			    </c:forEach>
			</table>
			<p class="center">			
			</p>
		</form>
		
	</body>
</html>