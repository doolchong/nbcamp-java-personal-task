package calculator;

public class SubtractOperator implements OperatorInterface {
    @Override
    public int operate(int num1, int num2) {
        return num1 - num2;
    }
}
