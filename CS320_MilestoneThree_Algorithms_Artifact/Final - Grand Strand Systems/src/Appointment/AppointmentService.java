/*************************
 * Artifact Enhancement for CS 499 (Algorithms & Data Structures)
 * Enhancement: Replace ArrayList + linear search (O(n)) with HashMap lookup (avg O(1))
 *************************/

package Appointment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService {

    // Enhancement: HashMap provides average O(1) add/get/update/delete by ID
    private final Map<String, Appointment> appointmentsById = new HashMap<>();

    public void displayAppointmentList() {
        for (Appointment a : appointmentsById.values()) {
            System.out.println("\t Appointment ID: " + a.getAppointmentID());
            System.out.println("\t Appointment Date: " + a.getAppointmentDate());
            System.out.println("\t Appointment Description: " + a.getAppointmentDesc());
        }
    }

    // Adds a new appointment and RETURNS its generated ID
    public String addAppointment(Date appointmentDate, String appointmentDesc) {
        Appointment appointment = new Appointment(appointmentDate, appointmentDesc);
        String id = appointment.getAppointmentID();

        if (appointmentsById.containsKey(id)) {
            throw new IllegalStateException("Duplicate Appointment ID generated: " + id);
        }

        appointmentsById.put(id, appointment);
        return id;
    }

    public Appointment getAppointment(String appointmentID) {
        return appointmentsById.get(appointmentID);
    }

    public void deleteAppointment(String appointmentID) {
        Appointment removed = appointmentsById.remove(appointmentID);
        if (removed == null) {
            System.out.println("Appointment ID: " + appointmentID + " not found.");
        }
    }

    public void updateAppointmentDate(Date updatedDate, String appointmentID) {
        Appointment a = appointmentsById.get(appointmentID);
        if (a != null) a.setAppointmentDate(updatedDate);
        else System.out.println("Appointment ID: " + appointmentID + " not found.");
    }

    public void updateAppointmentDesc(String updatedString, String appointmentID) {
        Appointment a = appointmentsById.get(appointmentID);
        if (a != null) a.setAppointmentDesc(updatedString);
        else System.out.println("Appointment ID: " + appointmentID + " not found.");
    }

    // Optional Enhancement: Return appointments sorted by date
    public List<Appointment> getAppointmentsSortedByDate() {
        List<Appointment> list = new ArrayList<>(appointmentsById.values());
        Collections.sort(list, Comparator.comparing(Appointment::getAppointmentDate));
        return list;
    }

    public int size() {
        return appointmentsById.size();
    }
}