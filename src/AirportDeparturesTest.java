import org.junit.Test;
import static org.junit.Assert.*;

public class AirportDeparturesTest {

    private String[] BEFORE(String[] a) {
        System.out.println("Before: " + a[0]);
        return (a);
    }

    private String[] AFTER(String[] a) {
        System.out.println("After: " + a[0]);
        return (a);
    }

    @Test
    public void example() {
        // CAT => DOG
        String[] before = BEFORE(new String[]{"CAT"});
        int[][] rotors = new int[][]{{1,13,27}};
        String[] after = AFTER(AirportDepartures.flapDisplay(before,rotors));
        String[] expected = new String[]{"DOG"};
        assertArrayEquals(expected, after);
    }

    @Test
    public void basic() {
        // HELLO => WORLD!
        String[] before = BEFORE(new String[]{"HELLO "});
        int[][] rotors = new int[][]{{15,49,50,48,43,13}};
        String[] after = AFTER(AirportDepartures.flapDisplay(before,rotors));
        String[] expected = new String[]{"WORLD!"};
        assertArrayEquals(expected, after);

        // CODE => WARS
        String[] before2 = BEFORE(new String[]{"CODE"});
        int[][] rotors2 = new int[][]{{20,20,28,0}};
        String[] after2 = AFTER(AirportDepartures.flapDisplay(before2,rotors2));
        String[] expected2 = new String[]{"WARS"};
        assertArrayEquals(expected2, after2);
    }

}
