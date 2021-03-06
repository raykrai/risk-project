package model;

public class Terrain {
	
	//Atributos
	
	private String tipo;
	private int canT;
	private Troop t;
	private String equipo;
	
	//Constructores
	
	public Terrain() {
		
	}
	
	public Terrain(String tipo, int canT, Troop t, String equipo) {
		super();
		this.tipo = tipo;
		this.canT = canT;
		this.t = t;
		this.equipo = equipo;
	}

	//Getters and setters
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getCanT() {
		return canT;
	}

	public void setCanT(int canT) {
		this.canT = canT;
	}
	
	
	public Troop getT() {
		return t;
	}

	public void setT(Troop t) {
		this.t = t;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	//toString
	@Override
	public String toString() {
		return tipo + "" + canT + "" + t.getTipo() + equipo;
	}	
}
