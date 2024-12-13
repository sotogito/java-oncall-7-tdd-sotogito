#### Service

- SettingService : OnCallSettingService
    - Schedule 객체 반환
    - Staffs 객체 반환

- BusinessService
    - OnCallService
        - 기본 정렬
        - 연속되는 근무자 위치 변경

#### Enum

- PublicHolidays
    - 신정 : 1/1
    - 삼일절 3/1
    - 어린이날 5/5
    - 현충일 6/6
    - 광복절 8/15
    - 개천절 10/3
    - 한글날 10/9
    - 성탄절 12/25

- WorkType
    - WEEKDAY
    - WEEKEND
    - HOLIDAY

- Week
    - MON~SUN
    - LocalDate를 받고 요일로 변환시켜 주말인지 평일인지 판단한다.

---

#### 입력 객체

- Staff : 유효 검사를 위해 필요함
    - name
    - WorkType
    - LocalDate
        - equals : name
        - comparable : LocalDate

- Staffs : EnumMap<WorkType,OnCallStaff>
    - OnCallStaff(i)
        - WeekdayStaff
        - HolidayStaff

#### 필요(생성)객체

---

#### Result 객체

- OnCallSchedule : 날짜 + 휴일? + Staff
    - List<Staff> : Staff의 LocalDate로 정렬

#### History 객체

❌
---

#### Parser

- InputScheduleParser
- InputStaffNameParser -> 평일 주말 List<String>으로 받아서 한번에 반환하기

#### Dto

- InputScheduleDto : int , String
- InputWeekdayStaffDto
- InputWeekendStaffDto

---

#### Singleton

#### Helper

#### Policy 객체

- PolicyFinder

---

#### Reader

#### Factory