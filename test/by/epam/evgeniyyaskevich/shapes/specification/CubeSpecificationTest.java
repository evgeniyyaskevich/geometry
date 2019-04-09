package by.epam.evgeniyyaskevich.shapes.specification;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeSpecificationTest {

    CubeSpecification cubeSpecification = CubeSpecification.getInstance();

    @DataProvider(name = "dataBelongsToRangeFromOrigin")
    public Object[][] dataBelognsToRangeFromOrigin() {
        return new Object[][] {
                {2, 10, new Cube(new Point3D(4, 4, 4), 3), true},
                {10, 15, new Cube(new Point3D(-7, -7, -8), 2), true},
                {2, 3, new Cube(new Point3D(4, 4, 4), 5), false},
                {0, 0, new Cube(new Point3D(0, 0, 0), 0.0001), false}
        };
    }

    @Test(dataProvider = "dataBelongsToRangeFromOrigin")
    public void belongsToRangeFromOrigin(int leftBound, int rightBound, Cube cube, boolean expected) {
        boolean result = cubeSpecification.belongsToRangeFromOrigin(leftBound, rightBound, cube);
        Assert.assertEquals(result, expected);
    }


    @DataProvider(name = "dataBelongToFirstQuadrant")
    public Object[][] dataBelongToFirstQuadrant() {
        return new Object[][] {
                {new Cube(new Point3D(1, 2, 3), 10), false},
                {new Cube(new Point3D(1, 1, 1), 2.01), false},
                {new Cube(new Point3D(-1, 5, 6), 100), false},
                {new Cube(new Point3D(1, 1, 1), 0.99), true},
        };
    }

    @Test(dataProvider = "dataBelongToFirstQuadrant")
    public void belongsToFirstQuadrant(Cube cube, boolean expected) {
        boolean result = cubeSpecification.belongsToFirstQuadrant(cube);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "dataBelongsSurfaceAreaToRange")
    public Object[][] dataBelongsSurfaceAreaToRange() {
        return new Object[][] {
                {15, 20, new Cube(new Point3D(0, 0, 0), 15), false},
                {5, 10, new Cube(new Point3D(1, 2, 3), 1), true}
        };
    }

    @Test(dataProvider = "dataBelongsSurfaceAreaToRange")
    public void belongsSurfaceAreaToRange(int leftBound, int rightBound, Cube cube, boolean expected) {
        boolean result = cubeSpecification.belongsSurfaceAreaToRange(leftBound, rightBound, cube);
        Assert.assertEquals(result, expected);
    }
}