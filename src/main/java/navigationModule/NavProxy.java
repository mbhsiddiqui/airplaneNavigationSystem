//package navigationModule;
//
//// In this class, we are expecting that you would use the proxy pattern
//public class NavProxy {
//
//	// TODO: implement this class
//
//}

package navigationModule;

import GPSReceiverModule.*;
import autopilotModule.Coordinates;
import controlSurfacesModule.GPSDataSubject;
import coordinateComparisonModule.*;

import java.util.ArrayList;
import java.util.List;

public class NavProxy {
	private NavigationFacade facade;

	public NavProxy() {
		List<GPSReceiver> defaultReceivers = new ArrayList<GPSReceiver>();
		defaultReceivers.add(new HoneywellGPSReceiver());
		defaultReceivers.add(new RockwellGPSReceiver());

		ICompareCoordsStrategy defaultStrategyOne = new TwoThreeVoting();
		ICompareCoordsStrategy defaultStrategyTwo = new FirstIsBest();

		GPSDataSubject defaultDataSubject = new GPSDataSubject(new ArrayList<>());

		this.facade = new NavigationFacade(defaultReceivers, defaultStrategyOne, defaultStrategyTwo, defaultDataSubject);
	}
	public NavProxy(NavigationFacade facade) {
		this.facade = facade;
	}

	public Coordinates getCoordinates() {
		return facade.getCoordinates();
	}
}
