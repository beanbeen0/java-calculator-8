package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
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

        // 구분자 기준으로 토큰 분리
        String[] tokens = data.split(delimiter);

        //정수화
        List<Integer> numbers = new ArrayList<>();
        for(String token : tokens) {
            if (token.equals("")) continue;
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("혀용된 구분자와 양수 외에 잘못된 문자가 섞여 있습니다.", e);
            }
        }

        //양수 검증
        for (int num : numbers) {
            if (num <= 0) throw new IllegalArgumentException();
        }

        //덧셈
        int result = 0;
        for(int num : numbers) {
            result += num;
        }

        //결과 출력
        System.out.println("결과 : " + result);
    }
}
