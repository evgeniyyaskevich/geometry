package by.epam.evgeniyyaskevich.shapes.warehouse;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class CubeWareHouseTest {

    private CubeWareHouse cubeWareHouse = CubeWareHouse.getInstance();

    @Test
    public void update() {
        CubeWareHouse cubeWareHouse = CubeWareHouse.getInstance();
        Cube cube = new Cube(new Point3D(1, 2, 3), 100);
        cubeWareHouse.add(cube);

        cube.setLength(1);
        cubeWareHouse.update(cube);

        CubeWareHouseItem cubeWareHouseItem = cubeWareHouse.getItems().get(cube.getId());
        double result = cubeWareHouseItem.getSurfaceArea();
        Assert.assertEquals(result, 6.0);
    }

    @Test
    public void add() {
        Cube cube = new Cube(new Point3D(1, 2, 3), 5);
        int oldSize = cubeWareHouse.getItems().size();

        cubeWareHouse.add(cube);

        Map<Integer, CubeWareHouseItem> items = cubeWareHouse.getItems();
        boolean result = (items.size() == oldSize + 1);

        Assert.assertTrue(result);
    }
}