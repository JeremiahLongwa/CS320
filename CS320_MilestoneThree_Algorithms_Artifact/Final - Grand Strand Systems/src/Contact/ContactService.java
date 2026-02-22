/*************************
 * Artifact Enhancement for CS 499 (Algorithms & Data Structures)
 * Enhancement: Replace ArrayList + linear search (O(n)) with HashMap lookup (avg O(1))
 *************************/

package Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactService {

    // Enhancement: HashMap provides average O(1) add/get/update/delete by ID
    private final Map<String, Contact> contactsById = new HashMap<>();

    // Display all contacts (order not guaranteed; use sorted method below if needed)
    public void displayContactList() {
        for (Contact c : contactsById.values()) {
            System.out.println("\t Contact ID: " + c.getContactID());
            System.out.println("\t First Name: " + c.getFirstName());
            System.out.println("\t Last Name: " + c.getLastName());
            System.out.println("\t Phone Number: " + c.getNumber());
            System.out.println("\t Address: " + c.getAddress() + "\n");
        }
    }

    // Adds a new contact and RETURNS its generated ID
    public String addContact(String firstName, String lastName, String number, String address) {
        Contact contact = new Contact(firstName, lastName, number, address);
        String id = contact.getContactID();

        if (contactsById.containsKey(id)) {
            throw new IllegalStateException("Duplicate Contact ID generated: " + id);
        }

        contactsById.put(id, contact);
        return id;
    }

    // Get a contact by ID (returns null if not found)
    public Contact getContact(String contactID) {
        return contactsById.get(contactID);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        Contact removed = contactsById.remove(contactID);
        if (removed == null) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    public void updateFirstName(String updatedString, String contactID) {
        Contact c = contactsById.get(contactID);
        if (c != null) c.setFirstName(updatedString);
        else System.out.println("Contact ID: " + contactID + " not found.");
    }

    public void updateLastName(String updatedString, String contactID) {
        Contact c = contactsById.get(contactID);
        if (c != null) c.setLastName(updatedString);
        else System.out.println("Contact ID: " + contactID + " not found.");
    }

    public void updateNumber(String updatedString, String contactID) {
        Contact c = contactsById.get(contactID);
        if (c != null) c.setNumber(updatedString);
        else System.out.println("Contact ID: " + contactID + " not found.");
    }

    public void updateAddress(String updatedString, String contactID) {
        Contact c = contactsById.get(contactID);
        if (c != null) c.setAddress(updatedString);
        else System.out.println("Contact ID: " + contactID + " not found.");
    }

    // Optional Enhancement: Return contacts sorted by last name
    public List<Contact> getContactsSortedByLastName() {
        List<Contact> list = new ArrayList<>(contactsById.values());
        Collections.sort(list, Comparator.comparing(Contact::getLastName));
        return list;
    }

    public int size() {
        return contactsById.size();
    }
}