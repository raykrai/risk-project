package model;

import java.util.Arrays;

public class Battle {
	
	//Atributos
	
	private Terrain casilla[][];
	
	//Constructor
	
	public Battle() {
		
	}
	
	public Battle(Terrain[][] casilla) {
		super();
		this.casilla = casilla;
	}

	//Getters y setters
	

	public Terrain[][] getCasilla() {
		return casilla;
	}

	public void setCasilla(Terrain[][] casilla) {
		this.casilla = casilla;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Battle [casilla=" + Arrays.toString(casilla) + "]";
	}
	
	
}
