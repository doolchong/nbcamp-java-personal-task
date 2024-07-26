package calculator;

import java.util.regex.Pattern;

public class ArithmeticCalculator<T extends Number> extends Calculator {
    private static final String OPERATION_REG = "[+\\-*/%]";

    public T calculate(T num1, T num2, OperatorType operator) throws BadInputException {
        T result;

        // 0으로 나누려 하는 경우
        if (operator.equals(OperatorType.DIVIDE) && num2.doubleValue() == 0) {
            throw new BadInputException("0으로 나눌 수 없습니다.");
        }

        this.operator = operator.getOperator();

        result = (T) this.operator.operate(num1.doubleValue(), num2.doubleValue());

        // 연산의 결과를 Queue에 저장
        this.arithmeticQueue.add(result.doubleValue());

        return result;
    }

    public void setOperator(OperatorInterface operator) {
        this.operator = operator;
    }
}
