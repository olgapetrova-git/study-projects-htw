/**
 * 1.Aufgabe
 */
package model;

/**
 * AVerpackungseinheit.java:
 * Dient zur Definition von Groessen der Verpackungseinheiten.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */

public abstract class AVerpackungseinheit {
	/**
	 * Groesse einer Verpackungseinheit in Flaschen, bei default ist gleich ein Stuck.
	 * Zugriffsmodifikator "protected", um sichtbar fuer Unterklassen zu sein.
	 */
	protected int anzahlFlaschen = 1;

	/**
	 * AVerpackungseinheit:
	 * Konstruktor mit Parameter.
	 * Erzeugt ein neues Objekt, speichert ubergegebenen Wert der Verpackungsgroesse als Attribut.
	 * 
	 * @param anzahlFlaschen (int) Groesse einer Verpackungseinheit in Flaschen.
	 */

	public AVerpackungseinheit(int anzahlFlaschen) {
		super();
		this.anzahlFlaschen = anzahlFlaschen;
	}

	/**
	 * Liefert Groesse der Verpackungseinheit in Flaschen zurueck.
	 * 
	 * @return anzahlFlaschen (int) die Anzahl der Flaschen in einer Verpackungseinheit.
	 */
	public int getAnzahlFlaschen() {
		return anzahlFlaschen;
	}

	/**
	 * Setzt einen neuen uebergebenen Wert der Verpackungsgroesse.
	 * 
	 * @param anzahlFlaschen (int) the anzahlFlaschen to set.
	 */
	public void setAnzahlFlaschen(int anzahlFlaschen) {
		this.anzahlFlaschen = anzahlFlaschen;
	}

	/**
	 * Liefert die String Darstellung des Objektes zurueck.
	 */
	public abstract String toString();

}
