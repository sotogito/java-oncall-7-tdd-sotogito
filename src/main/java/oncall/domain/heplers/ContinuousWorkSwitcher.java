package oncall.domain.heplers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import oncall.domain.OnCallPolicy;
import oncall.domain.Staff;

public class ContinuousWorkSwitcher implements OnCallPolicy {

    public void sort(TreeMap<LocalDate, Staff> onCallSchedule){
        List<Map.Entry<LocalDate, Staff>> entryList = new ArrayList<>(onCallSchedule.entrySet());
        int count = entryList.size();

        for (int i = 1; i < count-1; i++) {
            Map.Entry<LocalDate, Staff> frontData = entryList.get(i-1);
            Staff frontStaff  = frontData.getValue();

            Map.Entry<LocalDate, Staff> middleData = entryList.get(i);
            Staff middleStaff  = middleData.getValue();

            if(frontStaff.equals(middleStaff)){
                Map.Entry<LocalDate, Staff> nextData = entryList.get(i+1);
                Staff nextStaff  = nextData.getValue();

                onCallSchedule.put(nextData.getKey(),middleStaff);
                onCallSchedule.put(middleData.getKey(),nextStaff);
            }
        }

    }

    /*
      public void sort(Map<LocalDate, Staff> onCallSchedule){
        List<LocalDate> dates = new ArrayList<>(onCallSchedule.keySet());
        int count = onCallSchedule.size();

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
     */

}
