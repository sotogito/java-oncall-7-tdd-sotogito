package oncall.domain.heplers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import oncall.domain.OnCallPolicy;
import oncall.domain.Staff;

public class ContinuousWorkSwitcher implements OnCallPolicy {


    public void sort(Map<LocalDate, Staff> onCallSchedule){
        List<LocalDate> dates = new ArrayList<>(onCallSchedule.keySet());
        int count = onCallSchedule.size();

        //note 날짜를 바꾸면 됨 -> 어차피 정렬됨
        for(int i = 1; i < count-1; i++){
            LocalDate frontDate = dates.get(i-1);
            Staff frontStaff = onCallSchedule.get(frontDate);

            LocalDate middleDate = dates.get(i);
            Staff middleStaff = onCallSchedule.get(middleDate);

            if(frontStaff.equals(middleStaff)){
                LocalDate nextDate = dates.get(i+1);
                Staff nextStaff = onCallSchedule.get(nextDate);

                onCallSchedule.put(nextDate,middleStaff);
                onCallSchedule.put(middleDate,nextStaff);
            }
        }
    }

}
