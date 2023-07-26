//package controlSurfacesModule;
//
//import autopilotModule.Coordinates;
//
//import java.util.ArrayList;
//
//public class GPSDataSubject {
//    // TODO: complete the implementation
//    /*
//    * The GPS Data Subject notifies the Actuators
//    * (which move the control surfaces) with the current
//    * latitude and longitude values,
//    * and the desired path’s latitude and longitude values (see the
//    * Observer Pattern).
//    */
//	private List<IControlActuator> actuators = new ArrayList<IControlActuator>();
//	private Coordinates wayPoint;
//
//	public Coordinates getWayPoint() {
//		return wayPoint;
//	}
//
//	public void setWayPoint(Coordinates wayPoint) {
//		this.wayPoint = wayPoint;
//	}
//
//	public void attach(IControlActuator actuator) {
//		actuators.add(actuator);
//	}
//	public void notifyAllActuators() {
//		for(IControlActuator actuator : actuators) {
//			actuator.update();
//		}
//	}
//}

package controlSurfacesModule;

import autopilotModule.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class GPSDataSubject {
	private List<IControlActuator> actuators;
	private Coordinates currentCoordinates;
	private Coordinates nextCoordinates;

	public GPSDataSubject() {
		this.actuators = new ArrayList<>();
	}

	public GPSDataSubject(List<IControlActuator> actuators) {
		this.actuators = actuators;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.currentCoordinates = coordinates;
		notifyAllActuators();
	}

	public void setNextCoordinates(Coordinates coordinates) {
		this.nextCoordinates = coordinates;
	}

	private void notifyAllActuators() {
		for (IControlActuator actuator : actuators) {
			actuator.update(currentCoordinates.getLatitude(), currentCoordinates.getLongitude(),
					nextCoordinates.getLatitude(), nextCoordinates.getLongitude());
		}
	}
}
