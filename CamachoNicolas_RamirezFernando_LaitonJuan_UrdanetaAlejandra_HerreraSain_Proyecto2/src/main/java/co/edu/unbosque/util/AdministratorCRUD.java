package co.edu.unbosque.util;

public interface AdministratorCRUD {

	public void create(Object o);

	public void create(String... args);

	public String readAll();

	public String readByName(String name);

	public int updateById(int id, String... args);

	public int deleteById(int id);
}