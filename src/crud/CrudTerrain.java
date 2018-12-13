package crud;


import model.Terrain;
import model.Troop;

public class CrudTerrain {
	
	Terrain t;
	Troop tp;
	
	public Terrain crearTerrenoMont() {
		
		t.setTipo("Montaña");
	
		
		return t;
	}
	
	public Terrain crearTerrenoBos() {
		t.setTipo("Bosque");
		return t;
		
	}
	
	public Terrain crearTerrenoLlan() {
		t.setTipo("Llanura");
		return t;
		
	}
	
	public Terrain crearTerrenoArt() {
		t.setTipo("Artilleria");
		return t;
	}

}