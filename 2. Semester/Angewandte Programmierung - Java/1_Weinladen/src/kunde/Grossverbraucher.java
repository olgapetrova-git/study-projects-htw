/**
 * 2.Aufgabe 
 */
package kunde;

/**
 * Grossverbraucher.java:
 * Beshreibt die Daten der Grossverbrauchers, der einer der Kundentypen ist.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class Grossverbraucher extends AKunde {

	/**
	 * Der Status des Grossverbrauchers.
	 * Der Defaultwert fuer Status ist gleich null.
	 */
	private int status = 0;

	/**
	 * Der Defaultwert des Kundenrabattes fuer den Grossverbraucher.
	 */
	private static final double RABATT_GROSSVERBRAUCHER = 0.05;

	/**
	 * Grossverbraucher:
	 * Konstruktor ohne Parameter.
	 * Erzeugt ein neues Objekt Grossverbraucher mit dem Defaultwert des Kundenrabattes gleich 5%.
	 */
	public Grossverbraucher() {
		super(RABATT_GROSSVERBRAUCHER);
	}

	/**
	 * Grossverbraucher:
	 * Konstruktor mit Parameter.
	 * Ermoeglicht neue Werte des Kundenrabattes und des Status zu setzen.
	 * Speichert ubergegebenene Werte als Attribute des neuen Objektes.
	 * 
	 * @param rabatt (double) Der Kundenrabatt.
	 * @param status (int) Der Status des Grossverbrauchers.
	 */

	public Grossverbraucher(double rabatt, int status) {
		super(rabatt);
		this.status = status;
	}

	/**
	 * Liefert den Wert der Status.
	 * 
	 * @return status (int) Der Status des Grossverbrauchers.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Setzt einen neuen Wert der Status.
	 * 
	 * @param status (int) Der Status des Grossverbrauchers.
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Liefert die formatierte String Darstellung des Objektes Grossverbraucher zurueck.
	 */
	public String toString() {

		return String.format("Grossverbraucher [nummer=%s, %-14s, rabatt=%-4s, anschrift=%s]", nummer,
				"status=" + status, rabatt, anschrift);
	}

}
