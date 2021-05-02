<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, main.java.clasesDAO.*, main.java.clasesVO.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listado de roles</title>
	</head>
	<body>
		<%!	//declaraciones java
		List<Roles> listaRoles = RolesDAO.getListaRoles();%>
		<%pageContext.setAttribute("listaRoles", listaRoles); %>
		
		<h1>Bienvenido, ${sessionScope.nombreUsuario}</h1>
		<h3>Sesión iniciada el ${sessionScope.fechaHoraLogin}</h3>
		
		<form action="" method="post">
			<table border="2">
				<tr>
				    <th>ID</th>
				    <th>Rol</th>
			    </tr>
			    <c:forEach items="${pageScope.listaRoles}" var="unRol" varStatus="status" begin="0" end="${pageScope.listaRoles.size() - 1}">
			        <tr>
			        	<td><input type="checkbox" id="chkItem${unRol.id}" name="shopItems" value="${unRol.id}"></td>
			            <td><c:out value="${unRol.rol}"></c:out></td>	            
			        </tr>
			    </c:forEach>
			</table>
			<p class="center">			
			</p>
		</form>
		
	</body>
</html>