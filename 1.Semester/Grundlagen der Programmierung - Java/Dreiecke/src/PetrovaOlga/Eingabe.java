
package PetrovaOlga;

import java.util.Scanner;

/**
 * Eingabe.java:
 * Enthaelt die Methoden, um User Eingaben abzulesen, zu pruefen und zu speichern.
 * 
 * @author Petrova Olga 
 * @version Java Version 1.8
 * @since * 18.12.2017
 */
public class Eingabe {
	// Attribute (Instanzvariable)
	Daten eingabedaten;
	Scanner scan; // als Instanzvariable definiert um die gleische Objekt scan mehrmals im alle Methoden der Klasse zu benutzen

	/**
	 * Eingabe: Konstruktor mit Parametern.
	 * Speichert ubergegebene Objekt als Attribut der Klasse.
	 * 
	 * @param newdaten (Daten) Instanz der Klasse Daten.
	 */

	public Eingabe(Daten newdaten) { // newdaten (Objekt der Klasse Daten) existiert nur innerhalb des Konstruktors
		eingabedaten = newdaten; // deswegen wurde newdaten als eingabedaten gespeichert, damit es in der Klasse Eingabe benutzt werden kann
	} // end of constructor

	/**
	 * getPositivInt: Validiert User Eingabe, um nur positive Ganzzahl oder Null zuzulassen.
	 * 
	 * @return zahl (int): gibt positive Ganzzahl oder "0" zurueck.
	 */
	int getPositivInt() {

		int zahl;
		do {
			while (!scan.hasNextInt()) {
				System.out.println("Das ist keine ganze Zahl!");
				scan.next();
			}
			zahl = scan.nextInt();
			if (zahl < 0)
				System.out.println("Bitte geben Sie eine positive Zahl oder \"0\" ein!");
		} while (zahl < 0);

		return zahl;
	}

	/**
	 * getUserInput:
	 * Liest die vom Benutzer eingegebenen Werte ab und speichert sie in einem Array.
	 */
	public void getUserInput() {
		scan = new Scanner(System.in);
		while (eingabedaten.eingangsArrayZaehler < 110) {
			System.out.println("Moechten Sie die dreieckigen Lederreststuecke pruefen?\n"
					+ "Sie koennen die Werte von drei Seiten nacheinander (ganzzahlig in cm) eingeben.\n"
					+ "Um die Eingabe zu beenden, geben Sie der Wert \"0\" ein.\n"
					+ "Bitte geben Sie die erste Seite ein:");
			int seite1 = getPositivInt();
			if (seite1 == 0)
				break;
			System.out.println("Bitte geben Sie die zweite Seite ein:");
			int seite2 = getPositivInt();
			if (seite2 == 0)
				break;
			System.out.println("Bitte geben Sie die dritte Seite ein:");
			int seite3 = getPositivInt();
			if (seite3 == 0)
				break;
			int[] dreieck = { seite1, seite2, seite3 };
			eingabedaten.addEngangsDreiecke(dreieck);
		}

		System.out.println("Vielen Dank. Eingabe von Werten ist beendet.\n");
		scan.close(); // close scanner nur wenn Eingabe von allen Werten ist beendet
	}

}
