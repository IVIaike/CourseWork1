import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {

    private static Employee[] employees = new Employee[10]; {
            employees[0] = new Employee("Мусатов", "Никита", "Александрович", "1", 60_000);
            employees[1] = new Employee("Сапожников", "Семен", "Сергеевич", "2", 70_000);
            employees[2] = new Employee("Дроздов", "Константин", "Андреевич", "3", 75_000);
            employees[3] = new Employee("Буханкин", "Евгений", "Олегович", "4", 80_000);
            employees[4] = new Employee("Лефтин", "Роман", "Юрьевич", "5", 90_000);
            employees[5] = new Employee("Нечаева", "Олеся", "Евгеньевна", "1", 56_000);
            employees[6] = new Employee("Тисаева", "Анастасия", "Михайловна", "2", 72_000);
            employees[7] = new Employee("Болонский", "Евгений", "Валерьевич", "3", 78_000);
            employees[8] = new Employee("Илутская", "Лиана", "Романовна", "4", 79_000);
            employees[9] = new Employee("Севков", "Кирилл", "Аркадьевич", "5", 94_000);
    }

        /**
         * Добавление нового сотрудника в массив
          * @param employee
         */

    public void addEmployee (Employee employee) {
            for (int i = 0; i<employees.length; i++) {
                    if (employees[i] == null) {
                            employees[i] = employee;
                            return;
                    }
            }
            System.out.println("Свободных ячеек нет");
    }

        /**
         * Удаление сотрудника измассива
         * @param lastName
         * @param name
         * @param patronymic
         */

    public void removeEmployee (String lastName, String name, String patronymic) {
            for (int i = 0; i < employees.length; i++) {
                    if (employees[i] != null && lastName.equals(employees[i].getLastName()) &&
                            name.equals(employees[i].getName()) &&
                            patronymic.equals(employees[i].getPatronymic())) {
                            employees[i] = null;
                            return;

                    }

            }
        System.out.println("Работника с такими ФИО не существует");
    }

        /**
         * Вывод списка всех сотрудников в консоль
         */

    public void printAllEmployees () {
            for (Employee employee: employees) {
                    System.out.println(employee);
            }
    }

        /**
         * Рассчет суммы всех зарплат (бюджета на заработную плату)
         * @return
         */
    public double sumSalary () {
            double sum = 0d;
            for (Employee employee: employees) {
                    if (employee != null) {
                            sum += employee.getSalary();
                    }
            }
            return sum;
    }

    public double averageSalary () {
        double avg = 0d;
        int currentEmployeeQuantity = 0;
        for (Employee employee: employees) {
            if (employee != null) {
                currentEmployeeQuantity = currentEmployeeQuantity +1;
            }
        }
        avg = sumSalary() / currentEmployeeQuantity;
        return avg;
    }

        /**
         * Вывод суммы всех зарплат (бюджета на заработную плату) в консоль
         * Сначала находим индекс сотрудника с ненулевыми полями, т.е. действующий сотрудник
         * Потом через сравнение находим сотрудников с минимальной и максимальной заработной платой
         */

    public int findFirstNotNullSalaryIndex () {
            for (int i = 0; i < employees.length; i++){
                    if (employees[i] != null) {
                            return i;
                    }
                    throw new RuntimeException("Нет сотрудников");
            }
            return 0;
    }

    public Employee minSalary () {
            Employee minSalary = employees[findFirstNotNullSalaryIndex()];
            for (int i = findFirstNotNullSalaryIndex() + 1; i < employees.length; i++) {
                  if (employees[i] != null && employees[i].getSalary() < minSalary.getSalary()) {
                          minSalary = employees[i];
                  }
            }
            return minSalary;
    }

    public Employee maxSalary () {
            Employee maxSalary = employees[findFirstNotNullSalaryIndex()];
            for (int i = findFirstNotNullSalaryIndex() + 1; i < employees.length; i++) {
                  if (employees[i] != null && employees[i].getSalary() > maxSalary.getSalary()) {
                          maxSalary = employees[i];
                  }
            }
            return maxSalary;
    }

    public void printAllEmployeeByDepartment (String department) {
            for (Employee employee: employees) {
                    if (department.equals(employee.getDepartment())) {
                            System.out.println(employee);
                    }
            }
    }

    public List<String> findAllDepartment() {
            List <String> allDepartment = new ArrayList<>();
            for (Employee employee: employees) {
                    if (employee != null && !allDepartment.contains(employee.getDepartment())) {
                            allDepartment.add(employee.getDepartment());
                    }
            }
            return allDepartment;
    }

    public void printAllEmployeeByDepartmentGrouping () {
            List<String> departments = findAllDepartment();
            for (String department: departments) {
                    System.out.println("В отделе № " + department + " работают следующие сотрудники: ");
                    printAllEmployeeByDepartment(department);
            }
    }

}
