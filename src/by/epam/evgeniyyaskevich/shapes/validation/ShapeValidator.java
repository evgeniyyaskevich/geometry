package by.epam.evgeniyyaskevich.shapes.validation;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;

public class ShapeValidator {

    private static final ShapeValidator INSTANCE = new ShapeValidator();


    public static ShapeValidator getInstance() {
        return INSTANCE;
    }

    public boolean isCube(Cube cube) {
        return cube != null && cube.getLength() > 0;
    }

    public boolean isCube(Point3D cubeCenter, double cubeLength) {
        return cubeCenter != null && cubeLength > 0;
    }
}
