/**
 * 1.Aufgabe
 */
package model;

/**
 * Karton.java:
 * Erhaellt Beschreibung des Objektes Karton.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class Karton extends AVerpackungseinheit {
	/**
	 * Der Defaultwert von der Anzahl der Flaschen fuer die Verpackungseinheit "Karton".
	 */
	private static final int DEFAULT_KARTON = 12;

	/**
	 * Karton:
	 * Konstruktor ohne Parameter.
	 * Erzeugt ein neues Objekt Karton mit der Standertmenge an Flaschen.
	 */
	public Karton() {
		super(DEFAULT_KARTON);
	}

	/**
	 * Karton:
	 * Konstruktor mit Parameter.
	 * Speichert ubergegebenen Wert als Attribut des Objektes.
	 * Ermoeglicht die Groesse des Kartons zu setzen.
	 * 
	 * @param anzahlFlaschen (int) Groesse des Kartons in Flaschen.
	 */

	public Karton(int anzahlFlaschen) {
		super(anzahlFlaschen);
	}

	/**
	 * Liefert die String Darstellung des Objektes Karton zurueck.
	 */
	public String toString() {
		return "Karton [anzahlFlaschen=" + anzahlFlaschen + "]";
	}

}
