
public class GarrageDownCommand implements Command {
	GarrageDoor garrageDoor;
	
	public GarrageDownCommand(GarrageDoor garrageDoor) {
		this.garrageDoor = garrageDoor;
	}
	
	public void execute() {
		garrageDoor.down();
	}
	
	public void undo() {
		garrageDoor.up();
	}

}
