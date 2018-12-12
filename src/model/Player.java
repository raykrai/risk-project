package model;

public class Player {
	
	//Atributos
	private String equipo;
	
	
	//Constructores
	public Player(String equipo) {
		this.equipo = equipo;
	}
	
	public Player() {
	
	}

	//Getters y setters
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	
	//toString
	@Override
	public String toString() {
		return "Player [equipo=" + equipo + "]";
	}
	
	
	
	
	
	
	
	

}
