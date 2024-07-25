package calculator;

public class CircleCalculator extends Calculator {
    //원주율을 상수로서 활용
    private static final double PI = 3.14159;

    public double calculate(int radius) {
        circleQueue.add(radius * radius * PI);
        return radius * radius * PI;
    }

}
