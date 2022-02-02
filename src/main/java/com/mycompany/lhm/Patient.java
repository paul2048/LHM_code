package com.mycompany.lhm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;


public class Patient extends Person {
    private LocalDate dateOfBirth;
    private Hospital treatedBy;
    private ArrayList<Appointment> appointments;
    private ArrayList<Prescription> prescriptions;
    private ArrayList<TreatmentCourse> treatmentCourses;
    private ArrayList<Payment> payments;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth,
            Hospital treatedBy) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.treatedBy = treatedBy;
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.treatmentCourses = new ArrayList<>();
        this.payments = new ArrayList<>();
    }
    
    public Hospital getTreatedBy() {
        return this.treatedBy;
    }
    
    public void setTreatedBy(Hospital treatedBy) {
        this.treatedBy = treatedBy;
    }
    
    public void addTreatmentCourse(TreatmentCourse treatmentCourse) {
        this.treatmentCourses.add(treatmentCourse);
    }
    
    public ArrayList<Appointment> getAppointments() {
        return this.appointments;
    }
    
    public ArrayList<TreatmentCourse> getTreatmentCourses() {
        return this.treatmentCourses;
    }
    
    public ArrayList<Payment> getPayments() {
        return this.payments;
    }
    
    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }
    
    public int getAge() {
        var now = LocalDate.now();
        return Period.between(this.dateOfBirth, now).getYears();
    }
    
    public Appointment requestAppointment(boolean isOnline, LocalDate appDate,
            Practitioner practitioner) {
        // Create a new appointment and add it to the list of appoitments
        var appointment = new Appointment(isOnline, appDate, this, practitioner);
        this.appointments.add(appointment);
        return appointment;
    }
    
    public void agreeTreatmentCosts(TreatmentCourse treatmentCourse) {
        // If the treatment course is already accepted
        if (treatmentCourse.getIsCancelledByPatient() == false) {
            System.out.println("This treatment course price is already accepted.");
        }
    }
    
    public void takePrescription(Prescription prescription) {
        // If the prescription is already taken
        if (prescription.getIsTaken() == true) {
            System.out.println("This prescription is already taken.");
        } else {
            // Mark the prescription as taken and mark the taken timestamp
            prescription.setIsTaken(true);
            prescription.setTakenTimestamp(LocalDateTime.now());
        }
    }
    
    public Payment makePayment(TreatmentCourse treatmentCourse) {
        // If the payment was already canceled by the patient
        if (treatmentCourse.getIsCancelledByPatient() == true) {
            System.out.println("Payment unsuccessful: patient cancelation.");
        } else {
            // The final price of the treatment (agreed price + restart fee)
            int finalPrice = treatmentCourse.getAgreedEstimatedPrice() +
                treatmentCourse.getRestartFee();
            // Make the payment
            var payment = new Payment(finalPrice, treatmentCourse, this);
            payments.add(payment);
            return payment;
        }
        // If the payment cannot be made
        return null;
    }
    
    public void restartTreatmentCourse(TreatmentCourse treatmentCourse) {
        int currRestartFee = treatmentCourse.getRestartFee();
        int restartFee = this.treatedBy.getRestartTreatmentFee();
        treatmentCourse.setRestartFee(currRestartFee + restartFee);
    }
}
