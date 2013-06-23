
public class GarrageOpenCommand implements Command {
	GarrageDoor garrageDoor;
	
	public GarrageOpenCommand(GarrageDoor garrageDoor) {
		this.garrageDoor = garrageDoor;
	}
		
	@Override
	public void execute() {
		garrageDoor.up();
		garrageDoor.lightOn();		
	}

	@Override
	public void undo() {
		garrageDoor.down();
		
	}
	
	

}
