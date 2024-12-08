package oncall.domain.parser;

import oncall.dto.ScheduleDto;

public class ScheduleParser {
    public static ScheduleDto parse(String input){
        input = input.trim();

        String[] split = input.split(",");
        if(split.length != 2){
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        try{
            int month = Integer.parseInt(split[0].trim());
            String dayOfWeek = split[1].trim();

            return new ScheduleDto(month,dayOfWeek);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }

    }
}
