package GPSReceiverModule;

// TODO: decide whether this is a class or interface,
// then complete your implementation
import autopilotModule.Coordinates;
import java.util.Random;

public abstract class GPSReceiver {
	protected Random random;

	public GPSReceiver() {
		this.random = new Random();
	}

	// generate random coordinates between 0 and 1
	protected Coordinates generateCoordinates() {
		int lat = random.nextInt(2); // will generate either 0 or 1
		int lon = random.nextInt(2); // will generate either 0 or 1
		return new Coordinates(lat, lon);
	}

	public abstract Coordinates getCoordinates();
}