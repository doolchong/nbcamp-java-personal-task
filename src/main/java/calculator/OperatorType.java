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

    public static OperatorType contains(String operator) throws BadInputException {
        switch (operator){
            case "ADD":
                return ADD;
            case "SUBTRACT":
                return SUBTRACT;
            case "MULTIPLY":
                return MULTIPLY;
            case "DIVIDE":
                return DIVIDE;
            case "MODULO":
                return MODULO;
            default:
                throw new BadInputException("올바른 연산자를 입력해주세요.");
        }
    }

    public OperatorInterface getOperator() {
        return operator;
    }
}
