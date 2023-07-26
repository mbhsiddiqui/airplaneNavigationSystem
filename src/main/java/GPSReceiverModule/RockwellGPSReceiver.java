package GPSReceiverModule;

import autopilotModule.Coordinates;

public class RockwellGPSReceiver extends GPSReceiver {
	@Override
	public Coordinates getCoordinates() {
		// Rockwell might have some specific implementation or additional functionality
		System.out.println("Rockwell GPS Reader is Used");
		return generateCoordinates();
	}
}
