/**
 * 1.Aufgabe
 */
package model;

import java.io.Serializable;

/**
 * WeinSorte.java:
 * Enthaellt die Beshreibung von einer Weinsorte und der Preis des Weines.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class WeinSorte implements Serializable {
	/**
	 * Die Sorte des Weins.
	 */
	private String weinsorte;

	/**
	 * Der Preis des Weins.
	 */
	private double preis;

	/**
	 * WeinSorte:
	 * Konstruktor mit Parameter.
	 * Erzeugt ein neues Objekt, speichert ubergegebenene Werte als Instanzvariable.
	 * 
	 * @param weinsorte (String) Weinsorte.
	 * @param preis (double) Preis des Weins.
	 */

	public WeinSorte(String weinsorte, double preis) {
		super();
		this.weinsorte = weinsorte;
		this.preis = preis;
	}

	/**
	 * Liefert die Bezeichnung der Weinsorte zurueck.
	 * 
	 * @return weinsorte (String) Weinsorte.
	 */
	public String getWeinsorte() {
		return weinsorte;
	}

	/**
	 * Setzt einen neuen Namen der Weinsorte.
	 * 
	 * @param weinsorte (String) Weinsorte.
	 */
	public void setWeinsorte(String weinsorte) {
		this.weinsorte = weinsorte;
	}

	/**
	 * Liefert den Wert des Preises von Wein zurueck.
	 * 
	 * @return preis (double) Preis des Weins.
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * Setzt einen neuen Preis der Weinsorte.
	 * 
	 * @param preis (double) Preis des Weins.
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * Liefert die String Darstellung des Objektes Weinsorte zurueck.
	 */
	public String toString() {
		return "WeinSorte [weinsorte=" + weinsorte + ", preis=" + preis + "]";
	}

}
