/**
 * Package Controller.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.PointsList;

/**
 * ClearButtonListener.java:
 * Bearbeitet Ereignisse von dem angemeldeten ClearButton.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 27 Jun 2018
 */
public class ClearButtonListener implements ActionListener {

	/**
	 * Instanz der Klasse PointsList,
	 * enthaelt eine Liste von Koordinatenpunkten.
	 * Observable.
	 */
	private PointsList pointsList;

	/**
	 * ClearButtonListener:
	 * Konstruktor mit Parameter.
	 * Speichert den ubergegebenen Wert als Attribute des neuen Objektes.
	 * 
	 * @param pointsList (PointsList) Instanz der Klasse PointsList.
	 */

	public ClearButtonListener(PointsList pointsList) {
		super();
		this.pointsList = pointsList;
	}

	/**
	 * actionPerformed:
	 * Wird aufgerufen, wenn ein ActionEvent an der angemeldeten Button auftritt.
	 * Loescht alle Koordinaten.
	 * 
	 * @param e (ActionEvent) Referenz auf das ActionEvent-Objekt
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	public void actionPerformed(ActionEvent e) {
		pointsList.deleteAllPoints();

	}

}
