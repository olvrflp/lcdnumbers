package per.olvr.inputreader;


import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link InputFileLoader}.
 *
 * @author OlvrFlp.
 */
public class InputFileLoaderTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private InputFileLoader testInstance;
    private File file;
    private final String fileName = "testFile.txt";

    private void createFileFromString(final String fileContent) throws IOException
    {
        file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        writer.write(fileContent);
        writer.flush();
        writer.close();
    }

    @After
    public void tearDown()
    {
        if (file != null)
        {
            file.delete();
        }
    }

    @Test
    public void testFileLoader() throws IOException
    {
        String fileContent = "1,123";
        createFileFromString(fileContent);
        testInstance = new InputFileLoader(fileName);
        assertEquals(
            "The extracted size is not correct. ",
            1,
            testInstance.getLines().get(0).getSize());
        assertEquals(
            "The extracted number is not correct. ",
            "123",
            testInstance.getLines().get(0).getNumber());
    }

    @Test
    public void testFileLoaderWithAdditionalData() throws IOException
    {
        String fileContent = "1,123,abc";
        createFileFromString(fileContent);
        testInstance = new InputFileLoader(fileName);
        assertEquals(
            "The extracted size is not correct. ",
            1,
            testInstance.getLines().get(0).getSize());
        assertEquals(
            "The extracted number is not correct. ",
            "123",
            testInstance.getLines().get(0).getNumber());
    }

    @Test
    public void testFileLoaderWithNotNumericSize() throws IOException
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(InputFileLoader.INVALID_SIZE_VALUE);
        String fileContent = "a,123";
        createFileFromString(fileContent);
        testInstance = new InputFileLoader(fileName);
    }

    @Test
    public void testFileLoaderWithInvalidSize() throws IOException
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(InputFileLoader.INVALID_SIZE_VALUE);
        String fileContent = "11,123";
        createFileFromString(fileContent);
        testInstance = new InputFileLoader(fileName);
    }

    @Test
    public void testFileLoaderWithInvalidNumberPart() throws IOException
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(InputFileLoader.INVALID_NUMBER_VALUE);
        String fileContent = "2,abc";
        createFileFromString(fileContent);
        testInstance = new InputFileLoader(fileName);
    }

}