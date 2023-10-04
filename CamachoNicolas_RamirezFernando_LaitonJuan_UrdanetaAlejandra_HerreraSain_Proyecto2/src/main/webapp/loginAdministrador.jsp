<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>Panel de Administrador</title>
</head>
<body>
  <div class="container mt-5">
    <h2>Bienvenido al Panel de Administrador</h2>
    
    <h3>Opciones de visualización</h3>
    <ul>
      <li><a href="mostrarTablaAlcoholicos.jsp">Mostrar tabla de alcohólicos</a></li>
      <li><a href="mostrarTablaPsicologos.jsp">Mostrar tabla de psicólogos</a></li>
      <li><a href="mostrarTablaServicio.jsp">Mostrar tabla de personas de servicio</a></li>
    </ul>
    
    <h3>Crear usuario</h3>
    <ul>
      <li><a href="crearCuentaAlcoholico.jsp">Crear cuenta de alcohólico</a></li>
      <li><a href="crearCuentaPsicologo.jsp">Crear cuenta de psicólogo</a></li>
      <li><a href="crearCuentaServicio.jsp">Crear cuenta de persona de servicio</a></li>
    </ul>
  </div>
</body>
</html>
