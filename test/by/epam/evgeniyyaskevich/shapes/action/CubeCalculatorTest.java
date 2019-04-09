package by.epam.evgeniyyaskevich.shapes.action;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeCalculatorTest {

    private static CubeCalculator cubeCalculator;

    @BeforeClass
    public static void setUp() {
        cubeCalculator = CubeCalculator.getInstance();
    }


    @Test(dataProvider = "dataCalculateSurfaceArea", dataProviderClass = CubeCalculationTestData.class)
    public void calculateSurfaceArea(Cube cube, double expected) {
        double result = cubeCalculator.calculateSurfaceArea(cube);
        Assert.assertEquals(result, expected, 1e-4);
    }

    @Test(dataProvider = "dataCalculateVolume", dataProviderClass = CubeCalculationTestData.class)
    public void calculateVolume(Cube cube, double expected) {
        double result = cubeCalculator.calculateVolume(cube);
        Assert.assertEquals(result, expected, 1e-4);
    }

    @Test (dataProvider = "dataCalculateRatioVolumesOfParts", dataProviderClass = CubeCalculationTestData.class)
    public void calculateRatioVolumesOfPartsAfterCuttingOxy(Cube cube, double expected) {
        double result = cubeCalculator.calculateRatioVolumesOfPartsAfterCuttingOxy(cube);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void calculateDistanceFromCenterToOrigin() {
        Cube cube = new Cube(new Point3D(1, 2, 3), 14);

        double distance = cubeCalculator.calculateDistanceFromCenterToOrigin(cube);

        Assert.assertEquals(distance, Math.sqrt(14));
    }
}