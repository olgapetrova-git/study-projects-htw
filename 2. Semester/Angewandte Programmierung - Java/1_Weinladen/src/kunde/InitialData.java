/**
 * 
 */
package kunde;

import bestellung.BestellVerwaltung;

/**
 * InitialData.java:
 * Dient zur Erstellung der Kunden und deren Bestellungen als Anfangsdaten.
 * sowie Hilfsmethoden zur Initialisierung der Daten.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 2 Jun 2018
 */
public class InitialData {

	/**
	 * Das Objekt vom Typ Kundenverwaltung speichert Kundendaten.
	 */
	private Kundenverwaltung kundenverwaltung;

	/**
	 * Das Objekt vom Typ BestellVerwaltung speichert Angaben zur Bestellungen.
	 */
	private BestellVerwaltung bestellverwaltung;

	/**
	 * InitialData:
	 * Konstruktor mit Parameter.
	 * 
	 * @param kundenverwaltung Instanz der Klasse Kundenverwaltung.
	 * @param bestellverwaltung Instanz der Klasse BestellVerwaltung.
	 */
	public InitialData(Kundenverwaltung kundenverwaltung, BestellVerwaltung bestellverwaltung) {
		this.kundenverwaltung = kundenverwaltung;
		this.bestellverwaltung = bestellverwaltung;
	}

	/**
	 * generateInitData:
	 * Erzeugt die neuen Kunden mit der Bestellungen zur Programmstart als Anfangsdaten.
	 */
	public void generateInitData() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				AKunde neuKunde = kundenverwaltung.neuKunde(i);
				for (int k = 0; k < (i * 2 + j + 1); k++) { // 1, 2, 3, 4, 5, 6 Bestellungen
					bestellverwaltung.generateNeuBestellung(neuKunde);
				}
			}
		}
	}

}
