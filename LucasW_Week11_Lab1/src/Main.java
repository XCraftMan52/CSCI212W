public class Main {
    
    public static void main(String[] args) {
        RegularPay regularPay = new RegularPay(7.5);
        HazardPay hazardPay = new HazardPay(7.5);
        
        double regularPay1 = regularPay.getPay(40);
        double hazardPay1 = hazardPay.getPay(40);
        
        System.out.println("40 hours regular pay at 7.5 is " + regularPay1);
        System.out.println("40 hours hazard pay at 7.5 is " + hazardPay1);
        
        System.out.println();
        
        // Change pay rate to 17.0
        regularPay.changeRate(17.0);
        hazardPay.changeRate(17.0);
        
        // Second calculation: 40 hours at 17.0 per hour
        double regularPay2 = regularPay.getPay(40);
        double hazardPay2 = hazardPay.getPay(40);
        
        System.out.println("40.0 hours regular pay at 17 is " + regularPay2);
        System.out.println("40.0 hours hazard pay at 17 is " + hazardPay2);
    }
}
