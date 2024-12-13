package oncall.domain.parsers;

import oncall.domain.dto.InputScheduleDto;

public class InputScheduleParser {

    public static InputScheduleDto parse(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        String[] split = input.split(",");
        if (split.length != 2) {
            throw new IllegalArgumentException("월, 시작 요일을 다시 입력해주세요.");
        }

        try {
            int month = Integer.parseInt(split[0]);
            String dayOfWeek = split[1];

            return new InputScheduleDto(month, dayOfWeek);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("월은 숫자로 입력해주세요.");
        }
    }
}
