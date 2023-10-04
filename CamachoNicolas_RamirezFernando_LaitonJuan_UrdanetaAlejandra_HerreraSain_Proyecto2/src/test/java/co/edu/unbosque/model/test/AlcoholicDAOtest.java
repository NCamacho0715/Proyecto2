package co.edu.unbosque.model.test;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import co.edu.unbosque.model.persistence.AlcoholicDAO;
	import co.edu.unbosque.model.AlcoholicDTO;

	public class AlcoholicDAOtest {
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
			AlcoholicDAO a = new AlcoholicDAO();
			a.create(new AlcoholicDTO(2, "patrix", "qwert", "patricio", new Date(1990, 8, 4), 111111, "bogota", 2, "juano"));
			contador++;
		}
		@Test
		public void createArgsTest() {
			AlcoholicDAO a = new AlcoholicDAO();
			a.create("2", "patrix", "qwert", "patricio",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota", "2", "juano");
			contador++;
		}
		@Test
		public void readAlltest() {
			AlcoholicDAO a = new AlcoholicDAO();
			String read = a.readAll();
			assertEquals("", read);
			contador++;
		}
		@Test
		public void readByNametest() {
			AlcoholicDAO a = new AlcoholicDAO();
			a.create(new AlcoholicDTO(2, "patrix", "qwert", "patricio", new Date(1990, 8, 4), 111111, "bogota", 2, "juano"));
			String read = a.readByName("patricio");
			assertEquals("Alcoholic [participatedSessions=" + 2 + ", nickname=" + "juano" + "]", read);
			contador++;
		}
		@Test
		public void updateByID() {
			AlcoholicDAO a = new AlcoholicDAO();
			int read = a.updateById(2, "2", "patrix", "qwert", "patricio",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota", "2", "juano");
			assertEquals(0, read);
					contador++;
		}
		@Test
		public void deleteByID() {
			AlcoholicDAO a = new AlcoholicDAO();
			int read = a.updateById(0);
			assertEquals(0, read);
			contador++;
		}


	}

