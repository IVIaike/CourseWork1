public class Main {

    public static void main(String[] args) {

        System.out.println("Курсовая работа №1");
        EmployeeBook employeeBook = new EmployeeBook();
        System.out.println("Базовый список сотрудников компании:");
        employeeBook.printAllEmployees();
        System.out.println("Удаляем сотрудника из базового списка. Совершаем ошибку в воде Имени и Фамилии: ");
        employeeBook.removeEmployee("Леутская", "Ульяна", "Романовна");
        System.out.println("Удаляем сотрудника из базового списка корректно. ");
        employeeBook.removeEmployee("Илутская", "Лиана", "Романовна");
        System.out.println("Обновленный список. Удален один сотрудник: ");
        employeeBook.printAllEmployees();
        System.out.println("Принимаем нового сотрудника. ");
        employeeBook.addEmployee(new Employee("Иванов", "Иван", "Иванович", "1", 57_000.0));
        System.out.println("Обновленный список сотрудников. Вместо удаленного сотрудника пришел новый: ");
        employeeBook.printAllEmployees();
        employeeBook.minSalary();
        System.out.println("Минимальная зарплата у сотрудника " + employeeBook.minSalary());
        employeeBook.maxSalary();
        System.out.println("Максимальная зарплата у сотрудника " + employeeBook.maxSalary());
        employeeBook.sumSalary();
        System.out.println("Сумма всех зарплат всех сотрудников составляет " + employeeBook.sumSalary() + " рублей");
        employeeBook.averageSalary();
        System.out.println("Средняя зарплата сотрудников составляет: " + employeeBook.averageSalary());
        System.out.println("Список сотрудников компании по департаментам:");
        employeeBook.printAllEmployeeByDepartmentGrouping();

    }
}
