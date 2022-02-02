package com.mycompany.lhm;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class InsurancePolicyTest {
    Hospital hospital = new Hospital("LHM", "33 Oxford Street", 10000);
    LocalDate now = LocalDate.now();
    LocalDate dob = now.minusYears(20);
    Patient patient = new Patient("John", "Doe", dob, hospital);
    LocalDate startDate = now.plusMonths(1);
    LocalDate endDate = startDate.plusMonths(2);
    TreatmentCourse treatmentCourse = new TreatmentCourse(startDate, endDate,
            patient, new ArrayList<>(), new ArrayList<>());
    Practitioner practitioner = new Practitioner("Joe", "Prak", treatmentCourse);
    InsurancePolicy insurance = new InsurancePolicy(42);
    
    /**
     * Test of makePayment method, of class InsurancePolicy.
     */
    @Test
    public void testMakePayment() {
        // PRE: The treatment course exists in the patient's list
        boolean expResult1 = true;
        boolean result1 = patient.getTreatmentCourses().contains(treatmentCourse);
        assertEquals(expResult1, result1);
        
        // POST: The payment exists in the insurance's list
        practitioner.setEstimatedPrice(50000);
        Payment payment = insurance.makePayment(treatmentCourse, 8000);
        boolean expResult2 = true;
        boolean result2 = insurance.getPayments().contains(payment);
        assertEquals(expResult2, result2);
        
        // POST: The payment was not made by a patient
        Patient expResult3 = null;
        Patient result3 = payment.getPaidByPatient();
        assertEquals(expResult3, result3);
        
        // POST: The payment has additional costs
        boolean expResult4 = true;
        boolean result4 = payment.getAdditionalCosts() > 0;
        assertEquals(expResult4, result4);
        
        // POST: The paid course exists and it's not canceled
        boolean expResult5 = true;
        boolean result5 = false;
        for (TreatmentCourse course : patient.getTreatmentCourses()) {
            // If the course that the patient paid for exists and that
            // course is not canceled by the patient
            if (course == payment.getPaidFor() &&
                    course.getIsCancelledByPatient() == false) {
                result5 = true;
            }
        }
        assertEquals(expResult5, result5);
    }
}
