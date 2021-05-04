<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<link href="formulario_estilo.css" rel="stylesheet" type="text/css">
		<title>Alta producto</title>
	</head>
	
	<body>
		<form name="formularioRol" action="AltaRol" method="post">
			<fieldset>
			  <legend>Dar de alta un producto</legend>

				<label for="id">ID del producto</label>
			  <input name="id" type="text" />
			  
			  <label for="categoria">Categoría del producto</label>
			  <input name="categoria" type="text" />
			  
			  <label for="nombre">Nombre del producto</label>
			  <input name="nombre" type="text" />
			  
			  <label for="descripcion">Descripción del producto</label>
			  <input name="descripcion" type="text" />
			  
			  <label for="precio">Precio del producto</label>
			  <input name="precio" type="text" />
			  
			  <label for="stock">Stock del producto</label>
			  <input name="stock" type="text" />
			  
			  <label for="fechaAlta">Fecha de alta</label>
			  <input name="fechaAlta" type="text" />
			  
			  <label for="fechaBaja">Fecha de baja</label>
			  <input name="fechaBaja" type="text" />
			  
			  <label for="impuesto">Impuesto</label>
			  <input name="impuesto" type="text" />

			  <input type="submit" class="boton" value="Dar de alta" />
			</fieldset>
		</form>
	<body>
</html>