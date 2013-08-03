
public class HomeTheaterTest {
	public static void main(String[] args) {
		CdPlayer cdPlayer;
		Amplifier amplifier = null;
		DvdPlayer dvdPlayer = null;
		Projector projector = null;
		Tuner tuner = null;
		
		cdPlayer = new CdPlayer(amplifier);
		amplifier = new Amplifier(tuner, dvdPlayer, cdPlayer);
		dvdPlayer = new DvdPlayer(amplifier);
        projector = new Projector(dvdPlayer);
		TheaterLights theaterLights = new TheaterLights();
		HomeTheaterFacade htf = new HomeTheaterFacade(amplifier, tuner, dvdPlayer, cdPlayer, projector, theaterLights);
		
		htf.watchMovie();
		
	}

}
