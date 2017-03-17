package per.olvr.main;

import com.google.common.base.Preconditions;
import per.olvr.inputreader.InputFileLoader;
import per.olvr.inputreader.InputLine;
import per.olvr.lcd.LCDNumber;
import per.olvr.lcd.LCDScreenRenderer;
import per.olvr.lcd.NumbersRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class.
 *
 * @author OlvrFlp.
 */
public class LCDNumbers
{
    private final InputFileLoader fileLoader;
    private final NumbersRepo repo;
    private final LCDScreenRenderer screenRenderer;

    /**
     * Main method.
     *
     * @param args arguments provided.
     */
    public static void main(String args[])
    {
        Preconditions.checkArgument(args.length > 0, "Must provide a filename.");
        Preconditions.checkNotNull(args[0], "file name not provided.");
        Preconditions.checkArgument(
            !args[0].trim().isEmpty(), "File name cannot be empty.");
        LCDNumbers lcdNumbers = new LCDNumbers(args[0]);
        lcdNumbers.renderInput();
        System.exit(0);
    }

    private LCDNumbers(final String fileName)
    {
        fileLoader = new InputFileLoader(fileName);
        repo = new NumbersRepo();
        screenRenderer = new LCDScreenRenderer();
    }

    /**
     * Class constructor used for mock injection.
     *
     * @param fileLoader an {@link InputFileLoader} mock.
     * @param repo a {@link NumbersRepo} mock.
     * @param screen a {@link LCDScreenRenderer} mock.
     */
    LCDNumbers(
        final InputFileLoader fileLoader,
        final NumbersRepo repo,
        final LCDScreenRenderer screen)
    {
        this.fileLoader = fileLoader;
        this.repo = repo;
        this.screenRenderer = screen;
    }

    /**
     * Renders the numbers provided in the input file.
     */
    void renderInput()
    {
        List<InputLine> lines = fileLoader.getLines();
        for (InputLine line: lines)
        {
            if (line.getSize() == 0)
            {
                return;
            }
            System.out.println(screenRenderer.renderNumbers(
                getLCDNumbersFromInput(line.getNumber()), line.getSize()));
        }
    }

    private List<LCDNumber> getLCDNumbersFromInput(final String numbers)
    {
        List<LCDNumber> numberList = new ArrayList<>();
        for (char number: numbers.toCharArray())
        {
            numberList.add(repo.getNumberMatrix(
                Integer.parseInt(String.valueOf(number))));
        }
        return numberList;
    }
}
