package calculator;

public enum OperatorType {
    ADD(new AddOperator()),
    SUBTRACT(new SubtractOperator()),
    MULTIPLY(new MultiplyOperator()),
    DIVIDE(new DivideOperator()),
    MODULO(new ModOperator());

    private final OperatorInterface operator;

    OperatorType(OperatorInterface operator) {
        this.operator = operator;
    }

    public OperatorInterface getOperator() {
        return operator;
    }
}
