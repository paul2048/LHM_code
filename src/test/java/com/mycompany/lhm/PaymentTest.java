package com.mycompany.lhm;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PaymentTest {
    Hospital hospital = new Hospital("LHM", "33 Oxford Street", 10000);
    LocalDate now = LocalDate.now();
    LocalDate dob = now.minusYears(20);
    Patient patient = new Patient("John", "Doe", dob, hospital);
    LocalDate startDate = now.plusMonths(1);
    LocalDate endDate = startDate.plusMonths(2);

    /**
     * Test if the payment is valid:
     * payment is either made by the patient or the insurance.
     * First test a patient payment, then an insurance policy payment.
     */
    @Test
    public void testValidPayment() {
        // 1) Test patient payment
        TreatmentCourse treatmentCourse1 = new TreatmentCourse(startDate,
                endDate, patient, new ArrayList<>(), new ArrayList<>());
        Practitioner practitioner1 = new Practitioner("Joe", "Foo",
                treatmentCourse1);
        practitioner1.setEstimatedPrice(78800);
        Payment payment1 = patient.makePayment(treatmentCourse1);
        // `true` if the payment was made by a patient, `false` otherwise
        boolean isPaidByPatient1 = payment1.getPaidByPatient() != null &&
                                   payment1.getPaidByInsurance() == null;
        // `true` if the payment was made by an insurance, `false` otherwise
        boolean isPaidByinsurance1 = payment1.getPaidByPatient() == null &&
                                     payment1.getPaidByInsurance() != null;
        boolean expResult1 = true;
        boolean result1 = isPaidByPatient1 ^ isPaidByinsurance1;
        assertEquals(expResult1, result1);
        
        // 2) Test insurance policy payment
        TreatmentCourse treatmentCourse2 = new TreatmentCourse(startDate,
                endDate, patient, new ArrayList<>(), new ArrayList<>());
        Practitioner practitioner2 = new Practitioner("Dan", "Bar",
                treatmentCourse2);
        practitioner2.setEstimatedPrice(63800);
        Payment payment2 = patient.makePayment(treatmentCourse2);
        // `true` if the payment was made by a patient, `false` otherwise
        boolean isPaidByPatient2 = payment2.getPaidByPatient() != null &&
                                   payment2.getPaidByInsurance() == null;
        // `true` if the payment was made by an insurance, `false` otherwise
        boolean isPaidByinsurance2 = payment2.getPaidByPatient() == null &&
                                     payment2.getPaidByInsurance() != null;
        boolean expResult2 = true;
        boolean result2 = isPaidByPatient2 ^ isPaidByinsurance2;
        assertEquals(expResult2, result2);
    }

    /**
     * This test assures that the payee of the payment is the same payee
     * as the person that took the paid treatment course.
     * (in short, make sure the "foreign keys" match).
     */
    @Test
    public void testPaymentPayee() {
        TreatmentCourse treatmentCourse = new TreatmentCourse(startDate,
                endDate, patient, new ArrayList<>(), new ArrayList<>());
        Practitioner practitioner = new Practitioner("Joe", "Foo",
                treatmentCourse);
        practitioner.setEstimatedPrice(78800);
        Payment payment = patient.makePayment(treatmentCourse);
        
        Patient expResult = payment.getPaidByPatient();
        Patient result = payment.getPaidFor().getTakenBy();
        assertEquals(expResult, result);
    }
}
