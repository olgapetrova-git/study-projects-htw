/**
 * Package Model.
 */
package model;

import java.util.GregorianCalendar;
import java.util.Observable;

/**
 * ClockModel.java:
 * Stellt Informationen ueber die aktuelle Uhrzeit bereit.
 * Observable: Diese Klasse wird beobachtet bei ClockObserver Klasse.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 1 Jul 2018
 */
public class ClockModel extends Observable implements Runnable {

	private GregorianCalendar currentTime;
	Thread thread;

	/**
	 * ClockModel:
	 * Konstruktor ohne Parameter.
	 * Startet den Thread.
	 */
	public ClockModel() {
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * getCurrentTime:
	 * Liefert GregorianCalendar getCurrentTime zurueck.
	 * 
	 * @return getCurrentTime (GregorianCalendar) Die aktuelle Uhrzeit.
	 */
	public GregorianCalendar getCurrentTime() {
		return currentTime;
	}

	/**
	 * run:
	 * Benachrichtigt den angemeldeten Beobachter ClockObserver
	 * jede Sekunde ueber die Zeitaenderung.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			currentTime = new GregorianCalendar();
			setChanged();

			if (hasChanged()) {
				notifyObservers(); // alle Beobachter benachrichtigen
				clearChanged();
			}

			try {
				thread.sleep(1000); // 1000 ms = 1 sec
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
