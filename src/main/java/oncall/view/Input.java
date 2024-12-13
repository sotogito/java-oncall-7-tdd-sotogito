package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputSchedule() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        return Console.readLine();
    }

    public static String inputWeekdayStaffs() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        return Console.readLine();
    }

    public static String inputWeekendStaffs() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
        return Console.readLine();
    }
}
