
public class Projector {
	DvdPlayer dvdPlayer;
	
	public Projector(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
	}
	
	public void on() {
		System.out.println("Projector on");
	}
	
	public void off() {
		System.out.println("Projector off");
	}
}
