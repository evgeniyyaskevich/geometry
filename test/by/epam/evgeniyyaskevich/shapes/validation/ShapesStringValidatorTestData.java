package by.epam.evgeniyyaskevich.shapes.validation;

import org.testng.annotations.DataProvider;

public class ShapesStringValidatorTestData {

    @DataProvider(name = "dataValidateStringForCube")
    public static Object[][] dataValidateStringForCube() {
        return new Object[][] {
                {"      ", false},
                {"123", false},
                {"   123.123", false},
                {"   12.123   ", false},
                {"1.12,13", false},
                {"1.12,  12", false},
                {"13, 15", false},
                {"13, 15.1, 123.6", false},
                {"12, 15, 12", false},
                {"12 15 16", false},
                {"12, 15 16", false},
                {"12 15, 16", false},
                {"1,2,3", false},
                {"1  ,   2 ,  3  ", false},
                {"1a.12,a.b,12.13", false},
                {"1;15;13;", false},
                {"1a.12,a.b,12.13,15", false},
                {"     15       15        15     b", false},
                {"12 15 ; 16 -3", false},
                {"12,12,12;-12", false},
                {";;;15", false},
                {"Cube(1, 2, 3, 4)", false},
                {"12,13,14,0", false},
                {"   3  ,4.1,   5   16", true},
                {"12 15 16 13", true},
                {"-15 -13 -12 13", true},
                {"13,14,12,12", true},
                {"12 ; 12 ; 12; 12", true},
                {"-13,-15;-16;1", true},
                {"12 12 15.3 0.85", true},
                {"13, 123.2 0.123 0.1124", true},
                {"0.152, 0.23123; 0.412412, 0.41241241   ", true}
        };
    }

    @DataProvider(name = "dataValidateStringForPoint")
    public static Object[][] dataValidateStringForPoint() {
        return new Object[][]{
                {"      ", false},
                {"123", false},
                {"   123.123", false},
                {"   12.123   ", false},
                {"1.12,13", false},
                {"1.12,  12", false},
                {"13, 15", false},
                {"1a.12,a.b,12.13", false},
                {"13, 15.1, 123.6", true},
                {"12, 15, 12", true},
                {"12 15 16", true},
                {"12, -15 16", true},
                {"12 15, 16", true},
                {"1,2,3", true},
                {"1  ,   2 ,  3  ", true},
                {"1;15;13;", true},
                {"  -1,   -5   ; -6;", true},
                {"-5,-6,-7", true},
                {"-1 -2 -3", true}
        };
    }

}
