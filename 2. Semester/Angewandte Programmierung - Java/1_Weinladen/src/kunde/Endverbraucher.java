/**
 * 2.Aufgabe
 */
package kunde;

/**
 * Endverbraucher.java:
 * Beshreibt die Daten des Endverbrauchers, der einer der Kundentypen ist.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class Endverbraucher extends AKunde {

	/**
	 * Die Bonitaet des Endverbrauchers gibt an,
	 * ob der Endverbraucher faehig seine Zahlungsverpflichtungen zu erfuellen ist.
	 */
	private boolean bonitaet;

	/**
	 * Der Defaultwert des Kundenrabattes fuer den Endverbraucher.
	 */
	private static final double RABATT_ENDVERBRAUCHER = 0;

	/**
	 * Endverbraucher:
	 * Konstruktor ohne Parameter.
	 * Erzeugt ein neues Objekt Endverbraucher mit dem Defaultwert des Kundenrabattes gleich null
	 * und dem Defaultwert der Bonitaet gleich true.
	 */
	public Endverbraucher() {
		super(RABATT_ENDVERBRAUCHER);
		bonitaet = true;
	}

	/**
	 * Endverbraucher:
	 * Konstruktor mit Parameter.
	 * Ermoeglicht neue Werte des Kundenrabattes und der Bonitaet zu setzen.
	 * Speichert ubergegebenene Werte als Attribute des neuen Objektes.
	 * 
	 * @param rabatt (double) Der Kundenrabatt.
	 * @param bonitaet (boolean) Die Bonitaet des Endverbrauchers.
	 */

	public Endverbraucher(double rabatt, boolean bonitaet) {
		super(rabatt);
		this.bonitaet = bonitaet;
	}

	/**
	 * Liefert den Wert der Bonitaet zurueck.
	 * 
	 * @return bonitaet (boolean) Die Bonitaet des Endverbrauchers.
	 */
	public boolean isBonitaet() {
		return bonitaet;
	}

	/**
	 * Setzt einen neuen Wert der Bonitaet des Endverbrauchers.
	 * 
	 * @param bonitaet (boolean) Die Bonitaet des Endverbrauchers.
	 */
	public void setBonitaet(boolean bonitaet) {
		this.bonitaet = bonitaet;
	}

	/**
	 * Liefert die formatierte String Darstellung des Objektes Endverbraucher zurueck.
	 */
	public String toString() {

		return String.format("Endverbraucher   [nummer=%s, %-14s, rabatt=%-4s, anschrift=%s]", nummer,
				"bonitaet=" + bonitaet, rabatt, anschrift);
	}

}
