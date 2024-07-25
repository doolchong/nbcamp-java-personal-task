package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Calculator {
    private static final String OPERATION_REG = "[+\\-*/]";
    //원주율을 상수로서 활용
    private static final double PI = 3.14159;

    //가장 먼저 저장된 연산 결과부터 삭제해야 하므로 Queue에 저장
    private Queue<Integer> a_results;
    private Queue<Double> c_results;

    public Calculator() {
        a_results = new LinkedList<>();
        c_results = new LinkedList<>();
    }

    //사칙연산 메서드
    public int calculate(int num1, int num2, char operator) throws BadInputException {
        //연산자의 입력이 잘못된 경우
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operator))) {
            throw new BadInputException("올바른 연산자를 입력해주세요.");
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
        a_results.add(result);

        return result;
    }

    public Queue<Integer> aGetter() {
        return a_results;
    }

    public void aSetter(Queue<Integer> queue) {
        this.a_results = queue;
    }

    public int a_remove() {
        return this.a_results.poll();
    }

    public String a_inquiry() {
        return this.a_results.toString();
    }

    //원의 넓이를 구하는 메서드
    public double calculateCircleArea(int radius) {
        c_results.add(radius * radius * PI);
        return radius * radius * PI;
    }

    public Queue<Double> cGetter() {
        return c_results;
    }

    public void cSetter(Queue<Double> queue) {
        this.c_results = queue;
    }

    public double c_remove() {
        return this.c_results.poll();
    }

    public String c_inquiry() {
        return this.c_results.toString();
    }
}
