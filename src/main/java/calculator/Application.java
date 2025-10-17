package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {

        // 입력 받기
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        // 변수 초기화
        String data = input;
        String delimiter = ",|:";

        // 커스텀 지정자 지정 기능
        Pattern customDelimeterPattern = Pattern.compile("^//(?<customDelimiter>.)\\\\n(?<data>.*)");
        Matcher matcher = customDelimeterPattern.matcher(input);

        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group("customDelimiter"));
            data = matcher.group("data");
        }

        // 구분자 기준으로 토큰 분리 후 정수화 -> 덧셈
        int result = 0;
        String[] tokens = data.split(delimiter);
        for(String token : tokens) {
            if (token.equals("")) continue;
            int operand = Integer.parseInt(token);
            if (operand < 0) throw new IllegalArgumentException();
            result += operand;
        }

        //결과 출력
        System.out.println("결과 : " + result);
    }
}
