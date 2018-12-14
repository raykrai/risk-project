package model;

import java.util.Arrays;

public class Battle {
	
	//TODO Determinar qué hacemos aquí
	
	//Atributos
	
	private int casilla[][];
	
	//Constructor
	
	public Battle() {
		
	}
	
	public Battle(int[][] casilla) {
		super();
		this.casilla = casilla;
	}
	
	//Getters y setters
	
	public int[][] getCasilla() {
		return casilla;
	}

	public void setCasilla(int[][] casilla) {
		this.casilla = casilla;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Battle [casilla=" + Arrays.toString(casilla) + "]";
	}
	
	
}
