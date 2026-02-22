package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import Appointment.AppointmentService;

class AppointmentServiceTest {

    @Test
    @DisplayName("Add and Get Appointment by returned ID")
    void testAddAndGetAppointment() {
        AppointmentService service = new AppointmentService();
        Date date = new Date(System.currentTimeMillis() + 86400000L); // +1 day
        String id = service.addAppointment(date, "Appointment Description");
        assertNotNull(service.getAppointment(id));
        assertEquals("Appointment Description", service.getAppointment(id).getAppointmentDesc());
    }

    @Test
    @DisplayName("Update Appointment Description by ID")
    void testUpdateAppointmentDesc() {
        AppointmentService service = new AppointmentService();
        Date date = new Date(System.currentTimeMillis() + 86400000L);
        String id = service.addAppointment(date, "Old Desc");
        service.updateAppointmentDesc("New Desc", id);
        assertEquals("New Desc", service.getAppointment(id).getAppointmentDesc());
    }

    @Test
    @DisplayName("Delete Appointment by ID")
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date date = new Date(System.currentTimeMillis() + 86400000L);
        String id = service.addAppointment(date, "Appointment Description");
        service.deleteAppointment(id);
        assertNull(service.getAppointment(id));
        assertEquals(0, service.size());
    }
}