package data;

import model.Player;

public class DataPlayer {
	
	private static Player arrayJugadores[] = {new Player ("R", 18), new Player ("A", 18)};
	
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
