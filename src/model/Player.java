package model;

public class Player {
	
	//Atributos
	private String equipo;
	
	
	//Constructores
	public Player() {
		
	}
	
	public Player(String equipo) {
		this.equipo = equipo;
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
