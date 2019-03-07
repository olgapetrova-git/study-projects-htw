/**
 * 
 */
package PetrovaOlga;

/**
 * Daten.java:
 * Enthaelt Daten ueber die originalen Dreiecke, angelesene Dreiecke, sortierte Dreiecke und Kategorienummer fuer sie, sowie Hilfsmethoden
 * zur Initialisierung der Daten.
 * 
 * @author Petrova Olga 
 * @version Java Version 1.8
 * @since * 27.12.2017
 */
public class Daten {

	// 2-dimensionaler Array, um die Werte von die vorgegebenen Dreiecke zu speichern
	int[][] originalArray = { { 2, 2, 4 }, { 3, 4, 5 }, { 5, 5, 5 }, { 8, 6, 10 }, { 10, 10, 2 }, { 2, 4, 9 },
			{ 12, 36, 4 }, { 5, 6, 7 }, { 7, 9, 12 } };
	// 2-dimensionaler Array fur originale Dreiecke und Dreiecke, die vom Benutzer eingegeben wurden
	int[][] eingangsArray;
	// sortierte Dreiecke und Kategorienummer fuer sie
	int[][] ausgangsArray;
	int eingangsArrayZaehler;
	int ausgangsArrayZaehler;

	/**
	 * Daten:
	 * Konstruktor der Klasse ohne Parameter, um Arrays und Zaelern zu initialisieren.
	 */
	public Daten() {
		// Instanzvariablen (Attribute)
		eingangsArray = new int[110][3];
		ausgangsArray = new int[110][4];
		eingangsArrayZaehler = 0;
		ausgangsArrayZaehler = 0;
	}

	/**
	 * addEngangsDreiecke:
	 * Fuegt dem EingangsArray ein Dreieck hinzu.
	 * 
	 * @param dreieck (int[]): Array mit Werten von Seiten eines Dreiecks.
	 */
	public void addEngangsDreiecke(int[] dreieck) {
		eingangsArray[eingangsArrayZaehler][0] = dreieck[0];
		eingangsArray[eingangsArrayZaehler][1] = dreieck[1];
		eingangsArray[eingangsArrayZaehler][2] = dreieck[2];
		eingangsArrayZaehler++;
	}

	/**
	 * addAusgangsDreiecke:
	 * Fuegt dem ausgangsArray ein Dreieck und dessen Kategorienummer hinzu.
	 * 
	 * @param dreieck (int[]): Array mit Werten von Seiten eines Dreiecks und dessen Kategorienummer.
	 */
	public void addAusgangsDreiecke(int[] dreieck) {
		ausgangsArray[ausgangsArrayZaehler][0] = dreieck[0];
		ausgangsArray[ausgangsArrayZaehler][1] = dreieck[1];
		ausgangsArray[ausgangsArrayZaehler][2] = dreieck[2];
		// das 3-te Wert ist Kategorienummer des Dreiecks
		ausgangsArray[ausgangsArrayZaehler][3] = dreieck[3];
		ausgangsArrayZaehler++;
	}

	/**
	 * addInitialData:
	 * Fuegt dem eingangsArray die Daten aus dem originalArray hinzu.
	 */
	public void addInitialData() {
		for (int index = 0; index < originalArray.length; index++) {
			addEngangsDreiecke(originalArray[index]);
		}

	}

}
