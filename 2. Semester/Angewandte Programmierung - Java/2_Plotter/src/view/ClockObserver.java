/**
 * Package View.
 */
package view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import model.ClockModel;
import model.ConstantValues;

/**
 * ClockObserver.java:
 * Beobachtet das ClockModel (Observable) und aktualisiert die Uhrzeit und das Datum in der Titelleiste.
 * 
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 1 Jul 2018
 */
public class ClockObserver implements Observer {

	/**
	 * Instanz der Klasse MainWindow, dient zur
	 * Ausgabe von eine Zeichenflaeche auf dem Hauptbereich.
	 */
	private MainWindow mainWindow;

	/**
	 * ClockObserver:
	 * Konstruktor mit Parameter.
	 * Speichert den ubergegeben Wert als Attribut des neuen Objektes.
	 * 
	 * @param mainWindow (MainWindow) Instanz der Klasse MainWindow.
	 */
	public ClockObserver(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}

	/**
	 * update:
	 * Diese Methode wird aufgerufen, wenn das beobachtete Objekt ClockModel geändert wird.
	 * Aktualisiert die Uhrzeit und das Datum in der Titelleiste.
	 * 
	 * @param o (Observable) Beobachtetes Objekt.
	 * @param arg (Object) Ein Parameter vom beobachteten Objekt.
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) // wird aufgerufen, wenn vom Subjekt benachrichtigt
	{
		GregorianCalendar currentTime;
		String formattedTime;

		try {
			currentTime = ((ClockModel) o).getCurrentTime(); // die Uhrzeit holen

			// Uhrzeitbestandteile ermitteln
			int day = currentTime.get(Calendar.DAY_OF_MONTH);
			int month = currentTime.get(Calendar.MONTH) + 1;
			int year = currentTime.get(Calendar.YEAR);

			int std = currentTime.get(Calendar.HOUR_OF_DAY);
			int min = currentTime.get(Calendar.MINUTE);
			int sek = currentTime.get(Calendar.SECOND);

			formattedTime = " ";

			if (day < 10)
				formattedTime = formattedTime + "0" + day + ".";
			else
				formattedTime = formattedTime + day + ".";

			if (month < 10)
				formattedTime = formattedTime + "0" + month + ".";
			else
				formattedTime = formattedTime + month + ".";

			formattedTime = formattedTime + year + "   ";

			if (std < 10)
				formattedTime = formattedTime + "0" + std + " : ";
			else
				formattedTime = formattedTime + std + " : ";

			if (min < 10)
				formattedTime = formattedTime + "0" + min + " : ";
			else
				formattedTime = formattedTime + min + " : ";

			if (sek < 10)
				formattedTime = formattedTime + "0" + sek + " ";
			else
				formattedTime = formattedTime + sek + " ";

			mainWindow.setTitle(ConstantValues.AUTOR_NAME + "  -  " + formattedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
