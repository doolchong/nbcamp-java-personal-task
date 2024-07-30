package calculator;

public class ModOperator<T extends Number> implements OperatorInterface<T> {
    @Override
    public T operate(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) (Integer) (num1.intValue() % num2.intValue());
        } else {
            return (T) (Double) (num1.doubleValue() % num2.doubleValue());
        }
    }
}
