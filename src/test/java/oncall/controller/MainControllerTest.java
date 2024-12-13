package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MainControllerTest {

    @Test
    void 요일_순환_출력_확인() {
        List<String> week = new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일"));

        int startIndex = week.indexOf("목");
        int totalCount = 31;

        for (int i = 0; i < totalCount; i++) {
            int index = startIndex % week.size();
            System.out.println(week.get(index));
            startIndex++;
        }
    }

}