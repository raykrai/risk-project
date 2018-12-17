package data;

import model.Player;

public class DataPlayer {
	
	//TODO Hay que planear cómo hacer para a partir del atributo de tropas de jugador, se limitaría el número de tropas por tipo, es decir infantería, caballería y eso.
	//Atributos (array de los jugadores cargados con sus equipos y la cantidad de tropas iniciales)
	
	private static Player arrayJugadores[] = {new Player ("R", 18), new Player ("A", 18)};
	
	//Getters y setters
	
	public static Player[] getArrayJugadores() {
		return arrayJugadores;
	}

	public static void setArrayJugadores(Player[] arrayJugadores) {
		DataPlayer.arrayJugadores = arrayJugadores;
	}

}
