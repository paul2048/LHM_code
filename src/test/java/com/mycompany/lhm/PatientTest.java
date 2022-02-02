package com.mycompany.lhm;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PatientTest {
    Hospital hospital = new Hospital("LHM", "33 Oxford Street", 10000);
    LocalDate now = LocalDate.now();
    LocalDate dob = now.minusYears(1);
    Patient patient = new Patient("John", "Doe", dob, hospital);
    LocalDate startDate = now.plusMonths(1);
    LocalDate endDate = startDate.plusMonths(2);
    TreatmentCourse treatmentCourse = new TreatmentCourse(startDate, endDate,
            patient, new ArrayList<>(), new ArrayList<>());
    Practitioner practitioner = new Practitioner("Joe", "Prak", treatmentCourse);

    /**
     * Test of getAge method, of class Patient.
     */
    @org.junit.jupiter.api.Test
    public void testGetAge() {
        // The age of the patient is greater than 0
        boolean expResult = true;
        boolean result = patient.getAge() > 0;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of requestAppointment method, of class Patient.
     */
    @org.junit.jupiter.api.Test
    public void testRequestAppointment() {
        var appointmentDate = LocalDate.now().plusDays(1);
        Appointment appointment = patient.requestAppointment(true,
                appointmentDate, practitioner);
        
        // PRE: The appointment date is a date in the future
        boolean expResult1 = true;
        boolean result1 = appointment.getTimestamp().isAfter(LocalDate.now());
        assertEquals(expResult1, result1);
        
        // POST: The appointment date is the same as the argument date
        LocalDate expResult2 = appointmentDate;
        LocalDate result2 = appointment.getTimestamp();
        assertEquals(expResult2, result2);
    }
    
    /**
     * Test of agreeTreatmentCosts method, of class Patient.
     */
    @org.junit.jupiter.api.Test
    public void testAgreeTreatmentCosts() {
        treatmentCourse.getTakenBy().addTreatmentCourse(treatmentCourse);
        treatmentCourse.setAgreedEstimatedPrice(25000);
        
        // PRE: The treatment course exists in the patient's list
        boolean expResult1 = true;
        boolean result1 = patient.getTreatmentCourses().contains(treatmentCourse);
        assertEquals(expResult1, result1);
        
        // POST: The costs are agreed
        Integer expResult2 = null;
        Integer result2 = treatmentCourse.getAgreedEstimatedPrice();
        assertNotEquals(expResult2, result2);
    }
}
