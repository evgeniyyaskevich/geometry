package by.epam.evgeniyyaskevich.shapes.warehouse;

import by.epam.evgeniyyaskevich.shapes.action.CubeCalculator;
import by.epam.evgeniyyaskevich.shapes.entity.Cube;

public class CubeWareHouseItem {

    private static final CubeCalculator cubeCalculator = CubeCalculator.getInstance();

    private final int ID;
    private double surfaceArea;
    private double volume;

    CubeWareHouseItem(Cube cube) {
        ID = cube.getId();
        surfaceArea = cubeCalculator.calculateSurfaceArea(cube);
        volume = cubeCalculator.calculateVolume(cube);
    }

    void update(Cube cube) {
        surfaceArea = cubeCalculator.calculateSurfaceArea(cube);
        volume = cubeCalculator.calculateVolume(cube);
    }

    public int getID() {
        return ID;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }
    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CubeWareHouseItem)) {
            return false;
        }
        CubeWareHouseItem that = (CubeWareHouseItem) o;
        return ID == that.ID &&
                Double.compare(that.surfaceArea, surfaceArea) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return 21 + this.toString().hashCode();
    }

    @Override
    public String toString() {
        return "CubeWareHouseItem{" +
                "ID=" + ID +
                ", surfaceArea=" + surfaceArea +
                ", volume=" + volume +
                '}';
    }
}
