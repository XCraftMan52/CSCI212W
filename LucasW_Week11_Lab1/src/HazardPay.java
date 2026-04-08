
public class HazardPay extends PayCalculator {
    
    public HazardPay(double payRate) {
        super(payRate);
    }

    @Override
    public double getPay(double hours) {
        return super.getPay(hours) * 1.5;
    }
}
 