package controller;

import java.util.Random;

import model.Terrain;
import model.Troop;


public class ControllerBattle {
	
	public int tirarDadox1(){
		Random r = new Random (System.nanoTime());
		int resul=0,hasta=6,desde=1;
		resul=r.nextInt(hasta-desde+1)+desde;
		return resul;
		
	}
	
	public int tirarDadox2() {
		Random r = new Random (System.nanoTime());
		int resul=0,hasta=12,desde=1;
		resul=r.nextInt(hasta-desde+1)+desde;
		return resul;
	}
	
	public int tirarDadox3() {
		Random r = new Random (System.nanoTime());
		int resul=0,hasta=18,desde=1;
		resul=r.nextInt(hasta-desde+1)+desde;
		return resul;
	}
	
	//Cuando atacas devuelves un int que indica tu tirada.
	public int atacarTropas(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		
		int cien =100;
		int cero=0;
		int tirada=0;
		
		
		
		
		if(comprobarDistancia(filaAct,columnaAct,casilla,filaAtaque,columnaAtaque)==true)  {
			
			if(casilla[filaAct-1][columnaAct-1].getTipo().equals("Artilleria")){
				
				if(casilla[filaAtaque-1][columnaAtaque-1].getT().getTipo().equals("Infanteria")) {
					tirada=tirarDadox1()*cien;
				}else {
					tirada=tirarDadox1()*cero;
				}
				
			}else if(comprobarTerreno(casilla,filaAct,columnaAct)==2) {
				
			}
		}
		return tirada;
		
			
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
	
	
	public int comprobarTerreno(Terrain casilla[][], int filaAct, int columnaAct) {
		int vent=1, uno=1;
		String tropInf="Inf", tropCab="Cab";
		String terMon="Mon", terMur="Mur";
		
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
		
		if(casilla[filaAct-uno][columnaAct-uno].getT().getTipo().equals(tropInf) && casilla[filaAct-uno][columnaAct-uno].getTipo().equals(terMon) || (casilla[filaAct-uno][columnaAct-uno].getT().getTipo().equals(tropCab) && casilla[filaAct-uno][columnaAct-uno].getTipo().equals(terMur))) {
			vent=2;
		}
		
		
			}
		}
		
		return vent;
	}
	
	
	
	

}
