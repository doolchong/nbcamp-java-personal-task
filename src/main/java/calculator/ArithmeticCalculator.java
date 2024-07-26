package calculator;

import java.util.regex.Pattern;

public class ArithmeticCalculator extends Calculator {
    private static final String OPERATION_REG = "[+\\-*/%]";
    //가장 먼저 저장된 연산 결과부터 삭제해야 하므로 Queue에 저장

    public double calculate(int num1, int num2, char operator) throws BadInputException {
        double result = 0;

        //연산자의 입력이 잘못된 경우
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operator))) {
            throw new BadInputException("올바른 연산자를 입력해주세요.");
        }
        //0으로 나누려 하는 경우
        if (operator == '/' && num2 == 0) {
            throw new BadInputException("0으로 나눌 수 없습니다.");
        }

        //연산자에 따른 사칙연산 구현
        switch (operator) {
            case '+':
                this.operator = OperatorType.ADD.getOperator();
                break;
            case '-':
                this.operator = OperatorType.SUBTRACT.getOperator();
                break;
            case '*':
                this.operator = OperatorType.MULTIPLY.getOperator();
                break;
            case '/':
                this.operator = OperatorType.DIVIDE.getOperator();
                break;
            case '%':
                this.operator = OperatorType.MODULO.getOperator();
                break;
        }

        result = this.operator.operate(num1, num2);

        //연산의 결과를 Queue에 저장
        this.arithmeticQueue.add(result);

        return result;
    }

    public void setOperator(OperatorInterface operator) {
        this.operator = operator;
    }
}
