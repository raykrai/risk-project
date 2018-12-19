package controller;

import java.util.Random;

import model.Terrain;
import model.Troop;


public class ControllerBattle {
	
	public int tirarDado(){
		Random r = new Random (System.nanoTime());
		int resul=0,hasta=6,desde=1;
		resul=r.nextInt(hasta-desde+1)+desde;
		return resul;
		
	}
	
	
	
	public Terrain moverTropas(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov) {
		Terrain posicionAct=casilla[filaAct][columnaAct];
		int uno=1, dos=2;
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				switch(ladoMov) {
				
				case 1:	//Dcha
					posicionAct = casilla[filaAct-uno][columnaAct];	
					break;
				
				case 2:	//Debajo
					posicionAct = casilla[filaAct][columnaAct-uno];
					break;
					
				case 3:	//Izq
					posicionAct = casilla[filaAct-uno][columnaAct-dos];
					break;
					
				case 4:	//Arriba
					posicionAct = casilla[filaAct-dos][columnaAct-uno];
					break;
					
				default:
					break;
				}
				
				
			}
		}
		return posicionAct;
		
	}
	
	
	public boolean comprobarDistancia(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		boolean distancia=false;
		int uno=1, dos=2;
		
		if(casilla[filaAct-uno][columnaAct]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct][columnaAct-uno]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct-uno][columnaAct-dos]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct-dos][columnaAct-uno]==casilla[filaAtaque][columnaAtaque]) {
			distancia=true;
		}
		
		return distancia;
	}
	
	
	public boolean comprobarTipoTropas(Troop t) {
		boolean tipoInf=false;
		String tropa = "infanteria";
		
		if(t.getTipo().equals(tropa)) {
			tipoInf=true;
		}
		
		return tipoInf;
		
	}
	
	

}
