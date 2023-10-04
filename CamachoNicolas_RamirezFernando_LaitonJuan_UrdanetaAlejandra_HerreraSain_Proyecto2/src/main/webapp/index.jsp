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
<title>Alcohólicos Anónimos</title>
</head>
<head>
  <title>Selección de Rol</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-5">
    <h1 class="text-center">Elegir Rol</h1>
    <div class="d-flex justify-content-center">
      <form action="rolecontrollerservlet" method="post">
        <div class="form-group">
          <label for="role">Seleccione un rol:</label>
          <select class="form-control" id="role" name="role">
            <option value="administrador">Administrador</option>
            <option value="psicologo">Psicólogo</option>
            <option value="alcoholico">Alcohólico</option>
            <option value="persona_de_servicio">Persona de Servicio</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
      </form>
    </div>
  </div>
</body>
</html>