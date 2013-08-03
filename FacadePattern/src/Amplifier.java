import org.w3c.dom.CDATASection;


public class Amplifier {
    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer  cdPlayer;
    
    Amplifier(Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer) {
    	this.tuner = tuner;
    	this.dvdPlayer = dvdPlayer;
    	this.cdPlayer = cdPlayer;
    }
    
    public void on() {
    	System.out.println("Amplifier on");
    }
    
    public void off() {
    	System.out.println("Amplifier off");
    }
}
