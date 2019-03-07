/**
 * 
 */
package PetrovaOlga;

/**
 * Dreiecke.java:
 * Enthaelt Methoden, die Werten von der Seiten eines Dreiecks in der aufsteigenden Reihenfolge aussortieren und eine Kategorie fuer jedes
 * Dreieck definieren.
 * 
 * @author Petrova Olga
 * @version Java Version 1.8
 * @since * 18.12.2017
 */
public class Dreiecke {

	/**
	 * testDreieck:
	 * Ruft die Methode zur Aussortierung von Arrays, rechnet Kategoreinummer aus.
	 * 
	 * @param dreieck (int[] ): Array mit unsortierten Seiten von einem Dreieck.
	 * @return Gibt Array mit integer Werte von Seiten des Dreiecks und Kategoreinummer zurueck.
	 */
	public int[] testDreieck(int[] dreieck) {
		int[] sortedArray = sortDreieck(dreieck);
		boolean ud = testUndefiniert(sortedArray);
		boolean rwk = testRechtwinkelig(sortedArray);
		boolean stpw = testStumpwinkelig(sortedArray);
		boolean spzw = testSpitzwinkelig(sortedArray);
		boolean gstg = testGleichseitig(sortedArray);
		boolean gschg = testGleichschenkelig(sortedArray);
		int kategorieNummer = rechnenKategorieNummer(ud, rwk, stpw, spzw, gstg, gschg);
		int[] kategorisiertArray = { sortedArray[0], sortedArray[1], sortedArray[2], kategorieNummer };
		return kategorisiertArray;
	}

	/**
	 * rechnenKategorieNummer:
	 * Bestimmt den Kategorienummer aus gesammelten boolean Werte.
	 * 
	 * @param ud (boolean): kennzeichnet, dass das Dreieck undefiniert ist.
	 * @param rwk (boolean): kennzeichnet, dass das Dreieck rechtwinkelig ist.
	 * @param stpw (boolean): kennzeichnet, dass das Dreieck stumpwinkelig ist.
	 * @param spzw (boolean): kennzeichnet, dass das Dreieck spitzwinkelig ist.
	 * @param gstg (boolean): kennzeichnet, dass das Dreieck gleichseitig ist.
	 * @param gschg (boolean): kennzeichnet, dass das Dreieck gleichschenkelig ist.
	 * @return Gibt Kategorienummer (int) zurueck.
	 */
	public int rechnenKategorieNummer(boolean ud, boolean rwk, boolean stpw, boolean spzw, boolean gstg,
			boolean gschg) {
		if (ud == true) { // undefiniert, Kategorie 0
			return 0;

		} else if (gstg == true) { // gleichseitig, Kategorie 1
			return 1;

		} else if (rwk == true && gschg == true) { // rechtwinkelig & gleichschenkelig, Kategorie 2
			return 2;

		} else if (rwk == true && gschg != true) { // rechtwinkelig, Kategorie 3
			return 3;

		} else if (stpw == true && gschg == true) { // stumpwinkelig & gleichschenkelig, Kategorie 4
			return 4;

		} else if (stpw == true && gschg != true) { // stumpwinkelig, Kategorie 5
			return 5;

		} else if (spzw == true && gschg == true) { // spitzwinkelig & gleichschenkelig, Kategorie 6
			return 6;

		} else if (spzw == true && gschg != true) { // spitzwinkelig, Kategorie 7
			return 7;
		}
		return -1;
	}

	/**
	 * sortDreieck:
	 * Methode zur Aussortierung von Arrays.
	 * 
	 * @param dreieck (int[]): Array mit Seiten von einem Dreieck.
	 * @return gibt Array mit sortierten Werten zurueck.
	 * diese Werten sind in der aufsteigenden Reihenfolge aussortiert.
	 */
	public int[] sortDreieck(int[] dreieck) {
		int temp;
		// vergleichen und tauschen erste [0] und zweite [1] Seiten, falls erste
		// Seite ist groesser
		if (dreieck[0] > dreieck[1]) {
			temp = dreieck[0];
			dreieck[0] = dreieck[1];
			dreieck[1] = temp;
		}
		// vergleichen und tauschen zweite [1] und dritte [2]Seiten
		if (dreieck[1] > dreieck[2]) {
			temp = dreieck[1];
			dreieck[1] = dreieck[2];
			dreieck[2] = temp;
		}
		// noch mal vergleichen Werte, die als [0] und [1] Seiten gespechert,
		// weil zu diesem Punkt an der stelle von [1] kann [2] gespechert werden
		if (dreieck[0] > dreieck[1]) {
			temp = dreieck[0];
			dreieck[0] = dreieck[1];
			dreieck[1] = temp;
		}
		return dreieck;
	}

	/**
	 * testUndefiniert:
	 * Methode zum Pruefen, ob das uberhaupt ein Dreieck ist.
	 * 
	 * @param dreieck (int[]): Array mit (aussortierten) Seiten von einem Dreieck.
	 * @return (boolean) gibt "true" wert zurueck, wenn laut der Formel gegebene Werte keine Dreieck bilden. Wert "false" - Dreieck.
	 */
	public boolean testUndefiniert(int[] dreieck) {
		boolean result;
		if (dreieck[0] + dreieck[1] <= dreieck[2]) {
			result = true; // Undefiniert
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * testRechtwinkelig:
	 * Methode zum Pruefen, ob Dreieck rechtwinkelig ist.
	 * 
	 * @param dreieck (int[]): Array mit (aussortierten) Seiten von einem Dreieck.
	 * @return (boolean) gibt true wert zurueck, wenn die Formel fuer Rechtwinkelig Dreieck erfuellt, ansonst false.
	 */
	public boolean testRechtwinkelig(int[] dreieck) {
		boolean result;
		if (dreieck[0] * dreieck[0] + dreieck[1] * dreieck[1] == dreieck[2] * dreieck[2]) {
			result = true; // Rechtwinkelig
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * testStumpwinkelig:
	 * Methode zum Pruefen, ob Dreieck Stumpwinkelig ist.
	 * 
	 * @param dreieck (int[]): Array mit (aussortierten) Seiten von einem Dreieck.
	 * @return (boolean) gibt true wert zurueck, wenn die Formel fuer Stumpwinkelig Dreieck erfuellt, ansonst false.
	 */
	public boolean testStumpwinkelig(int[] dreieck) {
		boolean result;
		if (dreieck[0] * dreieck[0] + dreieck[1] * dreieck[1] < dreieck[2] * dreieck[2]) {
			result = true; // Stumpwinkelig
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * testSpitzwinkelig:
	 * Methode zum Pruefen, ob Dreieck Spitzwinkelig ist.
	 * 
	 * @param dreieck (int[]): Array mit (aussortierten) Seiten von einem Dreieck.
	 * @return (boolean) gibt true wert zurueck, wenn die Formel fuer Spitzwinkelig Dreieck erfuellt, ansonst false.
	 */
	public boolean testSpitzwinkelig(int[] dreieck) {
		boolean result;
		if (dreieck[0] * dreieck[0] + dreieck[1] * dreieck[1] > dreieck[2] * dreieck[2]) {
			result = true; // Spitzwinkelig
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * testGleichseitig:
	 * Methode zum Pruefen, ob Dreieck Gleichseitig ist.
	 * 
	 * @param dreieck (int[]): Array mit (aussortierten) Seiten von einem Dreieck.
	 * @return (boolean) gibt true wert zurueck, wenn die Bedingung fuer Gleichseitig Dreieck erfuellt, ansonst false.
	 */
	public boolean testGleichseitig(int[] dreieck) {
		boolean result;
		if (dreieck[0] == dreieck[1] && dreieck[1] == dreieck[2]) {
			result = true; // Gleichseitig
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * testGleichschenkelig:
	 * Methode zum Pruefen, ob Dreieck Gleichschenkelig ist.
	 * 
	 * @param dreieck (int[]): Array mit (aussortierten) Seiten von einem Dreieck.
	 * @return (boolean) gibt true wert zurueck, wenn die Bedingung fuer Gleichschenkelig Dreieck erfuellt.
	 * (entweder a = b oder b = c oder a = c), ansonst false.
	 */
	public boolean testGleichschenkelig(int[] dreieck) {
		boolean result;
		if (dreieck[0] == dreieck[1] ^ dreieck[1] == dreieck[2] ^ dreieck[0] == dreieck[2]) {
			result = true; // Gleichschenkelig
		} else {
			result = false;
		}
		return result;
	}
}
