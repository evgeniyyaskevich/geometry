package by.epam.evgeniyyaskevich.shapes.action;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CubeLocation {
    private static final Logger LOGGER = LogManager.getLogger(CubeLocation.class);
    private static final CubeLocation INSTANCE = new CubeLocation();

    public static CubeLocation getInstance() {
        return INSTANCE;
    }

    private CubeLocation() { }

    public boolean touchesOxyzPlanes(Cube cube) {
        LOGGER.trace("Checking Cube for touching to Coord plane.");
        Point3D cubeCenter = cube.getCenter();
        double cubeLength = cube.getLength();
        return (Math.abs(cubeCenter.getX()) == cubeLength / 2)
                || (Math.abs(cubeCenter.getY()) == cubeLength / 2)
                || (Math.abs(cubeCenter.getZ()) == cubeLength / 2);
    }

    public boolean cutsByOxyPlane(Cube cube) {
        LOGGER.trace("Checking Cube for cutting by plane Oxy.");
        Point3D cubeCenter = cube.getCenter();
        double cubeLength = cube.getLength();
        return Math.abs(cubeCenter.getZ()) < (cubeLength / (double) 2);
    }
}
