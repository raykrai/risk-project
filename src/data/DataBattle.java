package data;

import model.Battle;
import model.Terrain;
import model.Troop;

public class DataBattle {
	
	Troop t = new Troop("Inf");
	
	private Terrain casilla[][] = {{new Terrain("M",0,t,"R"), new Terrain("L",0,t,"R"), new Terrain("M",0,t,"A"), new Terrain("L",0,t,"A")}, {new Terrain("A",0,t,"R"), new Terrain("M",0,t,"R"), new Terrain("L",0,t,"A"), new Terrain("A",0,t,"A")}, {new Terrain("M",0,t,"R"), new Terrain("L",0,t,"R"), new Terrain("M",0,t,"A"), new Terrain("L",0,t,"A")}};
	
	//Getters y setters
	
	public Troop getT() {
		return t;
	}
	public void setT(Troop t) {
		this.t = t;
	}
	public Terrain[][] getCasilla() {
		return casilla;
	}
	public void setCasilla(Terrain[][] casilla) {
		this.casilla = casilla;
	}
}
