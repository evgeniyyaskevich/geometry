package by.epam.evgeniyyaskevich.shapes.entity;

import java.util.Objects;

public class Cube extends Shape {
    private Point3D center;
    private double length;

    public Cube(Point3D center, double length) {
        super("Cube");
        this.center = center;
        this.length = length;
    }

    public Point3D getCenter() {
        return center;
    }
    public double getLength() {
        return length;
    }
    public void setCenter(Point3D center) {
        this.center = center;
        setChanged();
        notifyObservers(this);
    }
    public void setLength(double length) {
        this.length = length;
        setChanged();
        notifyObservers(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Cube)) {
            return false;
        } else {
            Cube cube = (Cube) obj;
            return length == cube.length &&
                    Objects.equals(center, cube.center);
        }
    }

    @Override
    public int hashCode() {
        return 27 + toString().hashCode();
    }

    @Override
    public String toString() {
        return "[name=" + name + ", id=" + ID + ", center=(" + center.getX() + ", "
                + center.getY() + "," + center.getZ() + "), length=" + length + "]";

    }
}
