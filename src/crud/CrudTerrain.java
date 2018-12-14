package crud;


import model.Terrain;


public class CrudTerrain {
	
	Terrain t;
	
	
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
