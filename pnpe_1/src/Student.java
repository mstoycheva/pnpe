public class Student {
    private String name;
    private String facultyNumber;
    private static int totalStudents = 0;

    public Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        totalStudents++;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Marieta", "000000");
        Student s2 = new Student("Stefani", "111111");
        System.out.println(s1.name);
        System.out.println(s1.facultyNumber);
        System.out.println(totalStudents);
    }
}
