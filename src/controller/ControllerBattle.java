package controller;

import java.util.Random;

import model.Terrain;


public class ControllerBattle {
	
	public int tirarDado(){
		Random r = new Random (System.nanoTime());
		int resul=0,hasta=6,desde=1;
		resul=r.nextInt(hasta-desde+1)+desde;
		return resul;
		
	}
	
	
	
	public Terrain moverTropas(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov) {
		Terrain posicionAct = casilla[filaAct-1][columnaAct-1];
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				switch(ladoMov) {
				
				case 1:	//Dcha
					posicionAct = casilla[filaAct][columnaAct+1];	
					break;
				
				case 2:	//Debajo
					posicionAct = casilla[filaAct+1][columnaAct];
					break;
					
				case 3:	//Izq
					posicionAct = casilla[filaAct][columnaAct-1];
					break;
					
				case 4:	//Arriba
					posicionAct = casilla[filaAct-1][columnaAct];
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
		Terrain posicionAct = casilla[filaAct-1][columnaAct-1];
		Terrain ataque= casilla[filaAtaque-1][columnaAtaque-1];
		
		if(casilla[filaAct+1][columnaAct]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct-1][columnaAct]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct][columnaAct+1]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct][columnaAct-1]==casilla[filaAtaque][columnaAtaque]) {
			distancia=true;
		}
		
		return distancia;
	}
	
	
	public boolean comprobarTipoTropas() {
		boolean tipo=false;
		
		return tipo;
		
	}
	
	

}
