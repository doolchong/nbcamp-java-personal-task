package calculator;

import java.util.regex.Pattern;

public class ArithmeticCalculator extends Calculator {
    private static final String OPERATION_REG = "[+\\-*/%]";
    //가장 먼저 저장된 연산 결과부터 삭제해야 하므로 Queue에 저장

    public double calculate(int num1, int num2, OperatorType operator) throws BadInputException {
        double result = 0;

        //0으로 나누려 하는 경우
        if (operator.equals(OperatorType.DIVIDE) && num2 == 0) {
            throw new BadInputException("0으로 나눌 수 없습니다.");
        }

        this.operator = operator.getOperator();

        result = this.operator.operate(num1, num2);

        //연산의 결과를 Queue에 저장
        this.arithmeticQueue.add(result);

        return result;
    }

    public void setOperator(OperatorInterface operator) {
        this.operator = operator;
    }
}
