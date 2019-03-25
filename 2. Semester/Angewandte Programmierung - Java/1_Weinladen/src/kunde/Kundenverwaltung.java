/**
 * 2.Aufgabe
 */
package kunde;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

import testrahmen.EingabeValidator;

/**
 * Kundenverwaltung.java:
 * Dient dazu, neue Kundendaten zu verwalten: neue Kunden zu erstellen und sortieren, ihre Angaben zu speichern und zu loeschen.
 * Lasst Kunden nach Nummer zu vergleichen und zu sortieren.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 24 Apr 2018
 */
public class Kundenverwaltung implements Comparator<AKunde>, Serializable {

	/**
	 * Die Liste der Kunden (mit Objekte vom eglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz).
	 */
	private LinkedList<AKunde> kundenliste = new LinkedList<AKunde>();

	/**
	 * Kundenverwaltung:
	 * Konstruktor Ohne Parameter.
	 */

	public Kundenverwaltung() {
		super();
	}

	/**
	 * addKunde:
	 * Addiert neuen Kunden zur Liste der Kunden.
	 * 
	 * @param neuKunde (AKunde) Das Objekt vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 */
	private void addKunde(AKunde neuKunde) { // Instanz der Kind-Klasse (Polimorphismus)
		if (neuKunde != null) {
			kundenliste.add(neuKunde);
		}
	}

	/**
	 * removeKunde:
	 * Loescht einen Kunden aus der Liste von Kunden.
	 * 
	 * @param kunde (AKunde) Instanz der Kind-Klasse vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 */
	private void removeKunde(AKunde kunde) { // Instanz der Kind-Klasse (Polimorphismus)
		if (kunde != null) {
			kundenliste.remove(kunde);
		}
	}

	/**
	 * neuGrossverbraucher:
	 * Erzeugt ein Objekt Grossverbraucher und speichert in die Liste von Kunden.
	 * 
	 * @return neuKunde (AKunde) Instanz der Klasse Grossverbraucher.
	 */
	public AKunde neuGrossverbraucher() {
		AKunde neuKunde = new Grossverbraucher();
		addKunde(neuKunde);
		return neuKunde;
	}

	/**
	 * neuEndverbraucher:
	 * Erzeugt ein Objekt Endverbraucher und speichert in die Liste von Kunden.
	 * 
	 * @return neuKunde (AKunde) Instanz der Klasse Endverbraucher.
	 */
	public AKunde neuEndverbraucher() {
		AKunde neuKunde = new Endverbraucher();
		addKunde(neuKunde);
		return neuKunde;
	}

	/**
	 * neuGesellschaftMLiz:
	 * Erzeugt ein Objekt GesellschaftMLiz und speichert in die Liste von Kunden.
	 * 
	 * @return neuKunde (AKunde) Instanz der Klasse GesellschaftMLiz.
	 */
	public AKunde neuGesellschaftMLiz() {
		AKunde neuKunde = new GesellschaftMLiz();
		addKunde(neuKunde);
		return neuKunde;
	}

	/**
	 * compare:
	 * Vergleicht zwei Kunden nach ihrer Kundennummern.
	 * 
	 * Wenn beide Nummern sind gleich, wird 0 zurueckgegeben.
	 * Wenn die nummer von kunde1 ist kleiner als nummer von kunde2, wird -1 zurueckgegeben.
	 * Wenn die nummer von kunde1 ist groesser als nummer von kunde2, wird +1 zurueckgegeben.
	 * 
	 * @return ergebnis (int) das Vergleichergebnis.
	 */
	public int compare(AKunde kunde1, AKunde kunde2) {
		int ergebnis = kunde1.getNummer().compareTo(kunde2.getNummer());
		return ergebnis;
	}

	/**
	 * getSortedKundenliste:
	 * Sortiert die Liste der Kunden und gibt sie zurueck.
	 * 
	 * @return kundenliste (LinkedList AKunde) Die Liste von Kunden.
	 */
	public LinkedList<AKunde> getSortedKundenliste() {
		Collections.sort(kundenliste, this);
		return kundenliste;
	}

	/**
	 * getKundenliste:
	 * Liefert die Liste der Kunden zurueck.
	 * 
	 * @return kundenliste (LinkedList AKunde) Die Liste von Kunden.
	 */
	public LinkedList<AKunde> getKundenliste() {
		return kundenliste;
	}

	/**
	 * neuKunde:
	 * Erzuegt einen neuen Kunden, dessen Typ vom Parameter abhaengt.
	 * 
	 * @param kundentyp (int) Der Typ vom Kunden.
	 * @return kunde (AKunde) Das Objekt vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 */
	public AKunde neuKunde(int kundentyp) {
		AdresseVergeber adressevergeber = new AdresseVergeber();
		AKunde kunde = null;
		switch (kundentyp) {
		case 0:
			kunde = neuEndverbraucher();
			break;
		case 1:
			kunde = neuGesellschaftMLiz();
			break;
		case 2:
			kunde = neuGrossverbraucher();
			break;
		default:
			break;
		} // end of switch
		if (kunde != null) {
			kunde.setAnschrift(adressevergeber.generiereAdresse());
		}
		return kunde;
	}

	/**
	 * generateRandomKunden:
	 * Erzuegt eine Anzahl der Kunden, wobei es eine zufaellige Verteilung von Kundentypen gibt.
	 * 
	 * @param anzahlkunden (int) Die von Benutzer uebergebene Anzahl der Kunden.
	 */
	public void generateRandomKunden(int anzahlkunden) {
		Random rand = new Random();
		for (int i = 0; i < anzahlkunden; i++) { // generiert von 0 bis n-1
			int kundentyp = rand.nextInt(3);
			neuKunde(kundentyp);
		} // end of for
	}

	/**
	 * sucheKunde:
	 * Sucht, ob es ein Kunde mit der vom Benutzer eingegebenen Nummer bereits im System gibt.
	 * 
	 * @param eingabevalidator (EingabeValidator) Das Objekt vom Typ EingabeValidator ueberprueft
	 * die vom Benutzer eingegebene Werte.
	 * @return kunde (AKunde) Gibt das Objekt zurueck, wenn die Kundennummer stimmt, ansonsten null.
	 */
	public AKunde sucheKunde(EingabeValidator eingabevalidator) {
		String kundennummer = eingabevalidator.validateKundennummer();
		for (AKunde kunde : kundenliste) {
			if (kunde.getNummer().equals(kundennummer)) {
				return kunde;
			}
		}
		System.out.println("Ein Kunde mit dieser Nummer existiert nicht.");
		return null;
	}

}
