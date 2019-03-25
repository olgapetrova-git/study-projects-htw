/**
 * 
 */
package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import bestellung.BestellVerwaltung;
import kunde.Kundenverwaltung;
import testrahmen.Ausgabe;
import testrahmen.Eingabe;

/**
 * ObjectWriter.java:
 * Speichert Objekte in der binaere Datei.
 * 
 * @author Petrova Olga
 * E-Mail
 * @version Java Version 1.8
 * @since * 3 Jun 2018
 */
public class ObjectWriter {

	/**
	 * Das Objekt vom Typ Eingabe liest Benutzereingaben ein.
	 */
	private Eingabe eingabe;

	/**
	 * Das Objekt vom Typ Ausgabe gibt die Daten auf der Console aus.
	 */
	private Ausgabe ausgabe;

	/**
	 * ObjectWriter:
	 * Konstruktor mit Parameter.
	 * 
	 * @param eingabe (Eingabe) Das Objekt vom Typ Eingabe liest Benutzereingaben ein.
	 * @param ausgabe (Ausgabe) Das Objekt vom Typ Ausgabe gibt die Daten auf der Console aus.
	 */
	public ObjectWriter(Eingabe eingabe, Ausgabe ausgabe) {
		super();
		this.eingabe = eingabe;
		this.ausgabe = ausgabe;
	}

	/**
	 * schreibObjekte:
	 * Liest den vom Benutzer eingegebenen Dateinamen ab und prueft,
	 * ob das Programm in dieser Datei schreiben kann, und dann schreibt Objekte in dieser Datei.
	 * 
	 * @param kundenverwaltung (Kundenverwaltung) Das Objekt speichert Kundendaten.
	 * @param bestellverwaltung (BestellVerwaltung) Das Objekt speichert Angaben zur Bestellungen.
	 * @param label (String) Hinweis fuer den Benutzer.
	 */
	public void schreibObjekte(Kundenverwaltung kundenverwaltung,
			BestellVerwaltung bestellverwaltung, String label) {
		File datei = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
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
					fos = new FileOutputStream(dateiname);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(kundenverwaltung);
					oos.writeObject(bestellverwaltung);
				}

			} catch (IOException e) {
				isOK = false;
				ausgabe.reportIOException();
			} catch (SecurityException e) {
				isOK = false;
				ausgabe.reportExceptionZugriff();
			} finally {
				if (isOK == true) {
					try {
						oos.close();
						fos.close();

						System.out.println("Es wurde in Datei erfolgreich geschrieben. \n");
					} catch (IOException | NullPointerException e) {
						System.out.println("ObjectOutputStream konnte nicht geschlossen werden. \n");
					}
				}
			}
		} while (isOK == false);
	}

}
