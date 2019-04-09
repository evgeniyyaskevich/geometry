package by.epam.evgeniyyaskevich.shapes.observer;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.warehouse.CubeWareHouse;

import java.util.Observable;

public class CubeWareHouseUpdateObserver implements IShapeObserver {

    private CubeWareHouse cubeWareHouse = CubeWareHouse.getInstance();

    @Override
    public void update(Observable o, Object cube) {
        cubeWareHouse.update((Cube)cube);
    }
}