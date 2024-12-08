package oncall;

import java.time.LocalDate;
import net.bytebuddy.asm.Advice.Local;
import oncall.controller.OnCallMainController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OnCallMainController controller = new OnCallMainController();
        controller.run();
    }
}
