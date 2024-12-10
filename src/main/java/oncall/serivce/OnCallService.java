package oncall.serivce;

import oncall.domain.OnCallPolicy;
import oncall.domain.OnCallSchedule;
import oncall.domain.Schedule;
import oncall.domain.Staffs;
import oncall.domain.heplers.BasicSortHelper;
import oncall.domain.heplers.ContinuousWorkSwitcher;

public class OnCallService {
    private final BasicSortHelper basicSortHelper;
    private final OnCallPolicy policySortHelper;

    public OnCallService() {
        this.basicSortHelper = new BasicSortHelper();
        this.policySortHelper = new ContinuousWorkSwitcher();
    }

    /**
     * 정렬과 연속 근무자 해결 이 두가지를 꼭 같이 진행할 필요 없다. 일단 기본 정렬을 생성 한 후 그 뒤에 연속 근무자를 해결하면 덜 복잡하다.
     */
    //note 정렬된 결과를 반환
    public OnCallSchedule schedule(Schedule schedule, Staffs staffs) {
        OnCallSchedule onCallSchedule = new OnCallSchedule();
        basicSorting(onCallSchedule, schedule, staffs);
        duplicateStaffProcessing(onCallSchedule);
        return onCallSchedule;
    }

    /**
     * 시작일로 하여 마지막까지 day++를 하여 LocalDate를 생성한다. 주말인지, 공휴일인지 변수로 정의하고 주말, 공휴일인 경우 Weekend staff 객체를 가져온다. 평일인 경우는 Weekdat
     * staff 객체를 가져온다.
     * <p>
     * 각각의 staff 객체가 name 뿐만 아니라 WorkType 상태도 갖기 때문에 찾아온 Staff 객체를 주말, 평일, 공휴일 3 WorkType으로 하여 클론하여 저장한다. 새로운 객체로 생성해주지
     * 않을 시 마지막 변경사항으로 동기화가 된다.
     */
    private void basicSorting(OnCallSchedule onCallSchedule, Schedule schedule, Staffs staffs) {
        basicSortHelper.sort(onCallSchedule, schedule, staffs);
        basicSortHelper.resetOrder();
    }

    /**
     * 기본으로 정렬된 결과를 토대로 연속된 근무자를 해결한다.
     */
    private void duplicateStaffProcessing(OnCallSchedule onCallSchedule) {
        onCallSchedule.reSort(policySortHelper);
    }

}
