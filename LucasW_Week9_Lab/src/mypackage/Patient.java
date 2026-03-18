package mypackage;

public class Patient {

    private String name;
    private int age;
    private String complaint;

    // Constructor
    public Patient(String name, int age, String complaint) {
        this.name = name;
        this.age = age;
        this.complaint = complaint;
    }

    // Getters
    public String getName() {
    	return name;      
    }
    
    public int getAge() { 
    	return age;       
    }
    
    public String getComplaint() {
    	return complaint; 
    }

    // Setters
    public void setName(String name) {
    	this.name = name;      
    }
    public void setAge(int age) {
    	this.age = age;
    }
    
    public void setComplaint(String complaint) {
    	this.complaint = complaint; 
    }
    
    @Override
    public String toString() {
        return String.format("Patient{name='%s', age=%d, complaint='%s'}",name, age, complaint);
    }
}