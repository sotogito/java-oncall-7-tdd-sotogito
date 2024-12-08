package oncall.serivce;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import oncall.constant.DayOfTheWeek;
import oncall.constant.PublicHoliday;
import oncall.constant.WorkType;
import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.Staff;
import oncall.domain.Staffs;

public class OnCallService {

    public OnCallSchedule schedule(Schedule schedule, Staffs staffs){
        OnCallSchedule onCallSchedule = new OnCallSchedule();
        basicSorting(onCallSchedule, schedule, staffs);

        duplicateStaffProcessing(onCallSchedule);

        onCallSchedule.sort();
        System.out.println(onCallSchedule);
        return onCallSchedule;
    }
    public void basicSorting(OnCallSchedule onCallSchedule,Schedule schedule, Staffs staffs){
        LocalDate scheduleDate = schedule.getDate();
        Month scheduleMonth = scheduleDate.getMonth();
        int dayOrder = 0;
        int endOrder = 0;
        Staff nowStaff = null;

        while (scheduleDate.getMonth().equals(scheduleMonth)){
            boolean isWeekend = DayOfTheWeek.isWeekend(scheduleDate.getDayOfWeek());
            boolean isIHoliday = PublicHoliday.isHoliday(scheduleDate);

            if(!isWeekend){
                if(isIHoliday){
                    //note 평일 공휴일 추가
                    nowStaff = staffs.findStaffByOrder(WorkType.WEEKDAY,dayOrder);
                    nowStaff.setWorkDate(scheduleDate);
                    nowStaff.setHoliday(true);
                    dayOrder++;
                } else if (!isIHoliday) {
                    //note 평일 추가
                    nowStaff = staffs.findStaffByOrder(WorkType.WEEKDAY,dayOrder);
                    nowStaff.setWorkDate(scheduleDate);
                    nowStaff.setHoliday(false);
                    dayOrder++;
                }
            } else if (isWeekend) {
                if(isIHoliday){
                    //note 평일 공휴일 추가
                    nowStaff = staffs.findStaffByOrder(WorkType.WEEKEND,endOrder);
                    nowStaff.setWorkDate(scheduleDate);
                    nowStaff.setHoliday(true);
                    endOrder++;
                } else if (!isIHoliday) {
                    //note 주말 추가
                    nowStaff = staffs.findStaffByOrder(WorkType.WEEKEND,endOrder);
                    nowStaff.setWorkDate(scheduleDate);
                    nowStaff.setHoliday(false);
                    endOrder++;
                }
            }
            onCallSchedule.addStaff(nowStaff);
            scheduleDate = scheduleDate.plusDays(1);
        }

    }

    public void duplicateStaffProcessing(OnCallSchedule onCallSchedule){
        List<Staff> staffs = onCallSchedule.getStaffs();
        for(int i = 0; i < staffs.size()-2; i++){
            Staff staff1 = staffs.get(i);
            Staff staff2 = staffs.get(i+1);
            Staff staff3 = staffs.get(i+2);

            /**
             * 같은 애들기리 바꾸는게 아님
             */
            if(staff1.isSameName(staff2)){
                onCallSchedule.changeOrder(i+1, i+2);
            }
        }
    }



}
