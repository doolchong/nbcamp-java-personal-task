package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성
        int[] resultNumbers = new int[10];
        //연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언
        int index = 0;

        //반복문 사용 해서 연산을 반복
        while (true) {
            int result = 0;

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            //switch문을 활용하여 사칙연산 기호에 맞는 연산 구현
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
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        result = num1 / num2;
                    }
            }

            System.out.println("결과: " + result);
            //연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장
            if (index >= resultNumbers.length) {
                for (int i = 1; i < resultNumbers.length; i++) {
                    resultNumbers[i - 1] = resultNumbers[i];
                }
                index--;
            }
            //연산의 결과를 배열에 저장
            resultNumbers[index] = result;
            //index를 증가
            index++;

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            //exit을 입력 받으면 반복 종료
            String end = scanner.next();
            if (end.equals("exit")) {
                break;
            }
        }
    }
}
