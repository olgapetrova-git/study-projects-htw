/**
 * 
 */
package io;

import java.io.PrintStream;

import kunde.AKunde;
import kunde.Endverbraucher;
import kunde.GesellschaftMLiz;
import kunde.Grossverbraucher;
import kunde.Kundenverwaltung;

/**
 * CSVexporter.java:
 * Exportiert Kundendaten als CSV-Datei.
 * 
 * @author Petrova Olga
 * E-Mail
 * @version Java Version 1.8
 * @since * 2 Jun 2018
 */
public class CSVexporter {

	/**
	 * CSVexporter:
	 * Konstruktor one Parameter.
	 */

	public CSVexporter() {
		super();

	}

	/**
	 * writeCSV:
	 * Abhaengig vom Kundentyp speichert die Daten der Kunden im CSV-Format in einer Datei.
	 * 
	 * @param printStream (PrintStream) PrintStream, der dem eingegebenen Dateinamen entspricht.
	 * @param sep (String) Das Trennzeichen.
	 * @param kundenverwaltung (Kundenverwaltung) Das Objekt vom Typ Kundenverwaltung speichert Kundendaten.
	 */
	public void writeCSV(PrintStream printStream, String sep, Kundenverwaltung kundenverwaltung) {
		try {
			for (AKunde kunde : kundenverwaltung.getKundenliste()) {
				String kundentyp = "";
				String merkmal = "";
				if (kunde instanceof Endverbraucher) {
					kundentyp = "Endverbraucher";
					merkmal = Boolean.toString(((Endverbraucher) kunde).isBonitaet());
				} else if (kunde instanceof GesellschaftMLiz) {
					kundentyp = "GesellschaftMLiz";
					merkmal = Integer.toString(((GesellschaftMLiz) kunde).getVertrieb());
				} else if (kunde instanceof Grossverbraucher) {
					kundentyp = "Grossverbraucher";
					merkmal = Integer.toString(((Grossverbraucher) kunde).getStatus());
				}
				printStream
						.println(kundentyp + sep + kunde.getNummer() + sep + merkmal + sep + kunde.getRabatt() + sep +
								kunde.getAnschrift().getName() + sep + kunde.getAnschrift().getStrasse_hnr() + sep +
								kunde.getAnschrift().getPlz() + sep + kunde.getAnschrift().getOrt());
			}
			printStream.close();
			System.out.println("Die Daten der Kunden wurden erfolgreich gespeichert.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
