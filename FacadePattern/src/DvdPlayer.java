
public class DvdPlayer {
    Amplifier amplifier;
    
    public DvdPlayer(Amplifier amplifier) {
    	this.amplifier = amplifier;
    }
    
    public void on() {
    	System.out.println("DvdPlayer on");
    }
    
    public void off() {
    	System.out.println("DvdPlayer off");
    }
}
