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
<body>

	<form action="alcoholiccontrollerservlet">
		<div class="input-group mb-3">
			<span class="input-group-text">@</span>
			<div class="form-floating">
				<input type="text" class="form-control" id="username" name="username"
					placeholder="Username"> <label for="username">Username</label>
			</div>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text"></span>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					placeholder="Password"> <label for="password">Password</label>
			</div>
		</div>
		
		<input type="submit" value="login">
	</form>
	

	<div class="container mt-5">
		<h1>Control Médico</h1>
		<div class="row">
			<div class="col">
				<h2>Visitantes</h2>
				<button class="btn btn-primary" data-toggle="modal"
					data-target="#addVisitorModal">Agregar Visitante</button>
				<table class="table table-bordered mt-3">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Apodo</th>
							<th>Sesiones Participadas</th>
						</tr>
					</thead>
					<tbody>
						<!-- Aquí irán los datos de los visitantes -->
					</tbody>
				</table>
			</div>
			<div class="col">
				<h2>Psicólogos</h2>
				<button class="btn btn-primary" data-toggle="modal"
					data-target="#addPsychologistModal">Agregar Psicólogo</button>
				<table class="table table-bordered mt-3">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Año de Graduación</th>
							<th>Días en Servicio</th>
							<th>Sesiones Apoyadas</th>
							<th>Salario</th>
						</tr>
					</thead>
					<tbody>
						<!-- Aquí irán los datos de los psicólogos -->
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Modal para agregar visitante -->
	<div class="modal" id="addVisitorModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Aquí iría el formulario para agregar un visitante -->
			</div>
		</div>
	</div>

	<!-- Modal para agregar psicólogo -->
	<div class="modal" id="addPsychologistModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Aquí iría el formulario para agregar un psicólogo -->
			</div>
		</div>
	</div>

</body>
</html>