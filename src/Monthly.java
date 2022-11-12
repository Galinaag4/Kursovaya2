import java.time.LocalDate;
import java.time.LocalDateTime;

public class Monthly extends Task{
    public Monthly(String name, String taskDescription, String task_type, LocalDate date) {
        super(name, taskDescription, task_type, date);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate startDate = LocalDate.now();
        while (!startDate.isAfter(inputDate)){
            if(startDate.equals(inputDate)){
                return true;
            }
            startDate = startDate.plusMonths(1);
        }
        return false;
    }
}

