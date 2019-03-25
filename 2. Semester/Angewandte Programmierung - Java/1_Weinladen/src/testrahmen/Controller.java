/**
 * 3.Aufgabe
 */
package testrahmen;

import java.io.PrintStream;
import java.util.LinkedList;

import bestellung.BestellVerwaltung;
import bestellung.Bestellung;
import io.CSVexporter;
import io.ObjectReader;
import io.ObjectWriter;
import kunde.AKunde;
import kunde.Endverbraucher;
import kunde.InitialData;
import kunde.Kundenverwaltung;
import kunde.Statistik;

/**
 * Controller.java:
 * Steuert die Ausfuehrung des ganzen Programms.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 24 Apr 2018
 */
public class Controller {

	/**
	 * Das Objekt vom Typ Kundenverwaltung speichert Kundendaten.
	 */
	private Kundenverwaltung kundenverwaltung;

	/**
	 * Das Objekt vom Typ BestellVerwaltung speichert Angaben zur Bestellungen.
	 */
	private BestellVerwaltung bestellverwaltung;

	/**
	 * Das Objekt vom Typ InitialData erzeugt Anfangsdaten.
	 */
	private InitialData initialdata;

	/**
	 * Das Objekt vom Typ Ausgabe gibt Informationen auf der Console aus.
	 */
	private Ausgabe ausgabe;

	/**
	 * Das Objekt vom Typ EingabeValidator ueberprueft die vom Benutzer eingegebene Werte.
	 */
	private EingabeValidator eingabevalidator;

	/**
	 * Das Objekt vom Typ Statistik erstellt Statistiken nach Kundentypen.
	 */
	private Statistik statistik;

	/**
	 * Das Objekt vom Typ CSVexporter exportiert Kundendaten als CSV-Datei.
	 */
	private CSVexporter csvexporter;

	/**
	 * Das Objekt vom Typ ObjectWriter schreibt Objekte in einer Datei.
	 */
	private ObjectWriter objectwriter;

	/**
	 * Das Objekt vom Typ ObjectReader laedt Objekte aus einer Datei.
	 */
	private ObjectReader objectreader;

	/**
	 * Controller:
	 * Konstruktor ohne Parameter. Erzeugt Instanzen der Klassen.
	 */
	public Controller() {
		super();
		kundenverwaltung = new Kundenverwaltung();
		bestellverwaltung = new BestellVerwaltung(kundenverwaltung);
		initialdata = new InitialData(kundenverwaltung, bestellverwaltung);
		ausgabe = new Ausgabe();
		eingabevalidator = new EingabeValidator(ausgabe);
		statistik = new Statistik(this);
		csvexporter = new CSVexporter();
		objectwriter = new ObjectWriter(eingabevalidator.getEingabe(), ausgabe);
		objectreader = new ObjectReader(eingabevalidator.getEingabe(), ausgabe);
	}

	/**
	 * start:
	 * Zeigt das Menue an und fordert den Benutzer zur Menueauswahl auf,
	 * erzeugt Anfangsdaten der Kunden und deren Bestellungen.
	 */
	public void start() {
		initialdata.generateInitData();
		int menuAuswahl;

		do {
			ausgabe.gibMenuAus();
			menuAuswahl = processUserInput();
		} while (menuAuswahl != KonstantenWerte.MAX_MENU);
	}

	/**
	 * processUserInput:
	 * Nimmt ein und verarbeitet die von Benutzer eingegebenen Menuauswahl.
	 * 
	 * @return auswahl (int) Die von Benutzer eingegebenen Menuauswahl.
	 */
	private int processUserInput() {
		Bestellung bestellung = null;
		int auswahl = eingabevalidator.getMenuauswahl();
		AKunde neuKunde;
		switch (auswahl) {
		case 1:
			// Endverbraucher
			neuKunde = kundenverwaltung.neuEndverbraucher();
			((Endverbraucher) neuKunde).setBonitaet(eingabevalidator.requestBonitaet());
			neuKunde.setAnschrift(eingabevalidator.getValidierteAdresse());
			ausgabe.reportNeuKunde(neuKunde);
			break;
		case 2:
			// Grossverbraucher
			neuKunde = kundenverwaltung.neuGrossverbraucher();
			neuKunde.setAnschrift(eingabevalidator.getValidierteAdresse());
			ausgabe.reportNeuKunde(neuKunde);
			break;
		case 3:
			// Gesellschaft
			neuKunde = kundenverwaltung.neuGesellschaftMLiz();
			neuKunde.setAnschrift(eingabevalidator.getValidierteAdresse());
			ausgabe.reportNeuKunde(neuKunde);
			break;
		case 4:
			// generiert eine Anzahl der Kunden
			int anzahlkunden = eingabevalidator.getAnzahlKunden();
			kundenverwaltung.generateRandomKunden(anzahlkunden);
			ausgabe.reportGeneriertenKunden(anzahlkunden);
			break;
		case 5:
			// sortiert
			LinkedList<AKunde> kundenliste = kundenverwaltung.getSortedKundenliste();
			ausgabe.gibKundenlisteAus(kundenliste);
			break;
		case 6:
			// stat
			statistik.rechnenStatistik();
			ausgabe.gibStatistikAus(statistik);

			break;
		case 7:
			// neue Bestellung erzeugen
			bestellung = bestellverwaltung.konstruiereBestellung(eingabevalidator);
			ausgabe.gibBestellungAus(bestellung);
			break;
		case 8:
			// suche nach Bestellnummer
			bestellung = bestellverwaltung.sucheBestellung(eingabevalidator);
			ausgabe.gibBestellungAus(bestellung);
			break;
		case 9:
			// Bestellungen eines Kunden ausgeben
			bestellverwaltung.getSortedBestellliste(eingabevalidator, ausgabe);
			break;
		case 10:
			// Exportieren Kunden
			PrintStream printStream = eingabevalidator.getFilenameForWriteCSV("den Dateinamen zum Export");
			csvexporter.writeCSV(printStream, ",", kundenverwaltung);
			break;
		case 11:
			// Speichern von Kunden mit Bestellungen
			objectwriter.schreibObjekte(kundenverwaltung, bestellverwaltung, "den Dateinamen zum Speichern");
			break;
		case 12:
			// Laden von Kunden mit Bestellungen
			objectreader.lesenObjekte(this, "den Dateinamen zum Laden");
			break;
		case KonstantenWerte.MAX_MENU:
			// end
			System.out.println("Die Ausfuehrung des Programms ist beendet.\n");
			break;
		default:
		}
		return auswahl;
	}

	/**
	 * Liefert Das Objekt vom Typ Kundenverwaltung zurueck.
	 * 
	 * @return kundenverwaltung (Kundenverwaltung) Das Objekt vom Typ Kundenverwaltung speichert Kundendaten.
	 */
	public Kundenverwaltung getKundenverwaltung() {
		return kundenverwaltung;
	}

	/**
	 * Setzt ein neuen Objekt vom Typ Kundenverwaltung.
	 * 
	 * @param kundenverwaltung (Kundenverwaltung) Das Objekt vom Typ Kundenverwaltung speichert Kundendaten.
	 */
	public void setKundenverwaltung(Kundenverwaltung kundenverwaltung) {
		this.kundenverwaltung = kundenverwaltung;
	}

	/**
	 * Liefert Das Objekt vom Typ BestellVerwaltung zurueck.
	 * 
	 * @return bestellverwaltung (BestellVerwaltung) Das Objekt vom Typ BestellVerwaltung speichert Angaben zur Bestellungen.
	 */
	public BestellVerwaltung getBestellverwaltung() {
		return bestellverwaltung;
	}

	/**
	 * Setzt ein neuen Objekt vom Typ BestellVerwaltung.
	 * 
	 * @param bestellverwaltung (BestellVerwaltung) Das Objekt vom Typ BestellVerwaltung speichert Angaben zur Bestellungen.
	 */
	public void setBestellverwaltung(BestellVerwaltung bestellverwaltung) {
		this.bestellverwaltung = bestellverwaltung;
	}

}
