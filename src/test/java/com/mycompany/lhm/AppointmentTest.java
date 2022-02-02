package com.mycompany.lhm;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentTest {
    Hospital hospital = new Hospital("LHM", "33 Oxford Street", 10000);
    LocalDate now = LocalDate.now();
    LocalDate dob = now.minusYears(33);
    Patient patient = new Patient("John", "Doe", dob, hospital);
    LocalDate startDate = now.plusMonths(1);
    LocalDate endDate = startDate.plusMonths(2);
    TreatmentCourse treatmentCourse = new TreatmentCourse(startDate, endDate,
            patient, new ArrayList<>(), new ArrayList<>());
    Practitioner practitioner = new Practitioner("Joe", "Prak", treatmentCourse);
    
    /**
     * Make sure the patient that requested the appointment can be found by
     * looking at the practitioner of the appointment, then at the
     * practitioner's treatment course, then at the treatment course's patient
     * (in short, make sure the "foreign keys" match).
     */
    @Test
    public void testAppointmentAppointee() {
        LocalDate appDate = now.plusMonths(1);
        Appointment appointment = patient.requestAppointment(true,
                appDate, practitioner);
        Patient expResult = appointment.getRequestedBy();
        Patient result = appointment.getAppointedBy().getPerforms().getTakenBy();
        assertEquals(expResult, result);
    }
}
