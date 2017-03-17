package per.olvr.inputreader;

import com.google.common.base.Preconditions;
import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads and validates the file containing the inputs (numbers and size).
 *
 * @author OlvrFlp.
 */
public class InputFileLoader
{
    static final String MISSING_DATA_ERROR =
        "The line \"%s\" does not contain the required information.";
    static final String INVALID_SIZE_VALUE = "The size value is not valid";
    static final String INVALID_NUMBER_VALUE = "The number part is not valid";
    private static final String INPUT_LINE_SEPARATOR = ",";

    @Getter
    private List<InputLine> lines;

    /**
     * Class Constructor.
     *
     * @param fileName the path of the file containing the inputs.
     */
    public InputFileLoader(final String fileName)
    {
        Preconditions.checkNotNull(fileName, "filename null");
        lines = new ArrayList<>();
        File inputFile = new File(fileName);
        loadFile(inputFile);
    }

    private void loadFile(final File inputFile)
    {
        try (
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (!line.isEmpty())
                {
                    lines.add(processLine(line));
                }
            }
        }
        catch (IOException e)
        {

        }
    }

    private InputLine processLine(final String line)
    {
        String[] parts = line.split(INPUT_LINE_SEPARATOR);

        if (parts.length < 2)
        {
            throw new IllegalArgumentException(
                String.format(MISSING_DATA_ERROR, line));
        }

        if (parts.length > 2)
        {
            System.out.println(String.format(
                "The line \"%s\" contains more parts than expected. " +
                    "Will try to use the first two parts only."
                , line));
        }

        int size;
        if (NumberUtils.isDigits(parts[0]))
        {
            size = Integer.parseInt(parts[0]);
            if (size < 0 || size > 10)
            {
                throw new IllegalArgumentException(INVALID_SIZE_VALUE);
            }
        }
        else
        {
            throw new IllegalArgumentException(INVALID_SIZE_VALUE);
        }

        if (!NumberUtils.isDigits(parts[1]))
        {
            throw new IllegalArgumentException(INVALID_NUMBER_VALUE);
        }

        return new InputLine(size, parts[1]);
    }
}
