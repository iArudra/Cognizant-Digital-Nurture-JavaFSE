import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class StudentView {
    public void printStudentDetails(int id, String name) {
        System.out.println("Student:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model = new Student(model.getId(), name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public int getStudentId() {
        return model.getId();
    }

    public void updateView() {
        view.printStudentDetails(model.getId(), model.getName());
    }
}

public class MVCExample {
    public static void main(String[] args) {
        Student student = new Student(1, "Jane Doe");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Jane Smith");
        System.out.println("\nAfter name update:");
        controller.updateView();
    }
}
