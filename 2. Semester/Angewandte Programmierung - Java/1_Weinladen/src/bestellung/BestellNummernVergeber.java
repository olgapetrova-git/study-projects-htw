/**
 * 
 */
package bestellung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * BestellNummernVergeber.java:
 * Dient zur Erstellung von Bestellnummern. Singleton.
 * 
 * @author Petrova Olga
 * E-Mail
 * @version Java Version 1.8
 * @since * 26 May 2018
 */
public class BestellNummernVergeber {

	/**
	 * Der einzigartige letzte Teil der Bestellnummer, wird aus 3 Ziffern erstellt.
	 */
	private String teilnummer;

	/**
	 * Der Katalog der Nummern von der erfassenden Bestellungen.
	 */
	private ArrayList<String> bestellnummernkatalog;

	/**
	 * Die einzigartige Instanz.
	 */
	private static BestellNummernVergeber bv = null;

	/**
	 * BestellNummernVergeber:
	 * Konstruktor ohne Parameter.
	 * Verhinderte Instanziierung von aussen (private).
	 */
	private BestellNummernVergeber() {
		super();
		bestellnummernkatalog = new ArrayList<String>();
	}

	/**
	 * getExemplar:
	 * Liefert eine Referenz auf einzigartige Instanz der Klasse.
	 * Wenn nicht vorhanden, erzeugt dieses.
	 * 
	 * @return bv (BestellNummernVergeber) Instanz der Klasse.
	 */

	public static BestellNummernVergeber getExemplar() {
		if (bv == null) {
			bv = new BestellNummernVergeber();
		}

		return bv;
	}

	/**
	 * generiereBestellnummer:
	 * Erstellt den eindeutigen Teil der Bestellnummer aus 3 Ziffern, die zufaellig gewaehlt werden.
	 * 
	 * @return teilnummer (String) der Teil der Bestellnummer.
	 */
	public String generiereBestellnummer() {
		char[] chararray = new char[3];
		Random rand = new Random();
		boolean success;
		do {
			success = true;

			for (int i = 0; i < 3; i++) {
				chararray[i] = (char) (rand.nextInt(10) + 48); // ziffern
			}
			teilnummer = new String(chararray);
			for (String bestellnummer : bestellnummernkatalog) {
				if (bestellnummer == teilnummer) {
					success = false;
				}
			}
		} while (success == false);
		bestellnummernkatalog.add(teilnummer);
		return teilnummer;
	}

	/**
	 * refreshBestellnummernkatalog:
	 * Erstellt den aktuellen Katalog der Bestellnummern.
	 * 
	 * @param bestellungsverzeichnis (HashMap String, Bestellung) Das Verzeichnis der Bestellungen.
	 */
	public void refreshBestellnummernkatalog(HashMap<String, Bestellung> bestellungsverzeichnis) {
		bestellnummernkatalog.clear();
		for (Map.Entry<String, Bestellung> entry : bestellungsverzeichnis.entrySet()) {
			bestellnummernkatalog.add(entry.getKey());
		}

	}
}
