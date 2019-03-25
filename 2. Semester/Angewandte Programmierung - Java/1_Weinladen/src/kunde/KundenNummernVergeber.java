/**
  * 2.Aufgabe
 */
package kunde;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * KundenNummernVergeber.java:
 * Dient zur Erstellung von Kundennummern. Singleton.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 22 Apr 2018
 */
public class KundenNummernVergeber {

	/**
	 * Die Kundennummer, wird aus Gross/Kleinbuschtaben und Ziffern erstellt.
	 */
	private String nummer;

	/**
	 * Der Katalog von Kundennummern.
	 */
	private ArrayList<String> kundennummernkatalog;

	/**
	 * Die einzigartige Instanz.
	 */
	private static KundenNummernVergeber kv = null;

	/**
	 * KundenNummernVergeber:
	 * Konstruktor ohne Parameter.
	 * Verhinderte Instanziierung von aussen (private).
	 */
	private KundenNummernVergeber() {
		super();
		kundennummernkatalog = new ArrayList<String>();
	}

	/**
	 * getExemplar:
	 * Liefert eine Referenz auf einzigartige Instanz der Klasse.
	 * Wenn nicht vorhanden, erzeugt dieses.
	 * 
	 * @return kv (KundenNummernVergeber) Instanz der Klasse.
	 */
	public static KundenNummernVergeber getExemplar() {
		if (kv == null) {
			kv = new KundenNummernVergeber();
		}

		return kv;
	}

	/**
	 * generiereKundenNummer:
	 * Erstellt die Kundennummer aus 3 Kleinbuchstaben, 3 Ziffern und 3 Grossbuchstaben, die zufaellig gewaehlt werden.
	 * 
	 * @return nummer (String) die Kundennummer.
	 */
	public String generiereKundenNummer() {
		char[] chararray = new char[9];
		Random rand = new Random();
		boolean success;
		do {
			success = true;
			for (int i = 0; i < 3; i++) {
				chararray[i] = (char) (rand.nextInt(26) + 97); // klein
			}
			for (int i = 3; i < 6; i++) {
				chararray[i] = (char) (rand.nextInt(10) + 48); // ziffern
			}
			for (int i = 6; i < 9; i++) {
				chararray[i] = (char) (rand.nextInt(26) + 65); // gross
			}
			nummer = new String(chararray);
			for (String kundennummer : kundennummernkatalog) {
				if (kundennummer == nummer) {
					success = false;
				}
			}
		} while (success == false);
		kundennummernkatalog.add(nummer);
		return nummer;
	}

	/**
	 * refreshKundennummernkatalog:
	 * Erstellt den aktuellen Katalog der Kundennummern.
	 * 
	 * @param kundenliste (LinkedList AKunde) Die Liste der Kunden.
	 */
	public void refreshKundennummernkatalog(LinkedList<AKunde> kundenliste) {
		kundennummernkatalog.clear();
		for (AKunde kunde : kundenliste) {
			kundennummernkatalog.add(kunde.getNummer());
		}

	}
}
