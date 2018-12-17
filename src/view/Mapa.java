package view;

import model.Battle;

public class Mapa {
	
	
	
	public Mapa() {
		// TODO Auto-generated constructor stub
	}

	public void imprimirMapa(Battle b) {
		
		for (int i = 0; i < b.getCasilla().length; i++) {
			
			for (int j = 0; j < b.getCasilla()[i].length; j++) {
				
				System.out.print(b.getCasilla()[i][j].getTipo()+"  ");
				System.out.print(b.getCasilla()[i][j].getCanT()+"  ");
				System.out.print(b.getCasilla()[i][j].getT().getTipo()+"  ");
				System.out.print(b.getCasilla()[i][j].getEquipo()+"  ");
				System.out.printf(" | ");

			}
			
			System.out.println("\n \n");
		} 
	}

}
