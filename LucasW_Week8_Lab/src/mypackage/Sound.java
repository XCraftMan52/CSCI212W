package mypackage;

public class Sound {
    private String soundName;
    private double soundLength; 

    public Sound(String soundName, double soundLength) {
        this.soundName = soundName;
        this.soundLength = soundLength;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public double getSoundLength() {
        return soundLength;
    }

    public void setSoundLength(double soundLength) {
        this.soundLength = soundLength;
    }

}