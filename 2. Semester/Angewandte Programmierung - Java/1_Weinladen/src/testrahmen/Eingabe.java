/**
 * 3.Aufgabe
 */
package testrahmen;

import java.util.Scanner;

/**
 * Eingabe.java:
 * Enthaelt die Methoden, um User Eingaben abzulesen, zu pruefen und zurueckzuliefern.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 1 May 2018
 */
public class Eingabe {

	/**
	 * scanner (Scanner) Liest die vom Benutzer eingegebenen Werte ab.
	 */
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Eingabe:
	 * Konstruktor ohne Parameter.
	 */
	public Eingabe() {
		super();
	}

	/**
	 * readString:
	 * Liest die von Benutzer eingegebene Zeichenkette ein.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @return line (String) Die vom Benutzer eingegebene nicht validierte Zeichenkette.
	 */
	public String readString(String label) {
		System.out.println("Bitte geben Sie " + label + " ein: ");
		String line = scanner.nextLine();
		return line;
	}

}