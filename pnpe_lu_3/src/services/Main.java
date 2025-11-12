package services;

import exceptions.EmployeeNotEligibleException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidEmailException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        Company company = null;

        while (!flag) {
            System.out.println("1. Enter company info");
            System.out.println("2. Add employee");
            System.out.println("3. List employees");
            System.out.println("4. Find employee by id");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter company name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter company domain (e.g. tu-sofia.com): ");
                    String domain = scanner.nextLine();

                    company = new Company(name, domain);
                    System.out.println("Company created successfully!");
                    break;
                case "2":
                    if (company == null) {
                        System.out.println("Please create a company first!");
                    } else {
                        try {
                            System.out.print("Enter name: ");
                            String nameEmp = scanner.nextLine();
                            if (nameEmp == null || nameEmp.trim().isEmpty()) {
                                System.out.println("Name cannot be empty!");
                            }

                            System.out.print("Enter employee id: ");
                            String id = scanner.nextLine();
                            if (!id.matches("^EMP-\\d{5}$")) {
                                System.out.println("Invalid ID format!");
                            }

                            System.out.print("Enter experience (years): ");
                            int exp = Integer.parseInt(scanner.nextLine());

                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();

                            Employee e = new Employee(nameEmp, id, exp, email);
                            company.addEmployee(e);

                        } catch (InvalidEmailException e) {
                            System.out.println("Invalid email: " + e.getMessage());
                        } catch (EmployeeNotEligibleException e) {
                            System.out.println("Not eligible: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case "3":
                    if (company != null) {
                        company.listEmployees();
                    }
                    else {
                        System.out.println("Please create a company first!");
                    }
                    break;
                case "4":
                    if (company != null) {
                        try {
                            System.out.print("Enter employee ID: ");
                            String id = scanner.nextLine();
                            Employee e = company.findById(id);
                            System.out.println(e);
                        } catch (EmployeeNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else {
                        System.out.println("Please create a company first!");
                    }
                    break;
                case "5":
                    flag = true;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

}
