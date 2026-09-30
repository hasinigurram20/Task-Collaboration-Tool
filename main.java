import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String title;
    String description;
    String assignedTo;
    String priority;
    String status;
    String deadline;

    Task(int id, String title, String description, String assignedTo,
         String priority, String status, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
    }

    void displayTask() {
        System.out.println("----------------------------------------");
        System.out.println("Task ID     : " + id);
        System.out.println("Title       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Assigned To : " + assignedTo);
        System.out.println("Priority    : " + priority);
        System.out.println("Status      : " + status);
        System.out.println("Deadline    : " + deadline);
    }
}

public class Main {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int taskId = 1;

    // Add a new task
    static void addTask() {
        System.out.println("\n===== ADD TASK =====");

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Assign to: ");
        String assignedTo = scanner.nextLine();

        System.out.print("Enter priority (Low/Medium/High): ");
        String priority = scanner.nextLine();

        System.out.print("Enter deadline: ");
        String deadline = scanner.nextLine();

        Task task = new Task(
                taskId++,
                title,
                description,
                assignedTo,
                priority,
                "Pending",
                deadline
        );

        tasks.add(task);

        System.out.println("Task added successfully!");
    }

    // View all tasks
    static void viewTasks() {
        System.out.println("\n===== ALL TASKS =====");

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {
            task.displayTask();
        }
    }

    // Update task
    static void updateTask() {
        System.out.println("\n===== UPDATE TASK =====");

        System.out.print("Enter Task ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Task task : tasks) {
            if (task.id == id) {

                System.out.print("Enter new title: ");
                task.title = scanner.nextLine();

                System.out.print("Enter new description: ");
                task.description = scanner.nextLine();

                System.out.print("Enter new assigned person: ");
                task.assignedTo = scanner.nextLine();

                System.out.print("Enter new priority: ");
                task.priority = scanner.nextLine();

                System.out.print("Enter new status (Pending/In Progress/Completed): ");
                task.status = scanner.nextLine();

                System.out.print("Enter new deadline: ");
                task.deadline = scanner.nextLine();

                System.out.println("Task updated successfully!");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    // Delete task
    static void deleteTask() {
        System.out.println("\n===== DELETE TASK =====");

        System.out.print("Enter Task ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == id) {
                tasks.remove(i);
                System.out.println("Task deleted successfully!");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    // Search task
    static void searchTask() {
        System.out.println("\n===== SEARCH TASK =====");

        System.out.print("Enter task title: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Task task : tasks) {
            if (task.title.toLowerCase().contains(keyword)) {
                task.displayTask();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching task found.");
        }
    }

    // Change task status
    static void updateStatus() {
        System.out.println("\n===== UPDATE STATUS =====");

        System.out.print("Enter Task ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Task task : tasks) {
            if (task.id == id) {

                System.out.print(
                    "Enter new status (Pending/In Progress/Completed): "
                );

                task.status = scanner.nextLine();

                System.out.println("Task status updated successfully!");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    // Main menu
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("       TASK COLLABORATION TOOL");
            System.out.println("====================================");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Update Task Status");
            System.out.println("7. Exit");
            System.out.println("====================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    updateTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    searchTask();
                    break;

                case 6:
                    updateStatus();
                    break;

                case 7:
                    System.out.println("Thank you for using Task Collaboration Tool!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
