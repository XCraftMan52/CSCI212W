public class Main {
    public static void main(String[] args) {
        // Create two doctors
        Doctor spock = new Doctor("Spock", "Pediatrician", 200.0);
        Doctor dolittle = new Doctor("Dolittle", "Witch", 175.0);
        
        System.out.println("Two doctors created:\n");
        spock.writeOutput();
        System.out.println();
        dolittle.writeOutput();
        System.out.println();
        
        // Create two patients
        Patient calvin = new Patient("Calvin", "123-45-6789");
        Patient hobbes = new Patient("Hobbes", "987-65-4321");
        
        System.out.println("Two patients created:\n");
        calvin.writeOutput();
        System.out.println();
        hobbes.writeOutput();
        System.out.println();
        
        // Create three billing records
        Billing billing1 = new Billing(spock, calvin);      
        Billing billing2 = new Billing(spock, hobbes);      
        Billing billing3 = new Billing(dolittle, calvin);
        
        System.out.println("Three billing records created:");
        billing1.writeOutput();
        System.out.println("===============================");
        billing2.writeOutput();
        System.out.println("===============================");
        billing3.writeOutput();
        System.out.println("===============================");
        System.out.println();
        
        double total = billing1.getBillingAmount() + billing2.getBillingAmount() + billing3.getBillingAmount();
        
        System.out.println("TOTAL BILLABLE DOLLARS");
        System.out.println("----------------------");
        System.out.println("$" + (billing1.getBillingAmount() + billing2.getBillingAmount() + billing3.getBillingAmount()));
        System.out.println();
        
        // Test equals method
        System.out.println("First billing record equal to the second = " + billing1.equals(billing2));
    }
}