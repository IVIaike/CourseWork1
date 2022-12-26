import org.w3c.dom.css.Counter;

import java.util.Objects;

public class Employee {

    private String name;
    private String patronymic;
    private String lastName;
    private String department;
    private double salary;
    private final long id = count;
    private static long count = 1L;

    public Employee (String lastName, String name, String patronymic, String department, double salary) {
        this.name = name;
        this.patronymic = patronymic;
        this.lastName = lastName;
        if(isDepartment(department)){
            this.department = department;
        }
        else {
            System.out.println("Такого отдела не существует");
        }
        this.salary = salary;
        count++;
    }

    @Override
    public String toString() {
        return "Работник ФИО: " + lastName + " " + name + " " + patronymic + " " + ", ID: " + id + ", отдел: "
                + department + ", заработная плата:" + String.format("%.2f", salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    private boolean isDepartment (String department) {
        if(department.equals("1") || department.equals("2") || department.equals("3") || department.equals("4") || department.equals("5")) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public long getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment (String department) {
        this.department =department;
    }


}
