package autopilotModule;

import navigationModule.NavProxy;

import java.util.ArrayList;
import java.util.List;

public class Autopilot {
	private NavProxy proxy;
	private int nextWaypointLatitude;
	private int nextWaypointLongitude;
	public Autopilot(NavProxy proxy, int nextWaypointLatitude, int nextWaypointLongitude) {
		// TODO: implement the constructor
		this.proxy = proxy;
		this.nextWaypointLatitude = nextWaypointLatitude;
		this.nextWaypointLongitude = nextWaypointLongitude;
	}

	/**
	 * The point of this method is to send a message to the proxy.
	 * @return the same coordinates that the facade is returning to the autopilot (via the proxy)
	 */
	public Coordinates navigate() {
		// TODO: complete the implementation of this method
		return proxy.getCoordinates(); // change this, as it should return the coordinates that the facade gave to the autopilot.
	}

	// TODO: complete the implementation of this class
}