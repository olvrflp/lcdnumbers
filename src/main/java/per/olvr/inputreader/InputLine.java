package per.olvr.inputreader;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents a line in the input file containing the size and the number to render.
 *
 * @author  OlvrFlp.
 */
@AllArgsConstructor
public class InputLine
{
    @Getter
    final int size;

    @Getter
    final String number;
}
