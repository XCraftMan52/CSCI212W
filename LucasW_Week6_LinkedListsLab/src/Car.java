
public class Car {
	public String cMake;
	public String cModel;
	public int cYear;
	public double cLiters;
	public boolean cAutomatic;
	
	public Car()
	{
		 cMake = "";
	     cModel = "";
	     cYear = 0;
	     cLiters = 0.0;
	     cAutomatic = false;
	}

	public Car(String tMake, String tModel, int tYear, double tLiters, boolean tAutomatic)
	{
		cMake = tMake;
		cModel = tModel;
		cYear = tYear;
		cLiters = tLiters;
		cAutomatic = tAutomatic;
	}
	
	public String getMake() { return cMake; }
    public String getModel() { return cModel; }
    public int getYear() { return cYear; }
    public double getLiters() { return cLiters; }
    public boolean getAutomatic() { return cAutomatic; }
    
    public void setMake(String tMake) { cMake = tMake; }
    public void setModel(String tModel) { cModel = tModel; }
    public void setYear(int tYear) { cYear = tYear; }
    public void setLiters(double tLiters) { cLiters = tLiters; }
    public void setAutomatic(boolean tAuto) { cAutomatic = tAuto; }
    
    public String toString() {
        return cYear + " " + cMake + " " + cModel + " " + cLiters + "L " + (cAutomatic ? "Automatic" : "Manual");
    }
}
