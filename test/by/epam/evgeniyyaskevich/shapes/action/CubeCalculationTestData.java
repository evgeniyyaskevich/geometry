package by.epam.evgeniyyaskevich.shapes.action;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.annotations.DataProvider;

public class CubeCalculationTestData {

    @DataProvider(name = "dataCalculateSurfaceArea")
    public static Object[][] dataCalculateSurfaceArea() {
        return new Object[][] {
                {new Cube(new Point3D(0, 0, 0), 3), 54},
                {new Cube(new Point3D(1, 2, 3), 2.5), 37.5},
                {new Cube(new Point3D(3, -5, 3), 3.775), 85.50375}
        };
    }

    @DataProvider(name = "dataCalculateVolume")
    public static Object[][] dataCalculateVolume() {
        return new Object[][] {
                {new Cube(new Point3D(0, 0, 0), 3), 27},
                {new Cube(new Point3D(1, 2, 3), 2.5), 15.625},
                {new Cube(new Point3D(3, -5, 3), 3.775), 53.7961}
        };
    }

    @DataProvider(name = "dataCalculateRatioVolumesOfParts")
    public static Object[][] calculateRatioVolumes() {
        return new Object[][] {
                {new Cube(new Point3D(1, 1, 2), 6), 5},
                {new Cube(new Point3D(1, 5, 0), 3), 1},
                {new Cube(new Point3D(0,0,0), 228), 1},
                {new Cube(new Point3D(3, 323, 34), 33), 0}
        };
    }

}
