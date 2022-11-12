import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Schedule schedule = new Schedule();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(scanner);
                            break;
                        case 2:
                            remove(scanner);
                            break;
                        case 3:
                            getTaskByDay(scanner);
                            break;
                        case 4:
                            //taskList.getAllTaskFromTaskList();
                            break;
                        case 5:
                            // taskList.editTask(scanner);
                            break;
                        case 6:
                            //taskList.getDeletedTask();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }
    private static void addTask(Scanner scanner){
        System.out.print("Введите название задачи:  ");
        String name =  scanner.next();
        scanner.nextLine();
        System.out.print("Введите описание задачи:  ");
        String taskDescription =  scanner.nextLine();
        System.out.print("Введите дату задачи в формате dd.mm.yy :  ");
        LocalDate date = LocalDate.parse(scanner.nextLine(),dtf);
        System.out.print("Введите тип задачи: Личный или Рабочий ");
        String task_type =  scanner.nextLine();
        System.out.print("Введите повторяемость задачи:  ");
        System.out.print("0 Не повторяется");
        System.out.print("1 Дневная");
        System.out.print("2 Еженедельная");
        System.out.print("3 Ежемесячная");
        System.out.print("4 Ежегодная");
        int typeTask =  scanner.nextInt();
        switch (typeTask){
            case 0:
                schedule.add(new Task(name, taskDescription, task_type, date));
                break;
            case 1:
                schedule.add(new Daily(name, taskDescription, task_type, date));
                break;
            case 2:
                schedule.add(new Weekly(name, taskDescription, task_type, date));
                break;
            case 3:
                schedule.add(new Monthly(name, taskDescription, task_type, date));
                break;
            case 4:
                schedule.add(new Annual(name, taskDescription, task_type, date));
                break;
            default:
                throw new RuntimeException("Нет такого типа задач");

        }

    }
    private static void remove(Scanner scanner){
        System.out.print("Введите id задачи  ");
        int id = scanner.nextInt();
        schedule.remove(id);

    }
    private static void getTaskByDay(Scanner scanner){
        System.out.print("Введите дату задачи в формате dd.mm.yy :  ");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(),dtf);
        var allTaskByDay  = schedule.getAllbyDate(LocalDate.from(dateTime));
        System.out.println("Список здач этого дня");
        for (Task task: allTaskByDay){
            System.out.println(task);

        }


    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");


    }
}

