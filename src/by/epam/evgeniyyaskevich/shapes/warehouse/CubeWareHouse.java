package by.epam.evgeniyyaskevich.shapes.warehouse;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;

import java.util.HashMap;
import java.util.Map;

public class CubeWareHouse {

    private static CubeWareHouse INSTANCE;
    private Map<Integer, CubeWareHouseItem> items = new HashMap<>();

    private CubeWareHouse() { }

    public static CubeWareHouse getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CubeWareHouse();
        }
        return INSTANCE;
    }

    public Map<Integer, CubeWareHouseItem> getItems() {
        return items;
    }

    public void add(Cube cube) {
        CubeWareHouseItem cubeWareHouseItem = new CubeWareHouseItem(cube);
        items.put(cube.getId(), cubeWareHouseItem);
    }

    public void update(Cube cube) {
        int cubeId = cube.getId();
        if (items.containsKey(cubeId)) {
            CubeWareHouseItem updatingItem =  items.get(cubeId);
            updatingItem.update(cube);
        }
    }

    @Override
    public String toString() {
        return "CubeWareHouse{" +
                "items=" + items +
                '}';
    }
}
