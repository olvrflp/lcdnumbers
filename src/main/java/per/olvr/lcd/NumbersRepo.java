package per.olvr.lcd;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that holds all the primary {@link LCDNumber}.
 *
 * @author OlvrFlp
 */
public class NumbersRepo
{
    private Map<Integer, LCDNumber> numberMasksCollection;

    /**
     * Class constructor.
     */
    public NumbersRepo()
    {
        numberMasksCollection = new HashMap<>();
        initialize();
    }

    private void initialize()
    {
        Boolean[][] one =
            {
                {false, false, false},
                {false, false, true},
                {false, false, false},
                {false, false, true},
                {false, false, false}
            };
        numberMasksCollection.put(1, new LCDNumber(one));

        Boolean[][] two =
            {
                {false, true, false},
                {false, false, true},
                {false, true, false},
                {true, false, false},
                {false, true, false}
            };
        numberMasksCollection.put(2, new LCDNumber(two));

        Boolean[][] three =
            {
                {false, true, false},
                {false, false, true},
                {false, true, false},
                {false, false, true},
                {false, true, false}
            };
        numberMasksCollection.put(3, new LCDNumber(three));

        Boolean[][] four =
            {
                {false, false, false},
                {true, false, true},
                {false, true, false},
                {false, false, true},
                {false, false, false}
            };
        numberMasksCollection.put(4, new LCDNumber(four));

        Boolean[][] five =
            {
                {false, true, false},
                {true, false, false},
                {false, true, false},
                {false, false, true},
                {false, true, false}
            };
        numberMasksCollection.put(5, new LCDNumber(five));

        Boolean[][] six =
            {
                {false, true, false},
                {true, false, false},
                {false, true, false},
                {true, false, true},
                {false, true, false}
            };
        numberMasksCollection.put(6, new LCDNumber(six));

        Boolean[][] seven =
            {
                {false, true, false},
                {false, false, true},
                {false, false, false},
                {false, false, true},
                {false, false, false}
            };
        numberMasksCollection.put(7, new LCDNumber(seven));

        Boolean[][] eight =
            {
                {false, true, false},
                {true, false, true},
                {false, true, false},
                {true, false, true},
                {false, true, false}
            };
        numberMasksCollection.put(8, new LCDNumber(eight));

        Boolean[][] nine =
            {
                {false, true, false},
                {true, false, true},
                {false, true, false},
                {false, false, true},
                {false, true, false}
            };
        numberMasksCollection.put(9, new LCDNumber(nine));

        Boolean[][] zero =
            {
                {false, true, false},
                {true, false, true},
                {false, false, false},
                {true, false, true},
                {false, true, false}
            };
        numberMasksCollection.put(0, new LCDNumber(zero));
    }

    /**
     * Returns the {@link LCDNumber} corresponding to the provided number.
     *
     * @param number the digit for which retrieve the {@link LCDNumber} representation.
     * @return the {@link LCDNumber} stored for the given digit.
     */
    public LCDNumber getNumberMatrix(final int number)
    {
        return numberMasksCollection.get(number);
    }
}
