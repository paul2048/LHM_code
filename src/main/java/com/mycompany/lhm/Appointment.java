package com.mycompany.lhm;

import java.time.LocalDate;


public class Appointment {
    private boolean isOnline;
    private LocalDate timestamp;
    private Patient requestedBy;
    private Practitioner appointedBy;

    public Appointment(boolean isOnline, LocalDate timestamp,
            Patient requestedBy, Practitioner appointedBy) {
        this.isOnline = isOnline;
        this.timestamp = timestamp;
        this.requestedBy = requestedBy;
        this.appointedBy = appointedBy;
    }
    
    public boolean getIsOnline() {
        return this.isOnline;
    }
    
    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }
    
    public LocalDate getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
    
    public Patient getRequestedBy() {
        return this.requestedBy;
    }
    
    public Practitioner getAppointedBy() {
        return this.appointedBy;
    }
}
