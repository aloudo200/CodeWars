import java.util.*;

    /* How it works
        You notice that each flap character is on some kind of a rotor and the order of characters on each rotor is:

        ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+0123456789

        And after a long while you deduce that the display works like this:

        Starting from the left, all rotors (from the current one to the end of the line) flap together until the left-most rotor character is correct.
        Then the mechanism advances by 1 rotor to the right...
        ...REPEAT this rotor procedure until the whole line is updated
        ...REPEAT this line procedure from top to bottom until the whole display is updated */

class AirportDepartures {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {

        String output = "";
        ArrayList<String> outputArrayList = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();
            int max = Arrays.stream(rotors[i]).sum();

            for (int j = chars.length - 1; j >= 0; j--) {

                int spinToCharAt = 0;

                while (max + ALPHABET.indexOf(chars[j]) >= 54) {
                    max -= 54;
                }

                spinToCharAt = max + ALPHABET.indexOf(chars[j]);
                chars[j] = ALPHABET.charAt(spinToCharAt);

                rotors[i][j] = 0;

                max = Arrays.stream(rotors[i]).sum();
                output = chars[j] + output;
            }
            outputArrayList.add(output);
            output = "";
        }
        return outputArrayList.toArray((new String[outputArrayList.size()]));
    }


}