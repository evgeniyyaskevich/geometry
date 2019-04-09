package by.epam.evgeniyyaskevich.shapes.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShapeStringValidator {

    private static final Logger LOGGER = LogManager.getLogger(ShapeStringValidator.class);
    private static final ShapeStringValidator INSTANCE = new ShapeStringValidator();

    private static final String REG_EXPR_FOR_CUBE = "^\\s*[-]?\\d+[.]?\\d*\\s*([,;]|\\s)\\s*"
            + "(\\s*[-]?[0-9]+[.]?[0-9]*\\s*([,;]|\\s)\\s*){2}"
            + "\\s*([1-9]\\d*[.]?[0-9]*|[0][.][0-9]+)\\s*[;]?$";

    private static final String REG_EXPR_FOR_POINT = "^\\s*[-]?\\d+[.]?\\d*\\s*([,;]|\\s)\\s*"
            + "\\s*[-]?\\d+[.]?\\d*\\s*([,;]|\\s)\\s*"
            + "\\s*[-]?\\d+[.]?\\d*\\s*[;]?$";


    public static ShapeStringValidator getInstance() {
        return INSTANCE;
    }

    public boolean isValidForCube(String s) {
        LOGGER.trace("CubeValidation");

        Pattern pattern =
                Pattern.compile(REG_EXPR_FOR_CUBE);
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

    public boolean isValidForPoint(String s) {
        LOGGER.trace("PointValidation");

        Pattern pattern =
                Pattern.compile(REG_EXPR_FOR_POINT);
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

}
