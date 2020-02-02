import java.util.List;
import java.util.ArrayList;


/* You are now to create a function that returns a Josephus permutation, taking as parameters the initial array/list of
   items to be permuted as if they were in a circle and counted out every k places until none remained.
   For example, with n=7 and k=3 josephus(7,3) should act this way:

    [1,2,3,4,5,6,7] - initial sequence
    [1,2,4,5,6,7] => 3 is counted out and goes into the result [3]
    [1,2,4,5,7] => 6 is counted out and goes into the result [3,6]
    [1,4,5,7] => 2 is counted out and goes into the result [3,6,2]
    [1,4,5] => 7 is counted out and goes into the result [3,6,2,7]
    [1,4] => 5 is counted out and goes into the result [3,6,2,7,5]
    [4] => 1 is counted out and goes into the result [3,6,2,7,5,1]
    [] => 4 is counted out and goes into the result [3,6,2,7,5,1,4]

    Final result should then be: josephus([1,2,3,4,5,6,7],3)==[3,6,2,7,5,1,4]

 */

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {

        List<T> mutable = items;
        List<T> result = new ArrayList<>();

        int adjust = 0;
        while (mutable.size() > 0) {
            adjust = (adjust + (k - 1)) % mutable.size();
            result.add(mutable.get(adjust));
            mutable.remove(adjust);

        }

        return result;
    }

}