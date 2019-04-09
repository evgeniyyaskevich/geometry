package by.epam.evgeniyyaskevich.shapes.specification;

import by.epam.evgeniyyaskevich.shapes.entity.Shape;

public class ShapeSpecification {

    private static ShapeSpecification INSTANCE;

    ShapeSpecification() { }

    public static ShapeSpecification getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ShapeSpecification();
        }
        return INSTANCE;
    }

    public boolean mathesById(Shape shape, int id) {
        return shape.getId() == id;
    }

    public boolean mathesByName(Shape shape, String name) {
        return shape.getName().equals(name);
    }
}
