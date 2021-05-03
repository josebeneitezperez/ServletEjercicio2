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
		<title>Listado de roles</title>
	</head>
	<body>
		<%!	//declaraciones java
		List<Roles> listaRoles = RolesDAO.getListaRoles();%>
		<%pageContext.setAttribute("listaRoles", listaRoles); %>
		
		<%@ include file="cabecera.jsp" %>
		
		<form action="" method="post">
			<table border="2">
				<tr>
				    <th>ID</th>
				    <th>Rol</th>
			    </tr>
			    <c:forEach items="${pageScope.listaRoles}" var="unRol" varStatus="status" begin="0" end="${pageScope.listaRoles.size() - 1}">
			        <tr>
			        	<!-- <td><input type="checkbox" id="chkItem${unRol.id}" name="listaRoles" value="${unRol.id}"></td>-->
			            <td><c:out value="${unRol.id}"></c:out></td>	
			            <td><c:out value="${unRol.rol}"></c:out></td>            
			        </tr>
			    </c:forEach>
			</table>
			<p class="center">			
			</p>
		</form>
		
	</body>
</html>