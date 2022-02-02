package com.mycompany.lhm;
import java.time.LocalDate;

public class Payment {
    private int finalPrice;
    private int additionalCosts;
    private LocalDate timestamp;
    private TreatmentCourse paidFor;
    private Patient paidByPatient;
    private InsurancePolicy paidByInsurance;

    // Constructor for patient payments
    public Payment(int finalPrice, TreatmentCourse paidFor, Patient paidByPatient) {
        this.finalPrice = finalPrice;
        this.additionalCosts = 0;
        this.timestamp = LocalDate.now();
        this.paidFor = paidFor;
        this.paidByPatient = paidByPatient;
        this.paidByInsurance = null;
    }
    
    // Constructor for insurance policy payments
    public Payment(int finalPrice, int additionalCosts,
            TreatmentCourse paidFor, InsurancePolicy paidByInsurance) {
        this.finalPrice = finalPrice;
        this.additionalCosts = additionalCosts;
        this.timestamp = LocalDate.now();
        this.paidFor = paidFor;
        this.paidByPatient = null;
        this.paidByInsurance = paidByInsurance;
    }
    
    public int getfinalPrice() {
        return this.finalPrice;
    }
    
    public int getAdditionalCosts() {
        return this.additionalCosts;
    }
    
    public LocalDate getTimestamp() {
        return this.timestamp;
    }
    
    public TreatmentCourse getPaidFor() {
        return this.paidFor;
    }
    
    public Patient getPaidByPatient() {
        return this.paidByPatient;
    }
    
    public InsurancePolicy getPaidByInsurance() {
        return this.paidByInsurance;
    }
}
