/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import static org.junit.Assert.fail;

import org.junit.Before;

import org.junit.Test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.SizeLimitReachedException;


/**
 * Uebung 2 - Komponenten und Integrationstest
 * Komponententests für den Controller
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 49
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author Philip Nys
 * @author Dominik Busse
 */
public class AddressBookControllerTest {
	
	/*
	 *  Aufgabe 3
	 *  Führen Sie im Rahmen eines Komponententests der Klasse exercise2.addressbook.controller.AddressBookControllerImpl einen Test der Methode add(...) durch.
	 *  Schreiben Sie für die model und view Komponenten Mock-Up Klassen und verwenden Sie dies im Komponententest der AddressBookController Komponente.
	 *  Testen Sie die add() Methode auf Herz und Nieren - es sind durchaus Fehler zu finden.
	 */
	
	// Model component for the test
	AddressBookModelMockUp model;
	
	// View component for the test
	AddressBookViewMockUp view;
	
	// Controller component for the test
	AddressBookController controller;
	
	/**
	 * Set up test system
	 */
	@Before
	public void setUp() {
		// Instantiate and wire components
		this.model = new AddressBookModelMockUp();
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}
	
	// TODO: Hier die Testfälle für den Komponententest hinschreiben
	@Test
	public void testAdd() {
		try {
			this.controller.add("Bob", "Example", "M", "1234567890", null);
		} catch (SizeLimitReachedException e) {
			fail();
		} catch (ParameterException e) {
			fail();
		}
	}

	@Test
	public void testAddNullFirstName() {
		try {
			this.controller.add(null, "example", "M", "1234567890", null);
			fail();
		} catch (ParameterException e) {} catch (SizeLimitReachedException e) {
			fail();
		}
	}

	@Test
	public void testAddNullLastName() {
		try {
			this.controller.add("Bob", null, "M", "1234567890", null);
			fail();
		} catch (ParameterException e) {} catch (SizeLimitReachedException e) {
			fail();
		}
	}

	@Test
	public void addInvalidGender() {
		try {
			this.controller.add("Bob", "Example", "invalid", "1234567890", null);
			fail();
		} catch (ParameterException e) {} catch (SizeLimitReachedException e) {
			fail();
		}
	}

	@Test
	public void addNullGender() {
		try {
			this.controller.add("Bob", "Example", null, "1234567890", null);
			fail();
		} catch (ParameterException e) {} catch (SizeLimitReachedException e) {}
	}

	@Test(expected = ParameterException.class)
	public void addMissingContactInformation() {
		try {
			this.controller.add("Bob", null, "M", null, null);
			fail();
		} catch (ParameterException e) {} catch (SizeLimitReachedException e) {
			fail();
		}
	}

	@Test
	public void addBothContactInformation() {
		try {
			this.controller.add("Bob", null, "M", "1234567890", "bob@example.com");
			fail();
		} catch (ParameterException e) {} catch (SizeLimitReachedException e) {
			fail();
		}
	}

	@Test
	public void testSizeLimit() {
		try {
			for (int i = 0 ; i < AddressBookModelMockUp.sizeLimit ; i++ ) {
				this.controller.add("Bob"+i, "Example"+i, "M", null, i+"@example.com");
			}

			this.controller.add("Full", "Exception", "M", null, "exception@example.com");
			fail();
		} catch (SizeLimitReachedException e) {} catch (ParameterException e) {
			fail();
		}
	}
}
