public class TaskTest {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        Task task1 = new Task("T1", "Task 1", "Pending");
        Task task2 = new Task("T2", "Task 2", "Completed");

        taskList.addTask(task1);
        taskList.addTask(task2);

        System.out.println("Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for task T1:");
        Task t = taskList.searchTask("T1");
        if (t != null) {
            System.out.println(t.getTaskId() + ": " + t.getTaskName() + ", " + t.getStatus());
        }

        System.out.println("\nDeleting task T1");
        taskList.deleteTask("T1");

        System.out.println("Tasks after deletion:");
        taskList.traverseTasks();
    }
}
