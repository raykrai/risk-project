package data;

import model.Player;

public class DataPlayer {
	
	//Se crean dos jugadores para controlar la cantidad de tropas a colocar al inicio de la partida
	
	private static Player arrayJugadores[] = {new Player ("R", 25), new Player ("B", 25)};
	
	public DataPlayer() {
		
	}
	
	//Getters y setters
	
	public static Player[] getArrayJugadores() {
		return arrayJugadores;
	}

	public static void setArrayJugadores(Player[] arrayJugadores) {
		DataPlayer.arrayJugadores = arrayJugadores;
	}

}
