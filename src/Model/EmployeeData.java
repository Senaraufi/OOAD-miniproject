package Model;

import Enums.Role;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {
    private List<Employee> employees;

    public EmployeeData() {
        employees = new ArrayList<>();
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Store Manager - David Byrne
        // Founding member of Talking Heads, known for his innovative approach and leadership
        // Perfect for a managerial role with his organizational skills and creative vision
        employees.add(new Employee(
            "EMP001",
            "David Byrne",
            Role.MANAGER,
            LocalTime.of(8, 0),
            LocalTime.of(17, 0),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
            25.00,
            true
        ));

        // Sales Associates

        // Kim Deal - Bassist and vocalist of The Pixies and The Breeders
        // Known for her friendly demeanor and deep knowledge of alternative rock
        employees.add(new Employee(
            "EMP002",
            "Kim Deal",
            Role.SALES_ASSOCIATE,
            LocalTime.of(9, 0),
            LocalTime.of(17, 30),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday", "Saturday"),
            15.50,
            true
        ));

        // Patti Smith - The "Godmother of Punk"
        // Poet, author, and musician with extensive knowledge of music history
        employees.add(new Employee(
            "EMP003",
            "Patti Smith",
            Role.SALES_ASSOCIATE,
            LocalTime.of(10, 30),
            LocalTime.of(19, 0),
            Arrays.asList("Wednesday", "Thursday", "Friday", "Saturday", "Sunday"),
            15.50,
            true
        ));

        // Kurt Cobain - Nirvana frontman
        // Icon of alternative rock with deep appreciation for indie and punk music
        employees.add(new Employee(
            "EMP004",
            "Kurt Cobain",
            Role.SALES_ASSOCIATE,
            LocalTime.of(14, 0),
            LocalTime.of(22, 0),
            Arrays.asList("Thursday", "Friday", "Saturday", "Sunday"),
            15.00,
            false
        ));

        // Cashiers

        // Debbie Harry - Lead singer of Blondie
        // Pioneer of new wave and punk rock with excellent people skills
        employees.add(new Employee(
            "EMP005",
            "Debbie Harry",
            Role.CASHIER,
            LocalTime.of(9, 0),
            LocalTime.of(17, 30),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
            14.50,
            true
        ));

        // Trent Reznor - Nine Inch Nails founder
        // Detail-oriented musician with strong technical background
        employees.add(new Employee(
            "EMP006",
            "Trent Reznor",
            Role.CASHIER,
            LocalTime.of(13, 0),
            LocalTime.of(21, 30),
            Arrays.asList("Wednesday", "Thursday", "Friday", "Saturday", "Sunday"),
            14.50,
            true
        ));

        // Inventory Clerks

        // Brian Eno - Pioneering producer and ambient music innovator
        // Known for his methodical approach and organizational skills
        employees.add(new Employee(
            "EMP007",
            "Brian Eno",
            Role.INVENTORY_CLERK,
            LocalTime.of(7, 0),
            LocalTime.of(15, 30),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
            16.00,
            true
        ));

        // Bjork - Innovative Icelandic artist
        // Known for her attention to detail and experimental approach
        employees.add(new Employee(
            "EMP008",
            "Bjork",
            Role.INVENTORY_CLERK,
            LocalTime.of(15, 0),
            LocalTime.of(23, 30),
            Arrays.asList("Wednesday", "Thursday", "Friday", "Saturday"),
            16.00,
            false
        ));

        // Music Experts

        // John Peel - Legendary BBC Radio DJ
        // One of the most influential DJs in British radio history
        // Known for discovering and promoting new talent
        employees.add(new Employee(
            "EMP009",
            "John Peel",
            Role.MUSIC_EXPERT,
            LocalTime.of(10, 0),
            LocalTime.of(18, 30),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Friday", "Saturday"),
            18.50,
            true
        ));

        // Thurston Moore - Sonic Youth guitarist and music historian
        // Extensive knowledge of experimental and avant-garde music
        employees.add(new Employee(
            "EMP010",
            "Thurston Moore",
            Role.MUSIC_EXPERT,
            LocalTime.of(12, 0),
            LocalTime.of(20, 30),
            Arrays.asList("Tuesday", "Wednesday", "Thursday", "Saturday", "Sunday"),
            18.50,
            true
        ));

        // Security Guards

        // Henry Rollins - Black Flag frontman and spoken word artist
        // Known for his discipline and strong work ethic
        employees.add(new Employee(
            "EMP011",
            "Henry Rollins",
            Role.SECURITY,
            LocalTime.of(8, 0),
            LocalTime.of(16, 30),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
            17.00,
            true
        ));

        // Ian MacKaye - Founder of Dischord Records, Minor Threat, and Fugazi
        // Straight-edge movement pioneer known for his principled approach
        employees.add(new Employee(
            "EMP012",
            "Ian MacKaye",
            Role.SECURITY,
            LocalTime.of(16, 0),
            LocalTime.of(0, 30),
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
            17.50,
            true
        ));

        // Dave Grohl - Former Nirvana drummer, Foo Fighters founder
        // Known for his versatility and strong presence
        employees.add(new Employee(
            "EMP013",
            "Dave Grohl",
            Role.SECURITY,
            LocalTime.of(16, 0),
            LocalTime.of(0, 30),
            Arrays.asList("Friday", "Saturday", "Sunday"),
            17.00,
            false
        ));

        // Part-time Sales Associate

        // Kim Gordon - Sonic Youth bassist/vocalist and visual artist
        // Brings extensive knowledge of alternative and experimental music
        employees.add(new Employee(
            "EMP014",
            "Kim Gordon",
            Role.SALES_ASSOCIATE,
            LocalTime.of(11, 0),
            LocalTime.of(19, 30),
            Arrays.asList("Saturday", "Sunday"),
            14.50,
            false
        ));
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    // Get employees by role
    public List<Employee> getEmployeesByRole(Role role) {
        List<Employee> roleEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getRole() == role) {
                roleEmployees.add(emp);
            }
        }
        return roleEmployees;
    }

    // Get employees working on a specific day
    public List<Employee> getEmployeesByWorkDay(String day) {
        List<Employee> dayEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getWorkDays().contains(day)) {
                dayEmployees.add(emp);
            }
        }
        return dayEmployees;
    }

    // Get full-time employees
    public List<Employee> getFullTimeEmployees() {
        List<Employee> fullTimeEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.isFullTime()) {
                fullTimeEmployees.add(emp);
            }
        }
        return fullTimeEmployees;
    }

    // Get part-time employees
    public List<Employee> getPartTimeEmployees() {
        List<Employee> partTimeEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (!emp.isFullTime()) {
                partTimeEmployees.add(emp);
            }
        }
        return partTimeEmployees;
    }

    // Calculate total weekly payroll
    public double calculateTotalWeeklyPayroll() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateWeeklySalary();
        }
        return total;
    }

    // Print all employees
    public void printAllEmployees() {
        for (Employee emp : employees) {
            System.out.println("\n" + emp.toString());
            System.out.println("Weekly Hours: " + emp.calculateWeeklyHours());
            System.out.println("Weekly Salary: $" + String.format("%.2f", emp.calculateWeeklySalary()));
            System.out.println("-".repeat(50));
        }
    }
}
