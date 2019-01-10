package controller;

import java.util.Random;

import data.DataPlayer;
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
				
			}else if(comprobarTerreno(casilla,filaAct,columnaAct)==2 && casilla[filaAct][columnaAct].getCanT() > casilla[filaAtaque-1][columnaAtaque-1].getCanT()) {
				tirada=tirarDadox3();
			
					
				}else if(comprobarTerreno(casilla,filaAct,columnaAct)==2) {
					
					tirada=tirarDadox2();
					
				}else {
					tirada=tirarDadox1();
				}
		}
		return tirada;
		
			
	}
	
	
	public boolean comprobarBatalla(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		
		
		
		
		
		return true;
		
	}
	
	

	
	public boolean comprobarDistancia(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		
		boolean isNear=false;

		int uno=1, dos=2;
		
/*		if(casilla[filaAct-uno][columnaAct]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct][columnaAct-uno]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct-uno][columnaAct-dos]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct-dos][columnaAct-uno]==casilla[filaAtaque][columnaAtaque]) {
			isNear=true;
		}
*/		
		
		/*En la primera forma de hacerlo lo más recomendable sería poner las 4 líneas de abajo para controlar posibles errores de posiciones en el array

		filaAct -= 1;
		columnaAct -= 1;
		filaAtaque -= 1;
		columnaAtaque -= 1;
		
		if (casilla[filaAct][columnaAct+uno]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct][columnaAct-uno]==casilla[filaAtaque][columnaAtaque] || casilla[filaAct+uno][columnaAct] == casilla[filaAtaque][columnaAtaque] || casilla[filaAct-uno][columnaAct] == casilla[filaAtaque][columnaAtaque]) {
			isNear = true;
		}
		
		Segunda forma de hacerlo, en esta no hay que controlar posibles errores de posiciones en el array.
		
		if ( (filaAct == filaAtaque && columnaAct+uno == columnaAtaque) || (filaAct == filaAtaque && columnaAct-uno == columnaAtaque) || (filaAct+uno == filaAtaque && columnaAct == columnaAtaque) || (filaAct-uno == filaAtaque && columnaAct == columnaAtaque)) {
			isNear = true;
		}
		*/
		
		
		
		return isNear;
	}
	
	
	public int comprobarTerreno(Terrain casilla[][], int filaAct, int columnaAct) {
		int vent=1, uno=1;
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
		
		if(casilla[filaAct-uno][columnaAct-uno].getT().getTipo().equals("Inf") && casilla[filaAct-uno][columnaAct-uno].getTipo().equals("M") || (casilla[filaAct-uno][columnaAct-uno].getT().getTipo().equals("Cab") && casilla[filaAct-uno][columnaAct-uno].getTipo().equals("L"))) {
			vent=2;
		}
		
		
			}
		}
		
		return vent;
	}
	
	
	
	public Terrain [][] moverTropas(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		int uno=1, dos=2, tres=3, cuatro=4, cero=0;
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
				
				filaAct -= uno;
				columnaAct -= uno;
				cantidad--;
	
				switch(ladoMov) {
					
				case 1:	//Dcha
					if(casilla[filaAct][columnaAct]!=casilla[cero][cuatro] && casilla[filaAct][columnaAct]!=casilla[uno][cuatro] && casilla[filaAct][columnaAct]!=casilla[dos][cuatro] && casilla[filaAct][columnaAct]!=casilla[tres][cuatro] && casilla[filaAct][columnaAct]!=casilla[cuatro][cuatro]) {
						casilla[filaAct][columnaAct]=casilla[filaAct-uno][columnaAct];
					}else {
						cantidad++;
					}
					break;
					
				case 2:	//Debajo
					if(casilla[filaAct][columnaAct]!=casilla[cuatro][cero] && casilla[filaAct][columnaAct]!=casilla[cuatro][uno] && casilla[filaAct][columnaAct]!=casilla[cuatro][dos] && casilla[filaAct][columnaAct]!=casilla[cuatro][tres] && casilla[filaAct][columnaAct]!=casilla[cuatro][cuatro]) {
						casilla[filaAct][columnaAct]=casilla[filaAct][columnaAct-uno];
					}else {
						cantidad++;
					}
					break;
						
				case 3:	//Izq
					if(casilla[filaAct][columnaAct]!=casilla[cero][cero] && casilla[filaAct][columnaAct]!=casilla[uno][cero] && casilla[filaAct][columnaAct]!=casilla[dos][cero]&& casilla[filaAct][columnaAct]!=casilla[tres][cero] &&casilla[filaAct][columnaAct]!=casilla[cuatro][cero]) {
						casilla[filaAct][columnaAct]=casilla[filaAct-uno][columnaAct-dos];
					}else {
						cantidad++;
					}
					break;
						
				case 4:	//Arriba
					if(casilla[filaAct][columnaAct]!=casilla[cero][cero] && casilla[filaAct][columnaAct]!=casilla[cero][uno] && casilla[filaAct][columnaAct]!=casilla[cero][dos] && casilla[filaAct][columnaAct]!=casilla[cero][3] && casilla[filaAct][columnaAct]!=casilla[cero][cuatro]) {
						casilla[filaAct][columnaAct]=casilla[filaAct-dos][columnaAct-uno];
					}else {
						cantidad++;
					}
					break;
						
				}
					
				
			
			}
		}
		return casilla;
		
	}
	
	
	public Terrain [][] moverTropas2(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		int uno=1, dos=2, tres=3, cuatro=4, cinco=5;
		
		
		for (int i = 0; i<casilla.length; i++) {
			
			for (int j = 0; j <casilla[i].length; j++) {
				
					
					switch(ladoMov) {
					
					case 1:	//Dcha
						if((filaAct!=uno&&columnaAct!=cinco) && (filaAct!=dos&&columnaAct!=cinco) && (filaAct!=tres&&columnaAct!=cinco) && (filaAct!=cuatro&&columnaAct!=cinco) && (filaAct!=cinco&&columnaAct!=cinco)) {
							columnaAct++;
							cantidad-=uno;
						}
						break;
					
					case 2:	//Abajo
						if((filaAct!=cinco&&columnaAct!=uno) && (filaAct!=cinco&&columnaAct!=dos) && (filaAct!=cinco&&columnaAct!=tres) && (filaAct!=cinco&&columnaAct!=cuatro) && (filaAct!=cinco&&columnaAct!=cinco)) {
							filaAct--;
							cantidad-=uno;
						}
						break;
						
					case 3:	//Izq
						if((filaAct!=uno&&columnaAct!=uno) && (filaAct!=dos&&columnaAct!=uno) && (filaAct!=tres&&columnaAct!=uno) && (filaAct!=cuatro&&columnaAct!=uno) && (filaAct!=cinco&&columnaAct!=uno)) {
							columnaAct--;
							cantidad-=uno;
						}
						break;
						
					case 4:	//Arriba
						if((filaAct!=uno&&columnaAct!=uno) && (filaAct!=uno&&columnaAct!=dos) && (filaAct!=uno&&columnaAct!=tres) && (filaAct!=uno&&columnaAct!=cuatro) && (filaAct!=uno&&columnaAct!=cinco)) {
							filaAct--;
							cantidad-=uno;
						}
						break;
					
					}
	
					
				}
				
				
			}
		
		return casilla;
		
	}
	

}
