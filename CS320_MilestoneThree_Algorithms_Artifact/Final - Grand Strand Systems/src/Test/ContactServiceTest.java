package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.ContactService;

class ContactServiceTest {

    @Test
    @DisplayName("Add and Get Contact by returned ID")
    void testAddAndGetContact() {
        ContactService service = new ContactService();
        String id = service.addContact("Dr.", "Cross", "5555551111", "123 Lollypop Lane");
        assertNotNull(service.getContact(id));
        assertEquals("Dr.", service.getContact(id).getFirstName());
    }

    @Test
    @DisplayName("Update Contact First Name by ID")
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        String id = service.addContact("Dr.", "Cross", "5555551111", "123 Lollypop Lane");
        service.updateFirstName("Sven", id);
        assertEquals("Sven", service.getContact(id).getFirstName());
    }

    @Test
    @DisplayName("Update Contact Address by ID")
    void testUpdateAddress() {
        ContactService service = new ContactService();
        String id = service.addContact("Dr.", "Cross", "5555551111", "123 Lollypop Lane");
        service.updateAddress("999 Updated Street", id);
        assertEquals("999 Updated Street", service.getContact(id).getAddress());
    }

    @Test
    @DisplayName("Delete Contact by ID")
    void testDeleteContact() {
        ContactService service = new ContactService();
        String id = service.addContact("Dr.", "Cross", "5555551111", "123 Lollypop Lane");
        service.deleteContact(id);
        assertNull(service.getContact(id));
        assertEquals(0, service.size());
    }
}