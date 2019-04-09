package by.epam.evgeniyyaskevich.shapes.warehouse;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeWareHouseItemTest {

    Cube cube;
    CubeWareHouseItem cubeWareHouseItem;

    @BeforeClass
    public void setUp() {
        cube = new Cube(new Point3D(1, 2, 3), 3);
        cubeWareHouseItem = new CubeWareHouseItem(cube);
    }

    @Test
    public void getSurfaceArea() {
        double result = cubeWareHouseItem.getSurfaceArea();
        Assert.assertEquals(result, 54.0);
    }

    @Test
    public void getVolume() {
        double result = cubeWareHouseItem.getVolume();
        Assert.assertEquals(result, 27.0);
    }

    @Test
    public void update() {
        Cube newCube = new Cube(new Point3D(1, 2, 3), 3.5);
        cubeWareHouseItem.update(newCube);

        double result = cubeWareHouseItem.getVolume();

        Assert.assertEquals(result, Math.pow(3.5, 3));
    }
}