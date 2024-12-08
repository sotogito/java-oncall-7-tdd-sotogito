package oncall.domain.parser;

import java.util.ArrayList;
import java.util.List;
import oncall.dto.WeekdayStaffsDto;
import oncall.dto.WeekendStaffsDto;

public class StaffParser {

    public static WeekdayStaffsDto parseWeekday(String input){
        List<String> result = new ArrayList<>();
        input = input.trim();

        String[] split = input.split(",");

        for (String s : split) {
            result.add(s.trim());
        }

        return new WeekdayStaffsDto(result);
    }

    public static WeekendStaffsDto parseWeekend(String input){
        List<String> result = new ArrayList<>();
        input = input.trim();

        String[] split = input.split(",");

        for (String s : split) {
            result.add(s.trim());
        }

        return new WeekendStaffsDto(result);
    }
}
