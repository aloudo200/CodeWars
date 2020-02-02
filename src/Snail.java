import java.util.*;
import java.util.stream.Collectors;

public class Snail {

    public static int[] snail(int[][] array) {

        List<String> output = new ArrayList<>();
        List<List<Integer>> values = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            List<Integer> line = Arrays.stream(array[i]).boxed().collect(Collectors.toList());
            values.add(line);
        }

        if (array[0].length != 0) {

            while (values.size() >= 1) {

                //right

                for (int i = 0; i < values.size(); i++) {

                    output.add(values.get(0).get(i) + "");
                }
                values.remove(0);

                //down

                for (int j = 0; j < values.size(); j++) {

                    output.add(values.get(j).get(values.get(j).size() - 1) + "");
                    values.get(j).remove(values.get(j).size() - 1);
                }
                //left

                for (int k = values.size() - 1; k >= 0; k--) {
                    output.add(values.get(values.size() - 1).get(k) + "");
                }
                if (values.size() > 0) {
                    values.remove(values.size() - 1);
                }

                //up

                for (int m = values.size() - 1; m >= 0; m--) {
                    output.add(values.get(m).get(0) + "");
                    values.get(m).remove(0);
                }
            }

            return Arrays.stream(output.toArray()).mapToInt(s -> Integer.parseInt((String) s)).toArray();
        }
        else {
            return new int[0];
        }

    }
}