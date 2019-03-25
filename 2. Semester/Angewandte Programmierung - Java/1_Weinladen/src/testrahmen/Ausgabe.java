/**
 * 
 */
package testrahmen;

import java.util.LinkedList;

import bestellung.Bestellung;
import kunde.AKunde;
import kunde.Statistik;

/**
 * Ausgabe.java:
 * Dient zur Programmausgabe auf der Console.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 30 May 2018
 */
public class Ausgabe {

	/**
	 * Ausgabe:
	 * Konstruktor Ohne Parameter
	 */

	public Ausgabe() {
		super();
	}

	/**
	 * gibMenuAus:
	 * Gibt die Menueanzeige aus.
	 */
	public void gibMenuAus() {
		System.out.println("--- Menu: ---\n" +
				"1. Einen neuen Endverbraucher anlegen.\n" +
				"2. Einen neuen Grossverbraucher anlegen.\n" +
				"3. Eine neue Gesellschaft mit Lizenzvertrieb anlegen.\n" +
				"4. Eine benutzerdefinierte Anzahl der Kunden erzeugen (max." + KonstantenWerte.MAX_KUNDEN + ").\n" +
				"5. Alle Kunden nach Nummer sortiert ausgeben.\n" +
				"6. Statistik nach der Anzahl der Kunden ausgeben.\n" +
				"7. Bestellung erfassen.\n" +
				"8. Bestellnummer suchen.\n" +
				"9. Bestellungen nach Datum absteigend sortiert ausgeben (nach Kundennummer suchen).\n" +
				"10. Exportieren aller Kunden als CSV-Datei. \n" +
				"11. Speichern vom Kunden mit Bestellungen. \n" +
				"12. Laden von Kunden mit Bestellungen. \n" +
				"13. Programm beenden. \n");
	}

	/**
	 * reportNeuKunde:
	 * Gibt auf der Console die Daten ueber den neuen Kunden aus.
	 * 
	 * @param kunde (AKunde) Objekt jegliches Typs: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 */
	public void reportNeuKunde(AKunde kunde) {
		System.out.println("Neuer Kunde wurde erstellt: " + kunde.toString() + " .\n");
	}

	/**
	 * reportGeneriertenKunden:
	 * Gibt auf der Console die Meldung ueber die automatisch generierten Kunden aus.
	 * 
	 * @param anzahlkunden (int) Vom Benutzer erhhaltene Anzahl der Kunden.
	 */
	public void reportGeneriertenKunden(int anzahlkunden) {
		System.out.println(anzahlkunden + " neue Kunden wurde erstellt. \n");
	}

	/**
	 * gibKundenlisteAus:
	 * Gibt die Kundenliste auf der Console aus.
	 * 
	 * @param kundenliste (LinkedList AKunde) Die Liste der Kunden.
	 */
	public void gibKundenlisteAus(LinkedList<AKunde> kundenliste) {
		System.out.println("---Kundenliste: ---");
		if (kundenliste.size() == 0) {
			System.out.println("Kundenliste ist leer.\n");
		} else {
			System.out.println("Gesamtanzahl der Kunden ist " + kundenliste.size() + ".");
			for (AKunde kunde : kundenliste) {
				System.out.println(kunde.toString());
			} // end of for
		} // end of else
	}

	/**
	 * gibStatistikAus:
	 * Gibt die Statistik nach Kundentypen auf der Console aus.
	 * 
	 * @param statistik (Statistik) Das Objekt erstellt Statistiken nach Kundentypen.
	 */
	public void gibStatistikAus(Statistik statistik) {
		System.out.println(statistik.gibStatistikAlsString());
	}

	/**
	 * gibBestellungAus:
	 * Gibt die Beschreibung einer Bestellung auf der Console aus.
	 * 
	 * @param bestellung (Bestellung) Das Objekt vom Typ Bestellung speichert Daten zur Bestellung.
	 */
	public void gibBestellungAus(Bestellung bestellung) {
		if (bestellung != null) {
			System.out.println(bestellung.toString());
		}
	}

	/**
	 * gibBestelllisteAus:
	 * Gibt die Bestellliste eines Kunden auf der Console aus.
	 * 
	 * @param bestellliste (LinkedList Bestellung) Die sortierte Liste der Bestellungen eines Kunden.
	 * @param kunde (AKunde) Das Objekt vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 */
	public void gibBestelllisteAus(LinkedList<Bestellung> bestellliste, AKunde kunde) {
		System.out.println("--- Bestellliste des Kunden mit Kundennummer " + kunde.getNummer() + " : ---");

		if (bestellliste.size() == 0) {
			System.out.println("Bestellliste dieses Kunden ist leer.\n");
		} else {
			System.out.println("Gesamtanzahl der Bestellungen ist " + bestellliste.size() + " .");
			for (Bestellung bestellung : bestellliste) {
				System.out.println(bestellung.toString());
			} // end of for
		} // end of else
	}// end of method

	/**
	 * reportExceptionLesezugriff:
	 * Gibt auf der Console die Meldung ueber die SecurityException.
	 */
	public void reportExceptionZugriff() {
		System.out.println("Zugriff auf die Datei ist verweigert. \n"
				+ "Geben Sie bitte einen anderen Dateinamen und/oder Pfad ein.\n");
	}

	/**
	 * reportMeldungSchreiben:
	 * Gibt auf der Console die Meldung, dass die Datei nicht beschreibbar ist.
	 */
	public void reportMeldungSchreiben() {
		System.out.println("Diese Datei ist nicht beschreibbar. "
				+ "Geben Sie bitte einen anderen Dateinamen und/oder Pfad ein.\n");
	}

	/**
	 * reportIOException:
	 * Gibt auf der Console die Meldung ueber die IOException.
	 */
	public void reportIOException() {
		System.out.println("Die Datei existiert nicht oder kann nicht geöffnet werden.\n"
				+ "Es konnte nicht aus der Datei gelesen oder in der Datei geschrieben werden.\n"
				+ "Geben Sie bitte einen anderen Dateinamen und/oder Pfad ein.\n");
	}

	/**
	 * reportErstelltException:
	 * Gibt auf der Console die Meldung ueber die Exception, dass die Datei nicht erstellt werden konnte.
	 */
	public void reportErstelltException() {
		System.out.println("Datei konnte nicht erstellt werden. "
				+ "Geben Sie bitte einen anderen Dateinamen und/oder Pfad ein.\n");
	}

	/**
	 * reportClassNotFoundException:
	 * Gibt auf der Console die Meldung ueber die reportClassNotFoundException.
	 */
	public void reportClassNotFoundException() {
		System.out.println("Die Daten in der Datei sind nicht korrekt. \n");
	}
}
