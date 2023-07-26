package coordinateComparisonModule;

import autopilotModule.*;

public class TwoThreeVoting implements ICompareCoordsStrategy {

    @Override
    public Coordinates compareCoords(Coordinates gps1, Coordinates gps2, Coordinates gps3) {
        // TODO: complete the implementation. Refer to SampleOutput.txt to see expected output strings
        if (gps1.getLatitude() == gps2.getLatitude() && gps1.getLongitude() == gps2.getLongitude()) {
            // gps1 and gps2 have the same coordinates
            System.out.println("------- AGREEMENT WITH GPS1 AND GPS2");
            return gps1;
        } else if (gps1.getLatitude() == gps3.getLatitude() && gps1.getLongitude() == gps3.getLongitude()) {
            // gps1 and gps3 have the same coordinates
            System.out.println("------- AGREEMENT WITH GPS1 AND GPS3");
            return gps1;
        } else if (gps2.getLatitude() == gps3.getLatitude() && gps2.getLongitude() == gps3.getLongitude()) {
            // gps2 and gps3 have the same coordinates
            System.out.println("------- AGREEMENT WITH GPS2 AND GPS3");
            return gps2;
        } else {
            // There is no agreement between at least 2/3 receivers, return null
            return null;
        }
    }
    
}
