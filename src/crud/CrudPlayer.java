package crud;

import data.DataPlayer;
import model.Player;
import model.Troop;

public class CrudPlayer {
	
	Player p;
	Troop tp;
	
	//Constructor
	public CrudPlayer() {
		
	}	
	
	
	//Métodos
	public Player createPlayer(String equipo) {
		p.setEquipo(equipo);
		
		return p;	
	}
	
	public void deletePlayer(DataPlayer arrayJugadores) {
		

}

}
