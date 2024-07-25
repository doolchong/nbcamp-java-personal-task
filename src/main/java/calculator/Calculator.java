package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Calculator {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    //가장 먼저 저장된 연산 결과부터 삭제해야 하므로 Queue에 저장
    Queue<Integer> results = new LinkedList<>();

    public int calculate(int num1, int num2, char operator) throws BadInputException {
        //연산자의 입력이 잘못된 경우
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operator))) {
            throw new BadInputException("올바른 연산자를 입력해주세요.");
        }

        //두 양의 정수의 입력이 잘못된 경우
        if (!Pattern.matches(NUMBER_REG, String.valueOf(num1))) {
            throw new BadInputException("올바른 정수값을 입력해주세요.");
        }
        if (!Pattern.matches(NUMBER_REG, String.valueOf(num2))) {
            throw new BadInputException("올바른 정수값을 입력해주세요.");
        }
        int result = 0;

        //연산자에 따른 사칙연산 구현
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new BadInputException("0으로 나눌 수 없습니다.");
                } else {
                    result = num1 / num2;
                }
        }
        //연산의 결과를 Queue에 저장
        results.add(result);

        return result;
    }
}
