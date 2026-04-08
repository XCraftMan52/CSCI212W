class Patient extends Person {
    private String idNumber;
    
    public Patient(String name, String idNumber) {
        super(name);
        this.idNumber = idNumber;
    }
    
    public String getIdNumber() {
        return idNumber;
    }
    
    public void writeOutput() {
        System.out.println("Name: " + getName());
        System.out.println("Social Security #: " + idNumber);
    }
}
 