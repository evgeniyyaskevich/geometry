package by.epam.evgeniyyaskevich.shapes.comparator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;

public class ShapeComparator {

    private static ShapeComparator INSTANCE;

    ShapeComparator() { }

    public static ShapeComparator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ShapeComparator();
        }
        return INSTANCE;
    }

    public int compareById(Cube left, Cube right) {
        return Integer.compare(left.getId(), right.getId());
    }

    public int compareByName(Cube left, Cube right) {
        return left.getName().compareTo(right.getName());
    }
}
