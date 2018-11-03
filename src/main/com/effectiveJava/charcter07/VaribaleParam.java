package main.com.effectiveJava.charcter07;

/**
 * Created by chenbin on 2018\11\3 0003.
 */
public class VaribaleParam {
    static int sum(int ... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    static int min(int fistArg, int ... remainingArgs) {
        int min = fistArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }
}
