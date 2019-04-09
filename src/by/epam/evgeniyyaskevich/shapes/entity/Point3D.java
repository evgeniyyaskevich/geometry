package by.epam.evgeniyyaskevich.shapes.entity;

import javax.persistence.Entity;

@Entity
public class Point3D extends Shape {
    private final double x;
    private final double y;
    private final double z;

    public Point3D(double x, double y, double z) {
        super("Point3D");
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Point3D)) {
            return false;
        } else {
            Point3D point3D = (Point3D) obj;
            return Double.compare(point3D.x, x) == 0 &&
                    Double.compare(point3D.y, y) == 0 &&
                    Double.compare(point3D.z, z) == 0;
        }
    }

    @Override
    public String toString() {
        return "(name=" + name + ", id=" + ID + ", (" + x + ", " + y + ", " + z + "))";
    }

    @Override
    public int hashCode() {
        return 228 + toString().hashCode();
    }
}
