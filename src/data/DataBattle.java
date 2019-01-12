package data;

import model.Terrain;
import model.Troop;

public class DataBattle {
	
	//Constructor
	
	public DataBattle() {

	}
	
	//Aquí es donde sucede la magia, se crea el terreno de juego, con los datos iniciales precargados

	private Terrain casilla[][] = {{new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B")}, {new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"B"), new Terrain("L",1,new Troop("Inf"),"B")}, {new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("A",1,new Troop("Inf"),"N"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B")}, {new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B"), new Terrain("L",1,new Troop("Inf"),"B")}, {new Terrain("M",1,new Troop("Inf"),"R"), new Terrain("L",1,new Troop("Inf"),"R"), new Terrain("M",1,new Troop("Inf"),"B"), new Terrain("L",1,new Troop("Inf"),"B"), new Terrain("M",1,new Troop("Inf"),"B")}};
	
	//Getters y setters
	
	public Terrain[][] getCasilla() {
		return casilla;
	}
	public void setCasilla(Terrain[][] casilla) {
		this.casilla = casilla;
	}
}
