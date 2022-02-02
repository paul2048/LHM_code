package com.mycompany.lhm;

import java.util.ArrayList;


public class InsurancePolicy {
    private int numberOfInsurers;
    private ArrayList<Payment> payments;
    
    public InsurancePolicy(int numberOfInsurers) {
        this.numberOfInsurers = numberOfInsurers;
        this.payments = new ArrayList<>();
    }
    
    public int getNumberOfInsurers() {
        return this.numberOfInsurers;
    }
    
    public void setNumberOfInsurers(int numberOfInsurers) {
        this.numberOfInsurers = numberOfInsurers;
    }
    
    public ArrayList<Payment> getPayments() {
        return this.payments;
    }
    
    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }
    
    public Payment makePayment(TreatmentCourse treatmentCourse,
            int additionalCosts) {
        // If the payment was already canceled by the patient
        if (treatmentCourse.getIsCancelledByPatient() == true) {
            System.out.println("Payment unsuccessful: patient cancelation.");
        } else {
            // The final price of the treatment (agreed price + restart fee)
            int finalPrice = treatmentCourse.getAgreedEstimatedPrice() +
                    treatmentCourse.getRestartFee();
            // Create a insurance policy payment
            var payment = new Payment(finalPrice, additionalCosts,
                    treatmentCourse, this);
            payments.add(payment);
            return payment;
        }
        // If the payment cannot be made
        return null;
    }
}
