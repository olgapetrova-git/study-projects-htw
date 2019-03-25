/**
 * 
 */
package testrahmen;

import java.io.File;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import kunde.Adresse;
import model.WeinLager;
import model.WeinSorte;

/**
 * EingabeValidator.java:
 * Ueberprueft die vom Benutzer eingegebene Werte auf der bestimmten Regeln.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 30 May 2018
 */
public class EingabeValidator {

	/**
	 * Das Objekt vom Typ Eingabe liest Benutzereingaben ein.
	 */
	private Eingabe eingabe;

	/**
	 * Das Objekt vom Typ Ausgabe gibt die Daten auf der Console aus.
	 */
	private Ausgabe ausgabe;

	/**
	 * EingabeValidator:
	 * Konstruktor mit Parameter.
	 * 
	 * @param ausgabe (Ausgabe) Das Objekt vom Typ Ausgabe gibt die Daten auf der Console aus.
	 */
	public EingabeValidator(Ausgabe ausgabe) {
		super();
		eingabe = new Eingabe();
		this.ausgabe = ausgabe;
	}

	/**
	 * validateValueRange:
	 * Prueft, ob der vom Benutzer eigegebene Wert liegt in dem zulaessigen Bereich.
	 * 
	 * @param nummer (int) Der vom Benutzer eigegebene Wert.
	 * @param minValue (int) Der minimal zulaessige Wert.
	 * @param maxValue (int) Der maximal zulaessige Wert.
	 * @throws ValueRangeException auftritt, falls der Wert nicht in dem bestimmten Bereich liegt.
	 */
	private void validateValueRange(int nummer, int minValue, int maxValue) throws ValueRangeException {
		if (nummer < minValue || nummer > maxValue) {
			throw new ValueRangeException("Der eingegebene Wert liegt nicht in dem bestimmten Bereich."
					+ " Zulaessige Eingabe: ganzzahlige Wert zwischen " + minValue + " und " + maxValue + ".");
		}
	}

	/**
	 * getUserInput:
	 * Liest die vom Benutzer eingegebenen Werte ab und validiert Benutzer Eingaben,
	 * um nur positive Ganzzahl vom bestimmten Interval zuzulassen.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @param minValue (int) Der minimal zulaessige Wert fuer die vom Benutzer eingegebene Zahl.
	 * @param maxValue (int) Der maximal zulaessige Wert fuer die vom Benutzer eingegebene Zahl.
	 * @return (int) Die vom Benutzer eingegebene Zahl.
	 */
	public int getUserInputZahl(String label, int minValue, int maxValue) {
		int nummer = 0;
		do {
			try {
				String line = eingabe.readString(label);
				nummer = Integer.parseInt(line);
				validateValueRange(nummer, minValue, maxValue);
			} // end of try
			catch (NumberFormatException notanumber) {
				// 1) kann waehrend Integer.parseInt(string) auftreten wenn string kann nicht zur nummer parsen
				System.out.println(notanumber.getMessage() + " : Der eingegebene Wert ist keine Zahl."
						+ " Zulaessige Eingabe: ganzzahlige Wert zwischen " + minValue + " und " + maxValue + ".");

			} catch (ValueRangeException notinrange) {
				// 2) tritt auf, wenn wert liegt nicht in dem zulaessigen interval
				System.out.println(notinrange.getMessage());
				nummer = 0;
			}
		} // end of do
		while (nummer == 0);
		return nummer;
	}// end of method

	/**
	 * getUserInputString:
	 * Nimmt die von Benutzer eingegebene Zeichenkette an und prueft,
	 * dass sie die bestimmte Laenge hat und einem Pattern uebereinstimmt.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @param minLength (String) Der minimal zulaessige Wert fuer die vom Benutzer eingegebene Zeichenkette.
	 * @param maxLength (String) Der maximal zulaessige Wert fuer die vom Benutzer eingegebene Zeichenkette.
	 * @param pattern (String) Die Musterregel fuer eine Zeichenkette.
	 * @param patternError (String) Die Meldung ueber den Fehler fuer den Benutzer.
	 * @return line (String) Die vom Benutzer eingegebene und validierte Zeichenkette.
	 */
	public String getUserInputString(String label, int minLength, int maxLength, String pattern, String patternError) {
		String line = null;
		boolean isOK = false;
		if (pattern == null) { // wenn das Muster leer ist, ersetzen es durch einen Ausdruck, der allem entspricht
			pattern = ".+";
		}
		do {
			line = eingabe.readString(label);
			if ((line.length() < minLength || line.length() > maxLength) && (minLength != maxLength)) {
				System.out.println("Der Wert liegt nicht zwischen " + minLength + " und " + maxLength + ".");
			} else if (Pattern.matches(pattern, line) == false) // wenn die vom Benutzer eingegebene Zeichenfolge nicht mit der Musterregel
																// uebereinstimmt
			{
				System.out.println(patternError); // dann geben eine Meldung ueber diesen Fehler an die Konsole aus
			} else {
				isOK = true;
			}
		} while (isOK == false);
		return line;
	}

	/**
	 * getUserInputBoolean:
	 * Nimmt die vom Benutzer eingegebene Zeichenkette an und prueft, dass sie die zulaessige Werte hat.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @return auswahl (boolean) Der vom Benutzer eingegebene Wert als boolean.
	 */
	private boolean getUserInputBoolean(String label) {
		String line = null;
		boolean auswahl = false;
		boolean isOK = false;
		do {
			line = eingabe.readString(label + " (1 - ja, 0 - nein)");
			if (line.equals("1") || line.equals("j") || line.equals("ja")) {
				auswahl = true;
				isOK = true;
			} else if (line.equals("0") || line.equals("n") || line.equals("nein")) {
				isOK = true;
			}
			if (isOK == false) {
				System.out.println("Der Wert kann nicht gelesen werden. Bitte geben Sie 1 fuer ja und 0 fuer nein.");
			}
		} while (isOK == false);
		return auswahl;
	}

	/**
	 * requestBonitaet:
	 * Liest ein das von Benutzer eingegebenen Bonitaet.
	 * 
	 * @return bonitaet (boolean) Die Bonitaet des Endverbrauchers gibt an,
	 * ob der Endverbraucher faehig seine Zahlungsverpflichtungen zu erfuellen ist (true oder false).
	 */
	public boolean requestBonitaet() {
		boolean bonitaet = getUserInputBoolean("Bonitaet");
		return bonitaet;
	}

	/**
	 * getUserInputDate:
	 * Liest ein und ueberprueft das von Benutzer eingegebenen Datum.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @return date (LocalDate) Validiertes Datum.
	 */
	public LocalDate getUserInputDate(String label) {
		String line = null;
		LocalDate date = null;
		boolean isOK = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
		do {
			line = eingabe.readString(label);
			try {
				date = LocalDate.parse(line, formatter);
				isOK = true;
			} catch (DateTimeParseException e) {
				System.out.println("Eingegebenes Datum ist nicht gueltig.");
			}

		} while (isOK == false);
		return date;
	}

	/**
	 * getValidierteAdresse:
	 * Ueberprueft und speichert Benutzereingaben in die Adresse der Kunden.
	 * 
	 * @return adresse (Adresse) Das Objekt vom Typ Adresse speichert die Anschrift eines Kunden.
	 */
	public Adresse getValidierteAdresse() {
		String name;
		String strasse_hnr;
		String plz;
		String ort;
		name = getUserInputString("Firmenname", KonstantenWerte.MIN_LENGTH, KonstantenWerte.MAX_LENGTH,
				"[^a-z].+",
				"Der erste Buchstabe soll gross geschrieben werden.");
		strasse_hnr = getUserInputString("Strasse und Hausnummer", KonstantenWerte.MIN_LENGTH,
				KonstantenWerte.MAX_LENGTH, "[^a-z].+\\s.+",
				"Es soll mindestens zwei Woerter geben. "
						+ "Der erste Buchstabe soll gross geschrieben werden.");
		plz = getUserInputString("Postleitzahl", KonstantenWerte.MIN_PLZ, KonstantenWerte.MAX_PLZ, "[0-9]{5}",
				"Es soll genau fuenf Ziffern geben.");
		ort = getUserInputString("Ort", KonstantenWerte.MIN_LENGTH, KonstantenWerte.MAX_LENGTH, "[^a-z].+",
				"Der erste Buchstabe soll gross geschrieben werden.");
		Adresse adresse = new Adresse(name, strasse_hnr, plz, ort);
		return adresse;
	}

	/**
	 * getAnzahlKunden:
	 * Nimmt ein und prueft die von Benutzer eingegebenen Anzahl der Kunden, die erstellt werden.
	 * 
	 * @return anzahlkunden (int) die Anzahl der Kunden.
	 */
	public int getAnzahlKunden() {
		int anzahlkunden = getUserInputZahl("Anzahl der Kunden", KonstantenWerte.MIN_KUNDEN,
				KonstantenWerte.MAX_KUNDEN);
		return anzahlkunden;
	}

	/**
	 * getUserInputWeinSorte:
	 * Liest die vom Benutzer eingegebene Zahl ab und gibt den Weinsorte
	 * entsprechend der eingegebenen Nummer zurueck.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @param weinlager (WeinLager) Instanz der Klasse WeinLager, die umfasst das ganzen Sortiment der Weinsorten.
	 * @return wein (WeinSorte) Das Objekt beschreibt die Weinsorte.
	 */
	public WeinSorte getUserInputWeinSorte(String label, WeinLager weinlager) {
		System.out.println("Bitte waehlen Sie einen Artikel aus dem verfuegbaren Sortiment.");
		System.out.println(weinlager.gibWeinlisteAus());
		int auswahl = getUserInputZahl(label, KonstantenWerte.MIN_MENU, weinlager.getWeinliste().size());
		WeinSorte wein = weinlager.getWeinliste().get(auswahl - 1);
		return wein;
	}

	/**
	 * getMenuauswahl:
	 * Liest die vom Benutzer eingegebene Zahl als Menueauswahl ab
	 * und prueft, ob der Wert liegt in dem bestimmten Bereich.
	 * 
	 * @return auswahl (int) Die vom Benutzer eingegebene Zahl als Menuauswahl.
	 */
	public int getMenuauswahl() {
		int auswahl = getUserInputZahl("Menuauswahl", KonstantenWerte.MIN_MENU,
				KonstantenWerte.MAX_MENU);
		return auswahl;
	}

	/**
	 * validateKundennummer:
	 * Validiert, ob die vom Benutzer eingegebene Nummer dem Format von der Kundennummer entspricht.
	 * 
	 * @return kundennummer (String) Die Kundennummer.
	 */
	public String validateKundennummer() {
		String kundennummer = getUserInputString("eine Kundennummer",
				KonstantenWerte.KUNDENNUMMER_LENGTH, KonstantenWerte.KUNDENNUMMER_LENGTH,
				"[a-z]{3}[0-9]{3}[A-Z]{3}",
				"Das Format der Kundennummer ist falsch. Bitte beachten Sie, dass die Kundennummer soll immer \n "
						+ "mit drei Kleinbuchstaben beginnen, gefolgt von drei Ziffern, gefolgt von drei Groﬂbuchstaben. Bsp.:abc765KLM\n");
		return kundennummer;
	}

	/**
	 * getFilenameForWriteCSV:
	 * Liest den vom Benutzer eingegebenen Dateinamen ab,
	 * prueft, ob das Programm in dieser Datei schreiben kann, erstellt entsprechenden PrintStream.
	 * 
	 * @param label (String) Hinweis fuer den Benutzer.
	 * @return printStream (PrintStream) PrintStream, der dem eingegebenen Dateinamen entspricht.
	 */
	public PrintStream getFilenameForWriteCSV(String label) {
		PrintStream printStream = null;
		File datei = null;
		String dateiname = null;
		boolean isOK = true;
		do {
			isOK = true;
			dateiname = eingabe.readString(label);
			datei = new File(dateiname);
			try {
				datei.createNewFile();
				if (datei.canWrite() == false) {
					isOK = false;
					ausgabe.reportMeldungSchreiben();

				} else {
					printStream = new PrintStream(datei);
				}
			} catch (Exception e) {
				isOK = false;
				ausgabe.reportErstelltException();
			}
		} while (isOK == false);
		return printStream;
	}

	/**
	 * * Liefert das Objekt vom Typ Eingabe zurueck.
	 * 
	 * @return the eingabe (Eingabe) Das Objekt liest Benutzereingaben ein.
	 */
	public Eingabe getEingabe() {
		return eingabe;
	}

}
