package per.olvr.lcd;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link LCDScreenRenderer}
 *
 * @author OlvrFlp.
 */
public class LCDScreenRendererTest
{
    private NumbersRepo repo = new NumbersRepo();
    private LCDScreenRenderer testInstance;

    @Before
    public void setup()
    {
        testInstance = new LCDScreenRenderer();
    }

    @Test
    public void testRenderWithSize1andNumber8()
    {
        String expectedRender =
            " -  \n" +
            "| | \n" +
            " -  \n" +
            "| | \n" +
            " -  \n\n";
        String actualRender = testInstance.renderNumbers(
            Collections.singletonList(repo.getNumberMatrix(8)), 1);
        assertEquals(
            "The render is not the expected. ", expectedRender, actualRender);
    }

    @Test
    public void testRenderWithSize2andNumber7()
    {
        String expectedRender =
            " --  \n" +
            "   | \n" +
            "   | \n" +
            "     \n" +
            "   | \n" +
            "   | \n" +
            "     \n\n";
        String actualRender = testInstance.renderNumbers(
            Collections.singletonList(repo.getNumberMatrix(7)), 2);
        assertEquals(
            "The render is not the expected. ", expectedRender, actualRender);
    }
}