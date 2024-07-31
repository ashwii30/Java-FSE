public class MVCPatternTest {
    public static void main(String[] args) {
        Student model = new Student("A", "a@gmail.com", "B+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("B");
        controller.setStudentId("b@gmail.com");
        controller.setStudentGrade("A");

        controller.updateView();
    }
}
