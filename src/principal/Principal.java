package principal;

import controller.ControllerPartida;
import data.DataBattle;
import model.Battle;
import model.Terrain;
import utilidades.Leer;
import view.Mapa;
import view.Menu;

public class Principal {

	public static void main(String[] args) {
		int turno = 2, opt, cero = 0, optC, filaAct=0, columnaAct=0, ladoMov=0;
		String turnoActivo = "R";
		
		DataBattle dB = new DataBattle();
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
					
					System.out.println("Lo primero es lo primero... hay dos facciones: RED (R) y BLUE (B)");
					
					map.imprimirMapa(b);
					
					//TODO método para elegir las posiciones iniciales del jugador red
					
					//TODO método para elegir las posiciones iniciales del segundo jugador, blue
					
					do {
						
						do {
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
					
					
					
					break;
					
				case 3:
					
					m.imprimirMenuCreditos();
					
					break;
		
				} 
		} while (opt !=0);
	}

}
