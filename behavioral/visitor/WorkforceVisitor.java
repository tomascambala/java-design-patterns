package behavioral.visitor;

import java.util.List;
import java.util.ArrayList;

interface Employee {
    void accept(Visitor visitor);
}

interface Visitor {
    void visit(Manager manager);
    void visit(Engineer engineer);
}

class Manager implements Employee {
    private String name;
    private int tasksPerformed;

    public Manager(String name, int tasksPerformed) {
        this.name = name;
        this.tasksPerformed = tasksPerformed;
    }

    public String getName() {
        return name;
    }

    public int getTasksPerformed() {
        return tasksPerformed;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Engineer implements Employee {
    private String name;
    private int tasksPerformed;

    public Engineer(String name, int tasksPerformed) {
        this.name = name;
        this.tasksPerformed = tasksPerformed;
    }

    public String getName() {
        return name;
    }

    public int getTasksPerformed() {
        return tasksPerformed;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor class
class TasksPerformedCalculator implements Visitor {
    private int totalTasksPerformed;

    public void visit(Manager manager) {
        totalTasksPerformed += manager.getTasksPerformed();
    }

    public void visit(Engineer engineer) {
        totalTasksPerformed += engineer.getTasksPerformed();
    }

    public int getTotalTasksPerformed() {
        return totalTasksPerformed;
    }
}

public class WorkforceVisitor {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("Tomas", 39));
        employees.add(new Engineer("Andrej", 48));
        employees.add(new Engineer("Fero", 92));

        TasksPerformedCalculator calculator = new TasksPerformedCalculator();
        for (Employee employee : employees) {
            employee.accept(calculator);
        }

        System.out.println("Company total tasks performed: " + calculator.getTotalTasksPerformed());
    }
}
