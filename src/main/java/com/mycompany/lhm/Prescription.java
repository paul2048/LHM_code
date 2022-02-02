package com.mycompany.lhm;

import java.time.LocalDateTime;


public class Prescription {
    private String name;
    private Boolean isTaken;
    private final LocalDateTime creationTimestamp;
    private LocalDateTime takenTimestamp;
    private LocalDateTime suspendedUntil;
    private Patient prescribedTo;
    private Practitioner cancelledBy;
    private Practitioner suspendedBy;
    
    public Prescription(String name, Patient prescribedTo) {
        this.isTaken = false;
        this.name = name;
        this.creationTimestamp = LocalDateTime.now();
        this.takenTimestamp = null;
        this.suspendedUntil = null;
        this.prescribedTo = prescribedTo;
        this.cancelledBy = null;
        this.suspendedBy = null;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Boolean getIsTaken() {
        return this.isTaken;
    }

    public void setIsTaken(Boolean isTaken) {
        this.isTaken = isTaken;
    }
    
    public LocalDateTime getCreationTimestamp() {
        return this.creationTimestamp;
    }
    
    public LocalDateTime getTakenTimestamp() {
        return this.takenTimestamp;
    }
    
    public void setTakenTimestamp(LocalDateTime date) {
        this.takenTimestamp = date;
    }
    
    public LocalDateTime getSuspendedUntil() {
        return this.suspendedUntil;
    }
    
    public void setSuspendedUntil(LocalDateTime date) {
        this.suspendedUntil = date;
    }
    
    public Patient getPrescribedTo() {
        return this.prescribedTo;
    }
    
    public void setPrescribedTo(Patient prescribedTo) {
        this.prescribedTo = prescribedTo;
    }
    
    public Practitioner getCancelledBy() {
        return this.cancelledBy;
    }
    
    public void setCancelledBy(Practitioner cancelledBy) {
        this.cancelledBy = cancelledBy;
    }
    
    public Practitioner getSuspendedBy() {
        return this.suspendedBy;
    }
    
    public void setSuspendedBy(Practitioner suspendedBy) {
        this.suspendedBy = suspendedBy;
    }
}
