package model;

public class Player {
	
	//Atributos, canT significa cantidad Tropas
	private String equipo;
	private int canT;
	
	//Constructores
	public Player() {
		
	}
	
	public Player(String equipo, int canT) {
		this.equipo = equipo;
		this.canT = canT;
	}

	//Getters y setters
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getCanT() {
		return canT;
	}

	public void setCanT(int canT) {
		this.canT = canT;
	}

	//toString
	@Override
	public String toString() {
		return "Player [equipo=" + equipo + "]";
	}
	
	
	

}
