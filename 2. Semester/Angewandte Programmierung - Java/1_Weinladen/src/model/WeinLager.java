/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * WeinLager.java:
 * Speichert das gesamte Sortiment der Weinsorten von dem Weinladen.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 26 May 2018
 */
public class WeinLager implements Serializable {

	/**
	 * Die Liste der Weinsorten im Sortiment des Ladens.
	 */
	private ArrayList<WeinSorte> weinliste = new ArrayList<WeinSorte>();

	/**
	 * Die Liste der Bezeichnungen von der vorhandenen Weinsorten.
	 */
	private String[] weinsortenBezeichnung = { "Cabernet Sauvignon",
			"Chianti", "Merlot", "Riesling", "Gewuerztraminer", "Chardonnay" };

	/**
	 * Die Preisliste der Weinsorten.
	 */
	private double[] preisListe = { 19.95, 15.80, 7.30, 10.80, 8.70, 7.95 };

	/**
	 * WeinLager:
	 * Konstruktor ohne Parameter. Initialisiert ArrayList WeinSorte weinliste.
	 */
	public WeinLager() {
		String weinsorte = null;
		double preis = 0;
		for (int i = 0; i < weinsortenBezeichnung.length; i++) {
			weinsorte = weinsortenBezeichnung[i];
			preis = preisListe[i];
			weinliste.add(new WeinSorte(weinsorte, preis));
		}
	} // end of konstruktor

	/**
	 * Liefert die Liste der Weinsorten zurueck.
	 * 
	 * @return weinliste ( ArrayList WeinSorte ) Die Liste der Weinsorten im Sortiment.
	 */
	public ArrayList<WeinSorte> getWeinliste() {
		return weinliste;
	}

	/**
	 * gibWeinlisteAus:
	 * Liefert die Beschreibung des Sortiments von Weinsorten zurueck.
	 * 
	 * @return weinlisteinhalt (String) Das Menue mit der Weinsortenliste.
	 */
	public String gibWeinlisteAus() {
		String weinlisteinhalt = "";
		for (int i = 0; i < weinliste.size(); i++) {
			weinlisteinhalt += "[" + (i + 1) + "] " + weinliste.get(i).getWeinsorte() +
					" - " + weinliste.get(i).getPreis() + " EUR.\n";
		}
		return weinlisteinhalt;
	}
}
