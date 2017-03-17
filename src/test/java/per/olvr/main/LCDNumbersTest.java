package per.olvr.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import per.olvr.inputreader.InputFileLoader;
import per.olvr.inputreader.InputLine;
import per.olvr.lcd.LCDScreenRenderer;
import per.olvr.lcd.NumbersRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Test class for {@link LCDNumbers}.
 *
 * @author OlvrFlp.
 */
public class LCDNumbersTest
{
    @Mock
    private LCDScreenRenderer screenRenderer;
    @Mock
    private InputFileLoader fileLoader;
    private NumbersRepo repo;
    private LCDNumbers testInstance;

    @Before
    public void setup()
    {
        initMocks(this);
        List<InputLine> lineList = new ArrayList<>();
        InputLine line1 = new InputLine(2, "2");
        InputLine line2 = new InputLine(0, "0");
        lineList.add(line1);
        lineList.add(line2);
        when(fileLoader.getLines()).thenReturn(lineList);

        repo = new NumbersRepo();
        testInstance = new LCDNumbers(fileLoader, repo, screenRenderer);
    }

    @Test
    public void testRenderInput()
    {
        testInstance.renderInput();
        verify(screenRenderer).renderNumbers(
            Collections.singletonList(repo.getNumberMatrix(2)), 2);
    }

}