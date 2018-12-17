package controller;

import model.Terrain;

public class ControllerPartida {
	
	public ControllerPartida() {
		
	}
	
	//Comprueba si se ha acabado la partida
	public boolean comprobarGanador(Terrain casilla[][]) {
		boolean isFinished = false;
		int cero = 0;
		int contA = 0;
		int contR = 0;
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				if (casilla[i][j].getEquipo().equals("A")) {
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
