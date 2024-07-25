package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Calculator {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    Queue<Integer> results = new LinkedList<>();

    public void calculate(int num1, int num2, char operator) throws BadInputException {
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operator))) {
            throw new BadInputException("올바른 연산자를 입력해주세요.");
        }
        if (!Pattern.matches(NUMBER_REG, String.valueOf(num1))) {
            throw new BadInputException("올바른 정수값을 입력해주세요.");
        }
        if (!Pattern.matches(OPERATION_REG, String.valueOf(num2))) {
            throw new BadInputException("올바른 정수값을 입력해주세요.");
        }
        switch (operator) {
            case '+':
                results.add(num1 + num2);
                break;
            case '-':
                results.add(num1 - num2);
                break;
            case '*':
                results.add(num1 * num2);
                break;
            case '/':
                if (num2 == 0) {
                    throw new BadInputException("0으로 나눌 수 없습니다.");
                } else {
                    results.add(num1 / num2);
                }
        }
    }
}
