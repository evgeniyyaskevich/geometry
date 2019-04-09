package by.epam.evgeniyyaskevich.shapes.factory;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;


public class ShapeFactory {

    private static final ShapeFactory INSTANCE = new ShapeFactory();


    public static ShapeFactory getInstance() {
        return INSTANCE;
    }

    public Point3D getPoint3D(double x, double y, double z) {
        return new Point3D(x, y, z);
    }

    public Cube getCube(Point3D center, double length) {
        return new Cube(center, length);
    }
}