public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        Employee emp1 = new Employee("E1", "Alice", "Manager", 75000);
        Employee emp2 = new Employee("E2", "Bob", "Developer", 65000);

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        System.out.println("Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for employee E1:");
        Employee e = manager.searchEmployee("E1");
        if (e != null) {
            System.out.println(e.getEmployeeId() + ": " + e.getName() + ", " + e.getPosition() + ", " + e.getSalary());
        }

        System.out.println("\nDeleting employee E1");
        manager.deleteEmployee("E1");

        System.out.println("Employees after deletion:");
        manager.traverseEmployees();
    }
}
