
public class BetterRemoteControlTest {
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		Light kitchenLight =  new Light();
		Light livingRoomLight = new Light();
		GarrageDoor garrageDoor = new GarrageDoor();
		
		LightOnCommand livingOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenOn  = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenOff = new LightOffCommand(kitchenLight);
		
		GarrageOpenCommand garrageOpen = new GarrageOpenCommand(garrageDoor);
		GarrageDownCommand garrageDown =  new GarrageDownCommand(garrageDoor);
		
		
		remote.setCommand(0, kitchenOn, kitchenOff);
		remote.setCommand(1, livingOn, livingOff);
		remote.setCommand(2, garrageOpen, garrageDown);
		
		
		remote.onButtonWasPushed(0);
		remote.onButtonWasPushed(1);
		remote.onButtonWasPushed(2);
		
		remote.offButtonWasPushed(0);
		remote.offButtonWasPushed(1);
		remote.offButtonWasPushed(2);
	}
}
