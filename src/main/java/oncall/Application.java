package oncall;

import java.time.LocalDate;
import net.bytebuddy.asm.Advice.Local;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LocalDate localDate = LocalDate.of(2023, 5, 1);
        System.out.println(localDate.getDayOfWeek());
    }
}
