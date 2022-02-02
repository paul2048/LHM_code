package com.mycompany.lhm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Practitioner extends TreatmentActor {
    private ArrayList<Appointment> appointments;
    private ArrayList<Prescription> presctiptions;
    
    public Practitioner(String firstName, String lastName,
            TreatmentCourse performs) {
        super(firstName, lastName, performs);
        this.appointments = new ArrayList<>();
        this.presctiptions = new ArrayList<>();
    }
    
    public void setEstimatedPrice(int price) {
        this.getPerforms().setAgreedEstimatedPrice(price);
    }
    
    public void setTreatmentDuration(LocalDate startDate, LocalDate endDate) {
        this.getPerforms().setStartDate(startDate);
        this.getPerforms().setEndDate(endDate);
    }
    
    public void cancelTreatment() {
        this.getPerforms().setIsCancelledByPatient(true);
    }
    
    public void cancelPrescription(Prescription prescription) {
        prescription.setCancelledBy(this);
    }
    
    public void suspendPrescription(Prescription prescription,
            LocalDateTime suspendedUntil) {
        var now = LocalDateTime.now();
        
        if (prescription.getCancelledBy() != null) {
            System.out.println("You cannot suspend a cancelled prescription.");
        } else if (suspendedUntil.isBefore(now)) {
            System.out.println("You cannot suspend with a date from the past.");
        } else {
            // Suspend the prescription until the desired date
            prescription.setSuspendedBy(this);
            prescription.setSuspendedUntil(suspendedUntil);
        }
    }
}
