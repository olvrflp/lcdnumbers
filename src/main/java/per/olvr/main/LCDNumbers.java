package per.olvr.main;

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
    public static void main(String args[])
    {
        NumbersRepo repo = new NumbersRepo();
        int size = 3;
        List<LCDNumber> numbers = new ArrayList<>();
        numbers.add(repo.getNumberMatrix(6));
        numbers.add(repo.getNumberMatrix(7));
        numbers.add(repo.getNumberMatrix(8));
        numbers.add(repo.getNumberMatrix(9));
        numbers.add(repo.getNumberMatrix(0));
        LCDScreenRenderer renderer = new LCDScreenRenderer();
        System.out.println(renderer.renderNumbers(numbers, size));
        System.exit(0);
    }
}
