/**
 * Package Controller.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ConstantValues;
import view.MainWindow;

/**
 * MenuListener.java:
 * Bearbeitet Ereignisse von der angemeldeten Menuepunkten "Beenden" und "Über das Programm".
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 1 Jul 2018
 */
public class MenuListener implements ActionListener {

	/**
	 * Instanz der Klasse MainWindow, dient zur
	 * Ausgabe von eine Zeichenflaeche auf dem Hauptbereich.
	 */
	private MainWindow mainWindow;

	/**
	 * MenuListener:
	 * Konstruktor mit Parameter.
	 * Speichert den ubergegebenen Wert als Attribut des neuen Objektes.
	 * 
	 * @param mainWindow (MainWindow) Instanz der Klasse MainWindow.
	 */

	public MenuListener(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}

	/**
	 * actionPerformed:
	 * Wird aufgerufen, wenn ein ActionEvent an einer der angemeldeten Menuepunkten
	 * "Beenden" bzw. "Über das Programm" auftritt.
	 * Fuehrt eine Aktion gemaess dem ausgewaehlten Menuepunkt aus.
	 * 
	 * @param e (ActionEvent) Referenz auf das ActionEvent-Objekt
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals(ConstantValues.MENUITEM_EXIT)) {
			System.exit(0);
		} else if (actionCommand.equals(ConstantValues.MENUITEM_ABOUT)) {
			mainWindow.showAboutDialog();
		}
	}

}
