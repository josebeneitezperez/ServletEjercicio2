<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link href="formulario_estilo.css" rel="stylesheet" type="text/css">
		<title>Alta categoría</title>
	</head>
	
	<body>
		<form name="formularioRol" action="AltaCategoria" method="post">
			<fieldset>
			  <legend>Dar de alta una categoría</legend>

			  <label for="nombre">Nombre de la categoría</label>
			  <input name="nombre" type="text" />
			  
			  <label for="descripcion">Descripción</label>
			  <input name="descripcion" type="text" />
			  
			  <input type="submit" class="boton" value="Dar de alta" />
			</fieldset>
		</form>
	<body>
</html>