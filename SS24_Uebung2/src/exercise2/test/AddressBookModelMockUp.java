/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für das AddressBookModel
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 49
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author Philip Nys
 * @author Dominik Busse
 */
public class AddressBookModelMockUp implements AddressBookModel {
	public final static int sizeLimit = 10;

	// TODO: Mock-Up erstellen
	public AddressBookModelMockUp() {
		
	}
/**
	 * Store a new entry.
	 * @param entry The entry to store
	 * @return true in case the entry has been stored, false in case that the entry already existed.
	 * @throws SizeLimitReachedException When the address book is full 
	 */
	public boolean addEntry(Entry entry) throws SizeLimitReachedException {
		return true;
	}

	/**
	 * Get a single entry
	 * @param surName The last name of a person's entry 
	 * @param firstName The first name of a person's entry
	 * @return A matching entry, or null if none was found
	 */
	public Entry getEntry(String surName, String firstName) {
		return new Entry();
	}

	/**
	 * Retrieve all entries stored in the address book
	 * @return a collection of entries (sorted by name)
	 */
	public Collection<Entry> getEntries() {
		return new TreeSet<Entry>();
	}
	
	/**
	 * Removes a single entry from the address book.
	 * @param entry The entry to remove
	 * @param return true in case the entry has been found and deleted, false in case there is no such entry
	 */
	public boolean deleteEntry(Entry entry) {
		return true;
	}

	/**
	 * Erase all entries in the address book.
	 */
	public void erase() {}

	/**
	 * Load data from persistent file storage.
	 * @throws IOException When file loading failed
	 */
	public void load() throws IOException {}
	
	/**
	 * Write data to persistent storage.
	 * @throws IOException When the file could not be written to
	 */
	public void save() throws IOException {}
	
}
