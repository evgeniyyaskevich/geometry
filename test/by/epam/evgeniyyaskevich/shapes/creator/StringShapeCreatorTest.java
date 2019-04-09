package by.epam.evgeniyyaskevich.shapes.creator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringShapeCreatorTest {

    private static StringShapeCreator stringShapeCreator = StringShapeCreator.getInstance();

    @DataProvider(name = "dataCreateCube")
    public static Object[][] dataCreateCube() {
        return new Object[][] {
                {"   3  ,4.1,   5   16", new Cube(new Point3D(3, 4.1, 5), 16) },
                {"12 15 16 13", new Cube(new Point3D(12, 15, 16), 13)},
                {"-15 -13 -12 13", new Cube(new Point3D(-15, -13, -12), 13)},
                {"13,14,12,12", new Cube(new Point3D(13, 14, 12), 12)},
                {"12 ; 12 ; 12; 12", new Cube(new Point3D(12, 12, 12), 12)},
                {"-13,-15;-16;1", new Cube(new Point3D(-13, -15, -16), 1)}
        };
    }

    @Test(dataProvider = "dataCreateCube")
    public void createCubeTest(String s, Cube expectedCube) {
        Cube resultCube = stringShapeCreator.createCube(s);
        Assert.assertEquals(resultCube, expectedCube);
    }

    @DataProvider(name = "dataCreatePoint3D")
    public static Object[][] dataCreatePoint3D() {
        return new Object[][] {
                {"13, 15.1, 123.6", new Point3D(13, 15.1, 123.6)},
                {"12, 15, 12", new Point3D(12, 15, 12)},
                {"12 15 16", new Point3D(12, 15, 16)},
                {"12, -15 16", new Point3D(12, -15, 16)},
                {"12 15, 16", new Point3D(12, 15, 16)},
                {"1,2,3", new Point3D(1, 2, 3)},
                {"1  ,   2 ,  3  ", new Point3D(1, 2, 3)},
                {"1;15;13;", new Point3D(1, 15, 13)},
                {"  -1,   -5   ; -6;", new Point3D(-1, -5, -6)},
                {"-5,-6,-7", new Point3D(-5, -6, -7)},
                {"-1 -2 -3", new Point3D(-1, -2, -3)}
        };
    }

    @Test(dataProvider = "dataCreatePoint3D")
    public void createPoint3DTest(String s, Point3D expected) {
        Point3D resultPoint3D = stringShapeCreator.createPoint3D(s);
        Assert.assertEquals(resultPoint3D, expected);
    }
}
