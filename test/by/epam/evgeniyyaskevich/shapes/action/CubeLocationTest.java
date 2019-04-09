package by.epam.evgeniyyaskevich.shapes.action;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeLocationTest {

    private static CubeLocation cubeLocation = CubeLocation.getInstance();

    @DataProvider(name = "dataTouchesOxyzPlanes")
    public Object[][] dataTouchesOxyzPlanes() {
        return new Object[][] {
                {new Cube(new Point3D(5, 5, 5), 8), false},
                {new Cube(new Point3D(0, 0, 0), 0.31), false},
                {new Cube(new Point3D(2, 3, 4), 8), true},
                {new Cube(new Point3D(5, 5, 5), 10), true}
        };
    }

    @Test (dataProvider = "dataTouchesOxyzPlanes")
    public void touchesOxyzPlanes(Cube cube, boolean expected) {
        boolean result = cubeLocation.touchesOxyzPlanes(cube);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "dataCutsByOxy")
    public Object[][] dataCutsByOxy() {
        return new Object[][] {
                {new Cube(new Point3D(3, 3, -3), 2), false},
                {new Cube(new Point3D(2, 3, 4), 8), false},
                {new Cube(new Point3D(12, 13.5, 3), 8), true},
                {new Cube(new Point3D(0, 0, 0), 0.31), true}
        };
    }

    @Test(dataProvider = "dataCutsByOxy")
    public void cutsByOxy(Cube cube, boolean expected) {
        boolean result = cubeLocation.cutsByOxyPlane(cube);
        Assert.assertEquals(result, expected);
    }
}