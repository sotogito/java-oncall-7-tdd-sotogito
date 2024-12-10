package oncall.domain.parser;

import java.util.ArrayList;
import java.util.List;
import oncall.dto.WeekdayStaffsDto;
import oncall.dto.WeekendStaffsDto;

public class StaffParser {

    public static WeekdayStaffsDto parseWeekday(String input){
        return new WeekdayStaffsDto(parse(input));
    }

    public static WeekendStaffsDto parseWeekend(String input){
        return new WeekendStaffsDto(parse(input));
    }

    private static List<String> parse(String input){
        List<String> result = new ArrayList<>();
        input = input.trim();

        String[] split = input.split(",");

        for (String s : split) {
            result.add(s.trim());
        }
        return result;
    }

}
