package principal;

import controller.ControllerPartida;
import controller.ControllerBattle;
import data.DataBattle;
import data.DataPlayer;
import model.Battle;
import model.Terrain;
import utilidades.Leer;
import view.Mapa;
import view.Menu;

public class Principal {

	public static void main(String[] args) {
		int turno = 2, opt, cero = 0, optC, filaAct=0, columnaAct=0, filaAtaque=0, columnaAtaque=0, ladoMov=0, cantidad;
		String turnoActivo = "R";
		String tipo;
		
		DataBattle dB = new DataBattle();
		ControllerBattle cB = new ControllerBattle();
		Battle b = new Battle(dB.getCasilla());
		Mapa map = new Mapa();
		Menu m = new Menu();
		
		ControllerPartida cP = new ControllerPartida();
		
		//Se muestra el menú
		m.imprimirMenuBienv();
		
		do {
		
			//Se muestra el menú y se lee la opción deseada
			m.imprimirMenuPrincipal();
			
			opt = Leer.datoInt();
				
			switch (opt) {
			
				case 0:
					
					break;
					
				case 1:
					
					System.out.println("Primero elegirá las posiciones el jugador Red (R)\n");
					
					do {
						
						map.imprimirMapa(b);
						
						System.out.println("Te quedan "+DataPlayer.getArrayJugadores()[0].getCanT()+" tropas");
						System.out.println("Elige el tipo de tropa a colocar:");
						System.out.println("Inf o Cab");
						
						tipo = Leer.dato();
						
						System.out.println("Elige la cantidad de tropas a colocar");
						
						cantidad = Leer.datoInt();
						
						System.out.println("Elige la fila del terreno");
						
						filaAct = Leer.datoInt();
						
						System.out.println("Elige la columna del terreno");
						
						columnaAct = Leer.datoInt();
						
						if (cantidad <= DataPlayer.getArrayJugadores()[0].getCanT()) {
							
							cP.colocarTropas(DataPlayer.getArrayJugadores()[0].getEquipo(), b.getCasilla(), tipo, cantidad, filaAct, columnaAct);
							
						} else {
							
							System.out.println("No tienes ese número de tropas");
							
						}
						
					} while (DataPlayer.getArrayJugadores()[0].getCanT() != 0);
					
					System.out.println("Ahora el jugador Blue (B)");
					
					
					do {
						
						map.imprimirMapa(b);
						
						System.out.println("Te quedan "+DataPlayer.getArrayJugadores()[1].getCanT()+" tropas");
						System.out.println("Elige el tipo de tropa a colocar:");
						System.out.println("Inf o Cab");
						
						tipo = Leer.dato();
						
						System.out.println("Elige la cantidad de tropas a colocar");
						
						cantidad = Leer.datoInt();
						
						System.out.println("Elige la fila del terreno");
						
						filaAct = Leer.datoInt();
						
						System.out.println("Elige la columna del terreno");
						
						columnaAct = Leer.datoInt();
						
						if (cantidad <= DataPlayer.getArrayJugadores()[1].getCanT()) {
							
							cP.colocarTropas(DataPlayer.getArrayJugadores()[1].getEquipo(), b.getCasilla(), tipo, cantidad, filaAct, columnaAct);
							
						} else {
							
							System.out.println("No tienes ese número de tropas");
							
						}
						
					} while (DataPlayer.getArrayJugadores()[1].getCanT() != 0);
					
					//TODO método para elegir las posiciones iniciales del segundo jugador, blue
					
					do {
						
						do {
							
							map.imprimirMapa(b);
							
							System.out.println("Es el turno del jugador "+turnoActivo);
							m.imprimirMenuCombate();
							optC = Leer.datoInt();
						
							switch (optC) {
								
								case 1:	//Mover tropas
									System.out.println("Indique la topa que desea movilizar:");
									System.out.println("Fila");
									filaAct=Leer.datoInt();
									System.out.println("Columna");
									columnaAct=Leer.datoInt();
									
									m.imprimirOpcionesMovimiento();
									ladoMov=Leer.datoInt();
									
									
									//TODO meter bucle para mover 
									break;
								
								case 2:
								
									break;
								
								case 3:
									
									break;
									
								default:
								
									System.out.println("¡Introduce una acción válida!");
								
									break;
							}
							
						} while (optC != 3);
						
						//TODO Aquí controlo los turnos
						if (turno%2 == cero) {
							turnoActivo = "A";
							System.out.println(turnoActivo);
						} else {
							turnoActivo = "R";
							System.out.println(turnoActivo);
						}
						
						turno++;
					
					} while (!cP.comprobarGanador(b.getCasilla()));
					break;
				case 2:
					m.imprimirMenuReglas();
					
					
					break;
					
				case 3:
					
					m.imprimirMenuCreditos();
					
					break;
		
				} 
		} while (opt !=0);
	}

}
