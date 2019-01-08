package data;

import model.Battle;
import model.Terrain;
import model.Troop;

public class DataBattle {
	
	Troop t = new Troop("Inf");
	
	private Terrain casilla[][] = {{new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B")}, {new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"B"), new Terrain("L",1,new Troop("Inf"),"B")}, {new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("A",1,new Troop("Inf"),"N"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B")}, {new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B"), new Terrain("L",1,new Troop("Inf"),"B")}, {new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"B"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B")}};
	
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
