package com.mycompany.lhm;


public class TreatmentItem {
    private String description;
    private TreatmentCourse assignedTo;
    private Treatment basedOn;
    private Hospital performedBy;
    
    public TreatmentItem(String description, TreatmentCourse assignedTo,
            Treatment basedOn, Hospital performedBy) {
        this.description = description;
        this.assignedTo = assignedTo;
        this.basedOn = basedOn;
        this.performedBy = performedBy;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public TreatmentCourse getAssignedTo() {
        return this.assignedTo;
    }
    
    public void setAssignedTo(TreatmentCourse assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    public Treatment getBasedOn() {
        return this.basedOn;
    }
    
    public void setBasedOn(Treatment basedOn) {
        this.basedOn = basedOn;
    }
    
    public Hospital getPerformedBy() {
        return this.performedBy;
    }
    
    public void setPerformedBy(Hospital performedBy) {
        this.performedBy = performedBy;
    }
}
