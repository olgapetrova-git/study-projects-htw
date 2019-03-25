/**
 * 2.Aufgabe
 */
package kunde;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * AKunde.java:
 * Beshreibt die gemeinsamen Eigenschaften fuer den verschiedenen Typen der Kunden.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public abstract class AKunde implements Serializable {

	/**
	 * Die Kundennummer.
	 */
	protected String nummer;

	/**
	 * Der Rabatt des Kunden.
	 */
	protected double rabatt = 0.0;

	/**
	 * Die Anschrift des Kunden.
	 */
	protected Adresse anschrift;

	/**
	 * Die Liste der Bestellnummern von einem Kunden.
	 */
	private LinkedList<String> bestellnummerliste = new LinkedList<String>();

	/**
	 * AKunde:
	 * Konstruktor mit Parameter.
	 * Wird beim Erstellen eines neuen Objektes (Endverbraucher, GesellschaftMLiz, Grossverbraucher) aufgeruft.
	 * Speichert ubergegebenen Wert des Kundenrabattes als Attribut des Objektes.
	 * Erstellt und speichert die Kundennummer als Attribut des Objektes.
	 * 
	 * @param rabatt (double) der Wert der zugehoerigen Rabattstafel.
	 */
	public AKunde(double rabatt) {
		super();
		this.rabatt = rabatt;
		nummer = KundenNummernVergeber.getExemplar().generiereKundenNummer();
		// Rufen die Klasse auf, erzeugen Instanz der Klasse mithilfe von der Klassenmethode getExemplar() (static),
		// rufen Instanzmethode getKundenNummer (non static)
	}

	/**
	 * addBestellnummer:
	 * Addiert die Bestellnummer zur Liste, um Links zur aktuellen Kundenbestellungen zu speichern.
	 * 
	 * @param bestellnummer (String) Die eindeutige Bestellnummer.
	 */
	public void addBestellnummer(String bestellnummer) {
		bestellnummerliste.add(bestellnummer);
	}

	/**
	 * Liefert den Wert der Kundennummer zurueck.
	 * 
	 * @return nummer (String) Die Kundennummer.
	 */
	public String getNummer() {
		return nummer;
	}

	/**
	 * Liefert den Wert des Kundenrabattes zurueck.
	 * 
	 * @return rabatt (double) Der Rabatt des Kunden.
	 */
	public double getRabatt() {
		return rabatt;
	}

	/**
	 * Setzt einen neuen uebergebenen Wert des Kundenrabattes.
	 * 
	 * @param rabatt (double) Der Rabatt des Kunden.
	 */
	public void setRabatt(double rabatt) {
		this.rabatt = rabatt;
	}

	/**
	 * Liefert die Anschriftdaten des Kunden zurueck.
	 * 
	 * @return anschrift (String) Die Anschrift des Kunden.
	 */
	public Adresse getAnschrift() {
		return anschrift;
	}

	/**
	 * Setzt einen neuen uebergebenen Wert der Kundenadresse.
	 * 
	 * @param anschrift (String) Die Anschrift des Kunden.
	 */
	public void setAnschrift(Adresse anschrift) {
		this.anschrift = anschrift;
	}

	/**
	 * getBestellnummerliste:
	 * Liefert Die Liste der Bestellnummern eines Kunden zurueck.
	 * 
	 * @return bestellnummerliste (LinkedList String) Die Liste der Bestellnummern Bestellnummern von einem Kunden.
	 */
	public LinkedList<String> getBestellnummerliste() {
		return bestellnummerliste;
	}

	/**
	 * Liefert die String Darstellung des Objektes zurueck.
	 */
	public abstract String toString();

}
