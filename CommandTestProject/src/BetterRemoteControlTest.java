
public class BetterRemoteControlTest {
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		Light kitchenLight =  new Light();
		Light livingRoomLight = new Light();
		GarrageDoor garrageDoor = new GarrageDoor();
		Stereo livingRoomStereo = new Stereo();
		
		LightOnCommand livingOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenOn  = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenOff = new LightOffCommand(kitchenLight);
		
		
		GarrageOpenCommand garrageOpen = new GarrageOpenCommand(garrageDoor);
		GarrageDownCommand garrageDown =  new GarrageDownCommand(garrageDoor);
		
		StereoOnCommand stereoOn =  new StereoOnCommand(livingRoomStereo);
		StereoOffCommand stereoOff =  new StereoOffCommand(livingRoomStereo);
		
		remote.setCommand(0, kitchenOn, kitchenOff);
		remote.setCommand(1, livingOn, livingOff);
		remote.setCommand(2, garrageOpen, garrageDown);
		remote.setCommand(3, stereoOn, stereoOff);
		
		
		remote.onButtonWasPushed(0);
		remote.onButtonWasPushed(1);
		remote.onButtonWasPushed(2);
		remote.onButtonWasPushed(3);
		
		remote.offButtonWasPushed(0);
		remote.offButtonWasPushed(1);
		remote.offButtonWasPushed(2);
		remote.offButtonWasPushed(3);
	}
}
