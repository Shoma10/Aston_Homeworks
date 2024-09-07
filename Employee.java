public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Олег Тиньков", "Менеджер", "tinkov@gmail.com", "89231231212", 3000000, 30);
        employees[1] = new Employee("Павел Дуров", "Директор", "durov@gmail.com", "89231231213", 4000000, 35);
        employees[2] = new Employee("Александр Петров", "Аналитик", "petrov@gmail.com", "89231231214", 35000, 28);
        employees[3] = new Employee("Азамат Мусагалиев", "Разработчик", "musagaliev@gmail.com", "89231231215", 50000, 25);
        employees[4] = new Employee("Дмитрий Белиал", "Дизайнер", "belial@gmail.com", "89231231216", 45000, 32);

        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }
    }
}

