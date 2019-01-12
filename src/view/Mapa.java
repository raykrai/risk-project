package view;

import model.Battle;

public class Mapa {
	
	
	
	public Mapa() {
		// TODO Auto-generated constructor stub
	}

	public void imprimirMapa(Battle b) {
		System.out.println("\n\n \t \t     M = Montaña  |  L = Llanura  |  A = Artillería  |  R = Jugador Red   |  B = Jugador Blue\n");
		System.out.printf("                      --------------------------------------------------------------------------------------\n");
		System.out.println("Fila ↓ / Columna →            1                2                3                4                5");
		//System.out.println("\n \t Fila ⬇️");
		System.out.println("                      --------------------------------------------------------------------------------------\n");
		
		for (int i = 0; i < b.getCasilla().length; i++) {
			
			System.out.printf("  %d",i+1);
			
			for (int j = 0; j < b.getCasilla()[i].length; j++) {
				
				if (j == 0 ) {
					System.out.printf("                   | ");
				}
				
				System.out.print(b.getCasilla()[i][j].getTipo()+"  ");
				System.out.print(b.getCasilla()[i][j].getCanT()+"  ");
				System.out.print(b.getCasilla()[i][j].getT().getTipo()+"  ");
				System.out.print(b.getCasilla()[i][j].getEquipo()+"  ");
				System.out.printf(" | ");

			}
			
			System.out.println("\n \n ");
		}
		System.out.println("                      --------------------------------------------------------------------------------------\n\n");
	}

}
