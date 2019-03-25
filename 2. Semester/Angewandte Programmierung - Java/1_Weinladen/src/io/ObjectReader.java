/**
 * 
 */
package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import bestellung.BestellNummernVergeber;
import bestellung.BestellVerwaltung;
import kunde.KundenNummernVergeber;
import kunde.Kundenverwaltung;
import testrahmen.Ausgabe;
import testrahmen.Controller;
import testrahmen.Eingabe;

/**
 * ObjectReader.java:
 * Laedt Objekte von einer Datei.
 * 
 * @author Petrova Olga
 * E-Mail
 * @version Java Version 1.8
 * @since * 3 Jun 2018
 */
public class ObjectReader {

	/**
	 * Das Objekt vom Typ Eingabe liest Benutzereingaben ein.
	 */
	private Eingabe eingabe;

	/**
	 * Das Objekt vom Typ Ausgabe gibt die Daten auf der Console aus.
	 */
	private Ausgabe ausgabe;

	/**
	 * ObjectReader:
	 * Konstruktor mit Parameter.
	 * 
	 * @param eingabe (Eingabe) Das Objekt vom Typ Eingabe liest Benutzereingaben ein.
	 * @param ausgabe (Ausgabe) Das Objekt vom Typ Ausgabe gibt die Daten auf der Console aus.
	 */

	public ObjectReader(Eingabe eingabe, Ausgabe ausgabe) {
		super();
		this.eingabe = eingabe;
		this.ausgabe = ausgabe;
	}

	/**
	 * lesenObjekte:
	 * Liest den vom Benutzer eingegebenen Dateinamen ab und prueft,
	 * ob das Programm aus dieser Datei lesen kann, und dann laedt Objekte aus dieser Datei.
	 * 
	 * 
	 * @param controller (Controller) Steuert die Ausfuehrung des ganzen Programms.
	 * @param label (String) Hinweis fuer den Benutzer.
	 */
	public void lesenObjekte(Controller controller, String label) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		String dateiname = null;
		boolean isOK = true;
		do {
			isOK = true;
			dateiname = eingabe.readString(label);

			try {
				fis = new FileInputStream(dateiname);
				ois = new ObjectInputStream(fis);
				controller.setKundenverwaltung(new Kundenverwaltung()); // um aktuellen Kunden und Bestellungen verwerfen
				controller.setBestellverwaltung(new BestellVerwaltung(controller.getKundenverwaltung()));
				Object objk = ois.readObject();
				if (objk instanceof Kundenverwaltung) {
					controller.setKundenverwaltung((Kundenverwaltung) objk);
				}
				Object objb = ois.readObject();
				if (objb instanceof BestellVerwaltung) {
					controller.setBestellverwaltung((BestellVerwaltung) objb);
				}
			} catch (IOException e) {
				isOK = false;
				ausgabe.reportIOException();
			} catch (SecurityException e) {
				isOK = false;
				ausgabe.reportExceptionZugriff();
			} catch (ClassNotFoundException e) {
				ausgabe.reportClassNotFoundException();
				isOK = false;
			} finally {
				if (isOK == true) {
					try {
						ois.close();
						fis.close();
						KundenNummernVergeber.getExemplar()
								.refreshKundennummernkatalog(controller.getKundenverwaltung().getKundenliste());
						BestellNummernVergeber.getExemplar()
								.refreshBestellnummernkatalog(
										controller.getBestellverwaltung().getBestellungsverzeichnis());
						System.out.println("Es wurde aus der Datei erfolgreich geladen. \n");
					} catch (IOException | NullPointerException e) {
						System.out.println("ObjectInputStream konnte nicht geschlossen werden. \n");
					}
				}
			}
		} while (isOK == false);
	}
}
