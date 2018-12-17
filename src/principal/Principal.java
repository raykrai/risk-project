package principal;

import utilidades.Leer;
import view.Menu;

public class Principal {

	public static void main(String[] args) {
		int turno = 2, opt, cero = 0, optC;
		String turnoActivo = "R";
		
		//TODO Ver la manera de controlar la finalización de la partida sin usar una variable aquí
		boolean isFinished = false;
		Menu m = new Menu();
		
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
					
					System.out.println("Lo primero es lo primero... hay dos facciones: Roja y Azul");
					
					//m.imprimirMapa;
					
					//método para elegir las posiciones iniciales
					
					//método para elegir las posiciones iniciales del segundo jugador
					
					do {
						
						//m.mostrarMenuCombate
						
						optC = Leer.datoInt();
						
						//TODO Aquí controlo los turnos
						if (turno%2 == cero) {
							turnoActivo = "A";
							System.out.println(turnoActivo);
						} else {
							turnoActivo = "R";
							System.out.println(turnoActivo);
						}
						
						turno++;
						
					} while (isFinished);
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
