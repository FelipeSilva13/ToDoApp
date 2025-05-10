import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar como feita");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    break;
                case 2:
                    manager.2listTasks();
                    break;
                case 3:
                    System.out.print("Número da tarefa feita: ");
                    int idx = scanner.nextInt();
                    manager.markTaskDone(idx);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (choice != 0);
    }
}
