/**
 * Package Controller.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ConstantValues;
import model.Point;
import model.PointsList;
import view.MainWindow;

/**
 * AddButtonListener.java:
 * Bearbeitet Ereignisse von dem angemeldeten AddButton.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 24 Jun 2018
 */
public class AddButtonListener implements ActionListener {

	/**
	 * Instanz der Klasse MainWindow, dient zur
	 * Ausgabe von eine Zeichenflaeche auf dem Hauptbereich.
	 */
	private MainWindow mainWindow;

	/**
	 * Instanz der Klasse PointsList,
	 * enthaelt eine Liste von Koordinatenpunkten.
	 * Observable.
	 */
	private PointsList pointsList;

	/**
	 * AddButtonListener:
	 * Konstruktor mit Parameter.
	 * Speichert ubergegebenene Werte als Attribute des neuen Objektes.
	 * 
	 * @param mainWindow (MainWindow) Instanz der Klasse MainWindow.
	 * @param pointsList (PointsList) Instanz der Klasse PointsList.
	 */
	public AddButtonListener(MainWindow mainWindow, PointsList pointsList) {
		super();
		this.mainWindow = mainWindow;
		this.pointsList = pointsList;
	}

	/**
	 * actionPerformed:
	 * Wird aufgerufen, wenn ein ActionEvent an dem angemeldeten Button auftritt.
	 * Validiert die vom Benutzer eingegebenen Koordinaten und
	 * fuegt dem Modell eine neue Koordinate hinzu.
	 * 
	 * @param e (ActionEvent) Referenz auf das ActionEvent-Objekt
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Point point = validateUserInput();
		if (point != null) {
			pointsList.addPoint(point);
		}
		mainWindow.getxField().setText("");
		mainWindow.getyField().setText("");
	}

	/**
	 * validateUserInput:
	 * Ueberprueft die vom Benutzer eingegebene Werte auf der bestimmten Regeln.
	 * 
	 * @return point (Point) Das Objekt der Klasse Point, enthaelt die Koordinaten.
	 */
	private Point validateUserInput() {
		Point point = null;
		boolean success = false;
		boolean isNotEmpty = true;
		boolean isValidNumber = true;
		int x = 0;
		int y = 0;

		try {
			if (mainWindow.getxField().getText().equals("")) {
				isNotEmpty = false; // xField is empty
			} else {
				x = Integer.parseInt(mainWindow.getxField().getText());
				if (x < ConstantValues.MIN_COORDINATE_VALUE ||
						x > ConstantValues.MAX_COORDINATE_VALUE) {
					throw new NotValidNumberException(); // parseInt succeed, interval not OK
				}
			}

			if (mainWindow.getyField().getText().equals("")) {
				isNotEmpty = false; // yField is empty
			} else {
				y = Integer.parseInt(mainWindow.getyField().getText());
				if (y < ConstantValues.MIN_COORDINATE_VALUE ||
						y > ConstantValues.MAX_COORDINATE_VALUE) {
					throw new NotValidNumberException(); // parseInt succeed, interval not OK
				}

			}
			if (isNotEmpty == true) { // both are not empty
				success = true; // parseInt succeed, interval OK
			}

		} catch (NumberFormatException | NotValidNumberException exception) {
			isValidNumber = false; // at least one value is not number or not in interval
		}

		if (isValidNumber == false) {
			mainWindow.showErrorMessage("\n"
					+ "Der eingegebene Wert ist nicht gültig. \n"
					+ "Zulässige Eingabe:\n"
					+ "ein ganzzahlige Wert zwischen "
					+ ConstantValues.MIN_COORDINATE_VALUE + " und " +
					ConstantValues.MAX_COORDINATE_VALUE + "."
					+ "\n\n");

		} else if (isNotEmpty == false) { // at least one value is empty
			mainWindow.showErrorMessage("\n Beide Koordinatenpunkte sollten eingegeben werden.\n");
		} else if (success == true) { // all is OK: both are not empty, parseInt succeed, interval OK

			point = new Point(x, y);

		}

		return point;

	}

}
