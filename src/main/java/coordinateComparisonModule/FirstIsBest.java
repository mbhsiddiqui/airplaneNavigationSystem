package coordinateComparisonModule;

import autopilotModule.*;

public class FirstIsBest implements ICompareCoordsStrategy {

    @Override
    public Coordinates compareCoords(Coordinates gps1, Coordinates gps2, Coordinates gps3) {
        // TODO: complete the implementation. Refer to SampleOutput.txt to see expected output strings
        System.out.println(" ********* NO AGREEMENT **********");
        System.out.println(" ********* GPS1 DATA WILL BE USED **********");
        return gps1;
    }
    
}
