package by.epam.evgeniyyaskevich.shapes.creator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import by.epam.evgeniyyaskevich.shapes.exception.IncorrectInputFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileListShapeCreatorTest {

    private static FileListShapeCreator fileListShapeCreator;

    @BeforeClass
    public static void setUp() {
        fileListShapeCreator = FileListShapeCreator.getInstance();
    }

    @DataProvider(name = "dataFileListShapeCreator")
    public Object[][] dataGetListOfCubesTest() {
        return new Object[][] {
                {new File(".\\files\\tests\\inputForListShapesCreatorFromFile.txt"),
                        Arrays.asList(new Cube(new Point3D(1, 1, 1), 1),
                                new Cube(new Point3D(0.0, 5.1, 15), 2.3),
                                new Cube(new Point3D(13.1, 15, 14), 20),
                                new Cube(new Point3D(3,4.1, 5), 16),
                                new Cube(new Point3D(0, 0, 0), 13)) }
        };
    }

    @Test(dataProvider = "dataFileListShapeCreator")
    public void getListOfCubes(File file, List<Cube> expected) throws IncorrectInputFileException {
        List<Cube> result = fileListShapeCreator.getListOfCubes(file.getPath());
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = IncorrectInputFileException.class)
    public void getListOfCubes() throws IncorrectInputFileException {

        File file = new File("NotExistingFile.txt");
        fileListShapeCreator.getListOfCubes(file.getPath());
    }
}
