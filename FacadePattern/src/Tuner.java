
public class Tuner {
    Amplifier amplifier;
    
    public Tuner(Amplifier amplifier) {
    	this.amplifier = amplifier;
    }
    
    public void on() {
    	System.out.println("Amplifier on");
    }
    
    public void off() {
    	System.out.println("Amplifier off");
    }
}
