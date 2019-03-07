/**
 * 
 */
package PetrovaOlga;

/**
 * Statistik.java:
 * Enthaelt Methoden zum Berechnen von Statistiken nach Kategorien von Dreiecken.
 * 
 * @author Petrova Olga 
 * @version Java Version 1.8
 * @since * 18.12.2017
 */
public class Statistik {
	// damit Klasse Dreiecke auf diese Variablen zugreifen kann, muessen diese Variablen
	// public sein - hier als Attribute der Klasse definiert
	public int undefiniert; // undefiniert
	public int gleichseitig; // gleichseitig
	public int rechtwinkeligUndGleichschenkelig; // rechtwinkelig & gleichschenkelig
	public int rechtwinkelig; // rechtwinkelig
	public int stumpwinkeligUndGleichschenkelig; // stumpwinkelig & gleichschenkelig
	public int stumpwinkelig; // stumpwinkelig
	public int spitzwinkeligUndGleichschenkelig; // spitzwinkelig & gleichschenkelig
	public int spitzwinkelig; // spitzwinkelig

	// Attribute (Instanzvariable)
	Daten statistikdaten;

	/**
	 * Statistik:
	 * Konstruktor ohne Parametern, setzt alle Zaehler um Null Wert, speichert ubergegebene Objekt als Attribut der Klasse.
	 * 
	 * @param statdaten (Daten) Instanz der Klasse Daten.
	 */
	public Statistik(Daten statdaten) {
		statistikdaten = statdaten;
		undefiniert = 0; // Kategorie 0
		gleichseitig = 0; // Kategorie 1
		rechtwinkeligUndGleichschenkelig = 0; // Kategorie 2
		rechtwinkelig = 0; // Kategorie 3
		stumpwinkeligUndGleichschenkelig = 0; // Kategorie 4
		stumpwinkelig = 0; // Kategorie 5
		spitzwinkeligUndGleichschenkelig = 0; // Kategorie 6
		spitzwinkelig = 0; // Kategorie 7
	}

	/**
	 * rechnenStatistik:
	 * Erstellt Statistik, indem boolean Werte von Programm sammelt und die Anzahl von Dreiecke jeder Kategorie zaelt.
	 */
	public void rechnenStatistik() {
		for (int indexarray = 0; indexarray < statistikdaten.ausgangsArrayZaehler; indexarray++) {

			switch (statistikdaten.ausgangsArray[indexarray][3]) {
			case 0:
				undefiniert++;
				break;
			case 1:
				gleichseitig++;
				break;
			case 2:
				rechtwinkeligUndGleichschenkelig++;
				break;
			case 3:
				rechtwinkelig++;
				break;
			case 4:
				stumpwinkeligUndGleichschenkelig++;
				break;
			case 5:
				stumpwinkelig++;
				break;
			case 6:
				spitzwinkeligUndGleichschenkelig++;
				break;
			case 7:
				spitzwinkelig++;
				break;
			default:
				break;
			}

		}
	}

}
