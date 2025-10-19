package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        List<Integer> numbers = parseToNumbers(input);
        validateAllPositive(numbers);
        int result = calculateSum(numbers);

        System.out.println("결과 : " + result);
    }

    private static List<Integer> parseToNumbers(String input) {
        String data = input;
        String delimiter = ",|:";

        Pattern customDelimeterPattern = Pattern.compile("^//(?<customDelimiter>.)\\\\n(?<data>.*)");
        Matcher matcher = customDelimeterPattern.matcher(input);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group("customDelimiter"));
            data = matcher.group("data");
        }

        String[] tokensSplitByDelimiter = data.split(delimiter);
        return convertToNumbers(tokensSplitByDelimiter);
    }

    private static List<Integer> convertToNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for(String token : tokens) {
            if (token.equals("")) continue;
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("혀용된 구분자와 양수 외에 잘못된 문자가 섞여 있습니다.", e);
            }
        }
        return numbers;
    }

    private static void validateAllPositive(List<Integer> numbers) {
        for (int num : numbers) {
            if (num <= 0) throw new IllegalArgumentException("0과 음수는 허용되지 않습니다.");
        }
    }

    private static int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
