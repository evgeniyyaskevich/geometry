package by.epam.evgeniyyaskevich.shapes.validation;


import org.testng.Assert;
import org.testng.annotations.Test;


public class ShapeStringValidatorTest {

    private ShapeStringValidator shapeStringValidator = ShapeStringValidator.getInstance();

    @Test (dataProvider = "dataValidateStringForCube", dataProviderClass = ShapesStringValidatorTestData.class)
    public void isValidForCube(String s, boolean expected) {
        boolean result = shapeStringValidator.isValidForCube(s);
        Assert.assertEquals(result, expected);
    }


    @Test(dataProvider = "dataValidateStringForPoint", dataProviderClass = ShapesStringValidatorTestData.class)
    public void isValidForPoint(String s, boolean expected) {
        boolean result = shapeStringValidator.isValidForPoint(s);
        Assert.assertEquals(result, expected);
    }
}
