package by.epam.evgeniyyaskevich.shapes.validation;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShapeValidatorTest {

    private ShapeValidator shapeValidator = ShapeValidator.getInstance();

    @Test (testName = "cubeValidatorTest")
    public void issCube() {
        Cube cube = new Cube(new Point3D(1, 2, 3), -5);

        boolean result = shapeValidator.isCube(cube);

        Assert.assertFalse(result);
    }

    @Test (testName = "cubeValidatorTestTwo")
    public void isCubeTwo() {
        Cube cube = new Cube(new Point3D(1, 0, 1), 0);

        boolean result = shapeValidator.isCube(cube);

        Assert.assertFalse(result);
    }

    @Test (testName = "cubeValidatorTestThree")
    public void isCubeThree() {
        Cube cube = new Cube(new Point3D(0, 0, 0), 3);

        boolean result = shapeValidator.isCube(cube);

        Assert.assertTrue(result);
    }

    @Test (testName = "cubeValidatorTestFour")
    public void testIsCubeFour() {
        Point3D cubeCenter = new Point3D(9, 99, 999);
        double cubeLength = -5;

        boolean result = shapeValidator.isCube(cubeCenter, cubeLength);

        Assert.assertFalse(result);
    }

    @Test (testName = "cubeValidatorTestFive")
    public void testIsCubeFive() {
        Point3D cubeCenter = new Point3D(-3, -5, 999);
        double cubeLength = 6;

        boolean result = shapeValidator.isCube(cubeCenter, cubeLength);

        Assert.assertTrue(result);
    }

}
