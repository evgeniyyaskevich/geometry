package by.epam.evgeniyyaskevich.shapes.comparator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShapeComparatorTest {

    private ShapeComparator shapeComparator = ShapeComparator.getInstance();

    @DataProvider(name = "dataCompareById")
    public Object[][] dataCompareById() {
        return new Object[][] {
                {new Cube(new Point3D(1, 2, 3), 5),  new Cube(new Point3D(3, 5, 1), 2)}
        };
    }

    @Test(dataProvider = "dataCompareById")
    public void compareById(Cube cubeLeft, Cube cubeRight) {
        boolean result = shapeComparator.compareById(cubeLeft, cubeRight) < 0;
        Assert.assertTrue(result);
    }

    @Test
    public void compareByIdTwo() {
        Cube cube = new Cube(new Point3D(1, 2, 3), 1);
        boolean result = shapeComparator.compareById(cube, cube) == 0;
        Assert.assertTrue(result);
    }


    @Test
    public void compareByName() {
        Cube cube = new Cube(new Point3D(1, 2, 3), 1);
        cube.setName("MEGACUBE");
        Cube cubeTwo = new Cube(new Point3D(1, 2, 5), 15);
        cubeTwo.setName("MEGACUBEA");

        boolean result = shapeComparator.compareByName(cube, cubeTwo) < 0;

        Assert.assertTrue(result);
    }

    @Test
    public void compareByNameTwo() {
        Cube cube = new Cube(new Point3D(5, 5,5), 3);

        boolean result = shapeComparator.compareByName(cube, cube) == 0;

        Assert.assertTrue(result);
    }

    @Test void compareByNameThree() {
        Cube cube = new Cube(new Point3D(1, 1,1), 2);
        Cube cubeTwo = new Cube(new Point3D(2, 3, 4), 5);
        cubeTwo.setName("A");

        boolean result = shapeComparator.compareByName(cube, cubeTwo) > 0;

        Assert.assertTrue(result);
    }
}