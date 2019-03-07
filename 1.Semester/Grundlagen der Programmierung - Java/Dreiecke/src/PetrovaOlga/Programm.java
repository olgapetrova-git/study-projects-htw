/**
 * 
 */
package PetrovaOlga;

/**
 * Programm.java:
 * Enthaelt die main Methode als Einstiegspunkt, mit dem die Ausfuehrung des Programms beginnt.
 * 
 * @author Petrova Olga 
 * @version Java Version 1.8
 * @since * 19.12.2017
 */
public class Programm {

	/**
	 * main:
	 * Uebergibt weitere Ausfuehrung des Programs in die Klasse Programm, indem erzeugt Instanz der Klasse Controller
	 * und aufrufs ihre run-Methode.
	 * 
	 * @param args (String[] ): angegebene command-line Argumente als Array von String-Objekten.
	 */
	public static void main(String[] args) {
		Controller control = new Controller();
		control.run();
	}
}
