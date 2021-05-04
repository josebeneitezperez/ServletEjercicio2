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
		List<Productos> listaProductos = ProductosDAO.getListaProductos();%>
		<%pageContext.setAttribute("listaProductos", listaProductos); %>
		
		<%@ include file="cabecera.jsp" %>
		
		<form action="" method="post">
			<table border="2">
				<tr>
				    <th>ID producto</th>
				    <th>ID categoría</th>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Precio</th>
					<th>Stock</th>
					<th>Fecha de alta</th>
					<th>Fecha de baja</th>
					<th>Impuesto</th>
			    </tr>
			    <c:forEach items="${pageScope.listaProductos}" var="unProducto" varStatus="status" begin="0" end="${pageScope.listaProductos.size() - 1}">
			        <tr>
			        	<!-- <td><input type="checkbox" id="chkItem${unRol.id}" name="listaRoles" value="${unRol.id}"></td>-->
			            <td><c:out value="${unProducto.id}"></c:out></td>	
						<td><c:out value="${unProducto.idCategoria}"></c:out></td>
						<td><c:out value="${unProducto.nombre}"></c:out></td>
						<td><c:out value="${unProducto.descripcion}"></c:out></td>
						<td><c:out value="${unProducto.precio}"></c:out></td>
						<td><c:out value="${unProducto.stock}"></c:out></td>
						<td><c:out value="${unProducto.fechaAlta}"></c:out></td>
						<td><c:out value="${unProducto.fechaBaja}"></c:out></td>
						<td><c:out value="${unProducto.impuesto}"></c:out></td>
			        </tr>
			    </c:forEach>
			</table>
			<p class="center">			
			</p>
		</form>
		
	</body>
</html>