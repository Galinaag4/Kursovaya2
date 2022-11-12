import java.time.LocalDate;
import java.util.*;

public class Schedule {
    private  static final Map<Integer, Task> taskMap = new HashMap<>();
    private Collection<Task> removedTasks;
    public static void add(Task task){
        taskMap.put(task.getId(),task);
    }
    public void remove(int id){
        taskMap.remove(id);
    }
    public Collection<Task> getAllbyDate(LocalDate inputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : taskMap.entrySet()) {
            Task task  = integerTaskEntry.getValue();
            if (task.isAvailable(inputDate)) {
                resultList.add(task);
            }
        }
        return resultList;
    }








}

