package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PsychologistDTO;
import co.edu.unbosque.util.PsychologistCRUD;

public class PsychologistDAO implements PsychologistCRUD{

	private ArrayList<PsychologistDTO> psychologistList;
	
	public PsychologistDAO() {
		psychologistList = new ArrayList();
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

	public ArrayList<PsychologistDTO> getPsychologistList() {
		return psychologistList;
	}

	public void setPsychologistList(ArrayList<PsychologistDTO> psychologistList) {
		this.psychologistList = psychologistList;
	}
}
