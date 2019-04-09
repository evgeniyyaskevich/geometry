package by.epam.evgeniyyaskevich.shapes.comparator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;

public class CubeComparator extends ShapeComparator {

    private static CubeComparator INSTANCE;

    CubeComparator() { }

    public static CubeComparator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CubeComparator();
        }
        return INSTANCE;
    }

    public int compareByLength(Cube left, Cube right) {
        return Double.compare(left.getLength(), right.getLength());
    }

    public int compareByXCoord(Cube left, Cube right) {
        Point3D centerOfLeftCube = left.getCenter();
        Point3D centerOfRightCube = right.getCenter();
        return Double.compare(centerOfLeftCube.getX(), centerOfRightCube.getX());
    }

    public int compareByYCoord(Cube left, Cube right) {
        Point3D centerOfLeftCube = left.getCenter();
        Point3D centerOfRightCube = right.getCenter();
        return Double.compare(centerOfLeftCube.getY(), centerOfRightCube.getY());
    }
}
