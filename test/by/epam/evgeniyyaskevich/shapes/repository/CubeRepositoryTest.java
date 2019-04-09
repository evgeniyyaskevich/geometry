package by.epam.evgeniyyaskevich.shapes.repository;

import by.epam.evgeniyyaskevich.shapes.comparator.CubeComparator;
import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;
import by.epam.evgeniyyaskevich.shapes.specification.CubeSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CubeRepositoryTest {

    private CubeRepository cubeRepository = new CubeRepository();
    private Cube cube, cubeTwo, cubeThree, cubeFour;

    @BeforeClass
    public void setUp() {
        cube = new Cube(new Point3D(1, 2, 3), 3);
        cubeTwo = new Cube(new Point3D(4, 5, 6), 7);
        cubeThree = new Cube(new Point3D(15, -3, 1), 12);
        cubeFour = new Cube(new Point3D(-5, 3, 15), 5.3);
        cubeRepository.add(cube);
        cubeRepository.add(cubeTwo);
        cubeRepository.add(cubeThree);
        cubeRepository.add(cubeFour);
    }

    @Test
    public void searchGroup() {
        List<Cube> result = cubeRepository.searchGroup(cube -> cube.getLength() < 10);

        List<Cube> expectedResult = Arrays.asList(cube, cubeTwo, cubeFour);

        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void searchFirst() {
        Cube result = cubeRepository.searchFirst(cube -> cube.getLength() > 10);

        Assert.assertEquals(result, cubeThree);
    }

    @Test
    public void searchGroupByBelongingToFirstQuadrant() {
        CubeSpecification cubeSpecification = CubeSpecification.getInstance();

        List<Cube> result = cubeRepository.searchGroup(cubeSpecification::belongsToFirstQuadrant);

        List<Cube> expected = Arrays.asList(cube, cubeTwo);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void sort() {
        cubeRepository.sort((cubeLeft, cubeRight) -> (-1) * Integer.compare(cubeLeft.getId(), cubeRight.getId()));
        List<Cube> result = cubeRepository.getListOfMembers();

        List<Cube> expectedResult = Arrays.asList(cubeFour, cubeThree, cubeTwo, cube);

        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void sortById() {
        CubeComparator cubeComparator = CubeComparator.getInstance();
        CubeRepository cubeRepository = new CubeRepository();
        Cube cube = new Cube(new Point3D(1, 2, 3), 5);
        Cube cubeTwo = new Cube(new Point3D(3, 2, 1), 10);
        cubeRepository.add(cubeTwo);
        cubeRepository.add(cube);

        cubeRepository.sort(cubeComparator::compareById);
        List<Cube> result = cubeRepository.getListOfMembers();

        List<Cube> expected = Arrays.asList(cube, cubeTwo);


        Assert.assertEquals(result, expected);
    }
}