import java.util.Arrays;

/*  In this Kata, you will implement the Luhn Algorithm, which is used to help validate credit card numbers.

    Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.

    Here is the algorithm:

    Double every other digit, scanning from right to left, starting from the second digit (from the right).

    Another way to think about it is: if there are an even number of digits, double every other digit starting with the first;

    if there are an odd number of digits, double every other digit starting with the second

 */

public class ValidateCard {

    public static boolean validate(String n) {

        String[] digits = n.split("");
        int replace = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits.length % 2 == 0) {
                replace = i % 2 == 0 ? Integer.parseInt(digits[i]) * 2 : Integer.parseInt(digits[i]);
                replace = replace > 9 ? replace - 9 : replace;
                digits[i] = String.valueOf(replace);
            } else {
                replace = i % 2 == 0 ? Integer.parseInt(digits[i]) : Integer.parseInt(digits[i]) * 2;
                replace = replace > 9 ? replace - 9 : replace;
                digits[i] = String.valueOf(replace);
            }
        }

        int sum = Arrays.stream(digits).mapToInt(i -> Integer.parseInt(i)).sum();
        return (sum % 10 == 0);
    }
}


