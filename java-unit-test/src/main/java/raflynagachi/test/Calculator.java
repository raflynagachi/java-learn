package raflynagachi.test;

public class Calculator {
    public Integer sum(Integer a, Integer b) {
        return a+b;
    }

    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divided by zero");
        }
        return a/b;
    }
}
