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
		
		
		
		
	}
	
	public void imprimirMenuPrincipal() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" __       _____                                                                 _    _      _        \r\n" + 
				"/  |     |  ___|                                                               | |  (_)    | |       \r\n" + 
				"`| |     | |__   _ __ ___   _ __    ___  ____  __ _  _ __   _ __    __ _  _ __ | |_  _   __| |  __ _ \r\n" + 
				" | |     |  __| | '_ ` _ \\ | '_ \\  / _ \\|_  / / _` || '__| | '_ \\  / _` || '__|| __|| | / _` | / _` |\r\n" + 
				"_| |_ _  | |___ | | | | | || |_) ||  __/ / / | (_| || |    | |_) || (_| || |   | |_ | || (_| || (_| |\r\n" + 
				"\\___/(_) \\____/ |_| |_| |_|| .__/  \\___|/___| \\__,_||_|    | .__/  \\__,_||_|    \\__||_| \\__,_| \\__,_|\r\n" + 
				"                           | |                             | |                                       \r\n" + 
				"                           |_|                             |_|                                       ");
		System.out.println(" _____    ______               _             \r\n" + 
				"/ __  \\   | ___ \\             | |            \r\n" + 
				"`' / /'   | |_/ /  ___   __ _ | |  __ _  ___ \r\n" + 
				"  / /     |    /  / _ \\ / _` || | / _` |/ __|\r\n" + 
				"./ /___ _ | |\\ \\ |  __/| (_| || || (_| |\\__ \\\r\n" + 
				"\\_____/(_)\\_| \\_| \\___| \\__, ||_| \\__,_||___/\r\n" + 
				"                         __/ |               \r\n" + 
				"                        |___/                ");
		System.out.println(" _____     _____                  _  _  _               \r\n" + 
				"|____ |   /  __ \\                | |(_)| |              \r\n" + 
				"    / /   | /  \\/ _ __   ___   __| | _ | |_   ___   ___ \r\n" + 
				"    \\ \\   | |    | '__| / _ \\ / _` || || __| / _ \\ / __|\r\n" + 
				".___/ / _ | \\__/\\| |   |  __/| (_| || || |_ | (_) |\\__ \\\r\n" + 
				"\\____/ (_) \\____/|_|    \\___| \\__,_||_| \\__| \\___/ |___/");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void imprimirMenuCreditos() {
		System.out.println("Realizado por: José María, Juan Antonio, Lucas y Gonzalo");
	}
	
	public void imprimirMenuReglas() {

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
