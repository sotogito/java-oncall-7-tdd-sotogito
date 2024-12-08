#### Service
- OnCallSetting
  - 월, 요일 입력
  - 사원 객체 생성Staff
- OnCallService 
  - 기본정렬
  - 순서 고려 정렬
#### Enum
- publicHoliday
  - 1/1 신정
  - 3.1 삼일절
  - 5.5어린이날
  - 6.6현충일
  - 8.15 광복절
  - 10.3 개천절
  - 10.9 한글날
  - 12.25 성탄절

- 요일
- WorkType
  - weekday - 저장할때 EnumMap으로
  - weekend
---

#### 입력 객체
- Staffs
  - Staff

- Schedule
  - LocalDate

#### 필요(생성)객체

---

#### Result 객체
#### History 객체

---

#### Parser
- DateParser
- StaffParser

#### Dto
- InputScheduleDto - 월,요일
---

#### Singleton

#### Helper
- Scheduler
#### Policy 객체

---

#### Reader
#### Factory