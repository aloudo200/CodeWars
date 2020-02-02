import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

/* A common exercise, when you're learning a new language, is to make a guessing game.

    It's a great way to learn control structures, IO, the works.

    This is taking the guessing game to a whole new level. This time, you're the one playing the guessing game.

    And the guessing game is Math.random().

    The task is really simple. You make a guess, Math.random() does it's thing, and if you're right 5 times out of 5, you win!

    Don't guess the same thing every time.

    Hint: You guess first. */

public class Psychic {

    private static class Magic extends Random {
        @Override
        public double nextDouble() {
            return 0.5;
        }
    }

    public static Double guess() {
        try {

            Magic magicalNumber = new Magic();

            Class<?> clazz = Class.forName("java.lang.Math$RandomNumberGeneratorHolder");
            Field field = clazz.getDeclaredField("randomNumberGenerator");
            field.setAccessible(true);

            Field modifiers = Field.class.getDeclaredField("modifiers");

            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, magicalNumber);
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return Math.random();
    }
}