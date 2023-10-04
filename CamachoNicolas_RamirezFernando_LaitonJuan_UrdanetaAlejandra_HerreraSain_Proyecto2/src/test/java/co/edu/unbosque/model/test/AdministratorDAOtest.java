package co.edu.unbosque.model.test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import co.edu.unbosque.model.persistence.AdministratorDAO;
	import co.edu.unbosque.model.AdministratorDTO;

	public class AdministratorDAOtest {
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
			AdministratorDAO a = new AdministratorDAO();
			a.create(new AdministratorDTO(2, "patriu", "qwertiu", "patriciu", new Date(1990, 8, 4), 111111, "bogota"));
			contador++;
		}
		@Test
		public void createArgsTest() {
			AdministratorDAO a = new AdministratorDAO();
			a.create("2", "patriu", "qwertiu", "patriciu",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota");
			contador++;
		}
		@Test
		public void readAlltest() {
			AdministratorDAO a = new AdministratorDAO();
			String read = a.readAll();
			assertEquals("", read);
			contador++;
		}
		@Test
		public void readByNametest() {
			AdministratorDAO a = new AdministratorDAO();
			a.create(new AdministratorDTO(2, "patriu", "qwertiu", "patriciu", new Date(1990, 8, 4), 111111, "bogota"));
			String read = a.readByName("patricio");
			assertEquals("Administrator [salary=" + 2 + ", cleanedSessions=" + 2 + "]", read);
			contador++;
		}
		@Test
		public void updateByID() {
			AdministratorDAO a = new AdministratorDAO();
			int read = a.updateById(2, "2", "patrixu", "qwertu", "patriciu",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota");
			assertEquals(0, read);
					contador++;
		}
		@Test
		public void deleteByID() {
			AdministratorDAO a = new AdministratorDAO();
			int read = a.updateById(0);
			assertEquals(0, read);
			contador++;
		}


	}

