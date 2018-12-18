package controller;

import java.util.Random;

public class ControllerBattle {
	
	public int tirarDado(){
		Random r = new Random (System.nanoTime());
		int resul=0,hasta=6,desde=1;
		resul=r.nextInt(hasta-desde+1)+desde;
		return resul;
		
	}
	
	
	
	

}
