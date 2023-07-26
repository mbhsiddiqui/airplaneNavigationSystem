//package navigationModule;
//
//import autopilotModule.*;
//import controlSurfacesModule.*;
//import coordinateComparisonModule.*;
//import GPSReceiverModule.*;
//
//import java.util.List;
//
//public class NavigationFacade {
//    // TODO: complete the implementation
//    /*
//    * The Navigation Façade does the following sequence of steps (see Façade pattern)
//    * a. Send a request to GPSReceiver object #1 to get the first reading
//    * b. Send a request to GPSReceiver object #2 to get the second reading
//    * c. Send a request to GPSReceiver object #3 to get the third reading
//    * !! Don’t forget, two of the GPSReceivers are Honeywell brand,
//    * and the other one is Rockwell brand.
//    * d. Apply the comparison strategy/strategies to get the resulting coordinates
//    * (see the Strategy pattern)
//    * e. Send the coordinates to the GPS Date Subject
//    * f. Update the Autopilot with the new coordinates
//    */
//
//    ICompareCoordsStrategy comparisonStrategyOne, comparisonStrategyTwo;
//
//    // TODO: uncomment the 4 lines below
//     public NavigationFacade(List<GPSReceiver> gpsReaders, ICompareCoordsStrategy comparisonStrategyOne,
//	 		ICompareCoordsStrategy comparisonStrategyTwo,List<IControlActuator> actuators) {
//
//         this.comparisonStrategyOne = comparisonStrategyOne;
//         this.comparisonStrategyTwo = comparisonStrategyTwo;
//	 	// TODO: complete the implementation
//	 }
//
//    public Coordinates compareGPSData(List<Coordinates> data) {
//        // TODO: complete the implementation. this method is part of step d
//        comparisonStrategyOne.compareCoords(data.get(0), data.get(1), data.get(2));
//        return null;
//    }
//
//}
//package navigationModule;
//
//import autopilotModule.*;
//import controlSurfacesModule.*;
//import coordinateComparisonModule.*;
//import GPSReceiverModule.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NavigationFacade {
//    private List<GPSReceiver> gpsReaders;
//    private List<ICompareCoordsStrategy> comparisonStrategies;
//    private List<IControlActuator> actuators;
//    private GPSDataSubject gpsDataSubject;
//
//    public NavigationFacade(List<GPSReceiver> gpsReaders, List<ICompareCoordsStrategy> comparisonStrategies,
//                            List<IControlActuator> actuators) {
//        this.gpsReaders = gpsReaders;
//        this.comparisonStrategies = comparisonStrategies;
//        this.actuators = actuators;
//        this.gpsDataSubject = new GPSDataSubject(actuators);
//    }
//
//    public Coordinates getCoordinates(Coordinates nextWaypoint) {
//        List<Coordinates> gpsData = getGPSData();
//        for (ICompareCoordsStrategy strategy : comparisonStrategies) {
//            Coordinates result = compareGPSData(strategy, gpsData);
//            if (result != null) {
//                gpsDataSubject.setCoordinates(result);
//                return result;
//            }
//        }
//        return null; // no valid result found
//    }
//
//    private List<Coordinates> getGPSData() {
//        List<Coordinates> gpsData = new ArrayList<>();
//        for (GPSReceiver receiver : gpsReaders) {
//            gpsData.add(receiver.getCoordinates());
//        }
//        return gpsData;
//    }
//
//    private Coordinates compareGPSData(ICompareCoordsStrategy strategy, List<Coordinates> data) {
//        return strategy.compareCoords(data.get(0), data.get(1), data.get(2));
//    }
//
//}

package navigationModule;

import autopilotModule.*;
import controlSurfacesModule.*;
import coordinateComparisonModule.*;
import GPSReceiverModule.*;

import java.util.List;

public class NavigationFacade {
    private List<GPSReceiver> gpsReceivers;
    private ICompareCoordsStrategy comparisonStrategyOne;
    private ICompareCoordsStrategy comparisonStrategyTwo;
    private GPSDataSubject gpsDataSubject;

    public NavigationFacade(List<GPSReceiver> gpsReceivers, ICompareCoordsStrategy comparisonStrategyOne,
                            ICompareCoordsStrategy comparisonStrategyTwo, GPSDataSubject gpsDataSubject) {
        this.gpsReceivers = gpsReceivers;
        this.comparisonStrategyOne = comparisonStrategyOne; // Should be TwoThreeVoting
        this.comparisonStrategyTwo = comparisonStrategyTwo; // Should be FirstIsBest
        this.gpsDataSubject = gpsDataSubject;
    }

    public Coordinates getCoordinates() {
        Coordinates[] data = new Coordinates[gpsReceivers.size()];
        for (int i = 0; i < gpsReceivers.size(); i++) {
            data[i] = gpsReceivers.get(i).getCoordinates();
            System.out.println("GPS DATA LAT DATA IS " + data[i].getLatitude() + " GPS DATA LON IS  " + data[i].getLongitude());
        }
        Coordinates result = compareGPSData(data);
        gpsDataSubject.setCoordinates(result);
        return result;
    }

    public Coordinates compareGPSData(Coordinates[] data) {
        System.out.println(" ********* INVOKING VOTING COMPARISON **********");
        Coordinates coords = comparisonStrategyOne.compareCoords(data[0], data[1], data[2]);
        if (coords == null) {
            coords = comparisonStrategyTwo.compareCoords(data[0], data[1], data[2]);
        }
        return coords;
    }
}

