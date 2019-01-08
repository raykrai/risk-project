package data;

import model.Player;

public class DataPlayer {
	
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
