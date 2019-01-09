package view;

public class Menu {
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void imprimirMenuBienv() {
		
		System.out.println("\r\n" + 
				"\t \t \t \t \t                                             */*      ./,,      ,**      .(*.   .            \r\n" + 
				"\t \t \t \t \t                        (#######################(*. .*(//***///(///**////(///**///(///,*////,(##########/                  \r\n" + 
				"\t \t \t \t \t                        (@@@@@@@@@@@##&@@@@@@@@&@@@%.  .(****,   *****/.  .(*****   ,/***/. .(@@@@@@@@@@/                  \r\n" + 
				"\t \t \t \t \t                       #@@@@@@@@@@@##&@@@@@@@@@@@@@&, .***/**   (,*/**,  ****/**   /,*/**. .(@@@@@@@@@@/                  \r\n" + 
				"\t \t \t \t \t                     ,(@@@@@@@@@@##%&&&&&@@@@@@@@@(...    .   .    ..  ,**//(#/**/.   ..  .*&@@@@@@@@/                  \r\n" + 
				"\t \t \t \t \t                        (@@@@@@@@@(,,,,,,,/(@@@@@@@* *&@@@@&@@@@#,  /(%@@@@@@%#%@@@@@@@@@#   (@@@@@@@@/   (@@@@@@@@@@#   \r\n" + 
				"\t \t \t \t \t                      ..(@@@@@@@@@##&@@@@@@@@@@@@@/  *&@@@@@@@@@%,.(@@@@@@@&(///(#&@@@@@@(   (@@@@@@@@/   (@@@@@@@@@@#   \r\n" + 
				"\t \t \t \t \t                      ..(@@@@@@@@@##&@@@@@@@@@/.    *&@@@@@@@@@%,/@@@@@@@@@#/*,.   /@@@@#   (@@@@@@@@/ .(%@@@@@@%###(   \r\n" + 
				"\t \t \t \t \t                       ..(@@@@@@@@@##&@@@@@@@@@@@@&*    #&@@@@@@@%,(@@@@@@@@@@@@@@@&%##*,..   (@@@@@@@@((%@@@@@@/         \r\n" + 
				"\t \t \t \t \t                       ..(@@@@@@@@@/   .#@@@@@@@@@@&.   ,#&&&&&@@#,,%@@@@@@@@@@@@@@@@@@@@&,   (@@@@@@@@##&@@@@@@@(.     . \r\n" + 
				"\t \t \t \t \t                      ..(&&&&&&&&&(.  .(&&&&&&&&&&&,   ,(&&&&&&@#,  *#&&&&&&&&&@@&&@@@@@@&.  (&@@@&&&@/,#@@@@@@&&&*  ... \r\n" + 
				"\t \t \t \t \t                        ((%&&&&&&&&&&%#..(&&&&&&&%&%((*,  (&&&&&&,/####( .,*(#%%&&&&&&&&&&// (%&&&&&&&&/  .%&&&&&&&///. \r\n" + 
				"\t \t \t \t \t                         (%%%%%%%%%%%%%#. (%%%%%%%%##%%#%*,(#%%%%%%#,/%%%%%%#*     ,#%%%&&&*  (&&%%&&%%%&/   (%%%%%%%%%%%#. \r\n" + 
				"\t \t \t \t \t                        (##############. *(###########%%*,(#%#%#%#(,/#%####%#%%##(########* .(%%%%%%%%%%/   (%#%%#######(. \r\n" + 
				"\t \t \t \t \t                        (##############.   *((##(###((##**(#######(,/(########%###%%%#(/.   .(##########/     (####((##(##(. ");
		
		System.out.println("\t");
		System.out.println("\t \t \t \t \t \t \t                       ______ _____ _____ _   _ _   _ _____ _   _ ___________ _____ _____ \r\n" + 
				"\t \t \t \t \t \t \t \t               | ___ \\_   _|  ___| \\ | | | | |  ___| \\ | |_   _|  _  \\  _  /  ___|\r\n" + 
				"\t \t \t \t \t \t \t \t               | |_/ / | | | |__ |  \\| | | | | |__ |  \\| | | | | | | | | | \\ `--. \r\n" + 
				"\t \t \t \t \t \t \t \t               | ___ \\ | | |  __|| . ` | | | |  __|| . ` | | | | | | | | | |`--. \\\r\n" + 
				"\t \t \t \t \t \t \t \t               | |_/ /_| |_| |___| |\\  \\ \\_/ / |___| |\\  |_| |_| |/ /\\ \\_/ /\\__/ /\r\n" + 
				"\t \t \t \t \t \t \t \t               \\____/ \\___/\\____/\\_| \\_/\\___/\\____/\\_| \\_/\\___/|___/  \\___/\\____/ \r\n" + 
				"                                                                   \r\n" + 
				"                                                                    ");
		
	}
	
	public void imprimirMenuPrincipal() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1. Empezar partida");
		System.out.println("2. Reglas");
		System.out.println("3. Créditos");
		System.out.println("-----------------------------------------------------------------");
	}
	
	public void imprimirMenuCreditos() {
		System.out.println("Realizado por: José María, Juan Antonio, Lucas y Gonzalo");
	}
	
	public void imprimirMenuReglas() {
		
		System.out.println("\t______  _____  _____  _       ___   _____ \r\n" + 
				"\t| ___ \\|  ___||  __ \\| |     / _ \\ /  ___|\r\n" + 
				"\t| |_/ /| |__  | |  \\/| |    / /_\\ \\\\ `--. \r\n" + 
				"\t|    / |  __| | | __ | |    |  _  | `--. \\\r\n" + 
				"\t| |\\ \\ | |___ | |_\\ \\| |____| | | |/\\__/ /\r\n" + 
				"\t\\_| \\_|\\____/  \\____/\\_____/\\_| |_/\\____/ \r\n" + 
				"                                          ");

		System.out.println("Gana la partida el que consigue destruir todas las tropas del enemigo");
		System.out.println("Si pasados 10 turnos no ha ganado nadie, ganará el que más tropa tenga");
		System.out.println("Sólo se pueden agrupar tropas del mismo tipo");
	}
	
	public void imprimirInicioPartida() {
		System.out.println("Lo primero es lo primero... hay dos facciones: Roja y Azul, elegid a suerte quién es quién y pulsad 1 cua");
		System.out.println("");
	}
	
	public void imprimirMenuCombate() {
		
		System.out.println("¿Qué deseas hacer?");
		System.out.println("1. Movilizar tropas");
		System.out.println("2. Atacar tropas");
		System.out.println("3. Pasar turno");
	}
	
	public void imprimirOpcionesMovimiento() {
		System.out.println("¿Hacia dónde quiere mover las tropas?");
		System.out.println("1. Derecha");
		System.out.println("2. Debajo");
		System.out.println("3. Izquierda");
		System.out.println("4. Arriba");
	}
}
