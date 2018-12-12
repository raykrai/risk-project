package model;

public class Terrain {
	
	//Atributos
	
	private String tipo;
	
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
	
	@Override
	public String toString() {
		return "Terrain [tipo=" + tipo + "]";
	}	
}
