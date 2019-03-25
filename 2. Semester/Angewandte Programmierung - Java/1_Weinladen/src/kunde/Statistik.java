/**
 * 2.Aufgabe
 */
package kunde;

import testrahmen.Controller;

/**
 * Statistik.java:
 * Enthaelt Methoden zum Berechnen und zum Ausgeben von Statistiken nach Kundentypen.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 3 May 2018
 */
public class Statistik {

	/**
	 * Steuert die Ausfuehrung des ganzen Programms.
	 */
	private Controller controller;

	/**
	 * Array speichert Statistikangaben nach Kundentypen, indem jeder Zelle als Zahler dient.
	 */
	private int[] stat = new int[3];

	/**
	 * Statistik:
	 * Konstruktor mit Parameter.
	 * 
	 * @param controller (Controller) Das Objekt vom Typ Controller steuert die Ausfuehrung des ganzen Programms.
	 */
	public Statistik(Controller controller) {
		this.controller = controller;
		resetStatistik();
	}

	/**
	 * rechnenStatistik:
	 * Erstellt Statistiken nach Kundentypen, indem durchlaeuft die Liste der Kunden und
	 * erhoeht fuer jeden Kunden den Wert in der entsprechenden dem Kundentyp Zelle des Arrays.
	 */
	public void rechnenStatistik() {
		resetStatistik();
		for (AKunde kunde : controller.getKundenverwaltung().getKundenliste()) {
			if (kunde instanceof Endverbraucher) {
				stat[0]++;
			} else if (kunde instanceof GesellschaftMLiz) { // operator
				stat[1]++;
			} else if (kunde instanceof Grossverbraucher) {
				stat[2]++;
			}
		}
	}// end of method

	/**
	 * gibStatistikAlsString:
	 * Erstellt den Bericht ueber Statistikdaten als String.
	 * 
	 * @return reportstat (String) Beschreibung der Statistikangaben nach Kundentypen.
	 */
	public String gibStatistikAlsString() {
		String reportstat = "Gesamtanzahl der Kunden: " + controller.getKundenverwaltung().getKundenliste().size() +
				"\n davon \n Endverbraucher: " + stat[0] +
				"\n Gesellschaft mit Lizenzvertrieb: " + stat[1] +
				"\n Grossverbraucher: " + stat[2];
		return reportstat;
	}

	/**
	 * resetStatistik:
	 * Setzt sie Satistik auf Null.
	 */
	private void resetStatistik() {
		for (int i = 0; i < 3; i++) {
			stat[i] = 0;
		}
	}
}
