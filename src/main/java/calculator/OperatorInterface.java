package calculator;

public interface OperatorInterface<T extends Number> {
    public abstract T operate(T num1, T num2);
}