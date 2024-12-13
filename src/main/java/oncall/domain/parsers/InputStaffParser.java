package oncall.domain.parsers;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.dto.InputWeekdayStaffsDto;
import oncall.domain.dto.InputWeekendStaffsDto;

public class InputStaffParser {

    public static InputWeekdayStaffsDto parseWeekday(String input) {
        return new InputWeekdayStaffsDto(parse(input));
    }

    public static InputWeekendStaffsDto parseWeekend(String input) {
        return new InputWeekendStaffsDto(parse(input));
    }

    private static List<String> parse(String input) {
        List<String> result = new ArrayList<>();

        input = input.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        String[] names = input.split(",");
        for (String name : names) {
            name = name.trim();
            result.add(name);
        }

        return result;
    }

}
