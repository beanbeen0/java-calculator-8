package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해주세요.");

        String input = sc.nextLine();

        int result = 0;

        String[] tokens = input.split(",|:");

        for(String token : tokens) {
            if (token.equals("")) {
                continue;
            }
            result += Integer.parseInt(token);
        }

        System.out.println("결과 : " + result);
    }
}
