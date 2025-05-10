import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List <Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));

    }

        public void ListTask(){
            if (tasks.isEmpty()){
                System.out.println("Nenhuma Tarefa cadastrada");

        }else {
            for (int i = 0; i < tasks.size(); i++){
                    System.out.println((i + 1) + "." + tasks.get(i));
                }
            }
        }
    public void markTaskDone(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.get(index - 1).markDone();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listTasks() {
    }
}
