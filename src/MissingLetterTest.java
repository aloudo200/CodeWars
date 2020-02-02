import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MissingLetterTest {

    @Test
    public void exampleTests() {
        assertEquals('e', MissingLetter.findMissingLetter(new char[] { 'a','b','c','d','f' }));
        assertEquals('P', MissingLetter.findMissingLetter(new char[] { 'O','Q','R','S' }));
    }
}

