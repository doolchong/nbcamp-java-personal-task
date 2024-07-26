package calculator;

public class MultiplyOperator<T extends Number> implements OperatorInterface<T> {
    @Override
    public T operate(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) (Integer) ((Integer) num1 * (Integer) num2);
        } else {
            return (T) (Double) ((Double) num1.doubleValue() * (Double) num2.doubleValue());
        }
    }
}
