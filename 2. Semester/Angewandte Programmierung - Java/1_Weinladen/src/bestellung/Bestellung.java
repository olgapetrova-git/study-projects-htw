/**
 * 
 */
package bestellung;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import kunde.AKunde;
import model.WeinSorte;

/**
 * Bestellung.java:
 * Speichert die Daten von einer Bestellung.
 * 
 * @author Petrova Olga
 * E-Mail
 * @version Java Version 1.8
 * @since * 21 May 2018
 */
// to do: Comments getter setter

public class Bestellung implements Comparable<Bestellung>, Serializable {

	/**
	 * Die eindeutige Bestellnummer, die aus der Kundennummer und 3 zufaellig gewaehlte Ziffern erstellt wird.
	 */
	private String bestellnummer;

	/**
	 * Das Datum einer Bestellung.
	 */
	private LocalDate bestelldatum;

	/**
	 * Die Beschreibung von einer Weinsorte.
	 */
	private WeinSorte weinsorte;

	/**
	 * Die Anzahl der Flaschen in einer Bestellung, unabhaengig von Verpackungseinheit.
	 */
	private int anzahl;

	/**
	 * Der Bruttopreis ohne Rabattabzug.
	 */
	private double gesamtPreis;

	/**
	 * Der Rabatt abhängig vom Kunden.
	 */
	private double gewaehrterRabatt = 0.0;

	/**
	 * Der Gesamtpreis mit Rabattabzug.
	 */
	private double gesamtPreisNetto;

	/**
	 * Bestellung:
	 * Konstruktor mit Parameter.
	 * Wird beim Erstellen eines neuen Objektes Bestellung aufgeruft.
	 * Speichert ubergegebenen Werte als Attribute des Objektes.
	 * Erstellt und speichert die Bestellnummer und den Gesamtpreis mit Rabattabzug als Attribute des Objektes.
	 * 
	 * @param kunde (AKunde) Das Objekt vom jeglichen Typ: Grossverbraucher, Endverbraucher, GesellschaftMLiz.
	 * @param bestelldatum (LocalDate) Das Bestelldatum.
	 * @param weinsorte (WeinSorte) Das Objekt mit der Beschreibung von einer Weinsorte.
	 * @param anzahl (int) Die Anzahl der Flaschen unabhaengig von Verpackungseinheit.
	 */
	public Bestellung(AKunde kunde, LocalDate bestelldatum, WeinSorte weinsorte, int anzahl) {
		super();
		this.bestellnummer = kunde.getNummer() + "-" + BestellNummernVergeber.getExemplar().generiereBestellnummer();
		this.bestelldatum = bestelldatum;
		this.weinsorte = weinsorte;
		this.anzahl = anzahl;
		this.gesamtPreis = weinsorte.getPreis() * anzahl;
		this.gewaehrterRabatt = kunde.getRabatt();
		this.gesamtPreisNetto = gesamtPreis - gesamtPreis * gewaehrterRabatt;
	}

	/**
	 * Liefert die bestellnummer zurueck.
	 * 
	 * @return bestellnummer (String) Die eindeutige Bestellnummer.
	 */
	public String getBestellnummer() {
		return bestellnummer;
	}

	/**
	 * Liefert das Bestelldatum zurueck.
	 * 
	 * @return bestelldatum (LocalDate) Das Datum einer Bestellung.
	 */
	public LocalDate getBestelldatum() {
		return bestelldatum;
	}

	/**
	 * Setzt ein neuen Bestelldatum.
	 * 
	 * @param bestelldatum (LocalDate) Das Datum einer Bestellung.
	 */
	public void setBestelldatum(LocalDate bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	/**
	 * Liefert das Objekt Weinsorte zurueck.
	 * 
	 * @return weinsorte (WeinSorte) Das Objekt mit der Beschreibung von einer Weinsorte.
	 */
	public WeinSorte getWein() {
		return weinsorte;
	}

	/**
	 * Setzt ein neuen Objekt Weinsorte.
	 * 
	 * @param wein (WeinSorte) Das Objekt beschreibt die Weinsorte und der Preis des Weines.
	 */
	public void setWein(WeinSorte wein) {
		this.weinsorte = wein;
	}

	/**
	 * Liefert die Anzahl der Flaschen zurueck.
	 * 
	 * @return anzahl (int) Die Anzahl der Flaschen in einer Bestellung, unabhaengig von Verpackungseinheit.
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Setzt eine neue Anzahl der Flaschen.
	 * 
	 * @param anzahl (int) Die Anzahl der Flaschen in einer Bestellung, unabhaengig von Verpackungseinheit.
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	/**
	 * Liefert der Bruttopreis zurueck.
	 * 
	 * @return gesamtPreis (double) Der Bruttopreis ohne Rabattabzug.
	 */
	public double getGesamtPreis() {
		return gesamtPreis;
	}

	/**
	 * Setzt einen neuen Bruttopreis.
	 * 
	 * @param gesamtPreis (double) Der Bruttopreis ohne Rabattabzug.
	 */
	public void setGesamtPreis(double gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}

	/**
	 * Liefert der Rabatt zurueck.
	 * 
	 * @return gewaehrterRabatt (double) Der Rabatt abhängig vom Kunden.
	 */
	public double getGewaehrterRabatt() {
		return gewaehrterRabatt;
	}

	/**
	 * Setzt einen neuen Rabatt.
	 * 
	 * @param gewaehrterRabatt (double) Der Rabatt abhängig vom Kunden.
	 */
	public void setGewaehrterRabatt(double gewaehrterRabatt) {
		this.gewaehrterRabatt = gewaehrterRabatt;
	}

	/**
	 * Liefert der Gesamtpreis mit Rabattabzug zurueck.
	 * 
	 * @return gesamtPreisNetto (double) Der Gesamtpreis mit Rabattabzug.
	 */
	public double getGesamtPreisNetto() {
		return gesamtPreisNetto;
	}

	/**
	 * Setzt einen neuen Gesamtpreis mit Rabattabzug.
	 * 
	 * @param gesamtPreisNetto (double) Der Gesamtpreis mit Rabattabzug.
	 */
	public void setGesamtPreisNetto(double gesamtPreisNetto) {
		this.gesamtPreisNetto = gesamtPreisNetto;
	}

	/**
	 * Liefert die String Darstellung des Objektes mit der bestimmten Attribute zurueck.
	 */
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DecimalFormat df = new DecimalFormat("#.##");
		return "Bestellung [bestellnummer=" + bestellnummer + ", bestelldatum=" + bestelldatum.format(formatter)
				+ ", weinsorte=" + weinsorte + ", anzahl=" + anzahl + ", gesamtPreisNetto="
				+ df.format(gesamtPreisNetto) + "]\n";
	}

	/**
	 * compareTo:
	 * Vergleicht zwei Bestellungen nach Datum.
	 * Wenn beide Bestellungen gleiches Datum haben, wird 0 zurueckgegeben.
	 * Wenn das Datum des Parameters vor dem Datum der Vergleichsobjektes liegt, wird -1 zurueckgegeben.
	 * Wenn das Datum des Parameters hinter dem Datum der Vergleichsobjektes liegt, wird +1 zurueckgegeben.
	 * 
	 * @return ergebnis (int) das Vergleichergebnis.
	 */
	public int compareTo(Bestellung o) {
		return -(this.bestelldatum.compareTo(o.bestelldatum));
	}

}
