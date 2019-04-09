package by.epam.evgeniyyaskevich.shapes.action;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeCalculator {

    private static final Logger LOGGER = LogManager.getLogger(CubeCalculator.class);
    private static final CubeCalculator INSTANCE = new CubeCalculator();

    public static CubeCalculator getInstance() {
        return INSTANCE;
    }

    private CubeCalculator() { }

    public double calculateSurfaceArea(Cube cube) {
        LOGGER.trace("Calculating square of Cube.");
        return 6 * Math.pow(cube.getLength(), 2);
    }

    public double calculateVolume(Cube cube) {
        LOGGER.trace("Calculating volume of Cube.");
        return Math.pow(cube.getLength(), 3);
    }

    public double calculateRatioVolumesOfPartsAfterCuttingOxy(Cube cube) {
        CubeLocation cubeLocation = CubeLocation.getInstance();
        Point3D cubeCenter = cube.getCenter();
        double cubeLength = cube.getLength();

        if (cubeLocation.cutsByOxyPlane(cube)) {
            return Math.abs(cubeLength / (double) 2 + cubeCenter.getZ())
                    / Math.abs(cubeLength / (double) 2 - cubeCenter.getZ());
        } else {
          LOGGER.warn("Cube isn`t cut by Oxy. Returned zero.");
          return 0;
        }
    }

    public double calculateDistanceFromCenterToOrigin(Cube cube) {
        Point3D center = cube.getCenter();
        return Math.sqrt(Math.pow(center.getX(), 2)
                + Math.pow(center.getY(), 2)
                + Math.pow(center.getZ(), 2));
    }

}
