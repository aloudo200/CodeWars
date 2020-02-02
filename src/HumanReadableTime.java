
/*  Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

    HH = hours, padded to 2 digits, range: 00 - 99
    MM = minutes, padded to 2 digits, range: 00 - 59
    SS = seconds, padded to 2 digits, range: 00 - 59
    The maximum time never exceeds 359999 (99:59:59)

    You can find some examples in the test fixtures.

 */

public class HumanReadableTime {
    public static String makeReadable(int seconds) {

        int totalMinutes = seconds / 60;
        int totalHours =  totalMinutes / 60;
        double remainingSeconds = seconds;

        if(seconds >= 60) {
            Double tmp = (double) seconds / 60;

            Double secondsLeftOver = Double.parseDouble("0."
                    + tmp.toString().substring(tmp.toString().lastIndexOf(".") + 1));

            remainingSeconds = secondsLeftOver * 60 ;
        }

        String hh = String.format("%02d", totalHours);
        String mm =  String.format("%02d", totalMinutes % 60);
        String ss = String.format("%02.0f", remainingSeconds);

        return  hh + ":" + mm + ":" + ss;
    }
}