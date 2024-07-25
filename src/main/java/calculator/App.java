package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        //반복문 사용 해서 연산을 반복
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            //예외 처리용
            try {
                System.out.println("결과: " + calculator.calculate(num1, num2, operator));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //remove 입력 시 가장 먼저 저장된 연산 결과를 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = scanner.next();
            if (remove.equals("remove")) {
                System.out.println(calculator.results.poll() + "(이)가 삭제되었습니다.");
            }

            //inquiry 입력 시 저장된 연산 결과 전부를 출력
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = scanner.next();
            if (inquiry.equals("inquiry")) {
                System.out.println(calculator.results.toString());
            }

            //exit을 입력 받으면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = scanner.next();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}
