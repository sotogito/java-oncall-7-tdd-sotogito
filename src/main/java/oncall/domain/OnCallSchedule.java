package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import oncall.constant.DayOfTheWeek;
import oncall.constant.WorkType;

public class OnCallSchedule {
    private final TreeMap<LocalDate,Staff> onCallSchedule;

    public OnCallSchedule() {
        onCallSchedule = new TreeMap<>(); //날짜 순서대로 정렬해야함
    }

    public void reSort(OnCallPolicy sortHelper){
        sortHelper.sort(onCallSchedule);
    }

    public void addSchedule(LocalDate date, Staff staff) {
        onCallSchedule.put(date, staff);
    }

    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();

        for(Map.Entry<LocalDate,Staff> entry : onCallSchedule.entrySet()){
            LocalDate date = entry.getKey();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            String dayOfWeek = DayOfTheWeek.find(date.getDayOfWeek()).getKorean();

            Staff staff = entry.getValue();

            if(staff.getWorkType().equals(WorkType.HOLIDAY)){
                printout.append(String.format(
                        "%d월 %d일 %s(휴일) %s\n",month,day,dayOfWeek,staff.getName()));
                continue;
            }
            printout.append(String.format(
                    "%d월 %d일 %s %s\n",month,day,dayOfWeek,staff.getName()));
        }
        return printout.toString();
    }


}
