class Doctor extends Person {
    private String specialty;
    private double officeVisitFee;
    
    public Doctor(String name, String specialty, double officeVisitFee) {
        super(name);
        this.specialty = specialty;
        this.officeVisitFee = officeVisitFee;
    }
    
    public String getSpecialty() {
        return specialty;
    }
    
    public double getOfficeVisitFee() {
        return officeVisitFee;
    }
    
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Office Fee: $" + officeVisitFee);
        System.out.println("Specialty: " + specialty);
    }
}
 