/**
 * Package Controller.
 */
package controller;

import java.awt.HeadlessException;

import model.ClockModel;
import model.PointsList;
import view.ClockObserver;
import view.MainWindow;

/**
 * MainController.java:
 * Steuert die Ausführung des ganzen Programms.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 24 Jun 2018
 */
public class MainController {

	/**
	 * MainController:
	 * Konstruktor ohne Parameter.
	 */
	public MainController() {
		super();
	}

	/**
	 * start:
	 * Erzeugt die Programmkomponenten und stellt die Bezeihungen zwischen ihnen.
	 */
	public void start() {

		try {
			ClockModel clockModel = new ClockModel();
			PointsList pointsList = new PointsList();
			MainWindow mainWindow = new MainWindow();

			ClockObserver clockObserver = new ClockObserver(mainWindow);
			clockModel.addObserver(clockObserver);

			AddButtonListener addButtonListener = new AddButtonListener(mainWindow, pointsList);
			mainWindow.getAddButton().addActionListener(addButtonListener);

			ClearButtonListener clearButtonListener = new ClearButtonListener(pointsList);
			mainWindow.getClearButton().addActionListener(clearButtonListener);

			pointsList.addObserver(mainWindow.getPlotterPanel());
			pointsList.addObserver(mainWindow.getKoordinatenListe());

			MenuListener menuListener = new MenuListener(mainWindow);
			mainWindow.getDeleteMenuItem().addActionListener(clearButtonListener);
			mainWindow.getExitMenuItem().addActionListener(menuListener);
			mainWindow.getAboutMenuItem().addActionListener(menuListener);
			// HeadlessException: Wird ausgelöst, wenn das Grafik-Device kein Display, Keyboard oder Maus besitzt.
		} catch (HeadlessException e) {
			e.printStackTrace();
		}

	}
}
