/**
 * 
 */
package kunde;

import java.util.Random;

/**
 * AdresseVergeber.java:
 * Dient zur Erstellung von Kundenadressen.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 8 May 2018
 */
public class AdresseVergeber {

	/**
	 * String Array erhaelt die Vorlagenwerte fuer zufaellig generierte Firmennamen.
	 */
	private final String[] NAME = { "Analytic Wine GmBH", "Fit Sekt AG", "Healthy Vodka OHG", "Fashion Beer KG",
			"Carousel Whiskey Kfm" };

	/**
	 * String Array erhaelt die Vorlagenwerte fuer zufaellig generierte Strassen und Hausnummern.
	 */
	private final String[] STRASSE_HNR = { "Tricky Allee 90", "Komplexer Weg 35", "Hauptstrasse 66", "Kater Platz 1",
			"Dunkle Strasse 45" };

	/**
	 * String Array erhaelt die Vorlagenwerte fuer zufaellig generierte Postleitzahlen.
	 */
	private final String[] PLZ = { "81981", "13088", "10318", "12459", "01010" };

	/**
	 * String Array erhaelt die Vorlagenwerte fuer zufaellig generierte Orte.
	 */
	private final String[] ORT = { "Hochebruck", "Eigenberg", "Langengfels", "Krichsebach", "Manneustadt" };

	/**
	 * AdresseVergeber:
	 * Konstruktor ohne Parameter.
	 */

	public AdresseVergeber() {
		super();
	}

	/**
	 * generiereAdresse:
	 * Erstellt die Kundenadresse aus einzelne Elementen, die zufaellig gewaehlt werden.
	 * 
	 * @return adresse (Adresse) Instanz der Klasse Adresse.
	 */
	public Adresse generiereAdresse() {
		Random rand = new Random();
		String name = NAME[rand.nextInt(NAME.length)];
		String strasse_hnr = STRASSE_HNR[rand.nextInt(STRASSE_HNR.length)];
		String plz = PLZ[rand.nextInt(PLZ.length)];
		String ort = ORT[rand.nextInt(ORT.length)];
		Adresse adresse = new Adresse(name, strasse_hnr, plz, ort);
		return adresse;
	}
}
