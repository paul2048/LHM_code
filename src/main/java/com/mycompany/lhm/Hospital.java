package com.mycompany.lhm;


public class Hospital {
    private String name;
    private String address;
    private int restartTreatmentFee;
    
    public Hospital(String name, String address, int fee) {
        this.name = name;
        this.address = address;
        this.restartTreatmentFee = fee;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getRestartTreatmentFee() {
        return this.restartTreatmentFee;
    }
    
    public void setRestartTreatmentFee(int fee) {
        this.restartTreatmentFee = fee;
    }
}
