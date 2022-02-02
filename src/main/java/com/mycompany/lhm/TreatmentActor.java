package com.mycompany.lhm;


public class TreatmentActor extends Person {
    protected TreatmentCourse performs;
    
    public TreatmentActor(String firstName, String lastName,
            TreatmentCourse treatmentCourse) {
        super(firstName, lastName);
        this.performs = treatmentCourse;
    }
    
    public TreatmentCourse getPerforms() {
        return this.performs;
    }
    
    public void setPerforms(TreatmentCourse treatmentCourse) {
        this.performs = treatmentCourse;
    }
}
