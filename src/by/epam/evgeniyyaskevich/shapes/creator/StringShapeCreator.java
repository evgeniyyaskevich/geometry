package by.epam.evgeniyyaskevich.shapes.creator;

import by.epam.evgeniyyaskevich.shapes.factory.ShapeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.entity.Point3D;

import java.util.StringTokenizer;

public class StringShapeCreator {

    private static final Logger LOGGER = LogManager.getLogger(StringShapeCreator.class);
    private static final StringShapeCreator INSTANCE = new StringShapeCreator();
    private static ShapeFactory shapeFactory = ShapeFactory.getInstance();


    public static StringShapeCreator getInstance() {
        return INSTANCE;
    }

    public Point3D createPoint3D(String s) {

            LOGGER.trace("Creating Point3D by string.");

            StringTokenizer tok = new StringTokenizer(s, ",; ");
            double x = Double.parseDouble(tok.nextToken());
            double y = Double.parseDouble(tok.nextToken());
            double z = Double.parseDouble(tok.nextToken());

            return shapeFactory.getPoint3D(x, y, z);
    }

    public Cube createCube(String s) {

            LOGGER.trace("Creating cube by string.");

            StringTokenizer tok = new StringTokenizer(s, ",; ");
            double x = Double.parseDouble(tok.nextToken());
            double y = Double.parseDouble(tok.nextToken());
            double z = Double.parseDouble(tok.nextToken());
            double cubeLength = Double.parseDouble(tok.nextToken());

            Point3D cubeCenter = shapeFactory.getPoint3D(x, y, z);

            return shapeFactory.getCube(cubeCenter, cubeLength);
    }

}
