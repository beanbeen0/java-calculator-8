package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        String delimiter = ",|:";

        int result = 0;


        String[] tokens = data.split(delimiter);
        for(String token : tokens) {
            if (token.equals("")) continue;
            result += Integer.parseInt(token);
        }

        System.out.println("결과 : " + result);
    }
}
