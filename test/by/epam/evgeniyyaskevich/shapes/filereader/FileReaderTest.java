package by.epam.evgeniyyaskevich.shapes.filereader;

import by.epam.evgeniyyaskevich.shapes.exception.IncorrectInputFileException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class FileReaderTest {

    private FileReader fileReader;

    @DataProvider(name = "dataHasNextLine")
    public Object[][] dataHasNextLine() {
        return new Object[][] {
                { ".//files//tests//EmptyInputFile.txt", false},
                { ".//files//tests//NotEmptyInputFile.txt", true}
        };
    }

    @Test (testName = "HasNextLine", dataProvider = "dataHasNextLine")
    public void hasNextLine(String fileName, boolean expected) throws IncorrectInputFileException {

        fileReader = new FileReader(new File(fileName));

        boolean result = fileReader.hasNextLine();

        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = IncorrectInputFileException.class)
    public void fileReader() throws IncorrectInputFileException{
        fileReader = new FileReader(new File(".//files//NoFile.txt"));
    }


    @Test
    public void readLine() throws IncorrectInputFileException {
        fileReader = new FileReader(new File(".//files//tests//NotEmptyInputFile.txt"));

        String result = fileReader.readLine();

        Assert.assertEquals(result, "String for testing FileReader.");

    }
}