package controller;

import data.DataPlayer;
import model.Terrain;

public class ControllerPartida {
	
	public ControllerPartida() {
		
	}
	
	public Terrain[][] colocarTropas(String jugador, Terrain casilla[][], String tipo, int cantidad, int fila, int columna) {
		
		if (casilla[fila-1][columna-1].getEquipo().equals(jugador)) {
			
			casilla[fila-1][columna-1].getT().setTipo(tipo);
			casilla[fila-1][columna-1].setCanT(cantidad+1);
			
			if (jugador.equals("R")) {
				DataPlayer.getArrayJugadores()[0].setCanT(DataPlayer.getArrayJugadores()[0].getCanT()-cantidad);
			} else {
				DataPlayer.getArrayJugadores()[1].setCanT(DataPlayer.getArrayJugadores()[1].getCanT()-cantidad);
			}
			
		} else {
			System.out.println("Ese terreno no te pertenece");
		}
		
		return casilla;
	}
	
	//Comprueba si se ha acabado la partida
	public boolean comprobarGanador(Terrain casilla[][]) {
		boolean isFinished = false;
		int cero = 0;
		int contA = 0;
		int contR = 0;
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				if (casilla[i][j].getEquipo().equals("B")) {
					contA++;
				}
				
				if (casilla[i][j].getEquipo().equals("R")){
					contR++;
				} 
			}
		}
		
		if (contA == cero || contR == cero) {
			isFinished = true;
		}
		
		return isFinished;
		
	}
}
