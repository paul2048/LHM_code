package com.mycompany.lhm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PrescriptionTest {
    Hospital hospital = new Hospital("LHM", "33 Oxford Street", 10000);
    LocalDate now = LocalDate.now();
    LocalDate dob = now.minusYears(33);
    Patient patient = new Patient("John", "Doe", dob, hospital);

    /**
     * Make sure the timestamp of when the prescription was taken is before
     * the current date and time. If the prescription is not taken, there is
     * no need to check that.
     * First test a case where the prescription is not taken, then one that it
     * is taken.
     */
    @Test
    public void testTakenTimestamp() {
        // Test a prescription that is not taken
        Prescription prescription = new Prescription("Acetaminophen", patient);
        boolean expResult1 = true;
        // The prescription is not taken yet or, if it is taken, the taken
        // date should be before the current date and time.
        boolean result1 = prescription.getIsTaken() == false ||
                prescription.getTakenTimestamp()
                        .isBefore(LocalDateTime.now().plusSeconds(1));
        assertEquals(expResult1, result1);

        // Test a prescription that is taken
        patient.takePrescription(prescription);
        boolean expResult2 = true;
        // We add 1 second at the end because otherwise the two timestemps
        // would be the same since the prescription was just taken.
        boolean result2 = prescription.getIsTaken() == false ||
                prescription.getTakenTimestamp()
                        .isBefore(LocalDateTime.now().plusSeconds(1));
        assertEquals(expResult2, result2);
    }
}
