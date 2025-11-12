package services;

import exceptions.EmployeeNotEligibleException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidEmailException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Company {
    private String companyName;
    private String domain;
    private List<Employee> employees;

    public Company(String companyName, String domain) {
        this.companyName = companyName;
        this.domain = domain;
        this.employees = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) throws InvalidEmailException, EmployeeNotEligibleException {
        if (!validateEmail(employee.getEmail())) {
            throw new InvalidEmailException("Email needs to end with @" + domain);
        }

        if (employee.getExperience() <= 1) {
            throw new EmployeeNotEligibleException("Employee needs more than a year experience!");
        }

        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void listEmployees() {
        if(employees == null) {
            System.out.println("No employees");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public Employee findById(String id) throws EmployeeNotFoundException {
        for (Employee e : employees) {
            if (e.getEmployeeId().equals(id)) {
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee with id " + id + " was not found!");
    }

    public boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[\\w.-]+@" + Pattern.quote(domain) + "$");
        return pattern.matcher(email).matches();
    }

}
