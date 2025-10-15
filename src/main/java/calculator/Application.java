package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        String data = input;
        String delimiter = ",|:";

        Pattern customDelimeterPattern = Pattern.compile("^//(?<customDelimiter>.)\\\\n(?<data>.*)");
        Matcher matcher = customDelimeterPattern.matcher(input);

        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group("customDelimiter"));
            data = matcher.group("data");
        }

        int result = 0;
        String[] tokens = data.split(delimiter);
        for(String token : tokens) {
            if (token.equals("")) continue;
            result += Integer.parseInt(token);
        }

        System.out.println("결과 : " + result);
    }
}
