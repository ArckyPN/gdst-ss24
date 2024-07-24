/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Theo Vassiliou
 * Technische Universität Berlin
 */
package exercise1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import javax.naming.SizeLimitExceededException;

import org.junit.Before;
import org.junit.Test;

import exercise1.addressbook.model.AddressBook;
import exercise1.addressbook.model.EmailAddress;
import exercise1.addressbook.model.Entry;
import exercise1.addressbook.model.Gender;
import exercise1.addressbook.model.PhoneNumber;
import exercise1.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 1 - Grundlagen des Testens mit JUnit
 * 
 * Bitte Nummer der Gruppe eintragen: 49
 * 
 * Bitte Gruppenmitglieder eintragen:
 * 
 * @author Philip Nys
 * @author Dominik  Busse
 */
public class AddressBookFunctionalTest {

	// The component under test
	private AddressBook addressBook;

	/*
	 * Aufgabe 3a) Schreiben Sie eine Methode zum Aufsetzen der Testumgebung
	 * ("Fixture"). Diese Methode soll automatisch vor jedem einzelnen JUnit
	 * Testfall ausgeführt werden. Innerhalb der Methode soll mindestens ein
	 * neues AddressBook Objekt angelegt und im Attribut "addressBook"
	 * gepeichert werden.
	 */
	@Before
	public void fixture() {
		this.addressBook = new AddressBook();
	}

	/*
	 * Aufgabe 3b) Schreiben Sie einen JUnit Testfall zum überprüfen der
	 * Funktionalität der addEntry() Methode.
	 */
	@Test
	public void testAddContact() {
		Entry bob = new Entry("Example", "Bob", Gender.Male, new EmailAddress("bob@example.com"));
		Entry alice = new Entry("Test", "Alice", Gender.Female, new EmailAddress("alice@example.com"));

		try {
			assertTrue(addressBook.addEntry(bob));
			assertTrue(addressBook.addEntry(alice));

			for (int i = 2 ; i < AddressBook.sizeLimit ; i++ ) {
				assertTrue(addressBook.addEntry(new Entry(i+"Family", i+"name", Gender.Male, new EmailAddress(i+"@example.com"))));
			}
		} catch (SizeLimitReachedException e) {
			fail();
		}
		try {
			addressBook.addEntry(alice);
			fail();
		} catch (SizeLimitReachedException e) {}
	}

	/*
	 * Aufgabe 3c) Schreiben Sie einen JUnit Testfall zum überprüfen der
	 * Funktionalität der getEntry() Methode.
	 */
	@Test
	public void testGetEntry() {
		Entry bob = new Entry("Example", "Bob", Gender.Male, new EmailAddress("bob@example.com"));

		assertNull(addressBook.getEntry("null", "null"));

		try {
			assertTrue(addressBook.addEntry(bob));
		} catch (SizeLimitReachedException e) { 
			fail(); 
		}

		assertEquals(bob, addressBook.getEntry("Example", "Bob"));
	}
}
