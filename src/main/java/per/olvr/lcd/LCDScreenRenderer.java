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
            for (LCDNumber number : numbers)
            {
                Boolean maskLine[] = number.getLcdMatrixMask()[i];
                if (i % 2 == 0)
                {
                    renderNumberLine(screen, maskLine, size, true);
                }
                else
                {
                    for (int j = 0; j < size; j++)
                    {
                        renderNumberLine(screen, maskLine, size, false);
                    }
                }
            }
            screen.append("\n");
        }
        screen.append("\n");
        return screen.toString();
    }

    private void renderNumberLine(
        final StringBuilder builder,
        final Boolean[] numberRow,
        final int size,
        final boolean horizontal)
    {
        for (int i = 0; i < numberRow.length; i++)
        {
            if (numberRow[i])
            {
                if (horizontal)
                {
                    for (int j = 0; j < size; j++)
                    {
                        builder.append(HORIZONTAL_CHARACTER);
                    }
                }
                else
                {
                    builder.append(VERTICAL_CHARACTER);
                }
            }
            else
            {
                builder.append(SEPARATOR);
            }
        }
        builder.append(SEPARATOR);
    }
}
