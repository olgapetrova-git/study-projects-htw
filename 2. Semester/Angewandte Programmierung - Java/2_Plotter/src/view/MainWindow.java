/**
 * Package View.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.ConstantValues;

/**
 * MainWindow.java:
 * Hauptbereich zur Ausgabe von eine Zeichenflaeche mit der zugehoerigen Komponenten.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 17 Jun 2018
 */
public class MainWindow extends JFrame {

	/**
	 * Der Textfeld auflistet die vom Nutzer eingegebene Koordinaten in Textform.
	 * Kann aus mehreren Textzeilen bestehen (Area).
	 */
	private OutputArea koordinatenListeArea;

	/**
	 * Die Zeichenflaeche mit dem Koordinatensystem.
	 */
	private PlotterPanel plotterPanel;

	/**
	 * Das Panel, auf dem sich die Buttons und Textfelder zur Eingabe der Funktionspunkte befinden.
	 */
	private JPanel controlPanel;

	/**
	 * Das Feld zur Eingabe von X-Koordinate.
	 */
	private JTextField xField;

	/**
	 * Das Feld zur Eingabe von Y-Koordinate.
	 */
	private JTextField yField;

	/**
	 * Die Schaltflaeche zum Hinzufügen von Koordinaten.
	 */
	private JButton addButton;

	/**
	 * Die Schaltflaeche zum Loeschen der gesamten Zeichnung.
	 */
	private JButton clearButton;

	/**
	 * Der Menuepunkt "Alle löschen".
	 */
	private JMenuItem deleteMenuItem;

	/**
	 * Der Menuepunkt "Beenden".
	 */
	private JMenuItem exitMenuItem;

	/**
	 * Der Menuepunkt "Über das Programm".
	 */
	private JMenuItem aboutMenuItem;

	/**
	 * MainWindow:
	 * Konstruktor ohne Parameter.
	 * 
	 */

	public MainWindow() {
		super();

		setTitle(ConstantValues.AUTOR_NAME);

		initWindowSize();

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		initComponents();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}

	/**
	 * initWindowSize:
	 * Setzt Fenstergroesse entsprechend der Groesse des Bildschirms.
	 * 
	 */
	private void initWindowSize() {
		// Wird verwendet, um ueber die Bildschirmgrößen zu erfahren
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// erhalten 2/3 der Höhe und 2/3 der Breite von Bildschirm
		int height = screenSize.height * 2 / 3;
		int width = screenSize.width * 2 / 3;
		setSize(width, height);

	}

	/**
	 * initComponents:
	 * Addiert die Komponente zum MainWindow.
	 */
	private void initComponents() {

		initOutputArea();
		plotterPanel = new PlotterPanel();
		add(plotterPanel, BorderLayout.CENTER);
		controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		initControlPanel();
		initMenu();
	}

	/**
	 * initOutputArea:
	 * Initialisiert Textbereich zur Ausgabe der Koordinatenliste.
	 */
	private void initOutputArea() {
		koordinatenListeArea = new OutputArea();
		koordinatenListeArea.setEditable(false);
		JScrollPane jsp = new JScrollPane(koordinatenListeArea);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		koordinatenListeArea.setColumns(ConstantValues.COLUMNS);
		add(jsp, BorderLayout.EAST);
	}

	/**
	 * initControlPanel:
	 * Addiert die Komponente zum ControlPanel.
	 */
	private void initControlPanel() {

		controlPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 10, 20, 10);

		JLabel xLabel = new JLabel("X-Koordinate");
		xField = new JTextField("", ConstantValues.TEXTFIELD_LENGTH); // 10 symbols
		JLabel yLabel = new JLabel("Y-Koordinate");
		yField = new JTextField("", ConstantValues.TEXTFIELD_LENGTH);
		addButton = new JButton("Hinzufügen");
		clearButton = new JButton("Alle löschen");
		controlPanel.add(xLabel, gbc);
		controlPanel.add(xField, gbc);
		controlPanel.add(yLabel, gbc);
		controlPanel.add(yField, gbc);
		controlPanel.add(addButton, gbc);
		controlPanel.add(clearButton, gbc);
		getRootPane().setDefaultButton(addButton);

	}

	/**
	 * initMenu:
	 * Initialisiert ein Menue mit Eintraege.
	 */
	public void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		// Menue Programm
		JMenu programmMenu = new JMenu("Programm");

		deleteMenuItem = new JMenuItem("Alle löschen");
		deleteMenuItem.setActionCommand(ConstantValues.MENUITEM_DELETE);

		exitMenuItem = new JMenuItem("Beenden");
		exitMenuItem.setActionCommand(ConstantValues.MENUITEM_EXIT);

		programmMenu.add(deleteMenuItem);
		programmMenu.addSeparator();
		programmMenu.add(exitMenuItem);

		JMenu helpMenu = new JMenu("?");
		aboutMenuItem = new JMenuItem("Über das Programm");
		aboutMenuItem.setActionCommand(ConstantValues.MENUITEM_ABOUT);
		helpMenu.add(aboutMenuItem);

		menuBar.add(programmMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);
	}

	/**
	 * showErrorMessage:
	 * Zeigt die Fehlermeldung ueber die falsche Benutzereingabe.
	 * 
	 * @param message (String) Der Text der Fehlermeldung.
	 */
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Fehler", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * showAboutDialog:
	 * Zeigt die Info ueber das Programm.
	 */
	public void showAboutDialog() {
		JOptionPane.showMessageDialog(this, "Plotter v1.1                      \nOlga Petrova\n"
				+ "Mkl-Nr. 562984", "Über das Programm", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Liefert OutputArea koordinatenListeArea zurueck (geerbt von JTextArea).
	 * 
	 * @return koordinatenListeArea (OutputArea) Der Textfeld auflistet die Koordinaten in Textform.
	 */
	public OutputArea getKoordinatenListe() {
		return koordinatenListeArea;
	}

	/**
	 * Liefert JTextField xField zurueck.
	 * 
	 * @return xField (JTextField) Das Feld zur Eingabe von X-Koordinate.
	 */
	public JTextField getxField() {
		return xField;
	}

	/**
	 * Liefert JTextField yField zurueck.
	 * 
	 * @return yField (JTextField) Das Feld zur Eingabe von Y-Koordinate.
	 */
	public JTextField getyField() {
		return yField;
	}

	/**
	 * Liefert JButton addButton zurueck.
	 * 
	 * @return addButton (JButton) Die Schaltflaeche zum Hinzufügen von Koordinaten.
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * Liefert JButton clearButton zurueck.
	 * 
	 * @return clearButton (JButton) Die Schaltflaeche zum Loeschen der gesamten Zeichnung.
	 */
	public JButton getClearButton() {
		return clearButton;
	}

	/**
	 * Liefert PlotterPanel plotterPanel zurueck.
	 * 
	 * @return plotterPanel (PlotterPanel) Die Zeichenflaeche mit dem Koordinatensystem.
	 */
	public PlotterPanel getPlotterPanel() {
		return plotterPanel;
	}

	/**
	 * Liefert JMenuItem deleteMenuItem zurueck.
	 * 
	 * @return the deleteMenuItem
	 */
	public JMenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}

	/**
	 * Liefert JMenuItem exitMenuItem zurueck.
	 * 
	 * @return the exitMenuItem
	 */
	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	/**
	 * Liefert JMenuItem aboutMenuItem zurueck.
	 * 
	 * @return the aboutMenuItem
	 */
	public JMenuItem getAboutMenuItem() {
		return aboutMenuItem;
	}

}
