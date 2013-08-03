
public class CdPlayer {
	Amplifier amplifier;
	
	public CdPlayer(Amplifier amplifier) {
		this.amplifier = amplifier;
	}

	public void on() {
		System.out.println("Cdplayer on");
	}
	
	public void off() {
		System.out.println("Cdplayer off");
	}
}
