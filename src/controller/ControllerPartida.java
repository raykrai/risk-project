package controller;

import data.DataPlayer;
import model.Terrain;

public class ControllerPartida {
	
	//Constructor
	
	public ControllerPartida() {
		
	}
	
	//Coloca las tropas iniciales
	
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
	
	public boolean comprobarFinal(Terrain casilla[][]) {
		
		boolean isFinished = false;
		int cero = 0;
		int uno = 1;
		int veinticinco = 25;
		int contB = 0;
		int contR = 0;
		int contT = 0;
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				if (casilla[i][j].getEquipo().equals("B")) {
					contB++;
				}
				
				if (casilla[i][j].getEquipo().equals("R")){
					contR++;
				} 
			}
		}
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				if (casilla[i][j].getCanT() == uno) {
					contT++;
				}
			}
		}
		
		if (contB == cero || contR == cero) {
			isFinished = true;
		} else if (contT == veinticinco) {
			isFinished = true;
		}
		
		return isFinished;	
	}
	
	//Comprueba el ganador
	
	public String comprobarGanador(Terrain casilla[][]) {
		
		int contB = 0;
		int contR = 0;
		
		String ganador = "Empate";
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				if (casilla[i][j].getEquipo().equals("B")) {
					contB++;
				}
				
				if (casilla[i][j].getEquipo().equals("R")){
					contR++;
				} 
			}
		}
		
		System.out.println("Terrenos del equipo Blue: " +contB);
		System.out.println("Terrenos de la facción Red: " + contR);
		if (contB > contR) {
			ganador = "Blue";
		} else if (contR > contB) {
			ganador = "Red";
		}
		
		return ganador;
	}
}
