/**
 * 
 */
package PetrovaOlga;

/**
 * Controller.java:
 * Enthaelt die run-Methode, die die Ausfuehrung des ganzen Programms steuert.
 * 
 * @author Petrova Olga 
 * @version Java Version 1.8
 * @since * 28.12.2017
 */
public class Controller {
	/**
	 * run:
	 * Die Methode steuert die Ausfuehrung des ganzen Programms und ausfuehrt Methoden anderer Klassen nacheinander.
	 */
	public void run() {
		// erzeugt Instanzen anderer Klassen;
		Daten daten = new Daten();
		Dreiecke dreiecke = new Dreiecke();
		Eingabe eingabe = new Eingabe(daten);
		Statistik stat = new Statistik(daten);
		Ausgabe ausgabe = new Ausgabe(daten, stat);

		daten.addInitialData(); // fuegt dem eingangsArray die Daten (vorgegebene Dreiecke) aus dem originalArray hinzu
		eingabe.getUserInput(); // erhaelt und speichert die Werte vom User;
		// rechnet Kategorie fuer jedes Dreieck in eingangsArray und speichert Ergebnisse in ausgangsArray;
		for (int indexarray = 0; indexarray < daten.eingangsArrayZaehler; indexarray++) {
			int[] kategorisiertArray = dreiecke.testDreieck(daten.eingangsArray[indexarray]);
			daten.addAusgangsDreiecke(kategorisiertArray);
		}
		stat.rechnenStatistik(); // zaelt die Anzahl von Dreiecke jeder Kategorie;
		ausgabe.printDreiecke();// Ausgabe auf der Console.
		ausgabe.printSatistik();
	}
}
