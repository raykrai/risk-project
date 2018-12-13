package model;

public class Troop {
	
	private String tipo;
	private int cantidad;
	
	
	public Troop() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Troop(String tipo, int cantidad) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Troop [tipo=" + tipo + ", cantidad=" + cantidad + "]";
	}
	
	
	

}
