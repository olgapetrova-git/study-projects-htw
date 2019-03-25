/**
 * Package View.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Point;
import model.PointsList;

/**
 * PlotterPanel.java:
 * Implementiert eine Zeichenflaeche mit einem Koordinatensystem.
 * Dient als Beobachter und reagiert auf Aenderungen vom beobachteten Objekt.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 19 Jun 2018
 */
public class PlotterPanel extends JPanel implements Observer {

	/**
	 * Die Liste von Koordinatenpunkten.
	 */
	private PointsList pointsList = null;

	/**
	 * PlotterPanel:
	 * Konstruktor ohne Parameter.
	 * Setzt die Ansicht fuer Plotter Panel.
	 */

	public PlotterPanel() {
		setBackground(new Color(229, 246, 249));
		setBorder(BorderFactory.createLineBorder(new Color(11, 84, 96), 4));
	}

	/**
	 * paintComponent:
	 * Zeichnet das Koordinatensystem auf der Zeichenflaeche.
	 * 
	 * @param g (Graphics) Grafikkontext, mit dem das Programm auf Komponenten zeichnen kann.
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintCoordinateAxes(g);
		paintPointsAndLines(g);
	}

	/**
	 * paintPointsAndLines:
	 * Zeichnet die Koordinatenpunkten und die Linien auf der Zeichenflaeche.
	 * 
	 * @param g (Graphics) Grafikkontext, mit dem das Programm auf Komponenten zeichnen kann.
	 */
	private void paintPointsAndLines(Graphics g) {
		Point displayPoint = null;
		Point lastDisplayPoint = null;
		g.setColor(new Color(206, 42, 24));
		((Graphics2D) g).setStroke(new BasicStroke(4)); // 11, 84, 96
		try {
			if (pointsList != null) {

				for (Point point : pointsList.getPoints()) {
					displayPoint = projectCoordinate(point.getX(), point.getY());
					g.fillOval((displayPoint.getX() - 5), (displayPoint.getY() - 5), 10, 10);
					if (lastDisplayPoint != null) {
						g.drawLine(lastDisplayPoint.getX(), lastDisplayPoint.getY(), displayPoint.getX(),
								displayPoint.getY());
					}
					lastDisplayPoint = displayPoint;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * paintCoordinateAxes:
	 * Zeichnet das Koordinatenachsen auf der Zeichenflaeche.
	 * 
	 * @param g (Graphics) Grafikkontext, mit dem das Programm auf Komponenten zeichnen kann.
	 */
	private void paintCoordinateAxes(Graphics g) {
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		int width = getWidth();
		int height = getHeight();
		g.setColor(new Color(11, 84, 96));
		((Graphics2D) g).setStroke(new BasicStroke(4));
		g.drawLine(0, centerY, width, centerY);
		g.drawLine(centerX, 0, centerX, height);
		for (int i = -100; i <= 100; i += 10) {
			Point point1 = projectCoordinate(i, 0);
			g.drawLine(point1.getX(), (centerY - 5), point1.getX(), (centerY + 5));
			Point point2 = projectCoordinate(0, i);
			g.drawLine((centerX - 5), point2.getY(), (centerX + 5), point2.getY());
		}
	}

	/**
	 * projectCoordinate:
	 * Konvertiert logische Koordinaten in Grafikkoordinaten.
	 * 
	 * @param x (int) logische X-Koordinate.
	 * @param y (int) logische Y-Koordinate.
	 * @return Point - Das Objekt der Klasse Point, enthaelt die Koordinaten.
	 */
	private Point projectCoordinate(int x, int y) {
		int newX = 0;
		int newY = 0;
		newX = (x + 100) * getWidth() / 200;
		newY = (-y + 100) * getHeight() / 200;
		return new Point(newX, newY);
	}

	/**
	 * update
	 * Diese Methode wird aufgerufen, wenn das beobachtete Objekt PointsList geändert wird (ruft die Methode notifyObserver)
	 * Zeichnet das Koordinatensystem wieder.
	 * 
	 * @param o (Observable) Beobachtetes Objekt.
	 * @param arg (Object) Ein Parameter vom beobachteten Objekt.
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof PointsList) {
			pointsList = (PointsList) o;
		}
		repaint();
	}

}
