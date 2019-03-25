/**
 * Package Controller.
 */
package controller;

import javax.swing.UIManager;

/**
 * Starter.java:
 * Enthaelt die start-Methode, die die Ausfuehrung des ganzen Programms initialisiert.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 17 Jun 2018
 */
public class Starter {

	/**
	 * main:
	 * Die Methode erzeugt MainWindow und initialisiert damit
	 * die Ausfuehrung des ganzen Programms.
	 * 
	 * @param args (String[]) Kommandozeilenparameter, dienen zur Steuerung des Programms von auessen.
	 */

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("LookAndFeel konnte nicht installiert werden.");

		}
		MainController maincontroller = new MainController();
		maincontroller.start();
	}

}
