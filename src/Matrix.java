import resources.Neo;

/*  Help Neo to escape the matrix by throwing himself out!

    Neo is an exception, which is defined already in the Neo class

    The example test is the same one as the real test case, so if your code pass the example test case, you are good to go!

    Hint: although Neo is an exception, there is nothing special about it, the solution is pretty generic. */

public class Matrix {

    public static <T extends Exception> void enter() throws T {

        throw (T) new Neo();

    }
}