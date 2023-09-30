package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.util.AlcoholicCRUD;

public class AlcoholicDAO implements AlcoholicCRUD {

	private ArrayList<AlcoholicDTO> alcoholicList;

	public AlcoholicDAO() {
		alcoholicList = new ArrayList();
	}

	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(String... args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateById(int id, String... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<AlcoholicDTO> getAlcoholicList() {
		return alcoholicList;
	}

	public void setAlcoholicList(ArrayList<AlcoholicDTO> alcoholicList) {
		this.alcoholicList = alcoholicList;
	}
}
