/**
 * 
 */
package bestellung;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import kunde.AKunde;
import kunde.Kundenverwaltung;
import model.WeinLager;
import model.WeinSorte;
import testrahmen.Ausgabe;
import testrahmen.EingabeValidator;
import testrahmen.KonstantenWerte;

/**
 * BestellVerwaltung.java:
 * Dient zur Verwaltung von Bestellungen.
 * 
 * @author Petrova Olga
 * E-Mail
 * @version Java Version 1.8
 * @since * 26 May 2018
 * 
 */

public class BestellVerwaltung implements Serializable {

	/**
	 * Das Verzeichnis der Bestellungen.
	 */
	private HashMap<String, Bestellung> bestellungsverzeichnis = new HashMap<String, Bestellung>();
	/**
	 * Objekt vom Typ Kundenverwaltung speichert Kundendaten.
	 */
	private Kundenverwaltung kundenverwaltung;

	/**
	 * Objekt vom Typ WeinLager speichert Angaben zur Weinsorten im Sortiment des Weinladens.
	 */
	private WeinLager weinlager;

	/**
	 * BestellVerwaltung:
	 * Konstruktor mit Parameter.
	 * Erzeugt und speichert Instanzen als Attribute.
	 * 
	 * @param kundenverwaltung (Kundenverwaltung) Objekt vom Typ Kundenverwaltung.
	 */
	public BestellVerwaltung(Kundenverwaltung kundenverwaltung) {
		super();
		this.kundenverwaltung = kundenverwaltung;
		weinlager = new WeinLager();
	}

	/**
	 * addBestellung:
	 * Addiert neue Bestellung zum Bestellungsverzeichnis.
	 * 
	 * @param neuBestellung (Bestellung) Instanz der Bestellung-Klasse.
	 */
	private void addBestellung(Bestellung neuBestellung) {
		if (neuBestellung != null) {
			bestellungsverzeichnis.put(neuBestellung.getBestellnummer(), neuBestellung);
		}
	} // end of method

	/**
	 * neuBestellung:
	 * Erzeugt neue Bestellung und speichert sie in Bestellungverzeichnis,
	 * Fuegt der Bestellnummerliste vom Kunden die Bestellnummer hinzu.
	 * 
	 * @param kunde (AKunde) Das Objekt vom jeglichen Typ: vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 * @param bestelldatum (LocalDate) Das Bestelldatum.
	 * @param weinsorte (WeinSorte) Instanz der Klasse, enthaelt die Beschreibung von einer Weinsorte.
	 * @param anzahl (int) Die Anzahl der Flaschen in einer Bestellung.
	 * @return neuBestellung (Bestellung) Das Objekt vom Typ Bestellung, speichert die Daten von einer Bestellung.
	 */
	public Bestellung neuBestellung(AKunde kunde, LocalDate bestelldatum, WeinSorte weinsorte, int anzahl) {
		Bestellung neuBestellung = new Bestellung(kunde, bestelldatum, weinsorte, anzahl);
		addBestellung(neuBestellung);
		kunde.addBestellnummer(neuBestellung.getBestellnummer());
		return neuBestellung;
	}

	/**
	 * generateNeuBestellung:
	 * Erzuegt eine neue Bestellung eines Kunden, wobei es eine randomisierte Zuweisung von Bestellparameter gibt.
	 * 
	 * @param kunde (AKunde) Das Objekt vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 * @return neuBestellung (Bestellung) Das Objekt vom Typ Bestellung, speichert die Daten von einer Bestellung.
	 */
	public Bestellung generateNeuBestellung(AKunde kunde) {
		Random rand = new Random();
		LocalDate current = LocalDate.of(2010, 1, 1);
		LocalDate bestelldatum = LocalDate.ofEpochDay(current.toEpochDay() + rand.nextInt(36524));
		// ofEpochDay erzeugt aus random int ein Datum
		// toEpochDay erzeugt aus Datum ein int (anzahl der tage seit epoch day - 1.1.1970 unix)
		ArrayList<WeinSorte> weinliste = weinlager.getWeinliste();
		WeinSorte weinsorte = weinliste.get(rand.nextInt(weinliste.size()));
		int anzahl = rand.nextInt(KonstantenWerte.MAX_FLASCHEN) + KonstantenWerte.MIN_FLASCHEN;
		Bestellung neuBestellung = new Bestellung(kunde, bestelldatum, weinsorte, anzahl);
		addBestellung(neuBestellung);
		kunde.addBestellnummer(neuBestellung.getBestellnummer());
		return neuBestellung;
	}

	/**
	 * konstruiereBestellung:
	 * Konstruiert neue Bestellung aus der vom Benutzer angegebenen Werten.
	 * 
	 * @param eingabevalidator (EingabeValidator) Das Objekt vom Typ EingabeValidator ueberprueft die vom Benutzer eingegebene Werte.
	 * @return neuBestellung (Bestellung) Das Objekt vom Typ Bestellung speichert die Daten von einer Bestellung.
	 */
	public Bestellung konstruiereBestellung(EingabeValidator eingabevalidator) {
		AKunde kunde = null;
		LocalDate bestelldatum;
		WeinSorte weinsorte;
		int anzahl;
		Bestellung bestellung = null;
		kunde = kundenverwaltung.sucheKunde(eingabevalidator);
		if (kunde == null) {
			return null;
		}
		bestelldatum = eingabevalidator.getUserInputDate("ein Datum mit dem Format TT.MM.JJJJ");

		weinsorte = eingabevalidator.getUserInputWeinSorte("Menuauswahl", weinlager);

		anzahl = eingabevalidator.getUserInputZahl("die Anzahl der Flaschen", KonstantenWerte.MIN_FLASCHEN,
				KonstantenWerte.MAX_FLASCHEN);
		bestellung = neuBestellung(kunde, bestelldatum, weinsorte, anzahl);
		return bestellung;
	}// end of method

	/**
	 * sucheBestellung:
	 * Sucht, ob es eine Bestellung mit der vom Benutzer eingegebenen Nummer gibt.
	 * 
	 * @param eingabevalidator (EingabeValidator) Das Objekt vom Typ EingabeValidator ueberprueft die vom Benutzer eingegebene Werte.
	 * @return bestellung (Bestellung) Gibt das Objekt vom Typ Bestellung zurueck, wenn die Bestellnummer stimmt, ansonsten null.
	 */
	public Bestellung sucheBestellung(EingabeValidator eingabevalidator) {
		Bestellung bestellung = null;
		String bestellnummer = eingabevalidator.getUserInputString("eine Bestellnummer",
				KonstantenWerte.BESTELLNUMMER_LENGTH,
				KonstantenWerte.BESTELLNUMMER_LENGTH,
				"[a-z]{3}[0-9]{3}[A-Z]{3}-[0-9]{3}",
				"Das Format der Bestellnummer ist falsch. Bitte beachten Sie, dass die Bestellnummer besteht aus der Kundennummer,\n"
						+ "ergaenzt durch den Bindestrich und drei Ziffern. Bsp.: abc765KLM-890. \n");
		bestellung = bestellungsverzeichnis.get(bestellnummer);

		if (bestellung == null) {
			System.out.println("Eine Bestellung mit dieser Nummer existiert nicht.\n");
		}
		return bestellung;
	}

	/**
	 * getBestellungsverzeichnis:
	 * Liefert das Bestellungsverzeichnis zurueck.
	 * 
	 * @return bestellungsverzeichnis (HashMap String, Bestellung) Das Verzeichnis der Bestellungen.
	 */
	public HashMap<String, Bestellung> getBestellungsverzeichnis() {
		return bestellungsverzeichnis;
	}

	/**
	 * getSortedBestellliste:
	 * Gibt die nach Datum sortierte Liste der Bestellungen von einem Kunden,
	 * entsprechend der vom Benutzer eingegebenen Kundennummer aus.
	 * 
	 * @param eingabevalidator (EingabeValidator) Das Objekt vom Typ EingabeValidator
	 * ueberprueft die vom Benutzer eingegebene Werte.
	 * @param ausgabe (Ausgabe) Das Objekt vom Typ Ausgabe gibt Informationen auf der Console aus.
	 */
	public void getSortedBestellliste(EingabeValidator eingabevalidator, Ausgabe ausgabe) {
		LinkedList<Bestellung> bestellliste = new LinkedList<Bestellung>();
		AKunde kunde = kundenverwaltung.sucheKunde(eingabevalidator);
		if (kunde != null) {
			for (String bestellnummer : kunde.getBestellnummerliste()) {
				bestellliste.add(bestellungsverzeichnis.get(bestellnummer));
			}
			Collections.sort(bestellliste);
			ausgabe.gibBestelllisteAus(bestellliste, kunde);
		}
	}

}
