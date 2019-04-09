package by.epam.evgeniyyaskevich.shapes.comparator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeComparatorTest {

    private CubeComparator cubeComparator = CubeComparator.getInstance();
    private Cube cubeOne, cubeTwo, cubeThree;

    @BeforeClass
    public void setUp() {
        cubeOne = new Cube(new Point3D(1, 2, 3), 15);
        cubeTwo = new Cube(new Point3D(14, 10, 30), 5);
        cubeThree = new Cube(new Point3D(0, -2, -12), 6.5);
    }

    @Test
    public void compareByLength() {
        boolean result = cubeComparator.compareByLength(cubeOne, cubeTwo) > 0;
        Assert.assertTrue(result);
    }

    @Test
    public void compareByLengthTwo() {
        boolean result = cubeComparator.compareByLength(cubeTwo, cubeThree) < 0;
        Assert.assertTrue(result);
    }


    @Test
    public void compareByXCoord() {
        boolean result = cubeComparator.compareByXCoord(cubeOne, cubeTwo) < 0;
        Assert.assertTrue(result);
    }

    @Test
    public void compareByXCoordTwo() {
        boolean result = cubeComparator.compareByXCoord(cubeTwo, cubeThree) > 0;
        Assert.assertTrue(result);
    }

    @Test
    public void compareByYCoord() {
        boolean result = cubeComparator.compareByYCoord(cubeTwo, cubeThree) > 0;
        Assert.assertTrue(result);
    }

    @Test
    public void compareByYCoordTwo() {
        boolean result = cubeComparator.compareByYCoord(cubeTwo, cubeThree) < 0;
    }
}