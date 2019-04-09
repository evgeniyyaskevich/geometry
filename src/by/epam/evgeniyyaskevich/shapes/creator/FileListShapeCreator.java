package by.epam.evgeniyyaskevich.shapes.creator;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import by.epam.evgeniyyaskevich.shapes.exception.IncorrectInputFileException;
import by.epam.evgeniyyaskevich.shapes.filereader.FileReader;
import by.epam.evgeniyyaskevich.shapes.validation.ShapeStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListShapeCreator {

    private static final Logger LOGGER = LogManager.getLogger(StringShapeCreator.class);
    private static final FileListShapeCreator INSTANCE = new FileListShapeCreator();
    private static StringShapeCreator stringShapeCreator = StringShapeCreator.getInstance();
    private static ShapeStringValidator shapeStringValidator = ShapeStringValidator.getInstance();


    public static FileListShapeCreator getInstance() {
        return INSTANCE;
    }

    public List<Cube> getListOfCubes(String fileName) throws IncorrectInputFileException {

        List<Cube> listCubes = new ArrayList<>();

        FileReader fileReader = new FileReader(new File(fileName));
        String currentLine;

        while (fileReader.hasNextLine()) {
            currentLine = fileReader.readLine();
            if (shapeStringValidator.isValidForCube(currentLine)) {
                listCubes.add(stringShapeCreator.createCube(currentLine));
            }
        }
        return listCubes;
    }
}
