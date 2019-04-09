package by.epam.evgeniyyaskevich.shapes.specification;

import by.epam.evgeniyyaskevich.shapes.action.CubeCalculator;
import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;

public class CubeSpecification extends ShapeSpecification {

    public static CubeSpecification INSTANCE;
    public static final CubeCalculator cubeCalculator = CubeCalculator.getInstance();

    private CubeSpecification() { }

    public static CubeSpecification getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CubeSpecification();
        }
        return INSTANCE;
    }

    public boolean belongsToRangeFromOrigin(int leftBound, int rightBound, Cube cube) {
        double distanceToOrigin = cubeCalculator.calculateDistanceFromCenterToOrigin(cube);

        return distanceToOrigin >= leftBound
                && distanceToOrigin <= rightBound
                && (rightBound - leftBound) >= (cube.getLength() * Math.sqrt(3) / (double) 2);
    }

    public boolean belongsToFirstQuadrant(Cube cube) {
        Point3D center = cube.getCenter();
        double distanceToOrigin = cubeCalculator.calculateDistanceFromCenterToOrigin(cube);

        return center.getX() >= 0
                && center.getY() >= 0
                && center.getZ() >= 0
                && distanceToOrigin >= (cube.getLength() * Math.sqrt(3) / (double) 2);
    }

    public boolean belongsSurfaceAreaToRange(int leftBound, int rightBound, Cube cube) {
        double surfaceArea = cubeCalculator.calculateSurfaceArea(cube);
        return surfaceArea >= leftBound && surfaceArea <= rightBound;
    }

}
