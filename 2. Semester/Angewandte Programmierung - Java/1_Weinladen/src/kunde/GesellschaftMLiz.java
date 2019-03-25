/**
 * 2.Aufgabe
 */
package kunde;

/**
 * GesellschaftMLiz.java:
 * Beshreibt die Daten der Gesellschaft mit Lizenzvertrieb, die eine der Kundentypen ist.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class GesellschaftMLiz extends AKunde {

	/**
	 * Der Vertriebswert der Gesellschaft mit Lizenzvertrieb.
	 * Der Defaultwert der Vertriebs ist gleich null.
	 */
	private int vertrieb = 0;

	/**
	 * Der Defaultwert des Kundenrabattes fuer die Gesellschaft mit Lizenzvertrieb.
	 */
	private static final double RABATT_GESELLSCHAFTMLIZ = 0.07;

	/**
	 * GesellschaftMLiz:
	 * Konstruktor ohne Parameter.
	 * Erzeugt ein neues Objekt GesellschaftMLiz mit dem Defaultwert des Kundenrabattes gleich 7%.
	 */
	public GesellschaftMLiz() {
		super(RABATT_GESELLSCHAFTMLIZ);
	}

	/**
	 * GesellschaftMLiz:
	 * Konstruktor mit Parameter.
	 * Ermoeglicht neue Werte des Kundenrabattes und des Vertriebs zu setzen.
	 * Speichert ubergegebenene Werte als Attribute des neuen Objektes.
	 * 
	 * @param rabatt (double) Der Kundenrabatt.
	 * @param vertrieb (int) Der Vertriebswert der Gesellschaft mit Lizenzvertrieb.
	 */
	public GesellschaftMLiz(double rabatt, int vertrieb) {
		super(rabatt);
		this.vertrieb = vertrieb;
	}

	/**
	 * Liefert den Wert der Vertiebs zurueck.
	 * 
	 * @return vertrieb (int) Der Vertrieb der Gesellschaft mit Lizenzvertrieb.
	 */
	public int getVertrieb() {
		return vertrieb;
	}

	/**
	 * Setzt einen neuen Wert der Vertiebs.
	 * 
	 * @param vertrieb (int) Der Vertrieb der Gesellschaft mit Lizenzvertrieb.
	 */
	public void setVertrieb(int vertrieb) {
		this.vertrieb = vertrieb;
	}

	/**
	 * Liefert die formatierte String Darstellung des Objektes GesellschaftMLiz zurueck.
	 */
	public String toString() {

		return String.format("GesellschaftMLiz [nummer=%s, %-14s, rabatt=%-4s, anschrift=%s]", nummer,
				"vertrieb=" + vertrieb, rabatt, anschrift);
	}

}
