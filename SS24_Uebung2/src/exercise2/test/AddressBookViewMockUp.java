/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.model.AddressBookAccess;
import exercise2.addressbook.view.AddressBookView;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für den AddressBookView
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 49
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author Philip Nys
 * @author Dominik Busse
 */
public class AddressBookViewMockUp implements AddressBookView {

	// TODO: Mock-Up erstellen
	public AddressBookViewMockUp() {}

	/**
	 * Creates the view object.
	 * @param model A source of address book data
	 * @param controller The application controller
	 */
	public void create(AddressBookAccess model, AddressBookController controller) {}

	/**
	 * Repaints the view.
	 * This method needs to be triggered whenever the address book data changed.
	 */
	public void refresh() {}
	
}
