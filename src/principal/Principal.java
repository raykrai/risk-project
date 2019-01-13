package principal;

import controller.ControllerPartida;
import controller.ControllerBattle;
import data.DataBattle;
import data.DataPlayer;
import model.Battle;
import utilidades.Leer;
import view.Mapa;
import view.Menu;

/*
 * Division de trabajo desglosado por partes:
 * 
 * -Clases POJO:
 *
 * 	-Terreno: Juan Antonio Lago
 * 	-Jugador: Jose María Ruiz
 * 	-Tropas: Lucas Amado
 * 	-Battle: Jose María Ruiz
 * 
 * -Data:
 * 
 * 	-Data Battle: Jose María Ruiz
 * 	-Data Player: Juan Antonio Lago
 * 
 * -View:
 * 
 * 	· Mapa:
 * 
 * 		-Imprimir mapa: Lucas Amado.
 * 
 * 	· Menú:
 * 		-Imprimir menú bienvenda: Jose María Ruiz
 * 		-Imprimir menú principal: Juan Antonio Lago
 * 		-Imprimir menú reglas: Lucas Amado
 * 		-Imprimir menú movimiento: Lucas Amado
 * 		-Imprimir Ganador ataque: Jose María Ruiz
 * 		-Imprimir Ganador partida: Juan Antonio Lago
 * 
 * 	-Controller:
 * 		-Controller Battle
 * 			-Método tirar dados x1 x2 x3: Juan Antonio Lago
 * 			-Método atacar tropas y defender: Juan Antonio Lago
 * 			-Método Comprobar batalla: Juan Antonio Lago
 * 			-Método conquistar terreno, comprobar distancia y mover tropas: Jose María Ruiz
 * 			-Método comprobar terreno y mover derecha, izquierda, debajo, arriba: Lucas Amado 
 * 		-Controller Partida:
 * 			-Método colocar tropas: Juan Antonio Lago
 * 			-Método comprobar final: Jose María Ruiz
 * 			-Método comprobar ganador: Lucas Amado
 * 
 * 	-Main:
 * 
 * 	En el main hemos hecho el testeo de métodos y haciendo el control de bucles e impresiones todos, por lo tanto es
 * 	difícil dividirlo de forma equitativa, todos hemos participado en el main pero a la hora de estructurar el programa
 * 	la decisión final era del coordinador Jose María Ruiz, pero Juan Antonio Lago, Lucas Amado y Jose María Ruiz han 
 *  desarrollado el main.
 *  
 *  -Valoración: Jose María Ruiz
 *  
 *   Yo, José María Ruiz Laguna, coordinador del proyecto redacto aquí mis impresiones:
 *
 *	 Creo que ha sido una experiencia buena en nuestro primer proyecto en el que realmente tocábamos código (porque el anterior eran dos sysos...).
 *	 A su vez, pienso que una gran complejidad del juego era que no usábamos interfaz gráfica, sino que usábamos la consola. De esta forma nos planteábamos formas distintas
 *	 y rebuscadas de hacer que el usuario interactuara con el menor "comedero de cabeza" posible.
 *
 *	 Creo que nuestro trabajo ha quedado bastante bien, y refleja bastante la dificultad e intensidad del juego de mesa, pero obviamente, sin llegar a serlo completamente, ya que, simplemente con 3 opciones,
 *	 hemos podido llegar a redactar más de 20 líneas de reglas sólo incluyendo tres opciones/funcionalidades jugables. 
 *
 *	 Por ello no vimos conveniente, el añadir más funcionalidades, ya que pasaría de ser un juego, a una tortura (como leer el manual de una lavadora en polaco).
 *	 En líneas generales, todos los miembros hemos estado implicados en el proyecto haciendo una función u otra (a excepción de Gonzalo).
 *  
 * 
 *  */


public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		//Variables (turno y turnoActivo para controlar el paso de los turnos) (movFin y atqFin para controlar la salida de los menús) (el resto para controlar posiciones y opciones)
		
		int turno = 2, opt, cero = 0, optC, filaAct=0, columnaAct=0, filaAtaque=0, columnaAtaque=0, ladoMov=0, cantidad, uno=1, dos=2, tres=3, quiereSalir, tiempo=2500;
		boolean movFin, atqFin, atacanteGanador;
		String turnoActivo = "R";
		String tipo;
		
		//Se inicializan la base de datos, el mapa de la batalla, el menú y los controladores
		
		DataBattle dB = new DataBattle();
		Battle b = new Battle(dB.getCasilla());
		Mapa map = new Mapa();
		Menu m = new Menu();
		
		ControllerBattle cB = new ControllerBattle();
		ControllerPartida cP = new ControllerPartida();
		
		//Se muestra el menú
		m.imprimirCarga();
		m.imprimirMenuBienv();
		
		do {
		
			//Se muestra el menú y se lee la opción deseada
			m.imprimirMenuPrincipal();
			
			opt = Leer.datoInt();
				
			switch (opt) {
			
				case 0:
					
					break;
					
				case 1:
					
					//Comienza la fase de inicio donde cada jugador elige donde colocar sus tropas
					
					m.imprimirComienzoPartida();
					System.out.println("Primero elegirá las posiciones iniciales el jugador Red (R)\n");
					
					do {
						
						//Fase de Inicio del jugador Red
						
						map.imprimirMapa(b);
						
						System.out.println("Te quedan "+DataPlayer.getArrayJugadores()[0].getCanT()+" tropas");
						System.out.println("Elige el tipo de tropa a colocar:");
						
						do {
							System.out.println("Inf o Cab");
							
							tipo = Leer.dato();
							
							//Se controla excepción o error tipográfico 
							
							if (!tipo.equals("Inf") && !tipo.equals("Cab")) {
								System.out.println("Elige un tipo de tropa existente");
							}
						} while (!tipo.equals("Inf") && !tipo.equals("Cab"));
						
						System.out.println("Elige la cantidad de tropas a colocar");
						
						cantidad = Leer.datoInt();
						
						System.out.println("Elige la fila del terreno");
						
						filaAct = Leer.datoInt();
						
						System.out.println("Elige la columna del terreno");
						
						columnaAct = Leer.datoInt();
						
						//Se controla el número de tropas que tiene el jugador aún por colocar, si es que tiene
						
						if (cantidad <= DataPlayer.getArrayJugadores()[cero].getCanT()) {
							
							cP.colocarTropas(DataPlayer.getArrayJugadores()[cero].getEquipo(), b.getCasilla(), tipo, cantidad, filaAct, columnaAct);
							
						} else {
							
							System.out.println("No tienes ese número de tropas");
							
						}
						
					} while (DataPlayer.getArrayJugadores()[cero].getCanT() != cero);
					
					//Comienza la fase de inicio del jugador Blue (igual que la del Red)
					
					System.out.println("Ahora el jugador Blue (B)");
					
					do {
						
						map.imprimirMapa(b);
						
						System.out.println("Te quedan "+DataPlayer.getArrayJugadores()[uno].getCanT()+" tropas");
						System.out.println("Elige el tipo de tropa a colocar:");
						System.out.println("Inf o Cab");
						
						tipo = Leer.dato();
						
						System.out.println("Elige la cantidad de tropas a colocar");
						
						cantidad = Leer.datoInt();
						
						System.out.println("Elige la fila del terreno");
						
						filaAct = Leer.datoInt();
						
						System.out.println("Elige la columna del terreno");
						
						columnaAct = Leer.datoInt();
						
						if (cantidad <= DataPlayer.getArrayJugadores()[uno].getCanT()) {
							
							cP.colocarTropas(DataPlayer.getArrayJugadores()[uno].getEquipo(), b.getCasilla(), tipo, cantidad, filaAct, columnaAct);
							
						} else {
							
							System.out.println("No tienes ese número de tropas");
							
						}
						
					} while (DataPlayer.getArrayJugadores()[uno].getCanT() != 0);
					
					//Comienza la partida como tal
					
					//El primer do{} while() hace que la partida siga hasta que se reunan las condiciones necesarias como para que haya un empate o un ganador
					
					do {
						
						//Este controla el turno de cada jugador con las variables turnoActivo y turno
						
						do {
							
							map.imprimirMapa(b);
							
							System.out.println("Es el turno del jugador "+turnoActivo);
							m.imprimirMenuCombate();
							optC = Leer.datoInt();
						
							switch (optC) {
								
								case 1:	//Mover tropas
									
									movFin = false;
									
									//Esto controla si el usuario quiere pasar turno porque se ha arrepentido de la opción escogida o si ha acabado el movimiento
									
									do { 
										
										System.out.println("Si deseas mover una tropa aliada a una posición aliada pulsa 0. Sin embargo, si no hay posición disponible, tendrás que pasar turno pulsando cualquier otro número.");
										
										quiereSalir = Leer.datoInt();

										if (quiereSalir == cero) {
											
											
											System.out.println("Indique la tropa que desea movilizar:");
											System.out.println("Fila");
											filaAct=Leer.datoInt();
											System.out.println("Columna");
											columnaAct=Leer.datoInt();
											
											if (!dB.getCasilla()[filaAct-uno][columnaAct-uno].getEquipo().equals(turnoActivo) ) {
												
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
								
								case 2: //Atacar tropas
									
									atqFin = false;
									
									//Se controla si el ataque se ha realizado o si el usuario se ha arrepentido y prefiere pasar turno
									
									do {
										
										System.out.println("Si deseas realizar un ataque pulsa 0. Sin embargo, si prefieres/tienes que pasar turno pulsa cualquier otro número.");
										
										quiereSalir = Leer.datoInt();
										
										if (quiereSalir == cero) {
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
											
											//Se comprueba la distancia de la casilla y si hay luz verde y las tropas elegidas para atacar son de tu equipo se llama a conquistarTerreno 
											//que llama a comprobarBatalla que saca si el atacante ha ganado o no y a su vez se modifica el campo de batalla según los resultados
											
											if (cB.comprobarDistancia(filaAct, columnaAct, filaAtaque, columnaAtaque) == true && dB.getCasilla()[filaAct-1][columnaAct-1].getEquipo().equals(turnoActivo)) {
												
												System.out.println("Espere un segundo. Se está realizando la batalla");
												cP.pararTiempo(tiempo);
												atacanteGanador = cB.comprobarBatalla(filaAct, columnaAct, dB.getCasilla(), filaAtaque, columnaAtaque);
												cB.conquistarTerreno(atacanteGanador, filaAct, columnaAct, dB.getCasilla(), filaAtaque, columnaAtaque);
												
												m.imprimirGanadorAtaque(atacanteGanador, turno);
												
												atqFin = true;
												
											} else {
												System.out.println("Las tropas no pueden efectuar el ataque porque el enemigo está demasiado lejos o porque quizás te has confundido de equipo :/\n");
											}
											
										} else {
											atqFin = true;
										}
										
									} while (atqFin != true);
									
									break;
								
								case 3:
									//Pasas turno
									
									break;
									
								default:
									//Se controlan excepciones
									
									System.out.println("¡Introduce una acción válida!");
								
									break;
							}
							
							// Aquí controlo los turnos con la regla de, un turno yo, un turno tú.
							
							if (turno%dos == cero) {
								turnoActivo = "B";
							} else {
								turnoActivo = "R";
							}
							
							turno++;
							
						} while (optC != tres);
					
					} while (!cP.comprobarFinal(b.getCasilla()));
					
					//Se muestra el resultado final de la partida y acaba el programa (para volver a jugar, hay que ejecutar de nuevo)
					
					System.out.println("Se ha acabado la partida");
					
					m.imprimirGanadorPartida(cP.comprobarGanador(b.getCasilla()));
					
					opt = cero;
					break;
					
				case 2:
					
					//Se imprime el menú de las reglas
					
					m.imprimirMenuReglas();
					
					break;
					
				case 3:
					
					//Se imprime el menú de los créditos
					m.imprimirMenuCreditos();
					
					break;
		
				} 
		} while (opt !=cero);
	}

}
