import java.time.LocalDate;

public class OneTask extends Task{
    public OneTask(String name, String taskDescription, String task_type, LocalDate date) {
        super(name, taskDescription, task_type, date);
    }
    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate startDate = LocalDate.now();
        if(startDate.equals(inputDate)){
            return true;
        }
        return false;
    }
}
