/**
 * 1.Aufgabe
 */
package model;

/**
 * Palette.java:
 * Erhaellt Beschreibung des Objektes Palette.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class Palette extends AVerpackungseinheit {
	/**
	 * Der Defaultwert von der Anzahl der Flaschen fuer die Verpackungseinheit "Palette".
	 */
	private static final int DEFAULT_PALETTE = 36;

	/**
	 * Palette:
	 * Konstruktor ohne Parameter.
	 * Erzeugt ein neues Objekt Palette mit der Standertmenge an Flaschen.
	 */
	public Palette() {
		super(DEFAULT_PALETTE);
	}

	/**
	 * Palette:
	 * Konstruktor mit Parameter.
	 * Speichert ubergegebenen Wert als Attribut des Objektes.
	 * Ermoeglicht die Groesse der Palette zu setzen.
	 * 
	 * @param anzahlFlaschen (int) Groesse der Palette in Flaschen.
	 */

	public Palette(int anzahlFlaschen) {
		super(anzahlFlaschen);
	}

	/**
	 * Liefert die String Darstellung des Objektes Palette zurueck.
	 */
	public String toString() {

		return "Palette [anzahlFlaschen=" + anzahlFlaschen + "]";
	}

}
