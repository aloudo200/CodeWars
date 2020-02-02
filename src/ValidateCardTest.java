import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ValidateCardTest{
    @Test
    public void test891(){
        assertEquals(false, ValidateCard.validate("891"));
    }
}