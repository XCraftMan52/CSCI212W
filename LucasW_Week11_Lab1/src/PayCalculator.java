public abstract class PayCalculator {

	protected double payRate;
    
    public PayCalculator(double payRate) {
        this.payRate = payRate;
    }
    
    public double getPay(double hours) {
        return hours * payRate;
    }
    
    public void changeRate(double newRate) {
        this.payRate = newRate;
    }
}