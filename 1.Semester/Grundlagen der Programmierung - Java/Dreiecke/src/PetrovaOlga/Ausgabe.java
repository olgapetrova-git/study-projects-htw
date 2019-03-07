
package PetrovaOlga;

/**
 * Ausgabe.java:
 * Gibt Werten von der Seiten jedes Dreiecks und dessen Kategorienamen, sowie die Statistik auf der Console aus.
 * 
 * @author Petrova Olga
 * @version Java Version 1.8
 * @since * 19.12.2017
 */
public class Ausgabe {
	// Attribute (Instanzvariable)
	Daten ausgabedaten;
	Statistik ausgabestatistik;

	/**
	 * Ausgabe:
	 * Konstruktor mit Parametren. Speichert ubergegebene Objekte als Attribute der Klasse.
	 * 
	 * @param daten (Daten) Instanz der Klasse Daten
	 * @param stat (Statistik) Instanz der Klasse Statistik
	 */
	public Ausgabe(Daten daten, Statistik stat) {
		ausgabedaten = daten;
		ausgabestatistik = stat;
	}

	/**
	 * printDreiecke:
	 * Gibt sortierten Seiten jedes Dreiecks und dessen Kategorienamen auf der Console aus.
	 * 
	 */
	public void printDreiecke() {
		System.out.println("\n-------- Dreieckige Lederreststuecke --------\n");
		String kategorieName;
		for (int indexarray = 0; indexarray < ausgabedaten.ausgangsArrayZaehler; indexarray++) {
			switch (ausgabedaten.ausgangsArray[indexarray][3]) {
			case 0:
				kategorieName = "undefiniert";
				break;
			case 1:
				kategorieName = "gleichseitig";
				break;
			case 2:
				kategorieName = "rechtwinkelig & gleichschenkelig";
				break;
			case 3:
				kategorieName = "rechtwinkelig";
				break;
			case 4:
				kategorieName = "stumpwinkelig & gleichschenkelig";
				break;
			case 5:
				kategorieName = "stumpwinkelig";
				break;
			case 6:
				kategorieName = "spitzwinkelig & gleichschenkelig";
				break;
			case 7:
				kategorieName = "spitzwinkelig";
				break;
			default:
				kategorieName = "";
				break;
			}
			System.out.println(String.format("%4d %4d %4d %s", ausgabedaten.ausgangsArray[indexarray][0],
					ausgabedaten.ausgangsArray[indexarray][1], ausgabedaten.ausgangsArray[indexarray][2],
					kategorieName));

		}
	}

	/**
	 * printSatistik:
	 * Gibt Statistikwerte fuer jede Kategorie aus.
	 */
	public void printSatistik() {
		System.out.println("\n-------- Statistik -----------------------\n");
		System.out.println("gleichseitig \t\t\t\t " + ausgabestatistik.gleichseitig);
		System.out.println("rechtwinkelig \t\t\t\t " + ausgabestatistik.rechtwinkelig);
		System.out.println("stumpwinkelig \t\t\t\t " + ausgabestatistik.stumpwinkelig);
		System.out.println("spitzwinkelig \t\t\t\t " + ausgabestatistik.spitzwinkelig);
		System.out.println("rechtwinkelig & gleichschenkelig \t " + ausgabestatistik.rechtwinkeligUndGleichschenkelig);
		System.out.println("stumpwinkelig & gleichschenkelig \t " + ausgabestatistik.stumpwinkeligUndGleichschenkelig);
		System.out.println("spitzwinkelig & gleichschenkelig \t " + ausgabestatistik.spitzwinkeligUndGleichschenkelig);
		System.out.println("undefiniert \t\t\t\t " + ausgabestatistik.undefiniert);
	}

}
