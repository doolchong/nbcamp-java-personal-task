package calculator;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator {
    //저는 static은 싫어욧
    protected final Queue<Double> circleQueue = new LinkedList<>();
    protected final Queue<Double> arithmeticQueue = new LinkedList<>();

    protected OperatorInterface operator;

    public Queue<Double> getCircleQueue() {
        return circleQueue;
    }

    public Queue<Double> getArithmeticQueue() {
        return arithmeticQueue;
    }

    public double deQueue(int mode) {
        return switch (mode) {
            case 0 -> this.arithmeticQueue.poll();
            default -> this.circleQueue.poll();
        };
    }

    public String inquiry(int mode) {
        return switch (mode) {
            case 0 -> this.arithmeticQueue.toString();
            default -> this.circleQueue.toString();
        };
    }
}
