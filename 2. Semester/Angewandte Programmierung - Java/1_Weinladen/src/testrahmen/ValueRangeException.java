/**
 * 3.Aufgabe
 */
package testrahmen;

/**
 * ValueRangeException.java:
 * Beschreibt die Exception, die tritt auf, falls der vom Benutzer eingegebene Wert nicht in dem bestimmten Bereich liegt.
 * 
 * @author Petrova Olga
 * E-Mail  
 * @version Java Version 1.8
 * @since * 3 May 2018
 */
public class ValueRangeException extends Exception {

	/**
	 * ValueRangeException:
	 * Konstruktor mit Parameter.
	 * 
	 * @param message (String) Der Text der Fehlermeldung.
	 */

	public ValueRangeException(String message) {
		super(message);

	}

}
