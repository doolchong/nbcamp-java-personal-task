package calculator;

public class CircleCalculator<T extends Number> extends Calculator {
    //원주율을 상수로서 활용
    private static final double PI = 3.14159;

    public T calculate(T radius) {
        if (radius instanceof Integer) {
            circleQueue.add((Integer) radius * (Integer) radius * PI);
            return (T) (Double) ((Integer) radius * (Integer) radius * PI);
        } else {
            circleQueue.add((Double) radius.doubleValue() * (Double) radius.doubleValue() * PI);
            return (T) (Double) ((Double) radius.doubleValue() * (Double) radius.doubleValue() * PI);
        }
    }

}
