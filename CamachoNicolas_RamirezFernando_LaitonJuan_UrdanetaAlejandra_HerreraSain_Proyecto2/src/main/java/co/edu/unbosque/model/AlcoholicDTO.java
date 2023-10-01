package co.edu.unbosque.model;

public class AlcoholicDTO extends PersonDTO {

	private int participatedSessions;
	private String nickname;

	public AlcoholicDTO() {
		// TODO Auto-generated constructor stub
	}

	public AlcoholicDTO(int participatedSessions, String nickname) {
		super();
		this.participatedSessions = participatedSessions;
		this.nickname = nickname;
	}

	public AlcoholicDTO(int id, String username, String password, String name, Date birthDate, int identityDoc,
			String birthCity) {
		super(id, username, password, name, birthDate, identityDoc, birthCity);
		// TODO Auto-generated constructor stub
	}
	public AlcoholicDTO(int id, String username, String password, String name, Date birthDate, int identityDoc,
			String birthCity, int participatedSessions, String nickname) {
		super(id, username, password, name, birthDate, identityDoc, birthCity);
		this.participatedSessions = participatedSessions;
		this.nickname = nickname;
	}


	public int getParticipatedSessions() {
		return participatedSessions;
	}

	public void setParticipatedSessions(int participatedSessions) {
		this.participatedSessions = participatedSessions;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Alcoholic [participatedSessions=" + participatedSessions + ", nickname=" + nickname + "]";
	}
}
