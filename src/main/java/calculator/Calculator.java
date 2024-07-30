package calculator;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator<T extends Number> {
    //저는 static은 싫어욧
    protected final Queue<T> circleQueue = new LinkedList<>();
    protected final Queue<T> arithmeticQueue = new LinkedList<>();

    protected OperatorInterface operator;

    public Queue<T> getCircleQueue() {
        return circleQueue;
    }
    public Queue<T> getArithmeticQueue() {
        return arithmeticQueue;
    }

    public T deQueue(int mode) {
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
