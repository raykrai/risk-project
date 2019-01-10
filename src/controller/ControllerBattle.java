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
			
			return tirada;
			}
			
	
	

	
	public boolean comprobarDistancia(int filaAct, int columnaAct, int filaAtaque, int columnaAtaque) {
		
		boolean isNear=false;

		int uno=1;
		
		if ( (filaAct == filaAtaque && columnaAct+uno == columnaAtaque) || (filaAct == filaAtaque && columnaAct-uno == columnaAtaque) || (filaAct+uno == filaAtaque && columnaAct == columnaAtaque) || (filaAct-uno == filaAtaque && columnaAct == columnaAtaque)) {
			isNear = true;
		}
	
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
	
	
	
	public boolean moverTropas(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		int uno=1, dos=2, tres=3, cuatro=4, cero=0;
		
		boolean hasMoved = false;
		
		filaAct -= uno;
		columnaAct -= uno;
		
		//TODO AQUÍ UN IF ENORME PARA CONTROLAR FACCIÓN Y PARA CONTROLAR CANTIDAD
		/* EL IF ENORME AQUÍ*/
		//TODO DENTRO DEL ELSE TERMINAR DE CONTROLAR ESQUINAS Y LATERALES Y LAS CASILLAS DEL CENTRO
		
		//if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo())  || !casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) || !casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) || !casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) ) {
			
		//	System.out.println("¡No puedes mover tropas al terreno enemigo!");
		
		if (casilla[filaAct][columnaAct].getCanT()-cantidad <1){
			
			System.out.println("¡No puedes dejar tu terreno vacío!");
			
		} else {
			
			if ( filaAct == 0 && columnaAct == 0) { //Esquina superior izquierda
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							
							casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						
						break;
				
					case 2: //Debajo
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}
						break;
						
					default:
						
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
				}
				
			} else if ( filaAct == 0 && columnaAct == 4){ //Esquina superior derecha
				
				switch (ladoMov) {
				

				case 1: //Debajo
					
					if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
						System.out.println("Esa casilla no te pertenece");
					} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
						System.out.println("No puedes agrupar dos tipos distintos de tropa");
					} else {
						casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
						casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
						hasMoved = true;
					}
					break;
				
				case 2: //Izq
					
					if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
						System.out.println("Esa casilla no te pertenece");
					} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
						System.out.println("No puedes agrupar dos tipos distintos de tropa");
					} else {
						casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct].getCanT());
						casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
					
						hasMoved = true;
					}
					break;
					
				default:
					
					System.out.println("Opción no válida, no puedes salirte del tablero");
					
					break;
					
				}
			} else if (filaAct == 0 ) { //Lateral superior
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							
							casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						
						break;
					
					case 2: //Debajo
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}
						break;
					
					case 3: //Izq
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						break;
						
					default:
						
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
				}
			} else if ( filaAct == 4 && columnaAct == 4){ //Esquina inferior derecha
				
				switch (ladoMov) {

					case 1: //Izq
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						break;
					
					case 2: //Arriba
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}	
						break;
						
					default:

						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
						
				}
			} else if (filaAct == 4 && columnaAct == 0) { //Esquina inferior izquierda
				
				switch (ladoMov) {
					
				
					case 1: //Dcha
					
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							
							casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						
						break;
						
					case 2: //Arriba

						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}	
						break;
					
					default:
						System.out.println("Opción no válida");
						break;
						
				}
			} else if (columnaAct == 0){ //Lateral Izquierdo
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							
							casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						
						break;
					
					case 2: //Arriba

						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}	
						break;
						
					case 3: //Debajo
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}
						break;
					
					default:
						System.out.println("Opción no válida");
						break;
						
				}
			} else if (columnaAct == 4) { //Lateral Derecho
				
				switch (ladoMov) {
				
					case 1: //Izq
					
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						break;
					
					case 2: //Arriba

						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}	
						break;
						
					case 3: //Debajo
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}
						break;
					
					default:
						System.out.println("Opción no válida");
						break;
				}	
			} else if (filaAct == 4) { //Lateral inferior
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							
							casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						
						break;
					
					case 2: //Arriba

						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}	
						break;
					
					case 3: //Izq
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						break;
						
					default:
						
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
				}
			} else {
				
				switch (ladoMov) {

					case 1: //Izq
						
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						break;
					
					case 2: //Arriba

						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}	
						break;
					
					case 3: //Dcha
	
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct+uno].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							
							casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
						
							hasMoved = true;
						}
						
						break;
					
					case 4: //Debajo
	
						if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct][columnaAct].getEquipo().equals("N")) {
							System.out.println("Esa casilla no te pertenece");
						} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
							System.out.println("No puedes agrupar dos tipos distintos de tropa");
						} else {
							casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT());
							casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
							
							hasMoved = true;
						}
						break;
						
					default:
	
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;	
				}
				
			}
		}	
		return hasMoved;
	}
	

}
