/**
 * Package Model.
 */
package model;

import java.util.LinkedList;
import java.util.Observable;

/**
 * PointsList.java:
 * Enthaelt eine Liste von Koordinatenpunkten,
 * Observable: Diese Klasse wird beobachtet bei dem PlotterPanel und bei dem Textfeld.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 27 Jun 2018
 */
public class PointsList extends Observable {

	/**
	 * Die Liste der Koordinatenpunkten.
	 */
	private LinkedList<Point> points;

	/**
	 * PointsList:
	 * Konstruktor ohne Parameter.
	 * Erzeugt einen LinkedList.
	 */
	public PointsList() {
		super();
		points = new LinkedList<Point>();
	}

	/**
	 * addPoint:
	 * Erzeugt einen neuen Koordinatenpunkt und fuegt ihn der Liste hinzu.
	 * 
	 * @param point (Point) Das Objekt der Klasse Point, enthaelt die Koordinaten.
	 */

	public void addPoint(Point point) {
		points.add(point);
		notifyObservers(point);
	}

	/**
	 * deleteAllPoints:
	 * Loescht alle Koordinatenpunkte aus der Liste.
	 */
	public void deleteAllPoints() {
		points.clear();
		notifyObservers(null);
	}

	/**
	 * notifyObservers:
	 * Ueber diese notifyObservers-Methode wird bei allen registrierten
	 * Observer-Objekten (PlotterPanel und koordinatenListeArea) die update-Methode aufgerufen.
	 * 
	 * @param point (Point) Objekt der Klasse Point, enthaelt die Koordinaten.
	 * @see java.util.Observable#notifyObservers()
	 */
	public void notifyObservers(Point point) {

		setChanged();
		super.notifyObservers(point);
		clearChanged();
	}

	/**
	 * Liefert die Liste der Koordinatenpunkten zurueck.
	 * 
	 * @return points (LinkedList Point) Die Liste der Koordinatenpunkten.
	 */
	public LinkedList<Point> getPoints() {
		return points;
	}

}
