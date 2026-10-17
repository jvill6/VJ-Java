import java.util.Scanner;

class Employee {
    protected String name;

    public Employee(String name) {
        // TODO: optionally validate non-empty name
        this.name = name;
    }

    // This method will be overridden by subclasses
    public void calculateWage() {
        System.out.println("Employee: " + name);
        System.out.println(
                "Wage: (base implementation - override in subclasses)"
        );
    }
}

class RegularEmployee extends Employee {
    private double monthlySalary;

    public RegularEmployee(String name, double monthlySalary) {
        super(name);

        // Basic validation: non-negative salary
        if (monthlySalary < 0) {
            System.out.println(
                    "Monthly salary must be non-negative."
            );
        }

        this.monthlySalary = monthlySalary;
    }

    @Override
    public void calculateWage() {
        System.out.println(
                "Regular Employee: " + name
        );
        System.out.println(
                "Monthly Salary: PhP" +
                        String.format("%.2f", monthlySalary)
        );
    }
}

class ContractualEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public ContractualEmployee(
            String name,
            double hourlyRate,
            int hoursWorked
    ) {
        super(name);

        if (hourlyRate < 0) {
            System.out.println(
                    "Hourly rate must be non-negative."
            );
        }

        if (hoursWorked < 0) {
            System.out.println(
                    "Hours worked must be non-negative."
            );
        }

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculateWage() {
        double wage = hourlyRate * hoursWorked;

        System.out.println(
                "Contractual Employee: " + name
        );
        System.out.println(
                "Hourly Rate: PhP" +
                        String.format("%.2f", hourlyRate)
        );
        System.out.println(
                "Hours Worked: " + hoursWorked
        );
        System.out.println(
                "Wage: Php" +
                        String.format("%.2f", wage)
        );
    }
}

public class Main {
    private static final Scanner scanner =
            new Scanner(System.in);

    public static void main(String[] args) {
        int n = readInt(
                "Enter number of employees: ",
                1,
                Integer.MAX_VALUE
        );

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println(
                    "\nEmployee #" + (i + 1)
            );

            String type = readType(
                    "Enter employee type " +
                            "(R for Regular, C for Contractual): "
            );

            String name = readNonEmptyLine(
                    "Enter employee name: "
            );

            if (type.equalsIgnoreCase("R")) {
                double salary = readDouble(
                        "Enter monthly salary: ",
                        0,
                        Double.MAX_VALUE
                );

                employees[i] =
                        new RegularEmployee(name, salary);
            } else {
                double rate = readDouble(
                        "Enter hourly rate: ",
                        0,
                        Double.MAX_VALUE
                );

                int hours = readInt(
                        "Enter hours worked: ",
                        0,
                        10_000
                );

                employees[i] =
                        new ContractualEmployee(
                                name,
                                rate,
                                hours
                        );
            }
        }

        System.out.println(
                "\n--- Wage Summary ---"
        );

        for (Employee e : employees) {
            e.calculateWage(); // polymorphic call
            System.out.println();
        }

        scanner.close();
    }

    // Input helpers with validation
    private static String readType(String prompt) {
        while (true) {
            System.out.print(prompt);

            String s =
                    scanner.nextLine().trim();

            if (
                    s.equalsIgnoreCase("R") ||
                            s.equalsIgnoreCase("C")
            ) {
                return s;
            }

            System.out.println(
                    "Invalid type. Enter R or C."
            );
        }
    }

    private static String readNonEmptyLine(
            String prompt
    ) {
        while (true) {
            System.out.print(prompt);

            String s =
                    scanner.nextLine().trim();

            if (!s.isEmpty()) {
                return s;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }

    private static int readInt(
            String prompt,
            int minInclusive,
            int maxInclusive
    ) {
        while (true) {
            System.out.print(prompt);

            try {
                int val = Integer.parseInt(
                        scanner.nextLine().trim()
                );

                if (
                        val < minInclusive ||
                                val > maxInclusive
                ) {
                    System.out.println(
                            "Enter an integer in range [" +
                                    minInclusive + ", " +
                                    maxInclusive + "]."
                    );
                    continue;
                }

                return val;
            } catch (NumberFormatException ex) {
                System.out.println(
                        "Invalid integer. Try again."
                );
            }
        }
    }

    private static double readDouble(
            String prompt,
            double minInclusive,
            double maxInclusive
    ) {
        while (true) {
            System.out.print(prompt);

            try {
                double val = Double.parseDouble(
                        scanner.nextLine().trim()
                );

                if (
                        val < minInclusive ||
                                val > maxInclusive
                ) {
                    System.out.println(
                            "Enter a number in range [" +
                                    minInclusive + ", " +
                                    maxInclusive + "]."
                    );
                    continue;
                }

                return val;
            } catch (NumberFormatException ex) {
                System.out.println(
                        "Invalid number. Try again."
                );
            }
        }
    }
}