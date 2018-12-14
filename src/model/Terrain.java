package model;

public class Terrain {
	
	//Atributos
	
	private String tipo;
	private int canT;
	
	//TODO Preguntar a Ángel si es buena idea tener un atributo equipo en terreno.
	private String equipo;
	
	//Constructores
	
	public Terrain() {
		
	}
	
	public Terrain(String tipo) {
		this.tipo = tipo;
	}
	
	//Getters and setters
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	//toString
	
	public int getCanT() {
		return canT;
	}

	public void setCanT(int canT) {
		this.canT = canT;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Terrain [tipo=" + tipo + "]";
	}	
}
