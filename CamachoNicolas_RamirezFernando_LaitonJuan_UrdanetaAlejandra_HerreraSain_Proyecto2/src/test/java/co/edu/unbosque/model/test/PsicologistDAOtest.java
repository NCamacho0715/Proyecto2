package co.edu.unbosque.model.test;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import co.edu.unbosque.model.persistence.PsychologistDAO;
	import co.edu.unbosque.model.PsychologistDTO;

	public class PsicologistDAOtest {
		private static int contador = 0;

		// solo se puede ejecutar una vez y solo puede haber una copia
		@BeforeAll
		public static void saludoInicio() {
			System.out.println("iniciando todas las pruebas unitarias...");

		}

		@AfterAll
		public static void saludoFin() {
			System.out.println("se han ejecutado" + contador + "test...");

		}

		@BeforeEach
		public void saludoAntesDe() {
			System.out.println("iniciando la prueba numero" + contador);

		}

		@AfterEach
		public void saludoDespuesDe() {
			System.out.println("finalizando la prueba numero" + (contador - 1));

		}

		@Test
		public void createObjTest() {
			PsychologistDAO a = new PsychologistDAO();
			a.create(new PsychologistDTO(2, "patri", "qwerti", "patricio", new Date(1990, 8, 4), 111111, "bogota", new Date(1990, 8, 4), 5, 5, 5));
			contador++;
		}
		@Test
		public void createArgsTest() {
			PsychologistDAO a = new PsychologistDAO();
			a.create("2", "patri", "qwerti", "patricio",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota", String.valueOf(new Date(1990, 8, 4)), "5", "5", "5");
			contador++;
		}
		@Test
		public void readAlltest() {
			PsychologistDAO a = new PsychologistDAO();
			String read = a.readAll();
			assertEquals("", read);
			contador++;
		}
		@Test
		public void readByNametest() {
			PsychologistDAO a = new PsychologistDAO();
			a.create(new PsychologistDTO(2, "patri", "qwerti", "patricio", new Date(1990, 8, 4), 111111, "bogota", new Date(1990, 8, 4), 5, 5, 5));
			String read = a.readByName("patricio");
			assertEquals("Psychologist [salary=" + 2 + ", cleanedSessions=" + 2 + "]", read);
			contador++;
		}
		@Test
		public void updateByID() {
			PsychologistDAO a = new PsychologistDAO();
			int read = a.updateById(2, "2", "patrix", "qwert", "patricio",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota", String.valueOf(new Date(1990, 8, 4)), "5", "5", "5");
			assertEquals(0, read);
					contador++;
		}
		@Test
		public void deleteByID() {
			PsychologistDAO a = new PsychologistDAO();
			int read = a.updateById(0);
			assertEquals(0, read);
			contador++;
		}


	}

