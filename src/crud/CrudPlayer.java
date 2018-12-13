package crud;

import data.DataPlayer;
import model.Player;

public class CrudPlayer {
	
	//Constructor
	public CrudPlayer() {
		
	}	
	
	
	//Métodos
	public Player createPlayer(String equipo) {
		Player p=new Player(equipo);
		
		return p;	
	}
	
	public void deletePlayer(DataPlayer arrayJugadores,int cantTropas) {
		if(cantTropas==0) {
			
	}

}

}
