USE ramirezFernando;

CREATE TABLE psicologo (
id INT PRIMARY KEY UNIQUE NOT NULL,
username VARCHAR (20) UNIQUE NOT NULL,
password VARCHAR (30) NOT NULL,
name VARCHAR(100) NOT NULL,
fechanacimiento DATE NOT NULL,
cedula VARCHAR(20) UNIQUE NOT NULL,
ciudadnacimiento VARCHAR (30),
fechagraduacion DATE NOT NULL,
diasservicio INT,
sesionesapoyadas INT,
salario INT NOT NULL
);

CREATE TABLE alcoholico (
id INT PRIMARY KEY UNIQUE NOT NULL,
username VARCHAR (20) UNIQUE NOT NULL,
password VARCHAR (30) NOT NULL,
name VARCHAR(100) NOT NULL,
fechanacimiento DATE NOT NULL,
cedula VARCHAR(20) UNIQUE NOT NULL,
ciudadnacimiento VARCHAR (30),
sesionesparticipadas INT,
apodo VARCHAR (50)
);

CREATE TABLE personaservicio(
id INT PRIMARY KEY UNIQUE NOT NULL,
username VARCHAR (20) UNIQUE NOT NULL,
password VARCHAR (30) NOT NULL,
name VARCHAR(100) NOT NULL,
fechanacimiento DATE NOT NULL,
cedula VARCHAR(20) UNIQUE NOT NULL,
ciudadnacimiento VARCHAR (30),
salario INT NOT NULL,
sesioneslimpiadas INT
);

CREATE TABLE administrador(
id INT PRIMARY KEY UNIQUE NOT NULL,
username VARCHAR (20) UNIQUE NOT NULL,
password VARCHAR (30) NOT NULL,
name VARCHAR(100) NOT NULL,
fechanacimiento DATE NOT NULL,
cedula VARCHAR(20) UNIQUE NOT NULL,
ciudadnacimiento VARCHAR (30)
);