package calculator;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> extends Calculator {
    public T calculate(T num1, T num2, OperatorType operator) throws BadInputException {
        T result;

        // 0으로 나누려 하는 경우
        if (operator.equals(OperatorType.DIVIDE) && num2.doubleValue() == 0) {
            throw new BadInputException("0으로 나눌 수 없습니다.");
        }

        this.operator = operator.getOperator();

        result = (T) this.operator.operate(num1, num2);

        // 연산의 결과를 Queue에 저장
        this.arithmeticQueue.add(result);

        return result;
    }

    public List<T> printResultsGreaterThan(double threshold) {
        // 입력값보다 큰 결과만 필터링
        return (List<T>) arithmeticQueue.stream().filter(result -> Double.parseDouble(result.toString())> threshold).collect(Collectors.toList());
        //result가 제네릭 타입이라 그런지 비교 연산자 '>'를 사용할 수 없어 result를 문자열로 바꾸고 그것을 다시 double형으로 형변환해서 비교 
    }


    public void setOperator(OperatorInterface operator) {
        this.operator = operator;
    }
}
