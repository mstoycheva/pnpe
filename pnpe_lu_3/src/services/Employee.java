package services;

public class Employee {
    private String name;
    private String employeeId;
    private int experience;
    private String email;

    public Employee(String name, String employeeId, int experience, String email) {
        this.name = name;
        this.employeeId = employeeId;
        this.experience = experience;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + employeeId + ", Experience: " + experience + " years, Email: " + email;
    }
}
