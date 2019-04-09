package by.epam.evgeniyyaskevich.shapes.observer;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import by.epam.evgeniyyaskevich.shapes.warehouse.CubeWareHouse;
import by.epam.evgeniyyaskevich.shapes.warehouse.CubeWareHouseItem;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeWareHouseUpdateObserverTest {

    @Test
    public void update() {
        Cube cube = new Cube(new Point3D(1, 2, 3), 15);
        CubeWareHouse cubeWareHouse = CubeWareHouse.getInstance();
        CubeWareHouseUpdateObserver observer = new CubeWareHouseUpdateObserver();
        cube.addObserver(observer);
        cubeWareHouse.add(cube);

        cube.setLength(33);

        CubeWareHouseItem cubeWareHouseItem = cubeWareHouse.getItems().get(cube.getId());
        double result = cubeWareHouseItem.getVolume();

        Assert.assertEquals(result, Math.pow(33, 3));
    }
}