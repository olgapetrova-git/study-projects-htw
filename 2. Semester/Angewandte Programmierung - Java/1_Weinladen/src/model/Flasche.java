/**
* 1.Aufgabe 
 */
package model;

/**
 * Flasche.java:
 * Erhaellt Beschreibung des Objektes Flasche.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class Flasche extends AVerpackungseinheit {
	/**
	 * Der Defaultwert von der Anzahl der Flaschen fuer die Verpackungseinheit "Flasche".
	 */
	private static final int DEFAULT_FLASCHE = 1;

	/**
	 * Flasche:
	 * Konstruktor ohne Parameter.
	 * Erzeugt eine neues Objekt Flasche, das eine Einzelflasche als Defaultwert darstellt.
	 */
	public Flasche() {
		super(DEFAULT_FLASCHE);
	}

	/**
	 * Flasche:
	 * Konstruktor mit Parameter.
	 * Speichert ubergegebenen Wert als Attribut des Objektes.
	 * Ermoeglicht die Groesse der Flasche zu setzen.
	 * 
	 * @param anzahlFlaschen (int) Groesse der groessen Flasche in Einzelnflaschen.
	 * 
	 */
	/*
	 * Klasse Flasche, Konstruktor Flashe(int anzahFlaschen):
	 * sollte es moeglich sein, eine Flasche mit der Groesse
	 * mehr als eine Flasche zu erstellen?
	 */
	public Flasche(int anzahlFlaschen) {
		super(anzahlFlaschen);
	}

	/**
	 * Liefert die String Darstellung des Objektes Flasche zurueck.
	 */
	public String toString() {
		return "Flasche [anzahlFlaschen=" + anzahlFlaschen + "]";
	}
}
