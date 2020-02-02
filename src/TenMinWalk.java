
/*  You live in the city of Cartesia where all roads are laid out in a perfect grid.
    You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk.
    The city provides its citizens with a Walk Generating App on their phones --
    everytime you press the button it sends you an array of one-letter strings representing directions to walk
    (eg. ['n', 's', 'w', 'e']). You always walk only a single block in a direction and you know it takes you
    one minute to traverse one city block, so create a function that will return true if the walk the app gives you will
    take you exactly ten minutes (you don't want to be early or late!) and will, of course, return you to your starting point.

    Return false otherwise.
 */

public class TenMinWalk {
    public static boolean isValid(char[] walk) {

        //establish simple 2d coordinates

        int x = 0;
        int y = 0;


        //north and south will be along the Y axis
        //east and west are along the X axis

        for (char direction : walk) {
            if (direction == "n".charAt(0)) {
                y++; //moving up along the Y axis from origin
            } else if (direction == "e".charAt(0)) {
                x++; //moving right along the X axis from origin
            } else if (direction == "s".charAt(0)) {
                y--; //moving down along the Y axis from origin
            } else if (direction == "w".charAt(0)) {
                x--; //moving left along the X axis from origin
            }
        }

        if (walk.length == 10 && x + y == 0) {
            return true;
        } else {
            return false;
        }
    }
}