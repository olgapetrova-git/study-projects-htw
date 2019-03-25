/**
* Package View.
*/
package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

import model.Point;

/**
 * OutputArea.java:
 * Dient zur Auflistung der vom Nutzer eingegebenen Koordinaten in Textform.
 * 
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 1 Jul 2018
 */
public class OutputArea extends JTextArea implements Observer {

	/**
	 * OutputArea:
	 * Konstruktor ohne Parameter.
	 */
	public OutputArea() {
		super();
	}

	/**
	 * update:
	 * Diese Methode wird aufgerufen, wenn das beobachtete Objekt PointsList geändert wird (ruft die Methode notifyObserver).
	 * Gibt die Koordinaten auf der Console aus.
	 * 
	 * @param o (Observable) Beobachtetes Objekt.
	 * @param arg (Object) Ein Parameter vom beobachteten Objekt.
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		try {
			if (arg == null) {
				setText("");
			} else if (arg instanceof Point) {

				Point point = (Point) arg;
				append("Punkt X = " + point.getX() + " und Punkt Y = " + point.getY() + "\n");
			}
		} catch (NullPointerException | ClassCastException e) {
			e.printStackTrace();
		}

	}

}
