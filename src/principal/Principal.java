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
		int turno = 2, opt, cero = 0, optC, filaAct=0, columnaAct=0, filaAtaque=0, columnaAtaque=0, ladoMov=0, cantidad, uno=1, quiereSalir;
		boolean movFin;
		String turnoActivo = "R";
		String tipo;
		
		DataBattle dB = new DataBattle();
		Battle b = new Battle(dB.getCasilla());
		Mapa map = new Mapa();
		Menu m = new Menu();
		
		ControllerBattle cB = new ControllerBattle();
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

					do {
						
						do {
							
							map.imprimirMapa(b);
							
							System.out.println("Es el turno del jugador "+turnoActivo);
							m.imprimirMenuCombate();
							optC = Leer.datoInt();
						
							switch (optC) {
								
								case 1:	//Mover tropas
									
									movFin = false;
									
									do {
										//TODO Meter condicional para pasar turno  
										
										System.out.println("Si deseas mover una tropa aliada a una posición aliada pulsa 0. Sin embargo, si no hay posición disponible, tendrás que pasar turno pulsando 1.");
										
										quiereSalir = Leer.datoInt();

										if (quiereSalir == 0) {
											
											
											System.out.println("Indique la tropa que desea movilizar:");
											System.out.println("Fila");
											filaAct=Leer.datoInt();
											System.out.println("Columna");
											columnaAct=Leer.datoInt();
											
											if (!dB.getCasilla()[filaAct-1][columnaAct-1].getEquipo().equals(turnoActivo) ) {
												
												System.out.println("Esas tropas no son tuyas");
												
											} else {
												System.out.println("Indica la cantidad deseada a mover");
												cantidad=Leer.datoInt();
												
												m.imprimirMenuMovimiento(filaAct, columnaAct);
												ladoMov=Leer.datoInt();
												movFin=cB.moverTropas(filaAct, columnaAct, b.getCasilla(), ladoMov, cantidad);
											}
											
											
										} else {
											movFin = true;
										}
									} while (!movFin);
									
									break;
								
								case 2:
									
									do {
										
										System.out.println("Indique la tropa con la que desea atacar");
										
										System.out.println("Fila");
										filaAct = Leer.datoInt();
										
										System.out.println("Columna");
										columnaAct = Leer.datoInt();
										
										System.out.println("Indique el terreno o casilla a atacar");
										
										System.out.println("Fila");
										filaAtaque = Leer.datoInt();
										
										System.out.println("Columna");
										columnaAtaque = Leer.datoInt();
										
										//TODO Finalizar comprobar distancia e incorporar método para comparar tirada de dados
										
										if (cB.comprobarDistancia(filaAct, columnaAct, filaAtaque, columnaAtaque) == true) {
											//método para comparar las tiradas (donde se ejecutarán las tiradas
										} else {
											System.out.println("Las tropas están demasiado lejos");
										}
									} while (cB.comprobarDistancia(filaAct, columnaAct, filaAtaque, columnaAtaque) != true);
									
									break;
								
								case 3:
									
									break;
									
								default:
								
									System.out.println("¡Introduce una acción válida!");
								
									break;
							}
							
							//TODO Aquí controlo los turnos
							if (turno%2 == cero) {
								turnoActivo = "B";
								System.out.println(turnoActivo);
							} else {
								turnoActivo = "R";
								System.out.println(turnoActivo);
							}
							
							turno++;
							
						} while (optC != 3);
					
					} while (!cP.comprobarGanador(b.getCasilla()));
					break;
				case 2:
					
					m.imprimirMenuReglas();
					
					//TODO Testeando comprobar distancia, NO BORRAR POR FAVOR
					
					/*map.imprimirMapa(b);
					
					do {
						
						System.out.println("Indique la tropa con la que desea atacar");
						
						System.out.println("Fila");
						filaAct = Leer.datoInt();
						
						System.out.println("Columna");
						columnaAct = Leer.datoInt();
						
						System.out.println("Indique el terreno o casilla a atacar");
						
						System.out.println("Fila");
						filaAtaque = Leer.datoInt();
						
						System.out.println("Columna");
						columnaAtaque = Leer.datoInt();
						
						if (cB.comprobarDistancia(filaAct, columnaAct, filaAtaque, columnaAtaque) == true) {
							System.out.println("Las tropas están al lado");
						} else {
							System.out.println("Las tropas están demasiado lejos");
						}
					} while (cB.comprobarDistancia(filaAct, columnaAct, filaAtaque, columnaAtaque) != true);
					*/
					
					break;
					
				case 3:
					
					m.imprimirMenuCreditos();
					
					break;
		
				} 
		} while (opt !=0);
	}

}
