
public class Stereo {
	
	public void on() {
		System.out.println("Stero is on");
	}
	
	public void off() {
		System.out.println("Stereo is off");
	}
	
	public void setCd() {
		System.out.println("Cd is set");
	}
	
	public void setDvd() {
		System.out.println("Dvd is set");
	}
	
	public void setRadio() {
		System.out.println("Radio is set");
	}
	
	public void setVolume(int volumeLevel) {
		System.out.println("Volume is to" + String.valueOf(volumeLevel));
	}

}
