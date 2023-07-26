package GPSReceiverModule;

import autopilotModule.Coordinates;

public class HoneywellGPSReceiver extends GPSReceiver {
	@Override
	public Coordinates getCoordinates() {
		// Honeywell might have some specific implementation or additional functionality
		System.out.println("Honeywell GPS Reader is Used");
		return generateCoordinates();
	}
}
