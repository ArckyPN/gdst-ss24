/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;

import java.io.File;
import java.util.Collection;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.AddressBookModelImpl;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.Gender;
import exercise2.addressbook.model.PhoneNumber;
import exercise2.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Integration Test für Addressbook und Controller.
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 49
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author Philip Nys
 * @author Dominik Busse
 */
public class ControllerAddressBookIntegrationTest {

	// Location of the address book file
	private static final File addressBookFile = new File("contacts.xml");
		
	/*
	 *  Aufgabe 4
	 *  Programmieren Sie einen Integrationstest für AddressBookModel und AddressBookController.
	 *  Testen Sie ob die Methoden des exercise2.addressbook.controller.AddressBookController Interface zu den erwarteten Resultate im Addressbuch führen.
	 *  Testen Sie intensiv und schreiben Sie MINDESTENS einen Testfall pro Methode des interfaces. Es sind Fehler zu finden.  
	 */
	
	// Model component for the test
	AddressBookModel model;
	
	// View component for the test
	AddressBookViewMockUp view;
	
	// Controller component for the test
	AddressBookController controller;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Instantiate and wire components
		this.model = new AddressBookModelImpl(addressBookFile);
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}

	// TODO: Hier die Testfälle für den Integrationstest hinschreiben
	@Test
	public void testModel() {
		Entry bob = new Entry("Example", "Bob", Gender.Male, new PhoneNumber(1));
		try {
			// test add entry
			this.model.addEntry(bob);
		} catch (SizeLimitReachedException e) {
			fail();
		}

		// test get entry
		assertEquals(bob, this.model.getEntry("Example", "Bob"));

		// test erase
		this.model.erase();
		Collection<Entry> entries = this.model.getEntries();
		assertEquals(0, entries.size());

	}

	@Test
	public void testDeleteEntry() {
		assertFalse(this.model.deleteEntry(new Entry("not", "existing", Gender.Male, new PhoneNumber(1))));
	}

	@Test
	public void testGetEntries() {
		Collection<Entry> entries = new TreeSet<Entry>();
		Entry bob = new Entry("Example", "Bob", Gender.Male, new PhoneNumber(1));
		Entry alice = new Entry("Example", "Alice", Gender.Female, new PhoneNumber(1));

		entries.add(bob);
		entries.add(alice);

		try {
			this.model.addEntry(bob);
			this.model.addEntry(alice);
		} catch (SizeLimitReachedException e) {
			fail();
		}

		assertEquals(entries, this.model.getEntries());
	}

	@Test
	public void testLoad() {
		try {
			this.model.load();
		} catch (IOException e) {
			fail();
		}

		Collection<Entry> entries = this.model.getEntries();
		assertTrue(entries.size() > 0);
	}

	@Test
	public void testSave() {
		try {
			this.model.save();
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void testToString() {
		assertTrue(this.model.toString() != "");
	}

	@Test
	public void testLoadController() {
		try {
			this.controller.load();
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void testSaveController() {
		try {
			this.controller.save();
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void testController() {
		// test add
		try {
			this.controller.add("Bob", "Example", "M", "1234567890", null);
		} catch (SizeLimitReachedException e) {
			fail();
		} catch (ParameterException e) {
			fail();
		}

		// test remove
		this.controller.remove(0);

		// test erase
		this.controller.erase();
	}
}
