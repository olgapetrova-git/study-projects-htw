/**
 * 2.Aufgabe
 */
package kunde;

import java.io.Serializable;

/**
 * Adresse.java:
 * Beshreibt die Adresse des Kunden.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class Adresse implements Serializable {

	/**
	 * Der Name der Strasse.
	 */
	private String name;

	/**
	 * Die Nummer des Hauses.
	 */
	private String strasse_hnr;

	/**
	 * Die Postleitzahl.
	 */
	private String plz;

	/**
	 * Der Ort.
	 */
	private String ort;

	/**
	 * Adresse:
	 * Konstruktor mit Parameter.
	 * Erzeugt ein neues Objekt, speichert ubergegebenene Werte als Instanzvariablen.
	 * 
	 * @param name (String) Der Name der Strasse.
	 * @param strasse_hnr (String) Die Nummer des Hauses.
	 * @param plz (String) Die Postleitzahl.
	 * @param ort (String) Der Ort.
	 */

	public Adresse(String name, String strasse_hnr, String plz, String ort) {
		super();
		this.name = name;
		this.strasse_hnr = strasse_hnr;
		this.plz = plz;
		this.ort = ort;
	}

	/**
	 * Liefert den Wert des Strassennamens zurueck.
	 * 
	 * @return name (String) Der Name der Strasse.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt einen neuen Namen der Strasse.
	 * 
	 * @param name (String) Der Name der Strasse.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Liefert den Wert der Hausnummer zurueck.
	 * 
	 * @return strasse_hnr (String) Die Nummer des Hauses.
	 */
	public String getStrasse_hnr() {
		return strasse_hnr;
	}

	/**
	 * Setzt einen neuen Wert der Hausnummer.
	 * 
	 * @param strasse_hnr (String) Die Nummer des Hauses.
	 */
	public void setStrasse_hnr(String strasse_hnr) {
		this.strasse_hnr = strasse_hnr;
	}

	/**
	 * Liefert den Wert der Postleitzahl zurueck.
	 * 
	 * @return plz (String) Die Postleitzahl.
	 */
	public String getPlz() {
		return plz;
	}

	/**
	 * Setzt einen neuen Wert der Postleitzahl.
	 * 
	 * @param plz (String) Die Postleitzahl.
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}

	/**
	 * Liefert den Name vom Ort zurueck.
	 * 
	 * @return ort (String) Der Ort.
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Setzt einen neuen Wert fuer den Namen vom Ort.
	 * 
	 * @param ort (String) Der Ort.
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * Liefert die String Darstellung des Objektes Adresse zurueck.
	 */
	public String toString() {
		return "Adresse [name=" + name + ", strasse_hnr=" + strasse_hnr + ", plz=" + plz + ", ort=" + ort + "]";
	}

}
