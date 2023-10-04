package co.edu.unbosque.model.test;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import co.edu.unbosque.model.persistence.ServicePersonDAO;
	import co.edu.unbosque.model.ServicePersonDTO;

	public class ServicePersonDAOtest {
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
			ServicePersonDAO a = new ServicePersonDAO();
			a.create(new ServicePersonDTO(2, "patri", "qwerti", "patricio", new Date(1990, 8, 4), 111111, "bogota", 2, 2));
			contador++;
		}
		@Test
		public void createArgsTest() {
			ServicePersonDAO a = new ServicePersonDAO();
			a.create("2", "patri", "qwerti", "patricio",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota", "2", "2");
			contador++;
		}
		@Test
		public void readAlltest() {
			ServicePersonDAO a = new ServicePersonDAO();
			String read = a.readAll();
			assertEquals("", read);
			contador++;
		}
		@Test
		public void readByNametest() {
			ServicePersonDAO a = new ServicePersonDAO();
			a.create(new ServicePersonDTO(2, "patri", "qwerti", "patricio", new Date(1990, 8, 4), 111111, "bogota", 2, 2));
			String read = a.readByName("patricio");
			assertEquals("ServicePerson [salary=" + 2 + ", cleanedSessions=" + 2 + "]", read);
			contador++;
		}
		@Test
		public void updateByID() {
			ServicePersonDAO a = new ServicePersonDAO();
			int read = a.updateById(2, "2", "patrix", "qwert", "patricio",String.valueOf(new Date(1990, 8, 4)), "111111", "bogota", "2", "2");
			assertEquals(0, read);
					contador++;
		}
		@Test
		public void deleteByID() {
			ServicePersonDAO a = new ServicePersonDAO();
			int read = a.updateById(0);
			assertEquals(0, read);
			contador++;
		}


	}

