package per.olvr.lcd;

import lombok.Getter;

/**
 * Class that represent the LCD matrix for a number.
 *
 * @author OlvrFlp
 */
public class LCDNumber
{
    /**
     * Getter for the lcd matrix that represents this number instance.
     * @return a {@link Boolean[][]} representation of the lcd matrix.
     */
    @Getter
    private final Boolean[][] lcdMatrixMask;

    /**
     * Class constructor.
     *
     * @param lcdMatrix lcd matrix that represents this number.
     */
    public LCDNumber(final Boolean[][] lcdMatrix)
    {
        this.lcdMatrixMask = lcdMatrix;
    }
}
