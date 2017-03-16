package per.olvr.lcd;

import java.util.List;

/**
 * This class performs the render of the numbers to an LCD screen representation.
 *
 * @author OlvrFlp
 */
public class LCDScreenRenderer
{
    private static final char HORIZONTAL_CHARACTER = '-';
    private static final char VERTICAL_CHARACTER = '|';
    private static final char SEPARATOR = ' ';

    /**
     * Produces a {@link String} that represents the information to render to the screen.
     *
     * @param numbers a {@link List<LCDNumber>} containing the numbers to render.
     * @param size the number size to be rendered.
     * @return a {@link String} representing the numbers render.
     */
    public String renderNumbers(final List<LCDNumber> numbers, final int size)
    {
        StringBuilder screen = new StringBuilder();
        int maskRowNumber = numbers.get(0).getLcdMatrixMask().length;
        for (int i = 0; i < maskRowNumber; i++)
        {
            if (i % 2 == 0)
            {
                renderLine(screen, numbers, size, i);
                screen.append("\n");
            }
            else
            {
                for (int j = 0; j < size; j++)
                {
                    renderLine(screen, numbers, size, i);
                    screen.append("\n");
                }
            }
        }
        screen.append("\n");
        return screen.toString();
    }

    private void renderLine(
        final StringBuilder builder, final List<LCDNumber> numbers, final int size, final int line)
    {
        for (LCDNumber number : numbers)
        {
            Boolean maskLine[] = number.getLcdMatrixMask()[line];
            renderNumberLine(builder, maskLine, size, line % 2 == 0);
        }
    }

    private void renderNumberLine(
        final StringBuilder builder,
        final Boolean[] numberRow,
        final int size,
        final boolean horizontal)
    {
        char charToPrint = horizontal ? HORIZONTAL_CHARACTER : VERTICAL_CHARACTER;
        for (int i = 0; i < numberRow.length; i++)
        {
            if (i % 2 == 0)
            {
                builder.append(numberRow[i] ? charToPrint : SEPARATOR);
            }
            else
            {
                for (int j = 0; j < size; j++)
                {
                    builder.append(numberRow[i] ? charToPrint : SEPARATOR);
                }
            }
        }
        builder.append(SEPARATOR);
    }
}
