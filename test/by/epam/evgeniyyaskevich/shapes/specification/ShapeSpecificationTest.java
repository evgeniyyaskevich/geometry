package by.epam.evgeniyyaskevich.shapes.specification;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShapeSpecificationTest {

    private Cube cube = new Cube(new Point3D(1, 2, 3), 15);
    private ShapeSpecification shapeSpecification = ShapeSpecification.getInstance();

    @Test
    public void testMathesById() {
        boolean result = shapeSpecification.mathesById(cube, 1);
        Assert.assertTrue(result);
    }

    @Test
    public void testMathesByIdTwo() {
        boolean result = shapeSpecification.mathesById(cube, 123);
        Assert.assertFalse(result);
    }

    @Test
    public void testMathesByName() {
        boolean result = shapeSpecification.mathesByName(cube, "Cube");
        Assert.assertTrue(result);
    }

    @Test
    public void testMathesByNameTwo() {
        boolean result = shapeSpecification.mathesByName(cube, "niceCuBe");
        Assert.assertFalse(result);
    }
}