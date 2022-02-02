package com.mycompany.lhm;

import java.time.LocalDate;
import java.util.ArrayList;


public class TreatmentCourse {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer agreedEstimatedPrice;
    private boolean treatedByLHM;
    private int restartFee;
    private boolean isCancelledByPatient;
    private Patient takenBy;
    private ArrayList<TreatmentItem> treatmentItems;
    private ArrayList<Consultant> consultants;
    private ArrayList<Surgeon> surgeons;
    
    public TreatmentCourse(LocalDate startDate, LocalDate endDate,
            Patient takenBy, ArrayList<Consultant> consultants,
            ArrayList<Surgeon> surgeons) {
        this.startDate = startDate;
        this.endDate = endDate;
        // "null" means the patient didn't agree to the costs yet
        this.agreedEstimatedPrice = null;
        this.treatedByLHM = true;
        this.restartFee = 0;
        this.isCancelledByPatient = false;
        this.takenBy = takenBy;
        this.treatmentItems = new ArrayList<>();
        this.consultants = consultants;
        this.surgeons = surgeons;
        // Imediatelly add the treatment course to the patient's list
        // of treatment courses
        this.takenBy.addTreatmentCourse(this);
    }
    
    public LocalDate getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public int getAgreedEstimatedPrice() {
        return this.agreedEstimatedPrice;
    }
    
    public void setAgreedEstimatedPrice(int agreedEstimatedPrice) {
        this.agreedEstimatedPrice = agreedEstimatedPrice;
    }
    
    public boolean getTreatedByLHM() {
        return this.treatedByLHM;
    }
    
    public void setTreatedByLHM(boolean treatedByLHM) {
        this.treatedByLHM = treatedByLHM;
    }
    
    public int getRestartFee() {
        return this.restartFee;
    }
    
    public void setRestartFee(int restartFee) {
        this.restartFee = restartFee;
    }
    
    public boolean getIsCancelledByPatient() {
        return this.isCancelledByPatient;
    }
    
    public void setIsCancelledByPatient(boolean isCancelledByPatient) {
        this.isCancelledByPatient = isCancelledByPatient;
    }
    
    public Patient getTakenBy() {
        return this.takenBy;
    }
    
    public void setTakenBy(Patient takenBy) {
        this.takenBy = takenBy;
    }
    
    public void printPrevRecords() {
        // Print the descriptions of the previous treatment items/records
        for (int i = 0; i < treatmentItems.size(); i++) {
            System.out.println(treatmentItems.get(i).getDescription());
        }
    }
    
    public void addTreatmentItem(TreatmentItem treatmentItem) {
        // Assign a treatment item to a treatment course
        treatmentItem.setAssignedTo(this);
        this.treatmentItems.add(treatmentItem);
    }
}
