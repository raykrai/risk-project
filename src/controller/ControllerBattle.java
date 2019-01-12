package controller;

import java.util.Random;

import model.Terrain;


public class ControllerBattle {

//Métodos de probabilidad necesarios en el método de combate
	
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
	
//Método de combate que usa la probabilidad de arriba para sacar la tirada del atacante
	
	public int atacar(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		
		int cien =100;
		int cero=0;
		int uno = 1;
		int dos = 2;
		int tirada=0;
		
			if(casilla[filaAct-uno][columnaAct-uno].getTipo().equals("A")){
				
				if(casilla[filaAtaque-1][columnaAtaque-1].getT().getTipo().equals("Inf")) {
					tirada=tirarDadox1()*cien;
				}else {
					tirada=tirarDadox1()*cero;
				}
				
				}else if(comprobarTerreno(casilla,filaAct,columnaAct)==dos && casilla[filaAct-uno][columnaAct-uno].getCanT() > casilla[filaAtaque-uno][columnaAtaque-uno].getCanT()) {
				
					tirada=tirarDadox3();
				
				}else if(comprobarTerreno(casilla,filaAct,columnaAct)==dos) {
					
					tirada=tirarDadox2();
					
				}else {
					tirada=tirarDadox1();
				}
			
			return tirada;
	}
			
	
//Método de combate que usa la probabilidad de arriba para sacar la tirada del defensor
	
	public int defender(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		
		int tiradaD=0, cien=100, cero=0, uno = 1, dos = 2;
		
		if(casilla[filaAtaque-1][columnaAtaque-1].getTipo().equals("A")) {
			
			if(casilla[filaAct-1][columnaAct-1].getT().getTipo().equals("Inf")) {
				tiradaD=tirarDadox1()*cien;
			}else {
				tiradaD=tirarDadox1()*cero;
			}
		}else if(comprobarTerreno(casilla,filaAtaque,columnaAtaque)==dos && casilla[filaAtaque-uno][columnaAtaque-uno].getCanT() > casilla[filaAtaque-uno][columnaAct-uno].getCanT()) {
				tiradaD=tirarDadox3();
					
		}else if(comprobarTerreno(casilla,filaAtaque,columnaAtaque)==dos) {
			
			tiradaD=tirarDadox2();
			
		}else{
			tiradaD=tirarDadox1();
		}
	
		
		return tiradaD;
	}
	
	
	
//Método de combate que compara las dos tiradas conseguidas con los anteriores métodos de combate y devuelve si el ganador ha sido el atacante o si no lo ha sido.
	
	public boolean comprobarBatalla(int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		
		boolean atacanteGanador;
		
		if(atacar(filaAct, columnaAct, casilla, filaAtaque, columnaAtaque)>=defender(filaAct, columnaAct, casilla, filaAtaque, columnaAtaque)  ) {
			atacanteGanador=true;
		}else {
			atacanteGanador=false;
		}
		
		return atacanteGanador;
		
	}
	
//Método final del combate que cambia los atributos del terreno en función del que haya ganado en el ataque.
	
	public void conquistarTerreno(boolean atacanteGanador, int filaAct, int columnaAct, Terrain casilla[][], int filaAtaque, int columnaAtaque) {
		int uno = 1;
		filaAct -= 1;
		columnaAct -= 1;
		
		filaAtaque -= 1;
		columnaAtaque -= 1;
		
		if (atacanteGanador) {
			
			//Avanzan las tropas del ganador
			casilla[filaAtaque][columnaAtaque].setCanT(casilla[filaAct][columnaAct].getCanT());
			casilla[filaAtaque][columnaAtaque].getT().setTipo(casilla[filaAct][columnaAct].getT().getTipo());
			//Reclama la facción el terreno
			casilla[filaAtaque][columnaAtaque].setEquipo(casilla[filaAct][columnaAct].getEquipo());
			//Genera una tropa defensora en su anterior posición
			casilla[filaAct][columnaAct].setCanT(uno);
		} else {
			//En caso de que pierda el ataque se queda con una tropa defensora
			casilla[filaAct][columnaAct].setCanT(uno); 
		}
	}
//Método usado en el main para comprobar si la tropa a atacar está cerca o no
	
	public boolean comprobarDistancia(int filaAct, int columnaAct, int filaAtaque, int columnaAtaque) {
		
		boolean isNear=false;

		int uno=1;
		
		if ( (filaAct == filaAtaque && columnaAct+uno == columnaAtaque) || (filaAct == filaAtaque && columnaAct-uno == columnaAtaque) || (filaAct+uno == filaAtaque && columnaAct == columnaAtaque) || (filaAct-uno == filaAtaque && columnaAct == columnaAtaque)) {
			isNear = true;
		}
	
		return isNear;
	}
	
//Método usado en los métodos de tirar dados para sacar las ventajas en cuanto al terreno dependiendo del tipo de tropa
	
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
	
//Métodos para mover en las distintas direcciones (posteriormente se llaman en el macro método moverTropas depende de la dirección que elija el usuario). Además rechazan movimientos a casillas que no te pertenezcan o con distinto tipo de tropa
	
	//Dcha
	
	public boolean moverDerecha(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		
		int uno = 1;
		
		boolean hasMoved = false;
		
		if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct+uno].getEquipo()) && !casilla[filaAct][columnaAct+uno].getEquipo().equals("N")) {
			System.out.println("Esa casilla no te pertenece");
		} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct+uno].getT().getTipo() ) ){
			System.out.println("No puedes agrupar dos tipos distintos de tropa");
		} else {
			casilla[filaAct][columnaAct+uno].setCanT(casilla[filaAct][columnaAct+uno].getCanT()+cantidad);
			casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
			
			if (casilla[filaAct][columnaAct+uno].getEquipo().equals("N")) {
				casilla[filaAct][columnaAct+uno].setEquipo(casilla[filaAct][columnaAct].getEquipo());
			}
			
			hasMoved = true;
		}
		return hasMoved;
	}
	
	//Dbajo
	
	public boolean moverDebajo(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		
		int uno = 1;
		
		boolean hasMoved = false;
		
		if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct+uno][columnaAct].getEquipo()) && !casilla[filaAct+uno][columnaAct].getEquipo().equals("N")) {
			System.out.println("Esa casilla no te pertenece");
		} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct+uno][columnaAct].getT().getTipo() ) ){
			System.out.println("No puedes agrupar dos tipos distintos de tropa");
		} else {
			casilla[filaAct+uno][columnaAct].setCanT(casilla[filaAct+uno][columnaAct].getCanT()+cantidad);
			casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);

			if (casilla[filaAct+uno][columnaAct].getEquipo().equals("N")) {
				casilla[filaAct+uno][columnaAct].setEquipo(casilla[filaAct][columnaAct].getEquipo());
			}
			
			hasMoved = true;
		}
		
		return hasMoved;
	}

	//Izq
	
	public boolean moverIzquierda(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		
		int uno = 1;
		
		boolean hasMoved = false;
		
		if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct][columnaAct-uno].getEquipo()) && !casilla[filaAct][columnaAct-uno].getEquipo().equals("N")) {
			System.out.println("Esa casilla no te pertenece");
		} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct][columnaAct-uno].getT().getTipo() ) ){
			System.out.println("No puedes agrupar dos tipos distintos de tropa");
		} else {
			casilla[filaAct][columnaAct-uno].setCanT(casilla[filaAct][columnaAct-uno].getCanT()+cantidad);
			casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);

			if (casilla[filaAct][columnaAct-uno].getEquipo().equals("N")) {
				casilla[filaAct][columnaAct-uno].setEquipo(casilla[filaAct][columnaAct].getEquipo());
			}
			
			hasMoved = true;
		}
		
		return hasMoved;
	}
	
	//Arriba
	
	public boolean moverArriba(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		
		int uno = 1;
		
		boolean hasMoved = false;
		
		if (!casilla[filaAct][columnaAct].getEquipo().equals(casilla[filaAct-uno][columnaAct].getEquipo()) && !casilla[filaAct-uno][columnaAct].getEquipo().equals("N")) {
			System.out.println("Esa casilla no te pertenece");
		} else if ( !casilla[filaAct][columnaAct].getT().getTipo().equals( casilla[filaAct-uno][columnaAct].getT().getTipo() ) ){
			System.out.println("No puedes agrupar dos tipos distintos de tropa");
		} else {
			casilla[filaAct-uno][columnaAct].setCanT(casilla[filaAct-uno][columnaAct].getCanT()+cantidad);
			casilla[filaAct][columnaAct].setCanT(casilla[filaAct][columnaAct].getCanT()-cantidad);
			
			if (casilla[filaAct-uno][columnaAct].getEquipo().equals("N")) {
				casilla[filaAct-uno][columnaAct].setEquipo(casilla[filaAct][columnaAct].getEquipo());
			}
			
			hasMoved = true;
		}
		
		return hasMoved;
	}
	
	
//Macro método principal controlador del movimiento de las tropas (función número 1 en la partida)

	
	public boolean moverTropas(int filaAct, int columnaAct, Terrain casilla[][], int ladoMov, int cantidad) {
		
		//Se definen variables necesarias
		
		int uno=1;
		int cero = 0;
		int cuatro = 4;
		
		boolean hasMoved = false;
		
		//Se ajustan las variables a la posición real del array
		
		filaAct -= uno;
		columnaAct -= uno;
		
		//Aquí empieza la fiesta :^)
		
		//Condicional para controlar que no se quede ningún terreno vacío
		if (casilla[filaAct][columnaAct].getCanT()-cantidad <uno){
			
			System.out.println("¡No puedes dejar tu terreno vacío!");
			
		} else {
			
		//Cada if de aquí dentro controla los límites (esquinas, laterales e interiores)
			
			if ( filaAct == cero && columnaAct == cero) { //Esquina superior izquierda
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						hasMoved = moverDerecha(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
				
					case 2: //Debajo
						
						hasMoved = moverDebajo(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
						
					default:
						
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
				}
				
			} else if ( filaAct == cero && columnaAct == cuatro){ //Esquina superior derecha
				
				switch (ladoMov) {
				

				case 1: //Debajo
					
					hasMoved = moverDebajo(filaAct, columnaAct, casilla, ladoMov, cantidad);
					
					break;
				
				case 2: //Izq
					
					hasMoved = moverIzquierda(filaAct, columnaAct, casilla, ladoMov, cantidad);
					
					break;
					
				default:
					
					System.out.println("Opción no válida, no puedes salirte del tablero");
					
					break;
					
				}
			} else if (filaAct == cero ) { //Lateral superior
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						hasMoved = moverDerecha(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 2: //Debajo
						
						hasMoved = moverDebajo(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 3: //Izq
						
						hasMoved = moverIzquierda(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
						
					default:
						
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
				}
			} else if ( filaAct == cuatro && columnaAct == cuatro){ //Esquina inferior derecha
				
				switch (ladoMov) {

					case 1: //Izq
						
						hasMoved = moverIzquierda(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 2: //Arriba
						
						hasMoved = moverArriba(filaAct, columnaAct, casilla, ladoMov, cantidad);
							
						break;
						
					default:

						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
						
				}
			} else if (filaAct == cuatro && columnaAct == cero) { //Esquina inferior izquierda
				
				switch (ladoMov) {
					
				
					case 1: //Dcha
					
						hasMoved = moverDerecha(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
						
					case 2: //Arriba

						hasMoved = moverArriba(filaAct, columnaAct, casilla, ladoMov, cantidad);
							
						break;
					
					default:
						System.out.println("Opción no válida");
						break;
						
				}
			} else if (columnaAct == cero){ //Lateral Izquierdo
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						hasMoved = moverDerecha(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 2: //Arriba

						hasMoved = moverArriba(filaAct, columnaAct, casilla, ladoMov, cantidad);
							
						break;
						
					case 3: //Debajo
						
						hasMoved = moverDebajo(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					default:
						System.out.println("Opción no válida");
						break;
						
				}
			} else if (columnaAct == cuatro) { //Lateral Derecho
				
				switch (ladoMov) {
				
					case 1: //Izq
					
						hasMoved = moverIzquierda(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 2: //Arriba

						hasMoved = moverArriba(filaAct, columnaAct, casilla, ladoMov, cantidad);
							
						break;
						
					case 3: //Debajo
						
						hasMoved = moverDebajo(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					default:
						System.out.println("Opción no válida");
						break;
				}	
			} else if (filaAct == cuatro) { //Lateral inferior
				
				switch (ladoMov) {
				
					case 1: //Dcha
						
						hasMoved = moverDerecha(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 2: //Arriba

						hasMoved = moverArriba(filaAct, columnaAct, casilla, ladoMov, cantidad);
							
						break;
					
					case 3: //Izq
						
						hasMoved = moverIzquierda(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
						
					default:
						
						System.out.println("Opción no válida, no puedes salirte del tablero");
						
						break;
				}
			} else {
				
				switch (ladoMov) {

					case 1: //Izq
						
						hasMoved = moverIzquierda(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 2: //Arriba

						hasMoved = moverArriba(filaAct, columnaAct, casilla, ladoMov, cantidad);
							
						break;
					
					case 3: //Dcha
	
						hasMoved = moverDerecha(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
						break;
					
					case 4: //Debajo
	
						hasMoved = moverDebajo(filaAct, columnaAct, casilla, ladoMov, cantidad);
						
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
