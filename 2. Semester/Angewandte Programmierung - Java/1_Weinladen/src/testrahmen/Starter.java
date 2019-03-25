/**
 * 3.Aufgabe
 */
package testrahmen;

/**
 * Starter.java:
 * Enthaelt die start-Methode, die die Ausfuehrung des ganzen Programms initialisiert.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 1 May 2018
 */
public class Starter {

	/**
	 * main:
	 * Die Methode initialisiert die Ausfuehrung des ganzen Programms.
	 * 
	 * @param args (String[]) Kommandozeilenparameter, dienen zur Steuerung des Programms von auessen.
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.start();
	}

}
