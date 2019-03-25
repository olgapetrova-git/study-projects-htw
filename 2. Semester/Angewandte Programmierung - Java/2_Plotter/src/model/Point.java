/**
 * Package Model.
 */
package model;

/**
 * Point.java:
 * Beschreibt einen Koordinatenpunkt auf der Zeichenflaeche.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 27 Jun 2018
 */
public class Point {

	/**
	 * Der ganzzahlige Wert fuer den X-Koordinate.
	 */
	private int x;

	/**
	 * Der ganzzahlige Wert fuer den Y-Koordinate.
	 */
	private int y;

	/**
	 * Point:
	 * Konstruktor mit Parameter.
	 * Speichert ubergegebenene Werte als Attribute des neuen Objektes.
	 * 
	 * @param x (int) X-Koordinate.
	 * @param y (int) Y-Koordinate.
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Liefert den Wert vom X-Koordinate zurueck.
	 * 
	 * @return x (int) X-Koordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Liefert den Wert vom Y-Koordinate zurueck.
	 * 
	 * @return y (int) Y-Koordinate.
	 */
	public int getY() {
		return y;
	}

}
