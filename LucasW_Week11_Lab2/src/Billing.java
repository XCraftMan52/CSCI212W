class Billing {
    private Patient patient;
    private Doctor doctor;
    private double billingAmount;
    
    public Billing(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        this.billingAmount = doctor.getOfficeVisitFee();
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public double getBillingAmount() {
        return billingAmount;
    }
    
    public void writeOutput() {
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Patient: " + patient.getName());
        System.out.println("Billing Amount: $" + billingAmount);
    }
    
    public boolean equals(Billing other) {
        if (other == null) {
            return false;
        }
        return this.doctor.getName().equals(other.doctor.getName()) &&
               this.patient.getName().equals(other.patient.getName()) &&
               this.billingAmount == other.billingAmount;
    }
}