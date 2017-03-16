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
        int size = 2;
        List<LCDNumber> numbers = new ArrayList<>();
        numbers.add(repo.getNumberMatrix(1));
//        numbers.add(repo.getNumberMatrix(2));
//        numbers.add(repo.getNumberMatrix(3));
//        numbers.add(repo.getNumberMatrix(4));
//        numbers.add(repo.getNumberMatrix(5));
        LCDScreenRenderer renderer = new LCDScreenRenderer();
        System.out.println(renderer.renderNumbers(numbers, size));
        System.exit(0);
    }
}
