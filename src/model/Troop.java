package model;

public class Troop {

	//Atributos
	private String tipo;
	
	//Constructores
	
	public Troop() {
		
	}

	public Troop(String tipo) {
		this.tipo = tipo;

	}

	//Getters y setters
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//toString
	@Override
	public String toString() {
		return "Troop [tipo=" + tipo + "]";
	}
	
	
	

}
